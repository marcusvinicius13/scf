package br.com.scf.parlamentar.pojo;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Deputado implements Serializable{

	private static final long serialVersionUID = 4703589998313480340L;
	
	private long id;
    private String uri;
    private String nome;
    private String uriPartido;
    private String siglaUf;
    private long idLegislatura;
    private String urlFoto;
    
	public Deputado() {}
	
	
    public String toXML() {
		return new XStream().toXML(this);
	}
    
    public String toJson() {
    	return new Gson().toJson(this);
    }

    /*Geteres and Seteres*/


	public String getUri() {
		return uri;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setUri(String uri) {
		this.uri = uri;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getUriPartido() {
		return uriPartido;
	}


	public void setUriPartido(String uriPartido) {
		this.uriPartido = uriPartido;
	}


	public String getSiglaUf() {
		return siglaUf;
	}


	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}

	public long getIdLegislatura() {
		return idLegislatura;
	}


	public void setIdLegislatura(long idLegislatura) {
		this.idLegislatura = idLegislatura;
	}


	public String getUrlFoto() {
		return urlFoto;
	}


	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
    
    
}
