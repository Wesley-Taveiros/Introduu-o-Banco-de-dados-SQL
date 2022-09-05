package br.com.fiap.BancoDeDados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.Objetos.Cliente;
import br.com.fiap.connection.Conexao;

public class GerenciamentoCliente {

public void IncluiCliente(Cliente p) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO tbl_cliente(nome, sobrenome, Dt_nascimento, cpf, rg, endereco, telefone) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try{
				
			con = new Conexao().getConexao();
			pstmt = con.prepareStatement(sql, new String[] {"cliente_id"});
	
			pstmt.setString(1, p.getNome());
			pstmt.setString(2, p.getSobrenome());
			pstmt.setDate(3, Date.valueOf(p.getDtNascimento()));
			pstmt.setLong(4, p.getCpf());
			pstmt.setLong(5, p.getRg());
			pstmt.setString(6, p.getEndereco());
			pstmt.setString(7, p.getTelefone());
			
			
			pstmt.executeUpdate();
			
			
	}catch(SQLException e){
			e.printStackTrace();
		}
	finally {
		con.close();
		pstmt.close();
	}
		
}
	
	public void AlteraCliente(Cliente p) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new Conexao().getConexao();
			String sql = "UPDATE tbl_cliente SET nome = ?, sobrenome = ?, DT_nascimento = ?, cpf = ?, rg = ?, endereco = ?, telefone = ? WHERE cliente_id = ?";
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, p.getNome());
			pstmt.setString(2, p.getSobrenome());
			pstmt.setDate(3, Date.valueOf(p.getDtNascimento()));
			pstmt.setLong(4, p.getCpf());
			pstmt.setLong(5, p.getRg());
			pstmt.setString(6, p.getEndereco());
			pstmt.setString(7, p.getTelefone());
			pstmt.setLong(8, p.getId());
			
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
	
	public Cliente PesquisaCliente(long p) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM tbl_cliente WHERE cliente_id =?";
		Cliente cliente = new Cliente();
		
		cliente.setId(p);
		try {
			con = new Conexao().getConexao();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, p);
			
			ResultSet pesquisa = pstmt.executeQuery();
			
			
			
			if(pesquisa.next()) {
				
				cliente.setNome(pesquisa.getString("nome"));
				cliente.setSobrenome(pesquisa.getString("sobrenome"));
				
				Date d = pesquisa.getDate("Dt_nascimento");
				cliente.setDtNascimento(d.toLocalDate());
				
				cliente.setCpf(pesquisa.getLong("cpf"));
				cliente.setRg(pesquisa.getLong("rg"));
				cliente.setEndereco(pesquisa.getString("endereco"));
				cliente.setTelefone(pesquisa.getString("telefone"));
			
					
			}	
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			pstmt.close();
		}
		return cliente;
		
	}
	
	public void ApagaCliente(long id) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM tbl_cliente WHERE cliente_id =?";
		
		try {
			con = new Conexao().getConexao();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			pstmt.close();
			con.close();
		}
		
	}
}
