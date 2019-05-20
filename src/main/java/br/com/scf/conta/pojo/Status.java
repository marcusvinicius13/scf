package br.com.scf.conta.pojo;

public enum Status {
	FINALIZADO("Finalizado"), PENDENTE("Pendente"), PARCIAL("Parcial"), ATRASADO("Em atraso");
	
	private String descricao;
	
	private Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
} 
