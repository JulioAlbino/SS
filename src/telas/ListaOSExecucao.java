package telas;

import javax.swing.BorderFactory;

import dao.factory.DaoFactory;

public class ListaOSExecucao extends TelaGenericaListas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;

	public ListaOSExecucao() {

		painel.setBorder(BorderFactory.createTitledBorder("Lista de OS em Execucao"));
		ListaTela aberto = new ListaTela(DaoFactory.get().getPedidoDAO().todos(), 20, 90, 1300,500, "aberto");
		painel.add(aberto.getLista());

}

}
