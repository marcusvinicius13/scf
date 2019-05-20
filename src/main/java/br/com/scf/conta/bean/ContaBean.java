package br.com.scf.conta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.scf.conta.dao.ContaDAO;
import br.com.scf.conta.pojo.Conta;
import br.com.scf.conta.pojo.ParametrosDeConsultaConta;
import br.com.scf.conta.pojo.Status;
import br.com.scf.generic.model.GenericModal;
import br.com.scf.global.Mensagem;
import br.com.scf.pessoa.dao.PessoaDAO;
import br.com.scf.pessoa.pojo.PessoaFisica;
import br.com.scf.stb.tipo.dao.TipoDAO;
import br.com.scf.stb.tipo.pojo.Tipo;


@Named(value = "contaBean")
@ViewScoped
public class ContaBean implements Serializable{

	private static final long serialVersionUID = -709183853277779573L;
	
	@Inject
	private Conta conta;

	@Inject
	private TipoDAO tipoDao;
	
	@Inject
	private PessoaDAO pessoaDao;
	
	@Inject
	private ContaDAO dao;
	
	@Inject
	private GenericModal modal;
	
	@Inject
	private Tipo tipo;
	
	@Inject
	private PessoaFisica titular;
	
	private String status;

	private String descricao; 

	
	private String dtVencimento;
	private String dtPagamento;
	
	
	private List<PessoaFisica> titularList = new ArrayList<>();
	private List<Tipo> tipoList = new ArrayList<>();
	private List<Status> statusList = new ArrayList<>();
	
	private List<Conta> contaList = new ArrayList<>();
	private List<Conta> contaListAux = new ArrayList<>();
	
	private ParametrosDeConsultaConta parametros = new ParametrosDeConsultaConta();

	private String linkPaginaAnterior;
	
	@PostConstruct
	public void init() {
		popularVariaveisDeInicializacao();
		statusList = Arrays.asList(Status.values());
	}
	
	@SuppressWarnings("unchecked")
	private void popularVariaveisDeInicializacao() {
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conta") != null)
			this.conta = (Conta) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("conta");
		else
			this.conta = new Conta();
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("contaList") != null)
			this.contaList = (List<Conta>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("contaList");
			
		this.linkPaginaAnterior = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("voltar");
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("conta");
	}
	
	public String salvar() {
		String retorno = this.dao.salvar(this.conta);
		modal.closeModal();
		contaList = dao.encontrarTodos();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contaList", contaList);
		novo();
		if(retorno != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", linkPaginaAnterior = "cadastrar-conta?faces-redirect=true");
		}else {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", "listar-contas?faces-redirect=true");
		}
		return retorno;
	}
	
	public void excluir(Conta conta) {
		dao.excluir(conta);
		contaList.remove(conta);
		Mensagem.mensagemExcluir();
	}
	
	public String consultar() {
		contaList = dao.encontrarTodos();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contaList", contaList);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", "consultar-contas?faces-redirect=true");
		return "listar-contas?faces-redirect=true";
	}
	
	
	public void selecionar(Conta conta) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("conta", conta);
		modal.openModal("cadastrar-conta");
	}
	
	public void showMessage() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado!", "Registro atualizado com sucesso!!.");
	     PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	 
	private void novo() {
		conta = new Conta();
	}
	
	public String voltar() {
		return linkPaginaAnterior;
	}
	
	public void buscarTipo() {
		tipoList = tipoDao.buscarPelaDescricao(conta.getTipo().getDescricao());
	}

	public void buscarTitular() {
		titularList = pessoaDao.buscarPorNome(conta.getTitular().getNome());
	}
	
	public void selecionarTipo(Tipo tipo) {
		this.conta.setTipo(tipo);
	}
	
	public void selecionarTitular(PessoaFisica pessoa) {
		this.conta.setTitular(pessoa);
	}
	
	
	
	/*Dados da conta*/
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public String getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(String dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public String getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(String dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public List<Tipo> getTipoList() {
		return tipoList;
	}

	public void setTipoList(List<Tipo> tipoList) {
		this.tipoList = tipoList;
	}

	public List<Status> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Conta> getContaList() {
		return contaList;
	}

	public void setContaList(List<Conta> contaList) {
		this.contaList = contaList;
	}

	public List<Conta> getContaListAux() {
		return contaListAux;
	}

	public void setContaListAux(List<Conta> contaListAux) {
		this.contaListAux = contaListAux;
	}

	public ParametrosDeConsultaConta getParametros() {
		return parametros;
	}

	public void setParametros(ParametrosDeConsultaConta parametros) {
		this.parametros = parametros;
	}

	public PessoaFisica getTitular() {
		return titular;
	}

	public void setTitular(PessoaFisica titular) {
		this.titular = titular;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public GenericModal getModal() {
		return modal;
	}

	public void setModal(GenericModal modal) {
		this.modal = modal;
	}

	public List<PessoaFisica> getTitularList() {
		return titularList;
	}

	public void setTitularList(List<PessoaFisica> titularList) {
		this.titularList = titularList;
	}
}