package br.com.scf.pagamento.dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.scf.stb.tipo.pojo.Tipo;
import br.com.scf.util.DAO;

public class PagamentoDAO implements Serializable{

	private static final long serialVersionUID = 7619257151060162883L;

	@Inject
	EntityManager em;
	
	private DAO<Tipo> dao;
	

	@PostConstruct
	void init() {
		this.dao = new DAO<Tipo>(this.em, Tipo.class);
	}


	public DAO<Tipo> getDao() {
		return dao;
	}


	public void setDao(DAO<Tipo> dao) {
		this.dao = dao;
	}
	
}
