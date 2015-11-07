package telas;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;

import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenericaListas;
import dao.factory.DaoFactory;

public class OSAguardandoFinalizar extends TelaGenericaListas {

	private static final long serialVersionUID = 8L;

	public OSAguardandoFinalizar() {

		painel.setBorder(BorderFactory.createTitledBorder("OS's aguardando finalizar"));
		ListaPedidos aberto = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAguardando(), 20, 90, 1300,500);
		painel.add(aberto.getLista());

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
