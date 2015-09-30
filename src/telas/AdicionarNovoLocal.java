package telas;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdicionarNovoLocal extends TelaGenerica {
	private JTextField Local;
	private JLabel textlocal;
	private JButton add;
	private JButton del;

	public AdicionarNovoLocal() {
		painel.setLayout(null);
		painel.setBounds(10, 10, 1024, 768);
		painel.setBorder(BorderFactory.createTitledBorder("Adicionar Novo Local"));	
		
		textlocal = new JLabel("Local:");
		textlocal.setBounds(15, 50, 150, 20);
		painel.add(textlocal);
		
		Local= new JTextField();
		Local.setBounds(55, 50, 150, 28);
		painel.add(Local);
		
		add = new JButton("Adicionar");
		add.setBounds(15,110,200,25);
		painel.add(add);
		
		del = new JButton("Excluir");
		del.setBounds(220,110,200,25);
		painel.add(del);
		

}
	
	
}
