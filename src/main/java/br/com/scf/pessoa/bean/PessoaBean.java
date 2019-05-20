package br.com.scf.pessoa.bean;

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

import br.com.scf.conta.pojo.Email;
import br.com.scf.converters.GenericConverter;
import br.com.scf.generic.model.GenericModal;
import br.com.scf.pessoa.dao.EmailDAO;
import br.com.scf.pessoa.dao.PessoaDAO;
import br.com.scf.pessoa.pojo.PessoaFisica;

@Named(value = "pessoaBean")
@ViewScoped
public class PessoaBean implements Serializable{
	
	private static final long serialVersionUID = 7266283882076272522L;
	private List<PessoaFisica> pessoaList = new ArrayList<>();
	private List<Email> emailList = new ArrayList<>();
	
	private String dtNascimento = "";
	private Integer idPessoaFisica;
	
	private String linkPaginaAnterior;
	
	private PessoaFisica pessoa;
	
	@Inject
	private Email email;
	
	@Inject
	private EmailDAO daoEmail;
	
	@Inject
	private PessoaDAO dao;
	
	@Inject
	private GenericConverter converter;
	
	@Inject
	private GenericModal modal;
	
	@PostConstruct
	public void init() {
		pessoaList = dao.consultar();
		this.pessoa = (PessoaFisica) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pessoa");
		this.linkPaginaAnterior = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("voltar");
		
		if(this.pessoa != null && this.pessoa.getDtNascimento() != null) {
			dtNascimento = converter.retornaDataConvertida(this.pessoa.getDtNascimento());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoa");
		}else
			pessoa = new PessoaFisica();
	}
	
	public String salvar() {
		if(dtNascimento != null)
			pessoa.setDtNascimento(converter.retornaDataConvertida(dtNascimento));
		modal.closeModal();
		String retorno = this.dao.salvar(pessoa);
		novo();
		if(retorno != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", linkPaginaAnterior = "cadastrar-pessoa?faces-redirect=true");
		}else {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", "listar-pessoas?faces-redirect=true");
		}
		return retorno;
	}
	
	public String consultar() {
		pessoaList = dao.consultar();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("voltar", "consultar-pessoas?faces-redirect=true");
		return "listar-pessoas?faces-redirect=true";
	}
	
	public String voltar() {
		novo();
		return linkPaginaAnterior;
	}
		
	private void novo() {
		pessoa = new PessoaFisica();
	}

	public void selecionar(PessoaFisica pessoa) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoa", pessoa);
		modal.openModal("cadastrar-pessoa");
	}
	
	public void excluirPessoa(PessoaFisica pessoa) {
		this.dao.excluir(pessoa);
		pessoaList.remove(pessoa);
	}
	
	public void showMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado!", "Registro atualizado com sucesso!!.");
	    PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	 
	/*Tudo Referente aos emails vinculados*/
	
	public String adcionarEmail() {
		pessoa.adicionaEmail(email);
		this.email = new Email();
		return null;
	}
	
	public void alterarEmail(Email email) {
		removerEmail(email);
		this.email = email;
	}
	
	public void removerEmail(Email email) {
		List<Email> emailList = pessoa.getEmailList();
		emailList.remove(email);
		if(!emailList.isEmpty())
			pessoa.setEmailList(emailList);
		else
			pessoa.setEmailList(new ArrayList<Email>());
	}
	
	public void excluirEmail(Email email) {
		daoEmail.excluir(email);
		removerEmail(email);
	}
	
	/*Geteres and Seteres*/
	
	public PessoaFisica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}


	public List<PessoaFisica> getPessoaList() {
		return pessoaList;
	}


	public void setPessoaList(List<PessoaFisica> pessoaList) {
		this.pessoaList = pessoaList;
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

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}
	
	public String getLinkPaginaAnterior() {
		return linkPaginaAnterior;
	}

	public void setLinkPaginaAnterior(String linkPaginaAnterior) {
		this.linkPaginaAnterior = linkPaginaAnterior;
	}
	
}
