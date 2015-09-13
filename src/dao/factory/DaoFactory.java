package dao.factory;

import daoo.UsuarioDAO;

public class DaoFactory {
	
	private static DaoFactory factory;
	private static AbstractDaoFactory daoFactory;
	
	public static DaoFactory get(){
		if(factory == null){
			factory = new DaoFactory();
			daoFactory = new DaoFactoryJDBC();
		}
		return factory;
	}

	/**
	 * Disponibiliza o DAO com base na fabrica construida dinamicamente.
	 * @return
	 */
public UsuarioDAO getUsuarioDAO(){
	return daoFactory.getUsuarioDAO();
}
}
