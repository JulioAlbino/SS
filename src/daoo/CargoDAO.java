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
import model.Local;
import model.Setor;

public class CargoDAO implements GenericDAO<Cargo>{
	
	private Connection con;
	
	
	public CargoDAO(){
		con = ConexaoUtil.getCon();
	}


	@Override
	public void inserir(Cargo entidade) {
		String sql = "insert into cargo (nome, setor_idsetor) values(?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entidade.getNome());
			pstmt.setInt(2, entidade.getSetor().getIdsetor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void alterar(Cargo entidade) {
		String sql = "update cargo set nome=?,setor_idsetor=?  where idcargo=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entidade.getNome());
			pstmt.setInt(2, entidade.getSetor().getIdsetor());
			pstmt.setInt(3, entidade.getIdcargo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	

		
	}


	@Override
	public void excluir(Cargo entidade) {
		String sql = "delete from cargo where idcargo=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, entidade.getIdcargo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
				cargo.setIdcargo(rs.getInt("idlocal"));
				cargo.setNome(rs.getString("nome"));
				Setor setor = DaoFactory.get().getSetorDAO().buscar(rs.getInt("setor_idsetor"));
				cargo.setSetor(setor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cargo;
	}


	@Override
	public List<Cargo> todos() {
		List<Cargo> cargos = new ArrayList<>();
		String sql = "select * from cargo";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Cargo cargo = new Cargo();
				cargo.setIdcargo(rs.getInt("idlocal"));
				cargo.setNome(rs.getString("nome"));
				Setor setor = DaoFactory.get().getSetorDAO().buscar(rs.getInt("setor_idsetor"));
				cargo.setSetor(setor);
				cargos.add(cargo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cargos;
	}

	
	

}