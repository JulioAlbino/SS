package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.factory.DaoFactory;
import model.Local;

public class AdicionarNovoLocal extends TelaGenerica implements ActionListener{
	private JTextField Local;
	private JLabel textlocal, textResultado;
	private JButton add;
	

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
		add.addActionListener(this);
		painel.add(add);
		
		textResultado = new JLabel("");
		textResultado.setBounds(15, 140, 800, 20);
		painel.add(textResultado);
		

}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add){
			Local local = new Local();
			local.setNome(Local.getText());
			if (DaoFactory.get().getLocalDAO().inserir(local)){
				textResultado.setText("Local "+Local.getText()+ " Cadastrado com Sucesso.");
				Local.setText(" ");
			}
		}
		
	}
	
	
}
