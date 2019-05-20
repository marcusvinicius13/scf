package br.com.scf.stb.tipo.dao;

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
import br.com.scf.stb.tipo.pojo.Tipo;
import br.com.scf.tx.Transacional;
import br.com.scf.util.DAO;

public class TipoDAO implements Serializable, GenericDAO<Tipo> {
	private static final long serialVersionUID = 3524222491623206285L;

	@Inject
	EntityManager em;
	
	private DAO<Tipo> dao;
	

	@PostConstruct
	void init() {
		this.dao = new DAO<Tipo>(this.em, Tipo.class);
	}
	
	
	@Transacional
	@Override
	public String salvar(Tipo tipo) {
		boolean isSalvar = true;
		
		if (tipo != null && tipo.getIdTipo() != null)
			isSalvar = false;
		
		if(isSalvar)
			this.dao.salva(tipo);
		else
			this.dao.atualiza(tipo);
		
		if(isSalvar)
			return "Registro cadastrado com sucesso!!.";
		else
			return "Registro atualizado com sucesso!!.";
	}
	
	@Transacional
	@Override
	public String excluir(Tipo tipo) {
		this.dao.exclui(tipo);
		return null;
	}
	
	
	@Override
	public Tipo selecionar(Tipo t) {
		return null;
	}


	@Override
	public List<Tipo> consultar() {
		return null;
	}
	
	
	public List<Tipo> encontrarTodos() {
		return this.dao.listaTodos();
	}
	
	
	public List<Tipo> buscarPelaDescricao(String dado) {
	    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	    CriteriaQuery<Tipo> query = criteriaBuilder.createQuery(Tipo.class);
	    Root<Tipo> root = query.from(Tipo.class);

	    Path<String> nomePath = root.<String> get("descricao");

	    if (!dado.isEmpty()) {
	        Predicate nomeIgual = criteriaBuilder.like(nomePath, "%" + dado + "%");
	        query.where(nomeIgual);
	    }
	   
	   return em.createQuery(query).getResultList();
	}
	
	
	public List<Tipo> buscarPelaDescricaoESgSistema(String descricao, String sgSistema) {
	    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	    CriteriaQuery<Tipo> query = criteriaBuilder.createQuery(Tipo.class);
	    Root<Tipo> root = query.from(Tipo.class);

	    Path<String> descricaoPath = root.<String> get("descricao");
	    Path<String> sgSistemaPath = root.<String> get("sgSistema");
	    
	    Predicate conjunction = criteriaBuilder.conjunction();
	    if(descricao != null)
	    	conjunction = criteriaBuilder.and(conjunction, criteriaBuilder.like(descricaoPath, "%" + descricao + "%"));
	    if(sgSistema != null)
	    	conjunction = criteriaBuilder.and(conjunction, criteriaBuilder.equal(sgSistemaPath, sgSistema)); 
	    
	    query.where(conjunction);
	   
	   return em.createQuery(query).getResultList();
	}
	
	
}
