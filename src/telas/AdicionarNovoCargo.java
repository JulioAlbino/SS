package telas;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdicionarNovoCargo extends TelaGenerica {
	
	private JTextField Cargo;
	private JLabel textCargo;
	private JButton add;
	private JButton del;

	public AdicionarNovoCargo() {
		painel.setLayout(null);
		painel.setBounds(10, 10, 1024, 768);
		painel.setBorder(BorderFactory.createTitledBorder("Adicionar Novo Cargo"));	
		
		textCargo = new JLabel("Cargo:");
		textCargo.setBounds(15, 50, 150, 20);
		painel.add(textCargo);
		
		Cargo= new JTextField();
		Cargo.setBounds(55, 50, 150, 28);
		painel.add(Cargo);
		
		add = new JButton("Adicionar");
		add.setBounds(15,110,200,25);
		painel.add(add);
		
		del = new JButton("Excluir");
		del.setBounds(220,110,200,25);
		painel.add(del);

}
	
	
}
