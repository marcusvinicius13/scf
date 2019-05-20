package br.com.scf.produto.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.scf.generic.dao.GenericDAO;
import br.com.scf.produto.pojo.Produto;
import br.com.scf.tx.Transacional;
import br.com.scf.util.DAO;

public class ProdutoDAO implements Serializable, GenericDAO<Produto>{

	private static final long serialVersionUID = 5358543279339574931L;

	@Inject
	EntityManager em;
	
	private DAO<Produto> dao ;

	@PostConstruct
	void init() {
		this.dao = new DAO<Produto>(this.em, Produto.class);
	}
	
	@Override
	@Transacional
	public String salvar(Produto produto) {
		boolean isSalvar = true;
		
		if (produto != null && produto.getIdProduto() != null)
			isSalvar = false;
		
		if(isSalvar)
			dao.salva(produto);
		else
			dao.atualiza(produto);
		
		if(isSalvar)
			return "Produto cadastrado com sucesso!!.";
		else
			return "Produto atualizado com sucesso!!.";
	}

	@Override
	@Transacional
	public String excluir(Produto produto) {
		dao.exclui(produto);
		return "Produto excluída com Sucesso!!!";
	}

	@Override
	public Produto selecionar(Produto produto) {
		return null;
	}


	@Override
	public List<Produto> consultar() {
		return null;
	}
	
	public List<Produto> encontrarTodos() {
		return dao.listaTodos();
	}

}
