package br.com.fiap.Objetos;

public class Banco {
	
	
	private long Id_Banco;
	private String nome;
	private  long cnpj;
	private String descricao;
	private long telefone;
	private String email;
	
	public long getId_Banco() {
		return Id_Banco;
	}
	public void setId_Banco(long id_Banco) {
		Id_Banco = id_Banco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Banco [Id_Banco=" + Id_Banco + ", nome=" + nome + ", cnpj=" + cnpj + ", descricao=" + descricao
				+ ", telefone=" + telefone + ", email=" + email + "]";
	}
	
}
