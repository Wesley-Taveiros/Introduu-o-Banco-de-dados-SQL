package br.com.fiap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Connection getConexao() {
		
		String jdbc = "jdbc:oracle:thin:@oracle.com.br:1500:orcl";//colocar a URL onde o Banco de dados esta localizado
		
		try {
			return DriverManager.getConnection(jdbc, "XXXXXX","XXXXX");// usuario , senha;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
