package br.com.scf.produto.pojo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.scf.compra.pojo.Compra;
import br.com.scf.stb.situacao.pojo.Situacao;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable{

	private static final long serialVersionUID = -5714396437191243504L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUTO")
	private Integer idProduto;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "DT_VENCIMENTO")
	private Calendar dtVencimento = Calendar.getInstance();
	
	@Column(name = "QUANTIDADE")
	private int quantidade;
	
	@OneToOne
	@JoinColumn(name = "ID_SITUACAO")
	private Situacao situacao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_COMPRA")
	private Compra compra;
	
	
	/* Construtores */
	
	public Produto() {
//		this.situacao = new Situacao();
//		this.dtVencimento = Calendar.getInstance();
	}

	/* Geteres and Seteres */
	
	
	public String getDescricao() {
		return descricao;
	}
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getDtVencimento() {
		return dtVencimento;
	}
	public void setDtVencimento(Calendar dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
