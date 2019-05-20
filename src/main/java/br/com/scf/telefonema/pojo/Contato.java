package br.com.scf.telefonema.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.scf.conta.pojo.Email;

@Entity
@Table(name = "CONTATO")
public class Contato implements Serializable{
	
	private static final long serialVersionUID = -4575549959409749442L;
	
	@Id
	@Column(name="ID_CONTATO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "FL_STATUS")
	private String flStatus;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "contato", optional = false)
	private Telefonema telefonema;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ID_CONTATO") 
	private List<Email> emailList = new ArrayList<>();
	
	
	/*GETERES and SETERES*/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public List<Email> getEmailList() {
//		return emailList;
//	}
//
//	public void setEmailList(List<Email> emailList) {
//		this.emailList = emailList;
//	}

	public String getFlStatus() {
		return flStatus;
	}

	public void setFlStatus(String flStatus) {
		this.flStatus = flStatus;
	}
	
}
