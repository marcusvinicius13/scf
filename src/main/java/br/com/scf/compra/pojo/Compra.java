package br.com.scf.compra.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import br.com.scf.pagamento.pojo.Pagamento;
import br.com.scf.produto.pojo.Produto;
import br.com.scf.stb.situacao.pojo.Situacao;
import br.com.scf.stb.tipo.pojo.Tipo;

@Entity
@Table(name = "COMPRA")
public class Compra implements Serializable{

	private static final long serialVersionUID = 4516810154098737660L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPRA")
	private Integer idCompra;
	
	@OneToOne
	private Tipo tipo = new Tipo();
	
	@OneToOne
	private Situacao situacao;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.DETACH, orphanRemoval = true)
	@Inject
	private Pagamento pagamento;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "ID_COMPRA")  
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Produto> produtoList = new ArrayList<>();
	
	
	private Calendar dtCompra;
	
	private String localDeCompra;
	

	public void adicionaProduto(Produto produto) {
		produtoList.add(produto);
	}
	
	
	/*Geteres and Seteres*/
	

	public Tipo getTipo() {
		return tipo;
	}
	public Integer getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public List<Produto> getProdutoList() {
		return produtoList;
	}
	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public Calendar getDtCompra() {
		return dtCompra;
	}
	public void setDtCompra(Calendar dtCompra) {
		this.dtCompra = dtCompra;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public String getLocalDeCompra() {
		return localDeCompra;
	}
	public void setLocalDeCompra(String localDeCompra) {
		this.localDeCompra = localDeCompra;
	}
	
}
