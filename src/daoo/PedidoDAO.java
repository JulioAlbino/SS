package daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import conexao.ConexaoUtil;
import dao.factory.DaoFactory;
import model.Local;
import model.Pedido;
import model.Setor;
import model.Usuario;

public class PedidoDAO implements GenericDAO<Pedido>{

private Connection con;
private static final Integer abertas = 1;
private static final Integer andamento = 2;
private static final Integer aguardando = 3;
private static final Integer finalizadas = 4;

	public PedidoDAO(){
		con = ConexaoUtil.getCon();
	}
	
	
	public Boolean finalizarParaAutorizar(Pedido entidade){
		String sql = "update pedido set situacao=? where idpedido=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, aguardando);
			pstmt.setInt(2, entidade.getIdpedido());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	
	@Override
	public Boolean inserir(Pedido entidade) {
		String sql = "insert into pedido (datahora, descricao, situacao, usuario_idusuario, local_idlocal, setor_idsetor, dataultimamod, responsavel, realizacoes) values(?, ?, ?, ? ,? ,?, ?, ?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(entidade.getData()));
			pstmt.setString(2, entidade.getDescricao());
			pstmt.setInt(3, entidade.getSituacao());
			pstmt.setInt(4, entidade.getUsuario().getIdusuario());
			pstmt.setInt(5, entidade.getLocal().getId());
			pstmt.setInt(6, entidade.getSetor().getIdsetor());
			pstmt.setDate(7, Date.valueOf(entidade.getData()));
			pstmt.setInt(8, entidade.getUsuario().getIdusuario());
			pstmt.setString(9, entidade.getResolucao());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Boolean alterar(Pedido entidade) {
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
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public Boolean efetuarTrabalho(Pedido pedido){
		String sql = "update pedido set dataultimamod=? , responsavel=? , realizacoes=?, situacao=?  where idpedido=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(pedido.getDataModificacao()));
			pstmt.setInt(2, pedido.getResponsavel().getIdusuario());
			pstmt.setString(3, pedido.getResolucao());
			pstmt.setInt(4, pedido.getSituacao());
			pstmt.setInt(5, pedido.getIdpedido());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	

	@Override
	public Boolean excluir(Pedido entidade) {
		String sql = "delete from pedido where idpedido=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, entidade.getIdpedido());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
				Usuario responsavel = DaoFactory.get().getUsuarioDAO().buscar(rs.getInt("responsavel"));
				pedido.setResponsavel(responsavel);
				
				pedido.setDataModificacao(rs.getDate("dataultimamod").toLocalDate());
				
				pedido.setResolucao(rs.getString("realizacoes"));
				
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
				Usuario responsavel = DaoFactory.get().getUsuarioDAO().buscar(rs.getInt("responsavel"));
				pedido.setResponsavel(responsavel);
				
				LocalDate datamod = rs.getDate("dataultimamod").toLocalDate();
				pedido.setDataModificacao(datamod);
				pedido.setResolucao(rs.getString("realizacoes"));
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidos;
	}
	
	
	//filtra as listas

	
	public List<Pedido> filtraSituacao(List<Pedido> lista , Integer situacao){
		List<Pedido> pedidosIT = lista;
		Iterator<Pedido> iterator = pedidosIT.iterator();
		
		while(iterator.hasNext()){
			Pedido p = iterator.next();
			if (!p.getSituacao().equals(situacao)){
				iterator.remove();
			}
		}
		return pedidosIT;
	}
	
	
	
	
public List<Pedido> todosNoSetor(Setor setor){
	List<Pedido> pedidosIT = todos();
	Iterator<Pedido> iterator = pedidosIT.iterator();
	
	while(iterator.hasNext()){
		Pedido p = iterator.next();
		if(!p.getSetor().equals(setor)){
			iterator.remove();
		}
		
	}
	return pedidosIT;
}

public List<Pedido> buscarPedido(String campo){
	List<Pedido> pedidos = new ArrayList<>();
	String sql = "select * from pedido where descricao like ? or realizacoes like ?";
	try {
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%"+campo+"%");
		pstmt.setString(2, "%"+campo+"%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Pedido pedido = new Pedido(rs.getInt("idpedido"));
			pedidos.add(pedido);
			
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return pedidos;	
}

public List<Pedido> buscarPedidosAbertos(String campo){
	return filtraSituacao(buscarPedido(campo), abertas);
}

public List<Pedido> buscarPedidosEmAndamento(String campo){
	return filtraSituacao(buscarPedido(campo), andamento);
}

public List<Pedido> buscarPedidosAguardando(String campo){
	return filtraSituacao(buscarPedido(campo), aguardando);
}

public List<Pedido> buscarPedidosFinalizados(String campo){
	return filtraSituacao(buscarPedido(campo), finalizadas);
}



	public List<Pedido> todosAbertos(){
		return filtraSituacao(todos(),abertas);
	}
	
	public List<Pedido> todosAndamento(){
		return filtraSituacao(todos(), andamento);
	}
	
	public List<Pedido> todosAguardando(){
		return filtraSituacao(todos(), aguardando);
	}
	
	public List<Pedido> todosFinalizados(){
		return filtraSituacao(todos(), finalizadas);
	}
	
}