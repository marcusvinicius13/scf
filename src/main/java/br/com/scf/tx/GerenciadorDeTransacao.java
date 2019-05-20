package br.com.scf.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable{
	
	private static final long serialVersionUID = 3385987300028727780L;
	
	@Inject
	EntityManager manager;

	@AroundInvoke
	public Object executaTx(InvocationContext contexto) throws Exception{
		manager.getTransaction().begin(); // abre transacao
		Object resultado = contexto.proceed(); //Execulta o método passado por contexto
		manager.getTransaction().commit(); // commita a transacao
		return resultado;
	}

}
