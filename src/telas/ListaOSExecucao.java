package telas;

import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;

import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenericaListas;
import dao.factory.DaoFactory;

public class ListaOSExecucao extends TelaGenericaListas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;

	public ListaOSExecucao() {

		painel.setBorder(BorderFactory.createTitledBorder("Lista de OS em Execucao"));
		listaPedidos = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAndamento(), 20, 90, 1300,500);
		painel.add(listaPedidos.getLista());

}


	@Override
	public void keyReleased(KeyEvent e) {
		Buscar(DaoFactory.get().getPedidoDAO().buscarPedidosEmAndamento(jtfBusca.getText()));
		
	}

}
