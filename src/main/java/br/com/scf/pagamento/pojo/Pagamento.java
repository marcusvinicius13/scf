package br.com.scf.pagamento.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.scf.stb.situacao.pojo.Situacao;

@Entity
@Table(name = "PAGAMENTO")
public class Pagamento implements Serializable{

	private static final long serialVersionUID = -1471771359901734373L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_PAGAMENTO")
	private Integer idPagamento;
	
	@Enumerated
	private FormaDePagamento formaDePagamento; 
	
	@OneToOne
	private Situacao situacao;
	
	private int quantidadeDeParcelas;
	private int quantidadeDeParcelasPagas;
	
	private BigDecimal valorTotal;
	private BigDecimal valorPago;
	private BigDecimal valorPorParcela;
	
	private Calendar dtPagamento;
	
	
	
	/*Geteres and Seteres*/
	
	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	public int getQuantidadeDeParcelas() {
		return quantidadeDeParcelas;
	}
	public void setQuantidadeDeParcelas(int quantidadeDeParcelas) {
		this.quantidadeDeParcelas = quantidadeDeParcelas;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public BigDecimal getValorPorParcela() {
		return valorPorParcela;
	}
	public void setValorPorParcela(BigDecimal valorPorParcela) {
		this.valorPorParcela = valorPorParcela;
	}
	public Integer getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}
	public Calendar getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(Calendar dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
//	public Situacao getSituacao() {
//		return situacao;
//	}
//	public void setSituacao(Situacao situacao) {
//		this.situacao = situacao;
//	}
	public int getQuantidadeDeParcelasPagas() {
		return quantidadeDeParcelasPagas;
	}
	public void setQuantidadeDeParcelasPagas(int quantidadeDeParcelasPagas) {
		this.quantidadeDeParcelasPagas = quantidadeDeParcelasPagas;
	}
	public BigDecimal getValorPago() {
		return valorPago;
	}
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	
}
