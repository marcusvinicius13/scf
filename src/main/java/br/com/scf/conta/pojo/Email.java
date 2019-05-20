package br.com.scf.conta.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.scf.pessoa.pojo.PessoaFisica;
import br.com.scf.telefonema.pojo.Contato;

@Entity
@Table(name="EMAIL")
public class Email implements Serializable{

	private static final long serialVersionUID = 594231279638056507L;
	
		@Id
		@Column(name="ID_EMAIL")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEmail;
	
		@Column(name="EMAIL")
	private String email;
	
		@ManyToOne
		@JoinColumn(name = "ID_PESSOA_FISICA")
	private PessoaFisica pessoa;
	
		@ManyToOne
		@JoinColumn(name = "ID_CONTATO")
	private Contato contato;
	
	
	/*Construtores*/
	public Email() {}
	
	public Email(String email) {
		this.email = email;	
	}
	
	
	/*Geteres and Seteres*/
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIdEmail() {
		return idEmail;
	}
	public void setIdEmail(Integer idEmail) {
		this.idEmail = idEmail;
	}
	public PessoaFisica getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
//	public Contato getContato() {
//		return contato;
//	}
//
//	public void setContato(Contato contato) {
//		this.contato = contato;
//	}
	
}
