package dao.factory;

import daoo.UsuarioDAO;

/**
 * Fabrica de DAO, inicializa a fabrica correta para 
 * o tipo de sistema e disponibiza os métodos de acesso a construção do DAO 
 * @author forchesatto
 *
 */
public class DaoFactory {
	
	private static DaoFactory factory;
	private static AbstractDaoFactory daoFactory;
	
	/**
	 * Constroi a fabrica correta de DAO.
	 * @return
	 */
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
