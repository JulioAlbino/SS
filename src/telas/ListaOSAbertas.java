package telas;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.factory.DaoFactory;

public class ListaOSAbertas extends TelaGenerica{

	private static final long serialVersionUID = 9L;

	private JLabel txtBusca = new JLabel("Buscar:");
	private JTextField jtfBusca = new JTextField();
	private JButton jbtSelecionar = new JButton("Abrir Selecionada");
	
	public ListaOSAbertas() {
		painel.setBorder(BorderFactory.createTitledBorder("Lista OS Abertas"));	
		
		txtBusca.setBounds(10,40, 100,30);
		painel.add(txtBusca);
		
		jtfBusca.setBounds(70,40,200,30);
		painel.add(jtfBusca);		
		
		
		ListaTela aberto = new ListaTela(DaoFactory.get().getPedidoDAO().todos(), 20, 90, 1300,500, "aberto");
		painel.add(aberto.getLista());
		
		jbtSelecionar.setBounds(20, 600,200,30);
		painel.add(jbtSelecionar);
}
}