package dao.factory;

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
	
}
