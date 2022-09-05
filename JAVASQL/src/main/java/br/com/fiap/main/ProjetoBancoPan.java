package br.com.fiap.main;


import java.time.LocalDate;
import java.util.Scanner;

import br.com.fiap.BancoDeDados.*;
import br.com.fiap.Objetos.*;

public class ProjetoBancoPan {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		GerenciamentoBanco Banco = new GerenciamentoBanco();
		GerenciamentoCliente Cliente = new GerenciamentoCliente();
		GerenciamentoProduto Produto = new GerenciamentoProduto();
		
		
		Banco ObjetoBanco = new Banco();
		Cliente ObjetoCliente = new Cliente();
		Produto ObjetoProduto = new Produto();
		
		
		int opcao, OpcBanco, opcaoApagar;
		
		System.out.println("Bem-Vindo aos testes de Banco de Dados ");
		System.out.println("_________________");
		System.out.println("Deseja inserir, apagar, modificar, retornar esse é o lugar certo. ");
		
		System.out.println("-----------------");
		do {
			System.out.println(" 0- Encerrar o programa");
			System.out.println(" 1- Inserir no Banco de dados");
			System.out.println(" 2- Apagar dado no Banco de dados");
			System.out.println(" 3- Modificar dado no Banco de dados");
			System.out.println(" 4- Retornar um dado do Banco de dados");
				opcao = teclado.nextInt();
			
			switch (opcao) {
				case 0 :
					System.out.println("Programa finalizado !");
				break;
				case 1:
					System.out.println(" 1- Inserir um objeto Banco");
					System.out.println(" 2- Inserir um objeto Cliente");
					System.out.println(" 3- Inserir um objeto Produto");
						OpcBanco = teclado.nextInt();
					switch(OpcBanco) {
						case 1:
							System.out.print("Nome do Banco -> ");
								String NomeBanco = teclado.nextLine();
								teclado.nextLine();
							System.out.print("CNPJ -> ");
								long cnpj = teclado.nextLong();
								teclado.nextLine();
							System.out.print("Descrição -> ");
								String Descricao = teclado.nextLine();
							System.out.print("Telefone -> ");
								long telefone = teclado.nextLong();
							System.out.print("E-mail -> ");
								String email = teclado.next();
								
							ObjetoBanco.setNome(NomeBanco);
							ObjetoBanco.setCnpj(cnpj);
							ObjetoBanco.setDescricao(Descricao);
							ObjetoBanco.setTelefone(telefone);
							ObjetoBanco.setEmail(email);
							try {
								Banco.IncluiBanco(ObjetoBanco);
							}catch(Exception e) {
								e.printStackTrace();
							}
							break;
						case 2:
							System.out.print("Nome do Cliente -> ");
								String NomeCliente = teclado.next();
								teclado.nextLine();
							System.out.print("Sobrenome do Cliente -> ");
								String SobrenomeCliente = teclado.nextLine();
							System.out.print("CPF -> ");
								long cpf = teclado.nextLong();
							System.out.print("RG -> ");
								long RG = teclado.nextLong();
								teclado.nextLine();
							System.out.print("Telefone -> ");
								String TelefoneCliente = teclado.next();
							System.out.print("Endereço -> ");
								String Endereco = teclado.nextLine();
							System.out.println("Data de nascimento :");
							System.out.println("17/11/2002");
							
							ObjetoCliente.setNome(NomeCliente);
							ObjetoCliente.setSobrenome(SobrenomeCliente);
							ObjetoCliente.setCpf(cpf);
							ObjetoCliente.setRg(RG);
							ObjetoCliente.setTelefone(TelefoneCliente);
							ObjetoCliente.setEndereco(Endereco);
							ObjetoCliente.setDtNascimento(LocalDate.of(2002, 11, 17));
							
							try {
								Cliente.IncluiCliente(ObjetoCliente);
							}catch(Exception e) {
								e.printStackTrace();
							}
							
							break;
						case 3:
							teclado.nextLine();
							System.out.print("Nome do Produto -> ");
								String NomeProduto = teclado.nextLine();
							System.out.print("Categoria -> ");
								String categoria = teclado.nextLine();
							System.out.print("Descrição -> ");
								String DescricaoProduto = teclado.nextLine();
							System.out.print("Tipo -> ");
								String tipo = teclado.nextLine();
								
							ObjetoProduto.setNome(NomeProduto);
							ObjetoProduto.setCategoria(categoria);
							ObjetoProduto.setDescricao(DescricaoProduto);
							ObjetoProduto.setTipo(tipo);
							
							try {
								Produto.IncluiProduto(ObjetoProduto);
							}catch(Exception e) {
								e.printStackTrace();
							}
						break;
						
					}
				break;		
			case 2:
				System.out.println("Deseja apagar de qual tabela de dados ?");
				System.out.println("______________");
				System.out.println(" 1- Apagar um objeto Banco");
				System.out.println(" 2- Apagar um objeto Cliente");
				System.out.println(" 3- Apagar um objeto Produto");
					opcaoApagar = teclado.nextInt();
				switch(opcaoApagar) {
					case 1:
						System.out.print("Qual id você quer apagar -> ");
						long id = teclado.nextLong();
						try {
							Banco.ApagaBanco(id);
						}catch(Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						System.out.print("Qual id você quer apagar -> ");
						long idCliente = teclado.nextLong();
						try {
							Cliente.ApagaCliente(idCliente);
						}catch(Exception e) {
							e.printStackTrace();
						}
						break;
					case 3:
						System.out.print("Qual id você quer apagar -> ");
						long idProduto = teclado.nextLong();
						try {
							Produto.ApagaProduto(idProduto);
						}catch(Exception e) {
							e.printStackTrace();
						}
						break;
				}
				break;
			case 3:
				System.out.println("Deseja tabela deseja modificar ?");
				System.out.println("______________");
				System.out.println(" 1- Modificar um objeto Banco");
				System.out.println(" 2- Modificar um objeto Cliente");
				System.out.println(" 3- Modificar um objeto Produto");
					int opc = teclado.nextInt();
				switch(opc) {
					case 1:
						teclado.nextLine();
						System.out.print("Nome do Banco -> ");
							String NomeBanco = teclado.nextLine();
						System.out.print("CNPJ -> ");
							long cnpj = teclado.nextLong();
							teclado.nextLine();
						System.out.print("Descrição -> ");
							String Descricao = teclado.nextLine();
						System.out.print("Telefone -> ");
							long telefone = teclado.nextLong();
							teclado.nextLine();
						System.out.print("E-mail -> ");
							String email = teclado.next();
						System.out.print("Numero do id para a mudança -> ");
							long id = teclado.nextLong();
							
						ObjetoBanco.setNome(NomeBanco);
						ObjetoBanco.setCnpj(cnpj);
						ObjetoBanco.setDescricao(Descricao);
						ObjetoBanco.setTelefone(telefone);
						ObjetoBanco.setEmail(email);
						ObjetoBanco.setId_Banco(id);
						
						try {
							Banco.AlteraBanco(ObjetoBanco);
						}catch(Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						System.out.print("Nome do Cliente -> ");
							String NomeCliente = teclado.nextLine();
							teclado.nextLine();
						System.out.print("Sobrenome do Cliente -> ");
							String SobrenomeCliente = teclado.nextLine();
						System.out.print("CPF -> ");
							long cpf = teclado.nextLong();
						System.out.print("RG -> ");
							long RG = teclado.nextLong();
							teclado.nextLine();
						System.out.print("Telefone -> ");
							String TelefoneCliente = teclado.nextLine();
						System.out.print("Endereço -> ");
							String Endereco = teclado.nextLine();
						System.out.println("Data de nascimento :");
						System.out.println("23/01/2011");
						System.out.print("Numero do id para a mudança -> ");
							long idcliente = teclado.nextLong();
						
						ObjetoCliente.setNome(NomeCliente);
						ObjetoCliente.setSobrenome(SobrenomeCliente);
						ObjetoCliente.setCpf(cpf);
						ObjetoCliente.setRg(RG);
						ObjetoCliente.setTelefone(TelefoneCliente);
						ObjetoCliente.setEndereco(Endereco);
						ObjetoCliente.setDtNascimento(LocalDate.of(2011, 01, 23));
						ObjetoCliente.setId(idcliente);
						
						try {
							Cliente.AlteraCliente(ObjetoCliente);
						}catch(Exception e) {
							e.printStackTrace();
						}
						break;
					case 3:
						teclado.nextLine();
						System.out.print("Nome do Produto -> ");
							String NomeProduto = teclado.nextLine();
						System.out.print("Categoria -> ");
							String categoria = teclado.nextLine();
						System.out.print("Descrição -> ");
							String DescricaoProduto = teclado.nextLine();
						System.out.print("Tipo -> ");
							String tipo = teclado.nextLine();
						System.out.print("Numero do id para a mudança -> ");
							long idproduto = teclado.nextLong();
							
						ObjetoProduto.setNome(NomeProduto);
						ObjetoProduto.setCategoria(categoria);
						ObjetoProduto.setDescricao(DescricaoProduto);
						ObjetoProduto.setTipo(tipo);
						ObjetoProduto.setId_Produto(idproduto);
						
						try {
							Produto.AlteraProduto(ObjetoProduto);
						}catch(Exception e) {
							e.printStackTrace();
						}
						break;
					}
				break;
			case 4:
				System.out.println("Deseja tabela deseja extrais qual dado ?");
				System.out.println("______________");
				System.out.println(" 1- Extrair um objeto Banco");
				System.out.println(" 2- Extrair um objeto Cliente");
				System.out.println(" 3- Extrair um objeto Produto");
					int opcaoExtrair = teclado.nextInt();
				switch(opcaoExtrair) {
					case 1:
						System.out.print("Numero do id para recuperar -> ");
							long id = teclado.nextLong();
							
						try {
							
							ObjetoBanco = Banco.ConsultaBanco(id);
							
						}catch(Exception e) {
							e.printStackTrace();
						}
						System.out.println(ObjetoBanco.toString());
						break;
					case 2:
						System.out.print("Numero do id para recuperar -> ");
							long idcliente = teclado.nextLong();
						
						try {
							ObjetoCliente = Cliente.PesquisaCliente(idcliente);
						}catch(Exception e) {
							e.printStackTrace();
						}
						System.out.println(ObjetoCliente.toString());
						break;
					case 3:
						System.out.print("Numero do id para recuperar -> ");
						long idproduto = teclado.nextLong();
						
						try {
							ObjetoProduto = Produto.PesquisaProduto(idproduto);
						}catch(Exception e) {
							e.printStackTrace();
						}
						System.out.println(ObjetoProduto.toString());
						break;
				}
			break;
			}
		}while(opcao != 0);
		
		
		
		
	}
}
