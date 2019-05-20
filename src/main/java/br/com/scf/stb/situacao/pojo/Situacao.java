package br.com.scf.stb.situacao.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITUACAO")
public class Situacao implements Serializable{

	private static final long serialVersionUID = 2874633480480602477L;
	
	@Id
	@Column(name="ID_SITUACAO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSituacao;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="SG_SISTEMA")
	private String sgSistema;
	
	
	/*Geteres and Seteres*/
	
	
	public Integer getIdSituacao() {
		return idSituacao;
	}
	public void setIdSituacao(Integer idSituacao) {
		this.idSituacao = idSituacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSgSistema() {
		return sgSistema;
	}
	public void setSgSistema(String sgSistema) {
		this.sgSistema = sgSistema;
	}

}
