package daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import dao.factory.DaoFactory;
import model.Cargo;
import model.Local;
import model.Pedido;
import model.Setor;
import model.Usuario;

public class PedidoDAO implements GenericDAO<Pedido>{

private Connection con;
	
	public PedidoDAO(){
		con = ConexaoUtil.getCon();
	}
	
	@Override
	public void inserir(Pedido entidade) {
		String sql = "insert into pedido (datahora, descricao, situacao, usuario_idusuario, local_idlocal, setor_idsetor) values(?, ?, ?, ? ,? ,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(entidade.getDatahora()));
			pstmt.setString(2, entidade.getDescricao());
			pstmt.setInt(3, entidade.getSituacao());
			pstmt.setInt(4, entidade.getUsuario().getIdusuario());
			pstmt.setInt(5, entidade.getLocal().getId());
			pstmt.setInt(6, entidade.getSetor().getIdsetor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Pedido entidade) {
		String sql = "update pedido set datahora=?,descricao=?, situacao=?, usuario_idusuario=?, local_idlocal=? ,setor_idsetor=? where idpedido=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(entidade.getDatahora()));
			pstmt.setString(2, entidade.getDescricao());
			pstmt.setInt(3, entidade.getSituacao());
			pstmt.setInt(4, entidade.getUsuario().getIdusuario());
			pstmt.setInt(5, entidade.getLocal().getId());
			pstmt.setInt(6, entidade.getSetor().getIdsetor());
			pstmt.setInt(7, entidade.getIdpedido());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void excluir(Pedido entidade) {
		String sql = "delete from pedido where idpedido=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, entidade.getIdpedido());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Pedido buscar(Integer id) {
		Pedido pedido = null;
		String sql = "select * from pedido where idpedido=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				pedido = new Pedido();
				pedido.setIdpedido(rs.getInt("idpedido"));
				pedido.setDatahora(rs.getDate("datahora").toLocalDate());
				pedido.setDescricao(rs.getString("descricao"));
				pedido.setSituacao(rs.getInt("situacao"));
				Usuario usuario = DaoFactory.get().getUsuarioDAO().buscar(rs.getInt("usuario_idusuario"));
				pedido.setUsuario(usuario);
				Local local = DaoFactory.get().getLocalDAO().buscar(rs.getInt("local_idlocal"));
				pedido.setLocal(local);
				Setor setor = DaoFactory.get().getSetorDAO().buscar(rs.getInt("setor_idsetor"));
				pedido.setSetor(setor);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedido;
	}

	@Override
	public List<Pedido> todos() {
		List<Pedido> pedidos = new ArrayList<>();
		String sql = "select * from pedido";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Pedido pedido = new Pedido();
				pedido.setIdpedido(rs.getInt("idpedido"));
				pedido.setDatahora(rs.getDate("datahora").toLocalDate());
				pedido.setDescricao(rs.getString("descricao"));
				pedido.setSituacao(rs.getInt("situacao"));
				Usuario usuario = DaoFactory.get().getUsuarioDAO().buscar(rs.getInt("usuario_idusuario"));
				pedido.setUsuario(usuario);
				Local local = DaoFactory.get().getLocalDAO().buscar(rs.getInt("local_idlocal"));
				pedido.setLocal(local);
				Setor setor = DaoFactory.get().getSetorDAO().buscar(rs.getInt("setor_idsetor"));
				pedido.setSetor(setor);
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidos;
	}

}
