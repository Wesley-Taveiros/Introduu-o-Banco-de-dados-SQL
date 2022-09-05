package br.com.fiap.Objetos;

public class Produto {
	
	private long Id_Produto;
	private String nome;
	private String descricao;
	private String categoria;
	private String tipo;
	
	public long getId_Produto() {
		return Id_Produto;
	}
	public void setId_Produto(long id) {
		Id_Produto = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	@Override
	public String toString() {
		return "Produto [Id_Produto=" + Id_Produto + ", nome=" + nome + ", descricao=" + descricao + ", categoria="
				+ categoria + ", tipo=" + tipo + "]";
	}
}
