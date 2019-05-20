package br.com.scf.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.scf.global.Mensagem;
import br.com.scf.parlamentar.pojo.Deputado;
import br.com.scf.parlamentar.pojo.Parlamentar;

public class RoboClient implements Serializable{

	private static final long serialVersionUID = 1L;
	private WebTarget baseTarget;

	/* Construtor */
	public RoboClient(String url) {
		Client cliente = ClientBuilder.newClient();
		baseTarget = cliente.target(url);
	}
	
    public Parlamentar capturarParlamentarPorId(String id){
		String deputadoString  =  baseTarget.path(id).request().get(String.class);
		deputadoString = tratarJson(deputadoString);
		Parlamentar parlamentar = new Gson().fromJson(deputadoString, Parlamentar.class);
		return parlamentar;
    }
	
	public List<Parlamentar> capturarTodosParlamentares() {
		Response response;
		List<String> urlParlamentarList = new ArrayList<>();
		List<Parlamentar> parlamentarList = new ArrayList<>();
		
		WebTarget json = baseTarget.path("/api/v2/deputados");
		Builder accept = json.request(MediaType.APPLICATION_JSON_TYPE);
        response = accept.get();
		
        
        String stringParlamentaresList = response.readEntity(String.class);
		
        stringParlamentaresList = stringParlamentaresList
        		.replace("{\"dados\":[", "")
        		.replace("]}", "");
       
        String[] parlamentaresJsonList = stringParlamentaresList.split("},");
        
        for (String regex : parlamentaresJsonList) {
        	regex = encontrarUnicoValorRegex(regex, "uri\":\".*?\",");
        
	    	String regexAux = encontrarUnicoValorRegex(regex, "uri\":\"https://.*?/");
	    	regex = regex.replace(regexAux, "/").replace("\",", "");
	    	
	    	System.out.println(regex);
        	
        	urlParlamentarList.add(regex);
        }

        for (String id : urlParlamentarList) {
        	parlamentarList.add(capturarParlamentarPorId(id));
		}
        return parlamentarList;
	}
	
