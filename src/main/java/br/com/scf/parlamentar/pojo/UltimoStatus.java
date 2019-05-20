package br.com.scf.parlamentar.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UltimoStatus {


	private String id;
	private String uri;
	private String nome;
	private String siglaPartido;
	private String uriPartido;
	private String siglaUf;
	private String idLegislatura;
	private String urlFoto;
	private String data;
	private String nomeEleitoral;
	private String situacao;
	private String condicaoEleitoral;
	private String descricaoStatus;
	private Gabinete gabinete;
	
	
	public UltimoStatus() {}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUri() {
		return uri;
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
	public String getSiglaPartido() {
		return siglaPartido;
	}
	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
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
	public String getIdLegislatura() {
		return idLegislatura;
	}
	public void setIdLegislatura(String idLegislatura) {
		this.idLegislatura = idLegislatura;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNomeEleitoral() {
		return nomeEleitoral;
	}
	public void setNomeEleitoral(String nomeEleitoral) {
		this.nomeEleitoral = nomeEleitoral;
	}
	public Gabinete getGabinete() {
		return gabinete;
	}
	public void setGabinete(Gabinete gabinete) {
		this.gabinete = gabinete;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getCondicaoEleitoral() {
		return condicaoEleitoral;
	}
	public void setCondicaoEleitoral(String condicaoEleitoral) {
		this.condicaoEleitoral = condicaoEleitoral;
	}
	public String getDescricaoStatus() {
		return descricaoStatus;
	}
	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}
	
}
