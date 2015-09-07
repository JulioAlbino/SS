package daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import model.Usuario;

public class UsuarioDAO {
private Connection con;
	
	public UsuarioDAO(){
		con = ConexaoUtil.getCon();
	}
	
	public void inserir(Usuario usuario) {
		String sql = "insert into usuario (nome, senha, login)"
				+ "values(?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getSenha());
			pstmt.setString(3, usuario.getLogin());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {
		String sql = "update usuario set nome=?, senha=?, login=?, cargo_idcargo=?, cargo_setor_idsetor=? where idusuario = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getSenha());
			pstmt.setString(3, usuario.getLogin());
			pstmt.setInt(4, usuario.getCargo_idcargo());
			pstmt.setInt(5, usuario.getCargo_setor_idsetor());
			pstmt.setInt(5, usuario.getIdusuario());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void excluir(Usuario usuario) {
		String sql = "delete from usuario where idusuario = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, usuario.getIdusuario());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario buscar(Integer id) {
		Usuario usuario = null;
		String sql = "select * from usuario where idusuario = ?";
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
				usuario.setCargo_idcargo(rs.getInt("cargo_idcargo"));
				usuario.setCargo_setor_idsetor(rs.getInt("cargo_setor_idsetor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public List<Usuario> todos() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "select * from usuario";
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
	
	public Usuario verificaExistencia(String login, String senha) {
		Usuario usuario = null;
		String sql = "select * from usuario where login=? and senha=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login);
			pstmt.setString(2, senha);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				usuario = new Usuario();
				usuario.setIdusuario(rs.getInt("idusuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setLogin(rs.getString("login"));
				usuario.setCargo_idcargo(rs.getInt("cargo_idcargo"));
				usuario.setCargo_setor_idsetor(rs.getInt("cargo_setor_idsetor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	
	
}