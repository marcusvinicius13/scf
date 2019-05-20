package br.com.scf.util;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> implements Serializable{

	private static final long serialVersionUID = 3176486322204301197L;

	private final Class<T> classe;
	
	@Inject
	private EntityManager em;
	
	public DAO(EntityManager em, Class<T> classe) {
		this.classe = classe;
		this.em = em;
	}
	
	public void salva(T t) {
		em.persist(t);
	}
	
	public void exclui(T t) {
		T objeto = em.merge(t);
		em.remove(objeto);
	}
	
	public void atualiza(T t) {
		em.merge(t);
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorId(Integer id) {
		T instancia = em.find(classe, id);
		return instancia;
	}

	public int contaTodos() {
		long result = (Long) em.createQuery("select count(n) from livro n")
				.getSingleResult();

		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> buscarPorParametro(String dado, String campoComparacao, String tabela) {
		String parametro = ":" + campoComparacao;
		
		return (List<T>) em.createQuery(
				"select tabela from " +	tabela + " tabela " +
				" where " + campoComparacao + " like " + parametro  
		).setParameter(parametro, '%'+dado+'%').getResultList();
		
	}
	
	
	
//	
//	public T buscarPorLogin(String login) {
//		TypedQuery<Usuario> usuarioList = em.createQuery("select u from Usuario u " +
//				"where email = :pEmail").setParameter("pEmail", login).getResultList();
//		return usuarioList;
//	}

}
