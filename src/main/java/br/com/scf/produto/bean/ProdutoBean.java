package br.com.scf.produto.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.scf.generic.model.GenericModal;
import br.com.scf.global.Mensagem;
import br.com.scf.produto.dao.ProdutoDAO;
import br.com.scf.produto.pojo.Produto;

@Named(value = "produtoBean")
@ViewScoped
public class ProdutoBean implements Serializable{

	private static final long serialVersionUID = -720466674079004790L;
	
	@Inject
	private ProdutoDAO dao;
	
	@Inject
	private Produto produto;
	
	@Inject
	private GenericModal modal;
	
	@Inject
	private List<Produto> produtoList;
	
	@PostConstruct
	public void init() {
		produtoList = dao.encontrarTodos();
	}
	
	
	public String salvar() {
		String retorno = dao.salvar(produto);
		modal.closeModal();
		produtoList.add(produto);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produtoList", produtoList);
		novo();
		return retorno;
	}
	
	public String consultar() {
		produtoList = dao.encontrarTodos();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produtoList", produtoList);
		return null;
	}
	
	public void selecionar(Produto produto) {
		this.produto = produto;
	}
	
	public void novo() {
		produto = new Produto();
	}
	
	public void excluir(Produto produto) {
		dao.excluir(produto);
		produtoList.remove(produto);
		Mensagem.mensagemExcluir();
	}
	
	public void showMessage() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado!", "Registro atualizado com sucesso!!.");
	     PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	
	
	/*Geteres and Seteres*/
	
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}
}
