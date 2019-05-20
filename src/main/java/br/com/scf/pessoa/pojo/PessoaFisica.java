package br.com.scf.pessoa.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;

import br.com.scf.conta.pojo.Email;
import br.com.scf.telefonema.pojo.Telefone;

@Entity
@Table(name="Pessoa_Fisica")
public class PessoaFisica implements Serializable{
	
	private static final long serialVersionUID = 8704119527130505883L;

	@Id 
	@Column(name="ID_PESSOA_FISICA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPessoaFisica;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="DATA_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dtNascimento = Calendar.getInstance();
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ID_PESSOA_FISICA")  
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Email> emailList = new ArrayList<>();
		
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ID_PESSOA_FISICA")  
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Telefone> telefoneList = new ArrayList<>();
	
	
	public void adicionaEmail(Email email) {
		this.emailList.add(email);
	}
	
	/*Construtores*/
	public PessoaFisica() {}
	
	public PessoaFisica(String nome, String cpf) {
		this.nome = nome; 
		this.cpf = cpf;
	}
	
	
	/*Geteres and Seteres*/
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Calendar getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public List<Email> getEmailList() {
		return emailList;
	}
	public void setEmailList(List<Email> emailList) {
		this.emailList = emailList;
	}
	public Integer getIdPessoaFisica() {
		return idPessoaFisica;
	}
	public void setIdPessoaFisica(Integer idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dtNascimento == null) ? 0 : dtNascimento.hashCode());
		result = prime * result + ((idPessoaFisica == null) ? 0 : idPessoaFisica.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		PessoaFisica other = (PessoaFisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dtNascimento == null) {
			if (other.dtNascimento != null)
				return false;
		} else if (!dtNascimento.equals(other.dtNascimento))
			return false;
		if (idPessoaFisica == null) {
			if (other.idPessoaFisica != null)
				return false;
		} else if (!idPessoaFisica.equals(other.idPessoaFisica))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public List<Telefone> getTelefoneList() {
		return telefoneList;
	}

	public void setTelefoneList(List<Telefone> telefoneList) {
		this.telefoneList = telefoneList;
	}

}
