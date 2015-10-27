package telas;

import java.awt.event.ActionEvent;

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
		ListaPedidos aberto = new ListaPedidos(DaoFactory.get().getPedidoDAO().todos(), 20, 90, 1300,500, "andamento");
		painel.add(aberto.getLista());

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
