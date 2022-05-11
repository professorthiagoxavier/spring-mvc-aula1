package br.com.fiap.appprodutoteste.produto.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.fiap.appprodutoteste.produto.model.Produto;

public class ProdutoDto {
	@NotBlank
	@NotNull
	private String nome;

	private Integer quantidade;

	@NotNull
	@DecimalMin(value = "0.0")
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

	public void fromProduto(Produto produto) {
		this.valor = produto.getValor();
		this.nome = produto.getNome();
		this.quantidade = produto.getQuantidade();
		
		
	}

}
