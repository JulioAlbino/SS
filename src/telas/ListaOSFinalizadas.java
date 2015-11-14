package telas;

import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;

import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenericaListas;
import dao.factory.DaoFactory;

public class ListaOSFinalizadas extends TelaGenericaListas {

	private static final long serialVersionUID = 12L;
	
	

	public ListaOSFinalizadas() {
		
		
		painel.setBorder(BorderFactory.createTitledBorder("Lista de OS Finalizadas"));
		listaPedidos = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosFinalizados(), 20, 90, 1300,500);
		painel.add(listaPedidos.getLista());
}

	@Override
	public void keyReleased(KeyEvent e) {
		Buscar(DaoFactory.get().getPedidoDAO().buscarPedidosFinalizados(jtfBusca.getText()));
		
	}

}