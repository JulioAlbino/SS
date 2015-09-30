package telas;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdicionarNovoSetor extends TelaGenerica {
	
	private JTextField LocalSetor;
	private JLabel textsetor;
	private JButton add;
	private JButton del;
	public AdicionarNovoSetor() {
		painel.setLayout(null);
		painel.setBounds(10, 10, 1024, 768);
		painel.setBorder(BorderFactory.createTitledBorder("Adicionar Novo Setor"));	
		
		textsetor = new JLabel("Setor:");
		textsetor.setBounds(15, 50, 150, 20);
		painel.add(textsetor);
		
		LocalSetor= new JTextField();
		LocalSetor.setBounds(55, 50, 150, 28);
		painel.add(LocalSetor);
		
		add = new JButton("Adicionar");
		add.setBounds(15,110,200,25);
		painel.add(add);
		
		del = new JButton("Excluir");
		del.setBounds(220,110,200,25);
		painel.add(del);
		

}
	
	
}
