package dao.factory;

import daoo.CargoDAO;
import daoo.LocalDao;
import daoo.PedidoDAO;
import daoo.SetorDAO;
import daoo.UsuarioDAO;

public class DaoFactoryJDBC implements AbstractDaoFactory{

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}

	@Override
	public LocalDao getLocalDAO() {
		return new LocalDao();
	}
	@Override
	public SetorDAO getSetorDAO(){
		return new SetorDAO();
	}
	@Override
	public CargoDAO getCargoDAO(){
		return new CargoDAO();
	}

	@Override
	public PedidoDAO getPedidoDAO() {
		
		return new PedidoDAO();
	}
	
	
}
