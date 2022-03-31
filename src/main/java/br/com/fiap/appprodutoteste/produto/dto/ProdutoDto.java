package br.com.fiap.appprodutoteste.produto.dto;

import java.math.BigDecimal;

public class ProdutoDto {
	private String nome; 
	private Integer quantidade; 
	private BigDecimal valor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	} 
}
