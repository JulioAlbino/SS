package telas;

import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;

import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenericaListas;
import dao.factory.DaoFactory;

public class OSAguardandoFinalizar extends TelaGenericaListas {

	private static final long serialVersionUID = 8L;

	public OSAguardandoFinalizar() {

		painel.setBorder(BorderFactory.createTitledBorder("OS's aguardando finalizar"));
		listaPedidos = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAguardando(), 20, 90, 1300,500);
		painel.add(listaPedidos.getLista());

}

	@Override
	public void keyReleased(KeyEvent e) {
		Buscar(DaoFactory.get().getPedidoDAO().buscarPedidosAguardando(jtfBusca.getText()));
		
	}

}
