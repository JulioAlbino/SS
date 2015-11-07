package telas;

import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenericaListas;
import dao.factory.DaoFactory;

public class ListaOSAbertas extends TelaGenericaListas{

	private static final long serialVersionUID = 9L;

	
	public ListaOSAbertas() {
		painel.setBorder(BorderFactory.createTitledBorder("Lista OS Abertas"));	
		ListaPedidos aberto = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAbertos(), 20, 90, 1300,500);
		painel.add(aberto.getLista());
}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}