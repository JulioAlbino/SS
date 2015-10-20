package telas;

import javax.swing.BorderFactory;
import dao.factory.DaoFactory;

public class ListaOSAbertas extends TelaGenericaListas{

	private static final long serialVersionUID = 9L;

	
	public ListaOSAbertas() {
		painel.setBorder(BorderFactory.createTitledBorder("Lista OS Abertas"));	
		ListaTela aberto = new ListaTela(DaoFactory.get().getPedidoDAO().todos(), 20, 90, 1300,500, "aberto");
		painel.add(aberto.getLista());
}
}