package br.com.scf.telefonema.pojo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.scf.stb.tipo.pojo.Tipo;

@Entity
@Table(name = "TELEFONEMA")
public class Telefonema implements Serializable{
	
	private static final long serialVersionUID = -4395065695582971578L;

	@Id
	@Column(name="ID_TELEFONEMA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTelefonema;
	
	@OneToOne
	private Contato contato;
	
	@Column(name="FL_SITUACAO")
	private String flSituacao;
	
	@Column(name="DATA_CONTATO")
	@Temporal(TemporalType.DATE)
	private Calendar dataContato;
	
	@Column(name="HORA_CONTATO")
	private String hora;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="ASSUNTO")
	private String assunto;
	
	@Column(name="TIPO")
	private Tipo flTipo;
	
	@Column(name="OBSERVACAO")
	private String observacao;
	
	@Column(name="TELEFONE_CONTATO")
	private Telefone telefoneParaContato;
	
	
	/*Geteres and Seteres*/
	
	
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public String getFlSituacao() {
		return flSituacao;
	}
	public void setFlSituacao(String flSituacao) {
		this.flSituacao = flSituacao;
	}
	public Calendar getDataContato() {
		return dataContato;
	}
	public void setDataContato(Calendar dataContato) {
		this.dataContato = dataContato;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Telefone getTelefoneParaContato() {
		return telefoneParaContato;
	}
	public void setTelefoneParaContato(Telefone telefoneParaContato) {
		this.telefoneParaContato = telefoneParaContato;
	}
}
