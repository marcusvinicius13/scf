package br.com.scf.telefonema.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.scf.pessoa.pojo.PessoaFisica;
@Entity
public class Telefone implements Serializable{

	private static final long serialVersionUID = 7943638894682702209L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TELEFONE")
	private Integer id;
	
	@Column(name = "DDD")
	private String ddd;
		
	@Column(name = "NUMERO")
	private String numero;
		
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA_FISICA")
	private PessoaFisica pessoa;

	/*GETERES and SETERES*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public PessoaFisica getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}
	
}
