package br.com.scf.compromisso.pojo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.scf.pessoa.pojo.PessoaFisica;
import br.com.scf.stb.situacao.pojo.Situacao;

@Entity
@Table(name = "COMPROMISSO")
public class Compromisso implements Serializable{

	private static final long serialVersionUID = -4028021781745649063L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompromisso;
	@Temporal(TemporalType.DATE)
	private Calendar dtCompromisso;
	
	private String evento;
	private String assunto;
	private String presenca;
	private String relevancia;
	private String hrInicio;
	private String hrFim;
	private String local;
	
	@OneToOne
	private Situacao situacao;
	
	@OneToOne
	private PessoaFisica pessoa;
	
	private boolean fbLembrar;

	
	/*Geteres and Seteres*/
	
	

	public Integer getIdCompromisso() {
		return idCompromisso;
	}
	public void setIdCompromisso(Integer idCompromisso) {
		this.idCompromisso = idCompromisso;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public Calendar getDtCompromisso() {
		return dtCompromisso;
	}
	public void setDtCompromisso(Calendar dtCompromisso) {
		this.dtCompromisso = dtCompromisso;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getPresenca() {
		return presenca;
	}
	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}
	public String getRelevancia() {
		return relevancia;
	}
	public void setRelevancia(String relevancia) {
		this.relevancia = relevancia;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public PessoaFisica getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}
	public boolean isFbLembrar() {
		return fbLembrar;
	}
	public void setFbLembrar(boolean fbLembrar) {
		this.fbLembrar = fbLembrar;
	}
	public String getHrInicio() {
		return hrInicio;
	}
	public void setHrInicio(String hrInicio) {
		this.hrInicio = hrInicio;
	}
	public String getHrFim() {
		return hrFim;
	}
	public void setHrFim(String hrFim) {
		this.hrFim = hrFim;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
}
