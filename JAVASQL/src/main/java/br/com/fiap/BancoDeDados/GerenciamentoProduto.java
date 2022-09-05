package br.com.fiap.BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.Objetos.Produto;
import br.com.fiap.connection.Conexao;

public class GerenciamentoProduto {
	public void IncluiProduto(Produto p) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new Conexao().getConexao();
			String sql = "INSERT INTO tbl_produto(nome, descricao, categoria, tipo) VALUES(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql, new String[] {"produto_id"});
			
			
			pstmt.setString(1, p.getNome());
			pstmt.setString(2, p.getDescricao());
			pstmt.setString(3, p.getCategoria());
			pstmt.setString(4, p.getTipo());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
			
		}
		finally {
			pstmt.close();
			con.close();
		}
	}
	
	public void AlteraProduto(Produto p) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new Conexao().getConexao();
			String sql = "UPDATE tbl_produto SET nome = ?, descricao = ?, categoria = ?, tipo = ? WHERE produto_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, p.getNome());
			pstmt.setString(2, p.getDescricao());
			pstmt.setString(3, p.getCategoria());
			pstmt.setString(4, p.getTipo());
			pstmt.setLong(5, p.getId_Produto());
			
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
	
	public Produto PesquisaProduto(long p) throws Exception{
		
		Produto produto = new Produto();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		produto.setId_Produto(p);
		try {
			con = new Conexao().getConexao();
			String sql = "SELECT * FROM tbl_produto WHERE produto_id =?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, p);
			
			ResultSet pesquisa = pstmt.executeQuery();
			
			
			
			if(pesquisa.next()) {
				produto.setCategoria(pesquisa.getString("categoria"));
				produto.setDescricao(pesquisa.getString("descricao"));
				produto.setNome(pesquisa.getString("nome"));
				produto.setTipo(pesquisa.getString("tipo"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			pstmt.close();
		}
		return produto;
		
		
	}
	public void ApagaProduto(long id)throws Exception{
		
		String sql = "DELETE FROM tbl_produto WHERE produto_id =?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new Conexao().getConexao();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			pstmt.close();
		}
		
		
		
	}
}
