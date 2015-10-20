package telas;

import javax.swing.BorderFactory;

import dao.factory.DaoFactory;

public class ListaOSFinalizadas extends TelaGenericaListas {

	private static final long serialVersionUID = 12L;

	public ListaOSFinalizadas() {

		painel.setBorder(BorderFactory.createTitledBorder("Lista de OS Finalizadas"));
		ListaTela aberto = new ListaTela(DaoFactory.get().getPedidoDAO().todos(), 20, 90, 1300,500, "aberto");
		painel.add(aberto.getLista());
}

}