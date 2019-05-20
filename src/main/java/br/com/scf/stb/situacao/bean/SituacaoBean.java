package br.com.scf.stb.situacao.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.scf.stb.situacao.dao.SituacaoDAO;
import br.com.scf.stb.situacao.pojo.Situacao;

@Named(value = "situacaoBean")
@ViewScoped
public class SituacaoBean implements Serializable{

	private static final long serialVersionUID = 1230504747173745454L;

	
	@Inject
	private Situacao situacao;
	
	@Inject
	private SituacaoDAO dao;
	
	private List<Situacao> situacaoList;
	private FacesMessage mensagem; 
	
	@PostConstruct
	public void init() {
		situacaoList = new ArrayList<>();
		situacaoList = dao.consultar();
	}
	
	public String salvar() {
		String mensagem = dao.salvar(situacao);
		situacaoList.add(situacao);
		novo();
		if(mensagem.equals("Registro cadastrado com sucesso!!.")) {
			this.mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado!", mensagem);
		}else {
			this.mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado!", mensagem);
		}
		PrimeFaces.current().dialog().showMessageDynamic(this.mensagem);
		return null;
	}
	
	public void selecionar(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public void excluir(Situacao situacao) {
		dao.excluir(situacao);
		situacaoList.remove(situacao);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão!", "Registro excluído com sucesso!!!");
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	
	private void novo() {
		situacao = new Situacao();
	}
	
	public void showMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado!", "Atualizado com sucesso!!!");
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	
	/*Getres and Seteres*/
	
	public List<Situacao> getSituacaoList() {
		return situacaoList;
	}
	public void setSituacaoList(List<Situacao> situacaoList) {
		this.situacaoList = situacaoList;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
}
