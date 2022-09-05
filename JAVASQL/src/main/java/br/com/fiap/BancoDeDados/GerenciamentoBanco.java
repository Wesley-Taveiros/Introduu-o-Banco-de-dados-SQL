package br.com.fiap.BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.Objetos.Banco;
import br.com.fiap.connection.Conexao;

public class GerenciamentoBanco {

public void IncluiBanco(Banco p) throws Exception{
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new Conexao().getConexao();
			String sql = "INSERT INTO tbl_banco(nome, cnpj, descricao, telefone, email) VALUES(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql, new String[] {"banco_id"});
			
			pstmt.setString(1, p.getNome());
			pstmt.setLong(2, p.getCnpj());
			pstmt.setString(3, p.getDescricao());
			pstmt.setLong(4, p.getTelefone());
			pstmt.setString(5, p.getEmail());
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			pstmt.close();
			con.close();
		}
	}
	
	public void AlteraBanco (Banco p) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new Conexao().getConexao();
			String sql = "UPDATE tbl_banco SET nome = ?, cnpj = ?, descricao = ?, telefone = ?, email = ? WHERE banco_id = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, p.getNome());
			pstmt.setLong(2, p.getCnpj());
			pstmt.setString(3, p.getDescricao());
			pstmt.setLong(4, p.getTelefone());
			pstmt.setString(5, p.getEmail());
			pstmt.setLong(6, p.getId_Banco());
			
			pstmt.executeUpdate();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			con.close();
			pstmt.close();
		}
		
	}
	
	public Banco ConsultaBanco(long p) throws Exception{
		
		Banco banco = new Banco();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM tbl_banco WHERE banco_id =?";
		
		
		try {
			con = new Conexao().getConexao();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, p);
			
			ResultSet pesquisa = pstmt.executeQuery();
			
			
			if(pesquisa.next()){
					
				banco.setCnpj(pesquisa.getLong("cnpj"));
				banco.setDescricao(pesquisa.getString("descricao"));
				banco.setNome(pesquisa.getString("nome"));
				banco.setTelefone(pesquisa.getLong("telefone"));
				banco.setEmail(pesquisa.getString("email"));
				banco.setId_Banco(pesquisa.getLong("banco_id"));
					
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			pstmt.close();
		}	
		return banco;
	}
	
	public void ApagaBanco(long id) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM tbl_banco WHERE banco_id =?";
		
		try {
			con = new Conexao().getConexao();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, id);
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
