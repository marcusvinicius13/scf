package br.com.scf.stb.tipo.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPO")
public class Tipo implements Serializable{

	private static final long serialVersionUID = -8575223306348123552L;

	@Id
	@Column(name="ID_TIPO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipo;
	
	private String descricao;
	
	private String sgSistema;
	
	/*Geteres and Seteres*/
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idTipo == null) ? 0 : idTipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipo other = (Tipo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idTipo == null) {
			if (other.idTipo != null)
				return false;
		} else if (!idTipo.equals(other.idTipo))
			return false;
		return true;
	}

	public String getSgSistema() {
		return sgSistema;
	}

	public void setSgSistema(String sgSistema) {
		this.sgSistema = sgSistema;
	}

}
