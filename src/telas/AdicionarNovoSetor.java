package telas;

import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.factory.DaoFactory;
import model.Setor;

public class AdicionarNovoSetor extends TelaGenerica{

	private static final long serialVersionUID = 1L;
	private JTextField LocalSetor;
	private JLabel textsetor, textResultado;
	private JButton add;

	public AdicionarNovoSetor() {

		painel.setBorder(BorderFactory.createTitledBorder("Adicionar Novo Setor"));	
		
		textsetor = new JLabel("Setor:");
		textsetor.setBounds(15, 50, 150, 20);
		painel.add(textsetor);
		
		LocalSetor= new JTextField();
		LocalSetor.setBounds(55, 50, 150, 28);
		painel.add(LocalSetor);
		
		add = new JButton("Adicionar");
		add.addActionListener(this);
		add.setBounds(15,110,200,25);
		painel.add(add);
		
		textResultado = new JLabel("");
		textResultado.setBounds(15, 140, 200, 20);
		painel.add(textResultado);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add){
			Setor novoSetor = new Setor();
			novoSetor.setNome(LocalSetor.getText());
			if (DaoFactory.get().getSetorDAO().inserir(novoSetor)){
				textResultado.setText("Setor "+LocalSetor.getText()+ " Cadastrado com Sucesso.");
				LocalSetor.setText(" ");
			}
		}
		
		
	}
	
	
}
