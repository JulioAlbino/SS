package telas;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;

import dao.factory.DaoFactory;

public class OSAguardandoFinalizar extends TelaGenericaListas {

	private static final long serialVersionUID = 8L;

	public OSAguardandoFinalizar() {

		painel.setBorder(BorderFactory.createTitledBorder("OS's aguardando finalizar"));
		ListaTela aberto = new ListaTela(DaoFactory.get().getPedidoDAO().todos(), 20, 90, 1300,500, "aberto");
		painel.add(aberto.getLista());

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
