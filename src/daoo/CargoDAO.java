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
import model.Setor;

public class CargoDAO implements GenericDAO<Cargo>{
	
	private Connection con;
	
	public CargoDAO(){
		con = ConexaoUtil.getCon();
	}

	@Override
	public Boolean inserir(Cargo entidade) {
		String sql = "insert into cargo (nome, setor_idsetor, ativo, permissoes) values(?,?,1,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entidade.getNome());
			pstmt.setInt(2, entidade.getSetor().getIdsetor());
			pstmt.setInt(3, entidade.getPermissao());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Boolean alterar(Cargo entidade) {
		String sql = "update cargo set nome=?,setor_idsetor=?, permissoes=?  where idcargo=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entidade.getNome());
			pstmt.setInt(2, entidade.getSetor().getIdsetor());
			pstmt.setInt(3, entidade.getPermissao());
			pstmt.setInt(4, entidade.getIdcargo());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	public Boolean desativar(Cargo entidade){
		
		String sql = "update cargo set ativo = 0 where idcargo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, entidade.getIdcargo());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean excluir(Cargo entidade) {
		String sql = "delete from cargo where idcargo=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, entidade.getIdcargo());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Cargo buscar(Integer id) {
		Cargo cargo = null;
		String sql = "select * from cargo where idcargo=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				cargo = new Cargo();
				cargo.setIdcargo(rs.getInt("idcargo"));
				cargo.setNome(rs.getString("nome"));
				Setor setor = DaoFactory.get().getSetorDAO().buscar(rs.getInt("setor_idsetor"));
				cargo.setSetor(setor);
				cargo.setPermissao(rs.getInt("permissoes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cargo;
	}

	@Override
	public List<Cargo> todos() {
		List<Cargo> cargos = new ArrayList<>();
		String sql = "select * from cargo where ativo = 1";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Cargo cargo = new Cargo();
				cargo.setIdcargo(rs.getInt("idcargo"));
				cargo.setNome(rs.getString("nome"));
				Setor setor = DaoFactory.get().getSetorDAO().buscar(rs.getInt("setor_idsetor"));
				cargo.setSetor(setor);
				cargo.setPermissao(rs.getInt("permissoes"));
				cargos.add(cargo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cargos;
	}
}