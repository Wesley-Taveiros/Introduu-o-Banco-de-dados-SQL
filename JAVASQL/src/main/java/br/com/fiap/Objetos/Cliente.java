package br.com.fiap.Objetos;


import java.time.LocalDate;

public class Cliente {
	
	
	private LocalDate DtNascimento;
	private String nome;
	private long cpf;
	private String sobrenome;
	private long rg;
	private String endereco;
	private String telefone;
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDate getDtNascimento() {
		return DtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		DtNascimento = dtNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public long getRg() {
		return rg;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Cliente [DtNascimento=" + DtNascimento + ", nome=" + nome + ", cpf=" + cpf + ", sobrenome=" + sobrenome
				+ ", rg=" + rg + ", endereco=" + endereco + ", telefone=" + telefone + ", id=" + id + "]";
	}
	
}
