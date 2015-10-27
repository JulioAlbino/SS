package telas;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;

import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenericaListas;
import dao.factory.DaoFactory;

public class ListaOSFinalizadas extends TelaGenericaListas {

	private static final long serialVersionUID = 12L;

	public ListaOSFinalizadas() {

		painel.setBorder(BorderFactory.createTitledBorder("Lista de OS Finalizadas"));
		ListaPedidos aberto = new ListaPedidos(DaoFactory.get().getPedidoDAO().todos(), 20, 90, 1300,500, "fechado");
		painel.add(aberto.getLista());
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}