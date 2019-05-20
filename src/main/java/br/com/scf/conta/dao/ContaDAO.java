package br.com.scf.conta.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.scf.conta.pojo.Conta;
import br.com.scf.generic.dao.GenericDAO;
import br.com.scf.tx.Transacional;
import br.com.scf.util.DAO;

public class ContaDAO implements Serializable , GenericDAO<Conta>{

	private static final long serialVersionUID = -4643732475564955886L;

	@Inject
	EntityManager em;
	
	private DAO<Conta> dao ;

	@PostConstruct
	void init() {
		this.dao = new DAO<Conta>(this.em, Conta.class);
	}
	
	@Transacional
	@Override
	public String salvar(Conta conta) {
		boolean isSalvar = true;
		
		if (conta != null && conta.getIdConta() != null)
			isSalvar = false;
		
		if(isSalvar)
			this.dao.salva(conta);
		else
			this.dao.atualiza(conta);
		
		if(isSalvar)
			return "listar-contas?faces-redirect=true";
		else
			return null;
		
	}

	public List<Conta> encontrarTodos() {
		return dao.listaTodos();
	}

	@Override
	public Conta selecionar(Conta t) {
		return null;
	}

	@Override
	@Transacional
	public String excluir(Conta conta) {
		this.dao.exclui(conta);
		return "Conta excluída com Sucesso!!!";
	}

	@Override
	public List<Conta> consultar() {
		return null;
	}

}
