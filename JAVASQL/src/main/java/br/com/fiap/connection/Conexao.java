package br.com.fiap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Connection getConexao() {
		
		String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		
		try {
			return DriverManager.getConnection(jdbc, "XXXXXX","XXXXX");// usuario , senha;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
