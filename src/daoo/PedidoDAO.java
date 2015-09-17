package daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import conexao.ConexaoUtil;
import model.Pedido;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Pedido entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> todos() {
		// TODO Auto-generated method stub
		return null;
	}

}
