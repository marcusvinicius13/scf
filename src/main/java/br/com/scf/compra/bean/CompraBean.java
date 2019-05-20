package br.com.scf.compra.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.scf.compra.dao.CompraDAO;
import br.com.scf.compra.pojo.Compra;
import br.com.scf.generic.model.GenericModal;
import br.com.scf.global.Mensagem;
import br.com.scf.produto.dao.ProdutoDAO;
import br.com.scf.produto.pojo.Produto;
import br.com.scf.stb.situacao.dao.SituacaoDAO;
import br.com.scf.stb.situacao.pojo.Situacao;
import br.com.scf.stb.tipo.dao.TipoDAO;
import br.com.scf.stb.tipo.pojo.Tipo;

@Named(value = "compraBean")
@ViewScoped
public class CompraBean implements Serializable{

	private static final long serialVersionUID = -3243258714210368316L;

	/*Declaração de Variáveis*/
	
	@Inject
	private Compra compra;
	
	@Inject
	private TipoDAO tipoDao;
	
	@Inject
	private SituacaoDAO situacaoDao;
	
	@Inject
	private CompraDAO dao;
	
	@Inject
	private ProdutoDAO daoProduto;
	
	@Inject
	private GenericModal modal;
	
	@Inject
	private Produto produto;
	
	@Inject
	private Situacao situacao;
	
	private List<Tipo> tipoList = new ArrayList<>();
	
	private List<Situacao> situacaoList = new ArrayList<>();
	
	private List<Compra> compraList = new ArrayList<>();

	private String linkPaginaAnterior;

	private List<Produto> produtoList;

	
	
	/* Métodos */
	
	@PostConstruct
	public void init() {
		popularVariaveisDeInicializacao();
	}
	
	@SuppressWarnings("unchecked")
	private void popularVariaveisDeInicializacao() {
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("compra") != null)
			compra = (Compra) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("compra");
		else
			compra = new Compra();
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("compraList") != null)
			compraList = (List<Compra>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("compraList");
			
		linkPaginaAnterior = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("voltar");
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("compra");
	}
	
	
	public String salvar() {
		String retorno = dao.salvar(compra);
		modal.closeModal();
		compraList = dao.encontrarTodos();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("compraList", compraList);
		novo();
		if(retorno != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", linkPaginaAnterior = "cadastrar-compra?faces-redirect=true");
		}else {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", "listar-compra?faces-redirect=true");
		}
		return retorno;
	}
	
	public void excluir(Compra compra) {
		dao.excluir(compra);
		compraList.remove(compra);
		Mensagem.mensagemExcluir();
	}
	
	public String consultar() {
		compraList = dao.encontrarTodos();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("compraList", compraList);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", "consultar-compra?faces-redirect=true");
		return "listar-compras?faces-redirect=true";
	}
	
	public void selecionar(Compra compra) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("compra", compra);
		modal.openModal("cadastrar-compra");
	}
	
	public void novo() {
		produto = new Produto();
	}

	public String voltar() {
		return linkPaginaAnterior;
	}
	
	public void showMessage() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado!", "Registro atualizado com sucesso!!.");
	     PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	
	public void buscarTipo() {
		tipoList = tipoDao.buscarPelaDescricaoESgSistema(compra.getTipo().getDescricao(),"COM");
	}
	
	public void buscarSituacao(String sigla) {
		situacaoList = situacaoDao.buscarPelaDescricaoESgSistema(situacao.getDescricao(), sigla);
	}
	
	public void selecionarTipo(Tipo tipo) {
		compra.setTipo(tipo);
	}
	
	public void selecionarSituacao(Situacao situacao) {
		compra.setSituacao(situacao);
	}
	
	public void selecionarSituacaoProduto(Situacao situacao) {
		produto.setSituacao(situacao);
	}
	
	/*Adicionar produtos*/
	
	public String adcionarProduto() {
		compra.adicionaProduto(produto);
		this.produto = new Produto();
		return null;
	}
	
	public void alterarProduto(Produto produto) {
		removerProduto(produto);
		this.produto = produto;
	}
	
	public void removerProduto(Produto produto) {
		List<Produto> produtoList = compra.getProdutoList();
		produtoList.remove(produto);
		if(!produtoList.isEmpty())
			compra.setProdutoList(produtoList);
		else
			compra.setProdutoList(new ArrayList<Produto>());
	}
	
	public void excluirProduto(Produto produto) {
		daoProduto.excluir(produto);
		removerProduto(produto);
	}
	
	
	/*Geteres and Seteres*/
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public List<Tipo> getTipoList() {
		return tipoList;
	}

	public void setTipoList(List<Tipo> tipoList) {
		this.tipoList = tipoList;
	}

	public List<Situacao> getSituacaoList() {
		return situacaoList;
	}

	public void setSituacaoList(List<Situacao> situacaoList) {
		this.situacaoList = situacaoList;
	}

	public List<Compra> getCompraList() {
		return compraList;
	}

	public void setCompraList(List<Compra> compraList) {
		this.compraList = compraList;
	}

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

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
}
