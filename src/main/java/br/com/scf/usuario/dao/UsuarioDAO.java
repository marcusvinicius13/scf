package br.com.scf.usuario.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.scf.usuario.pojo.Usuario;

public class UsuarioDAO implements Serializable{

	private static final long serialVersionUID = 159084130154054367L;
	@Inject
	EntityManager em;
	

	public Usuario existe(Usuario usuario) {
		Usuario usu;
		try {
			TypedQuery<Usuario> query = em.createQuery(
				  "select u from Usuario u "
				+ " where u.email = :pEmail and u.senha = :pSenha", Usuario.class);
		
			query.setParameter("pEmail", usuario.getEmail());
			query.setParameter("pSenha", usuario.getSenha());
		
			usu =  query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
		
		return usu;
	}

}
