package telas;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.BorderFactory;

import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenericaListas;
import dao.factory.DaoFactory;
import model.Pedido;

public class ListaOSFinalizadas extends TelaGenericaListas {

	private static final long serialVersionUID = 12L;
	
	private List<Pedido> lista;

	public ListaOSFinalizadas() {
		
		
		painel.setBorder(BorderFactory.createTitledBorder("Lista de OS Finalizadas"));
		ListaPedidos aberto = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosFinalizados(), 20, 90, 1300,500, "fechado");
		painel.add(aberto.getLista());
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}