	public void popularParlamentares(String dados) {
		Parlamentar deputado = new Gson().fromJson(dados, Parlamentar.class);
	}
	
	
	public StringBuilder lerUrl(String url, String encoding) throws UnsupportedEncodingException, IOException {
		try {
			Charset UTF8_CHARSET = Charset.forName("utf-8");
			URL pag = new URL(url);
			URLConnection urlConn = pag.openConnection();
			urlConn.setConnectTimeout(20000);
	        urlConn.setReadTimeout(20000);
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), encoding));
			StringBuffer inputLine = new StringBuffer("");
			
			String linha = null;
			while ((linha = in.readLine()) != null) {
				inputLine.append(linha).append("\n");
			}
			in.close();
			if(url.contains("www.senado.gov.br")){
				return new StringBuilder(new String(inputLine.toString().getBytes("iso-8859-1"), UTF8_CHARSET));
			}
			return new StringBuilder(inputLine.toString());
		} catch (UnsupportedEncodingException e) {
			Mensagem.mensagemDinamica("Conexão temporariamente indisponível!" + e.getMessage(), "Falha !", FacesMessage.SEVERITY_INFO, false);
			return new StringBuilder();
		}
	}

	public List<String> encontrarTodosRegex(CharSequence texto, String pattern) {
		List<String> valoresList = new ArrayList<String>();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(texto);
		while (m.find()) {
			valoresList.add(m.group());
		}
		return valoresList;
	}

	public String encontrarUnicoValorRegex(CharSequence texto, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(texto);
		if(m.find())
			return m.group();
		return "";
	}
	
	public String encontrarUnicoValorRegex(String[] texto, String pattern) {
		String a = "";
		for(String t : texto){
			a = encontrarUnicoValorRegex(t, pattern);
			if(!a.isEmpty()){
				return a;
			}
		}
		return "";
	}

	public String removerTagsHTML(String texto) {
		return texto.replaceAll("</?(.|\\n)*?>", "");
	}
	
	public String tiraAcento(String palavra){
		palavra = palavra.replace("á","a");
		palavra = palavra.replace("á","a");
		palavra = palavra.replace("â","a");
		palavra = palavra.replace("ã","a");
		palavra = palavra.replace("é","e");
		palavra = palavra.replace("ê","e");
		palavra = palavra.replace("í","i");
		palavra = palavra.replace("ó","o");
		palavra = palavra.replace("ô","o");
		palavra = palavra.replace("õ","o");
		palavra = palavra.replace("ú","u");
		palavra = palavra.replace("ü","u");
		palavra = palavra.replace("ç","c");
		palavra = palavra.replace("À","A");
		palavra = palavra.replace("Á","A");
		palavra = palavra.replace("Â","A");
		palavra = palavra.replace("Ã","A");
		palavra = palavra.replace("É","E");
		palavra = palavra.replace("Ê","E");
		palavra = palavra.replace("Í","I");
		palavra = palavra.replace("Ó","O");
		palavra = palavra.replace("Ô","O");
		palavra = palavra.replace("Õ","O");
		palavra = palavra.replace("Ú","U");
		palavra = palavra.replace("Ü","U");
		palavra = palavra.replace("Ç", "C");
	
		return palavra;
	}

	public String tiraCaracterEspecial(String palavra){
		palavra = palavra.replace("&Aacute;","Á");
		palavra = palavra.replace("&aacute;","á");
		palavra = palavra.replace("&Acirc;","Â");
		palavra = palavra.replace("&acirc;","â");
		palavra = palavra.replace("&Agrave;","À");
		palavra = palavra.replace("&agrave;","à");
		palavra = palavra.replace("&Aring;","Å");
		palavra = palavra.replace("&aring;","å");
		palavra = palavra.replace("&Atilde;","Ã");
		palavra = palavra.replace("&atilde;","ã");
		palavra = palavra.replace("&Auml;","Ä");
		palavra = palavra.replace("&auml;","ä");
		palavra = palavra.replace("&AElig;","Æ");
		palavra = palavra.replace("&aelig;","æ");
		palavra = palavra.replace("&Eacute;","É");
		palavra = palavra.replace("&eacute;","é");
		palavra = palavra.replace("&Ecirc;","Ê");
		palavra = palavra.replace("&ecirc;","ê");
		palavra = palavra.replace("&Egrave;","È");
		palavra = palavra.replace("&egrave;","è");
		palavra = palavra.replace("&Euml;","Ë");
		palavra = palavra.replace("&euml;","ë");
		palavra = palavra.replace("&Iacute;","Í");
		palavra = palavra.replace("&iacute;","í");
		palavra = palavra.replace("&Icirc;","Î");
		palavra = palavra.replace("&icirc;","î");
		palavra = palavra.replace("&Igrave;","Ì");
		palavra = palavra.replace("&igrave;","ì");
		palavra = palavra.replace("&Iuml;","Ï");
		palavra = palavra.replace("&iuml;","ï");
		palavra = palavra.replace("&Oacute;","Ó");
		palavra = palavra.replace("&oacute;","ó");
		palavra = palavra.replace("&Ocirc;","Ô");
		palavra = palavra.replace("&ocirc;","ô");
		palavra = palavra.replace("&Ograve;","Ò");
		palavra = palavra.replace("&ograve;","ò");
		palavra = palavra.replace("&Oslash;","Ø");
		palavra = palavra.replace("&oslash;","ø");
		palavra = palavra.replace("&Otilde;","Õ");
		palavra = palavra.replace("&otilde;","õ");
		palavra = palavra.replace("&Ouml;","Ö");
		palavra = palavra.replace("&ouml;","ö");
		palavra = palavra.replace("&Uacute;","Ú");
		palavra = palavra.replace("&uacute;","ú");
		palavra = palavra.replace("&Ucirc;","Û");
		palavra = palavra.replace("&ucirc;","û");
		palavra = palavra.replace("&Ugrave;","Ù");
		palavra = palavra.replace("&ugrave;","ù");
		palavra = palavra.replace("&Uuml;","Ü");
		palavra = palavra.replace("&uuml;","ü");
		palavra = palavra.replace("&Ccedil;","Ç");
		palavra = palavra.replace("&ccedil;","ç");
		palavra = palavra.replace("&ordf;", "ª");
		palavra = palavra.replace("&sect;", "§");
		palavra = palavra.replace("&ordm;", "º");
		return palavra;
	}
	
	
	private String tratarJson(String dado) {
		String [] dadosQuebrados = dado.split(",\"links\"");
		
		if(dadosQuebrados.length > 0) {
			String deputadoJson = dadosQuebrados[0].replace("{\"dados\":", "");
			return deputadoJson;
		}
		return "";
	}
	
	
	
	
	
	
	

	/*public List<Parlamentar> findByName(String name) {
		WebTarget searchTarget = baseTarget.path("/find/" + name);
		Invocation.Builder invocationBuilder = searchTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro listando contatos");
		}

		return response.readEntity(new GenericType<List<Parlamentar>>() {
		});
	}

	public Parlamentar findById(int id) {
		WebTarget searchTarget = baseTarget.path("/" + id);
		Invocation.Builder invocationBuilder = searchTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro recuperando contato");
		}

		return response.readEntity(Parlamentar.class);
	}

	public Parlamentar add(Parlamentar contact) {
		Invocation.Builder invocationBuilder = baseTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(contact, MediaType.APPLICATION_JSON));

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro criando contato");
		}
		return response.readEntity(Parlamentar.class);
	}

	public void update(Parlamentar contact) {
		WebTarget updateTarget = baseTarget.path("/" + contact.getId());
		Invocation.Builder invocationBuilder = updateTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(contact, MediaType.APPLICATION_JSON));

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro atualizando contato");
		}
	}

	public void delete(Parlamentar contact) {
		WebTarget deleteTarget = baseTarget.queryParam("contactId", contact.getId());
		Invocation.Builder invocationBuilder = deleteTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro removendo contato");
		}
	}*/

}