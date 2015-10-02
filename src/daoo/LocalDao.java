package daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import model.Local;
import model.Usuario;

public class LocalDao implements GenericDAO<Local>{
	private Connection con;
	
	public LocalDao(){
		con = ConexaoUtil.getCon();
	}
	
	@Override
	public Boolean inserir(Local entidade) {
		String sql = "insert into local (nome) values(?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entidade.getNome());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Boolean alterar(Local entidade) {
		String sql = "update local set nome=? where idlocal = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entidade.getNome());
			pstmt.setInt(1, entidade.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
	}

	@Override
	public Boolean excluir(Local entidade) {
		String sql = "delete from local where idlocal = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, entidade.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Local buscar(Integer id) {
		Local local = null;
		String sql = "select * from local where idlocal = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				local = new Local();
				local.setId(rs.getInt("idlocal"));
				local.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return local;
	}

	@Override
	public List<Local> todos() {
		List<Local> locais = new ArrayList<>();
		String sql = "select * from local";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Local local = new Local();
				local.setId(rs.getInt("idlocal"));
				local.setNome(rs.getString("nome"));
				locais.add(local);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locais;
	}



}