package br.com.scf.conta.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.scf.pessoa.pojo.PessoaFisica;
import br.com.scf.stb.tipo.pojo.Tipo;

@Entity
@Table(name="Conta")
public class Conta implements Serializable{

	private static final long serialVersionUID = 8021049061533884557L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idConta;
	
	@Enumerated
	private Status status;
	
	@OneToOne
	private Tipo tipo;
	
	@OneToOne
	private PessoaFisica titular; 

	@Temporal(TemporalType.DATE)
	private Calendar dtVencimentoConta;
	
	private String descricao;
	private BigDecimal valorConta;
	
	
	/*Geteres and Seteres*/
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValorConta() {
		return valorConta;
	}
	public void setValorConta(BigDecimal valorConta) {
		this.valorConta = valorConta;
	}
	public Calendar getDtVencimentoConta() {
		return dtVencimentoConta;
	}
	public void setDtVencimentoConta(Calendar dtVencimentoConta) {
		this.dtVencimentoConta = dtVencimentoConta;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Integer getIdConta() {
		return idConta;
	}
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
	public PessoaFisica getTitular() {
		return titular;
	}
	public void setTitular(PessoaFisica titular) {
		this.titular = titular;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dtVencimentoConta == null) ? 0 : dtVencimentoConta.hashCode());
		result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
		result = prime * result + ((valorConta == null) ? 0 : valorConta.hashCode());
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
		Conta other = (Conta) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dtVencimentoConta == null) {
			if (other.dtVencimentoConta != null)
				return false;
		} else if (!dtVencimentoConta.equals(other.dtVencimentoConta))
			return false;
		if (idConta == null) {
			if (other.idConta != null)
				return false;
		} else if (!idConta.equals(other.idConta))
			return false;
		if (status != other.status)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		if (valorConta == null) {
			if (other.valorConta != null)
				return false;
		} else if (!valorConta.equals(other.valorConta))
			return false;
		return true;
	}
	
}
