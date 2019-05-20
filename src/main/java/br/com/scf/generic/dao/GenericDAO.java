package br.com.scf.generic.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	public String  salvar(T t);
	
	public T selecionar(T t);
	
	public String excluir(T t) ;
	
	public List<T> consultar();
	
}
