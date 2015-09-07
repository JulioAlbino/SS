package dao.factory;

import daoo.UsuarioDAO;

public interface AbstractDaoFactory {

	/**
	 * Retorna uma implementação valida de ProdutoDAO
	 * @return ProdutoDAO
	 */
	UsuarioDAO getUsuarioDAO();
}
