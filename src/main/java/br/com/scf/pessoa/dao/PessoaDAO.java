package br.com.scf.pessoa.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.scf.generic.dao.GenericDAO;
import br.com.scf.pessoa.pojo.PessoaFisica;
import br.com.scf.tx.Transacional;
import br.com.scf.util.DAO;

public class PessoaDAO implements Serializable, GenericDAO<PessoaFisica>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager em;
	
	private DAO<PessoaFisica> dao ;

	@PostConstruct
	void init() {
		this.dao = new DAO<PessoaFisica>(this.em, PessoaFisica.class);
	}
	
	@Override
	@Transacional
	public String salvar(PessoaFisica pessoa) {
		boolean isSalvar = true;
		
		if(pessoa != null && pessoa.getIdPessoaFisica() != null) {
			isSalvar = false;
		}
		
		if(isSalvar)
			this.dao.salva(pessoa);
		else
			this.dao.atualiza(pessoa);
		
		if(isSalvar)
			return "listar-pessoas?faces-redirect=true";
		else
			return null;
	}

	@Override
	public PessoaFisica selecionar(PessoaFisica pessoa) {
		return null;
	}

	@Override
	public String excluir(PessoaFisica pessoa) {
		this.dao.exclui(pessoa);
		return "Pessoa excluída com Sucesso!!!";
	}
   
	@Override
	public List<PessoaFisica> consultar() {
		return this.dao.listaTodos();
	}

	public List<PessoaFisica> buscarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	    CriteriaQuery<PessoaFisica> query = criteriaBuilder.createQuery(PessoaFisica.class);
	    Root<PessoaFisica> root = query.from(PessoaFisica.class);

	    Path<String> nomePath = root.<String> get("nome");

	    if (!nome.isEmpty()) {
	        Predicate nomeIgual = criteriaBuilder.like(nomePath, "%" + nome + "%");
	        query.where(nomeIgual);
	    }
	   
	   return em.createQuery(query).getResultList();
	}
	

	
	/*Geteres and Seteres*/
	public DAO<PessoaFisica> getDao() {
		return dao;
	}

	public void setDao(DAO<PessoaFisica> dao) {
		this.dao = dao;
	}


}
