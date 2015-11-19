package daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import dao.factory.DaoFactory;
import model.Cargo;
import model.Usuario;

public class UsuarioDAO implements GenericDAO<Usuario>{
private Connection con;
	
	public UsuarioDAO(){
		con = ConexaoUtil.getCon();
	}
	
	public Boolean inserir(Usuario usuario) {
		String sql = "insert into usuario (nome, senha, login, cargo_idcargo, ativo)"
				+ "values(?,?,?,?,1)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getSenha());
			pstmt.setString(3, usuario.getLogin());
			pstmt.setInt(4, usuario.getCargo().getIdcargo());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean alterar(Usuario usuario) {
		String sql = "update usuario set nome=?, senha=?, login=?, cargo_idcargo=? where idusuario = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getSenha());
			pstmt.setString(3, usuario.getLogin());
			pstmt.setInt(4, usuario.getCargo().getIdcargo());
			pstmt.setInt(5, usuario.getIdusuario());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}

	public Boolean excluir(Usuario usuario) {
		String sql = "delete from usuario where idusuario = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, usuario.getIdusuario());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Boolean desativar(Usuario usuario){
		String sql = "update usuario set ativo=0 where idusuario = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, usuario.getIdusuario());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	

	public Usuario buscar(Integer id) {
		Usuario usuario = null;
		String sql = "select * from usuario where idusuario=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				usuario = new Usuario();
				usuario.setIdusuario(rs.getInt("idusuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setLogin(rs.getString("login"));
				
					usuario.setAtivo(true);
				
				Cargo cargo = DaoFactory.get().getCargoDAO().buscar(rs.getInt("cargo_idcargo"));
				usuario.setCargo(cargo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public List<Usuario> todos() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "select * from usuario where ativo=1";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Usuario usuario = new Usuario(rs.getInt("idusuario"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario logarUsuario(String login, String senha) {
		Usuario usuario = null;
		String sql = "select * from usuario where login=? and senha=? and ativo=1";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login);
			pstmt.setString(2, senha);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			
			while(rs.next()){
				usuario = new Usuario(rs.getInt("idusuario"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public List<Usuario> buscarUsuario(String campo){
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "select * from usuario where (login like ? or nome like ? or idusuario like ?) and ativo=1";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+campo+"%");
			pstmt.setString(2, "%"+campo+"%");
			pstmt.setString(3, "%"+campo+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario(rs.getInt("idusuario"));
				usuarios.add(usuario);
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return usuarios;
		
	}
	
	
	
}