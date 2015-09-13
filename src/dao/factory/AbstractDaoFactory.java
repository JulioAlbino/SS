package dao.factory;

import daoo.LocalDao;
import daoo.UsuarioDAO;

public interface AbstractDaoFactory {

	/**
	 * Retorna uma implementação valida de ProdutoDAO
	 * @return ProdutoDAO
	 */
	UsuarioDAO getUsuarioDAO();
	LocalDao getLocalDAO();
}
