package br.com.scf.compra.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.scf.compra.pojo.Compra;
import br.com.scf.generic.dao.GenericDAO;
import br.com.scf.tx.Transacional;
import br.com.scf.util.DAO;

public class CompraDAO implements Serializable, GenericDAO<Compra> {

	private static final long serialVersionUID = -819534195479700795L;

	@Inject
	EntityManager em;
	
	private DAO<Compra> dao ;

	@PostConstruct
	void init() {
		this.dao = new DAO<Compra>(this.em, Compra.class);
	}
	
	
	@Override
	@Transacional
	public String salvar(Compra compra) {
		boolean isSalvar = true;
		
		if (compra != null && compra.getIdCompra() != null)
			isSalvar = false;
		
		if(isSalvar)
			dao.salva(compra);
		else
			dao.atualiza(compra);
		
		if(isSalvar)
			return "listar-compras?faces-redirect=true";
		else
			return null;
	}

	@Override
	@Transacional
	public String excluir(Compra compra) {
		dao.exclui(compra);
		return "Compra excluída com Sucesso!!!";
	}

	@Override
	public Compra selecionar(Compra compra) {
		return null;
	}


	@Override
	public List<Compra> consultar() {
		return null;
	}
	
	public List<Compra> encontrarTodos() {
		return dao.listaTodos();
	}

	/*Geteres and Seteres*/
	
	public DAO<Compra> getDao() {
		return dao;
	}

	public void setDao(DAO<Compra> dao) {
		this.dao = dao;
	}

}
