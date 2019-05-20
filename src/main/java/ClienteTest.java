import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.google.gson.Gson;

import br.com.scf.parlamentar.pojo.Deputado;


public class ClienteTest {
	
	
	@Test
	public void buscarTodos() {
		Client cliente = ClientBuilder.newClient();
		Gson gson = new Gson();

		WebTarget baseTarget = cliente.target("https://dadosabertos.camara.leg.br") ;
		
		String json = baseTarget.path("/api/v2/deputados")
				.request(MediaType.APPLICATION_JSON).get(String.class);
		
		StringBuffer dados = new  StringBuffer();
		
		dados.append(json.substring(0, json.length() - 1));
		
		System.out.println(dados.subSequence(0, (json.length() - 1)));
		
//		StringBuilder dados = new  StringBuilder();
//		dados.append(json.toString());
//		
//		System.out.println(dados.length());
//		String[] fromJson = gson.fromJson(json, String[].class);
		
//		System.out.println(fromJson.toString());
	}
	
//	@Test
    public void buscarPorId(){
        Client cliente = ClientBuilder.newClient();
        WebTarget baseTarget = cliente.target("https://dadosabertos.camara.leg.br") ;
		String deputadoString  =  baseTarget.path("/api/v2/deputados/204554")
				.request().get(String.class);
		deputadoString = tratarJson(deputadoString);
		Deputado deputado = new Gson().fromJson(deputadoString, Deputado.class);
		
		System.out.println(deputado.toString());
    }
	
	private String tratarJson(String dado) {
		String [] dadosQuebrados = dado.split(",\"links\"");
		
		if(dadosQuebrados.length > 0) {
			String deputadoJson = dadosQuebrados[0].replace("{\"dados\":", "");
			return deputadoJson;
		}
		return "";
	}

}
