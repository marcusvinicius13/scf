package br.com.scf.compromisso.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.scf.compromisso.dao.CompromissoDAO;
import br.com.scf.compromisso.pojo.Compromisso;
import br.com.scf.generic.model.GenericModal;
import br.com.scf.pessoa.dao.PessoaDAO;
import br.com.scf.pessoa.pojo.PessoaFisica;
import br.com.scf.stb.situacao.dao.SituacaoDAO;
import br.com.scf.stb.situacao.pojo.Situacao;

@Named(value = "compromissoBean")
@ViewScoped
public class CompromissoBean implements Serializable{

	private static final long serialVersionUID = -3994751777605213492L;

	@Inject
	private CompromissoDAO dao;
	
	@Inject
	private SituacaoDAO situacaoDao;
	
	@Inject
	private PessoaDAO pessoaDao;
	
	@Inject
	private Situacao situacao;
	
	@Inject
	private PessoaFisica interessado;
	
	@Inject
	private Compromisso compromisso;
	
	@Inject
	private GenericModal modal;
	
	@Inject
	private List<Situacao> situacaoList;
	
	@Inject
	private List<PessoaFisica> interessadoList;

	@Inject
	private List<Compromisso> compromissoList;

	private String linkPaginaAnterior;
	
	@PostConstruct
	public void init() {
		popularVariaveisDeInicializacao();
	}
	
	@SuppressWarnings("unchecked")
	private void popularVariaveisDeInicializacao() {
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("compromisso") != null)
			compromisso = (Compromisso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("compromisso");
		else
			compromisso = new Compromisso();
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("compromissoList") != null)
			compromissoList = (List<Compromisso>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("compromissoList");
			
		linkPaginaAnterior = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("voltar");
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("compromisso");
	}
	
	public String salvar() {
		String retorno = dao.salvar(this.compromisso);
		modal.closeModal();
		compromissoList = dao.encontrarTodos();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("compromissoList", compromissoList);
		novo();
		if(retorno != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", linkPaginaAnterior = "cadastrar-compromisso?faces-redirect=true");
		}else {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", "listar-compromisso?faces-redirect=true");
		}
		return retorno;
	}
	
	
	private void novo() {
		compromisso = new Compromisso();
	}

	public String consultar() {
		compromissoList = dao.encontrarTodos();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("compromissoList", compromissoList);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", "consultar-compromissos?faces-redirect=true");
		return "listar-compromissos?faces-redirect=true";
	}
	
	public String voltar() {
		return linkPaginaAnterior;
	}

	
	/*SITUAÇÃO DO COMPROMISSO*/
	
	public void buscarSituacao(String sigla) {
		situacaoList = situacaoDao.buscarPelaDescricaoESgSistema(situacao.getDescricao(), sigla);
	}
	
	public void selecionarSituacao(Situacao situacao) {
		this.situacao = situacao;
		compromisso.setSituacao(situacao);
	}
	
	
	/*INTERESSADO AO COMPROMISSO*/
	
	public void buscarInteressado() {
		interessadoList = pessoaDao.buscarPorNome(interessado.getNome());
	}
	
	public void selecionarInteressado(PessoaFisica pessoa) {
		interessado = pessoa;
		this.compromisso.setPessoa(pessoa);
	}
	
	
	
	
	/*Geteres and Seteres*/
	
	
	public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

	public List<Situacao> getSituacaoList() {
		return situacaoList;
	}

	public void setSituacaoList(List<Situacao> situacaoList) {
		this.situacaoList = situacaoList;
	}

	public PessoaFisica getInteressado() {
		return interessado;
	}

	public void setInteressado(PessoaFisica interessado) {
		this.interessado = interessado;
	}

	public List<PessoaFisica> getInteressadoList() {
		return interessadoList;
	}

	public void setInteressadoList(List<PessoaFisica> interessadoList) {
		this.interessadoList = interessadoList;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Compromisso> getCompromissoList() {
		return compromissoList;
	}

	public void setCompromissoList(List<Compromisso> compromissoList) {
		this.compromissoList = compromissoList;
	}
	
}
