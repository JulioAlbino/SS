package telas;


import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AlterarUsuario extends TelaGenerica{

	private static final long serialVersionUID = 13L;

	private JTextField jtxBusca = new JTextField();
	private JLabel jlbBusca = new JLabel("Buscar Usuário:");
	private JButton jbtBusca = new JButton("Buscar");
	
	public AlterarUsuario() {

	painel.setBorder(BorderFactory.createTitledBorder("Painel Alterar Usuário"));	
	
	jlbBusca.setBounds(15,25,200,25);
	painel.add(jlbBusca);
	
	jtxBusca.setBounds(160,25,200,25);
	painel.add(jtxBusca);
	
	jbtBusca.setBounds(360,25,200,25);
	painel.add(jbtBusca);	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

		
	}
