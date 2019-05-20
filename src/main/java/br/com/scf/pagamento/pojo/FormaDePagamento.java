package br.com.scf.pagamento.pojo;

public enum FormaDePagamento {

	AVISTA("Avista"), PROMISSORIA("Promissória"), CARTAO_DE_CREDITO("Cartão de crédito"),
	CARTAO_DE_DEBITO("Cartão de Débito"),CHEQUE("Cheque"), BOLETO("Boleto"),CARNE("Carnê");
	
	private String descricao;
	
	private FormaDePagamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
