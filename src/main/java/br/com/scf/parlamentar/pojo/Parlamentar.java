package br.com.scf.parlamentar.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Parlamentar implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private String id;
	private String uri;
	private String nomeCivil;
	
	private UltimoStatus ultimoStatus;
	
	private String cpf;
	private String sexo;
	private String urlWebsite;
	private String escolaridade;
	private String ufNascimento;
	private String dataNascimento;
	private String dataFalecimento;
	private String municipioNascimento;
	List<String> redeSocial = new ArrayList<>();
	
	
	
	/*Geteres and Seteres*/
	
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
	public String getNomeCivil() {
		return nomeCivil;
	}
	public void setNomeCivil(String nomeCivil) {
		this.nomeCivil = nomeCivil;
	}
	public UltimoStatus getUltimoStatus() {
		return ultimoStatus;
	}
	public void setUltimoStatus(UltimoStatus ultimoStatus) {
		this.ultimoStatus = ultimoStatus;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getUrlWebsite() {
		return urlWebsite;
	}
	public void setUrlWebsite(String urlWebsite) {
		this.urlWebsite = urlWebsite;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getUfNascimento() {
		return ufNascimento;
	}
	public void setUfNascimento(String ufNascimento) {
		this.ufNascimento = ufNascimento;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getDataFalecimento() {
		return dataFalecimento;
	}
	public void setDataFalecimento(String dataFalecimento) {
		this.dataFalecimento = dataFalecimento;
	}
	public String getMunicipioNascimento() {
		return municipioNascimento;
	}
	public void setMunicipioNascimento(String municipioNascimento) {
		this.municipioNascimento = municipioNascimento;
	}
	public List<String> getRedeSocial() {
		return redeSocial;
	}
	public void setRedeSocial(List<String> redeSocial) {
		this.redeSocial = redeSocial;
	}
	
}
