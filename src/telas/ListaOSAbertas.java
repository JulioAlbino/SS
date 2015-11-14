package telas;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;

import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenericaListas;
import dao.factory.DaoFactory;

public class ListaOSAbertas extends TelaGenericaListas{

	private static final long serialVersionUID = 9L;

	
	
	public ListaOSAbertas() {
		painel.setBorder(BorderFactory.createTitledBorder("Lista OS Abertas"));	
		listaPedidos = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAbertos(), 20, 90, 1300,500);
		
		painel.add(listaPedidos.getLista());
		
		
}




	@Override
	public void keyReleased(KeyEvent e) {
		Buscar(DaoFactory.get().getPedidoDAO().buscarPedidosAbertos(jtfBusca.getText()));
		
	}


}