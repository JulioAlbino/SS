package dao.factory;

import daoo.CargoDAO;
import daoo.LocalDao;
import daoo.SetorDAO;
import daoo.UsuarioDAO;

public interface AbstractDaoFactory {

	/**
	 * Retorna uma implementação valida de ProdutoDAO
	 * @return ProdutoDAO
	 */
	UsuarioDAO getUsuarioDAO();
	LocalDao getLocalDAO();
	SetorDAO getSetorDAO();
	CargoDAO getCargoDAO();
}
