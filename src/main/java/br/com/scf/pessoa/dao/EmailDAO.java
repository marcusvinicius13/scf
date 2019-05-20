package br.com.scf.pessoa.dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.scf.conta.pojo.Email;
import br.com.scf.tx.Transacional;
import br.com.scf.util.DAO;

public class EmailDAO implements Serializable {

	private static final long serialVersionUID = 8528523849382906918L;

	@Inject
	EntityManager em;
	
	private DAO<Email> dao ;

	@PostConstruct
	void init() {
		this.dao = new DAO<Email>(this.em, Email.class);
	}
	
	@Transacional
	public void salvar(Email email) {
		this.dao.salva(email);
	}
	
	@Transacional
	public void excluir(Email email) {
		this.dao.exclui(email);
	}
	
	/*Geteres and Seteres*/
	public DAO<Email> getDao() {
		return dao;
	}

	public void setDao(DAO<Email> dao) {
		this.dao = dao;
	}

}
