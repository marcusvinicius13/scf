package br.com.scf.stb.tipo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.scf.stb.tipo.dao.TipoDAO;
import br.com.scf.stb.tipo.pojo.Tipo;


@Named(value = "tipoBean")
@ViewScoped
public class TipoBean implements Serializable{

	private static final long serialVersionUID = 7363047400970968440L;

	@Inject
	private Tipo tipo;
	
	@Inject
	private TipoDAO dao;
		
	private List<Tipo> tipoList = new ArrayList<>();
	
	private FacesMessage mensagem; 
	
	@PostConstruct
	public void init() {
		tipoList = this.dao.encontrarTodos();
	}

	
	public String salvar() {
		String mensagem = dao.salvar(tipo);
		tipoList.add(tipo);
		novo();
		if(mensagem.equals("Registro cadastrado com sucesso!!.")) {
			this.mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado!", mensagem);
		}else {
			this.mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado!", mensagem);
		}
		PrimeFaces.current().dialog().showMessageDynamic(this.mensagem);
		return null;
	}
	
	public void selecionar(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public void excluir(Tipo tipo) {
		dao.excluir(tipo);
		tipoList.remove(tipo);
	}
	
	private void novo() {
		tipo = new Tipo();
	}
	
	public void showMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado!", "Atualizado com sucesso!!!");
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	

	public void consultar() {
		
	}
	
	/*Geteres and Seteres*/
	
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	public List<Tipo> getTipoList() {
		return tipoList;
	}


	public void setTipoList(List<Tipo> tipoList) {
		this.tipoList = tipoList;
	}


	public FacesMessage getMensagem() {
		return mensagem;
	}


	public void setMensagem(FacesMessage mensagem) {
		this.mensagem = mensagem;
	}
	
}
