package dao.factory;

import daoo.CargoDAO;
import daoo.LocalDao;
import daoo.SetorDAO;
import daoo.UsuarioDAO;

/**
 * Fabrica concreta de Dao do tipo JDBC
 * @author forchesatto
 *
 */
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
	
}
