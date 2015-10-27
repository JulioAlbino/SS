package telasGenericas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class TelaGenericaListas extends TelaGenerica {

	private static final long serialVersionUID = 10L;
	

	protected JLabel txtBusca = new JLabel("Buscar:");
	protected JTextField jtfBusca = new JTextField();
	protected JButton jbtSelecionar = new JButton("Abrir Selecionada");
	
	public TelaGenericaListas(){
		txtBusca.setBounds(10,40, 100,30);
		painel.add(txtBusca);
		
		jtfBusca.setBounds(70,40,200,30);
		painel.add(jtfBusca);
		
		jbtSelecionar.setBounds(20, 600,200,30);
		painel.add(jbtSelecionar);
	}
	

}
