package br.com.scf.compromisso.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.scf.compromisso.pojo.Compromisso;
import br.com.scf.generic.dao.GenericDAO;
import br.com.scf.tx.Transacional;
import br.com.scf.util.DAO;

public class CompromissoDAO implements Serializable , GenericDAO<Compromisso>{

	private static final long serialVersionUID = -317828371220461809L;

	@Inject
	EntityManager em;
	
	private DAO<Compromisso> dao ;

	@PostConstruct
	void init() {
		this.dao = new DAO<Compromisso>(this.em, Compromisso.class);
	}
	
	@Transacional
	@Override
	public String salvar(Compromisso compromisso) {
		boolean isSalvar = true;
		
		if (compromisso != null && compromisso.getIdCompromisso() != null)
			isSalvar = false;
		
		if(isSalvar)
			this.dao.salva(compromisso);
		else
			this.dao.atualiza(compromisso);
		
		if(isSalvar)
			return "listar-compromissos?faces-redirect=true";
		else
			return null;
		
	}

	public List<Compromisso> encontrarTodos() {
		return dao.listaTodos();
	}

	@Override
	public Compromisso selecionar(Compromisso compromisso) {
		return null;
	}

	@Override
	@Transacional
	public String excluir(Compromisso compromisso) {
		this.dao.exclui(compromisso);
		return "Compromisso excluído com Sucesso!!!";
	}

	@Override
	public List<Compromisso> consultar() {
		return null;
	}

}
