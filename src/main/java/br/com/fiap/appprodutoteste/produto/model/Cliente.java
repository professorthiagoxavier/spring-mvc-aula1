package br.com.fiap.appprodutoteste.produto.model;

public class Cliente {
	private Long Id; 
	private String Nome; 
	private String Documento; 
	private String Endereco;
	
	
	public Cliente(Long id, String nome, String documento, String endereco) {
		super();
		Id = id;
		Nome = nome;
		Documento = documento;
		Endereco = endereco;
	}


	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String documento) {
		Documento = documento;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	
	

}
