package daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexao.ConexaoUtil;
import model.Setor;

public class SetorDAO implements GenericDAO<Setor>{
	private Connection con;
	
	public SetorDAO(){
		con = ConexaoUtil.getCon();
	}

	@Override
	public Boolean inserir(Setor entidade) {
		String sql = "insert into setor (nome) values(?)";
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
	public Boolean alterar(Setor entidade) {
		
		String sql = "update setor set nome=? where idsetor=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entidade.getNome());
			pstmt.setLong(2, entidade.getIdsetor());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean excluir(Setor entidade) {
		
		String sql = "delete from setor where idsetor = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, entidade.getIdsetor());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Setor buscar(Integer id) {
		Setor setor = null;
		String sql = "select * from setor where idsetor = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				setor = new Setor();
				setor.setIdsetor(rs.getInt("idsetor"));
				setor.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return setor;

	}

	@Override
	public List<Setor> todos() {
		List<Setor> setores = new ArrayList<>();
		String sql = "select * from setor";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Setor setor = new Setor();
				setor.setIdsetor(rs.getInt("idsetor"));
				setor.setNome(rs.getString("nome"));
				setores.add(setor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return setores;
	}
}