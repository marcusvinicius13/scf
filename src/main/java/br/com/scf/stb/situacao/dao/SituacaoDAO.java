package br.com.scf.stb.situacao.dao;

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
import br.com.scf.stb.situacao.pojo.Situacao;
import br.com.scf.tx.Transacional;
import br.com.scf.util.DAO;

public class SituacaoDAO implements Serializable, GenericDAO<Situacao> {

	private static final long serialVersionUID = -7469811024858332061L;

	@Inject
	EntityManager em;
	
	private DAO<Situacao> dao;
	

	@PostConstruct
	void init() {
		this.dao = new DAO<Situacao>(this.em, Situacao.class);
	}
	
	
	@Transacional
	@Override
	public String salvar(Situacao situacao) {
		boolean isSalvar = true;
		
		if (situacao != null && situacao.getIdSituacao() != null)
			isSalvar = false;
		
		if(isSalvar)
			this.dao.salva(situacao);
		else
			this.dao.atualiza(situacao);
		
		if(isSalvar)
			return "Registro cadastrado com sucesso!!.";
		else
			return "Registro atualizado com sucesso!!.";
	}

	@Override
	public Situacao selecionar(Situacao situacao) {
		return null;
	}

	@Transacional
	@Override
	public String excluir(Situacao situacao) {
		this.dao.exclui(situacao);
		return null;
	}

	@Override
	public List<Situacao> consultar() {
		return dao.listaTodos();
	}
	
	/*Testar e utilizar no lugar do consultar*/
	
	public List<Situacao> buscarPelaDescricaoESgSistema(String descricao, String sgSistema) {
	    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	    CriteriaQuery<Situacao> query = criteriaBuilder.createQuery(Situacao.class);
	    Root<Situacao> root = query.from(Situacao.class);

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
