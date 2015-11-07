package telas;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import telasGenericas.TelaGenerica;
import dao.factory.DaoFactory;
import model.Setor;
import model.Cargo;
public class AdicionarNovoCargo extends TelaGenerica {

	private static final long serialVersionUID = 1L;
	private JTextField Cargo;
	private JLabel textCargo;
	private JButton add;
	private JButton del;
	private JComboBox<Setor> combobox = new JComboBox<Setor>();
	private List<Setor> setores = DaoFactory.get().getSetorDAO().todos();

	public AdicionarNovoCargo() {
		painel.setBorder(BorderFactory.createTitledBorder("Adicionar Novo Cargo"));	
		
		textCargo = new JLabel("Nome do Cargo:");
		textCargo.setBounds(15, 50, 150, 20);
		painel.add(textCargo);
		
		Cargo = new JTextField();
		Cargo.setBounds(55, 50, 150, 28);
		painel.add(Cargo);
		
		setores.forEach((Setor setor) -> {
			combobox.addItem(setor);
		});
		
		combobox.setBounds(55, 80, 200, 28);
		painel.add(combobox);
		
		add = new JButton("Adicionar");
		add.setBounds(15,110,200,25);
		add.addActionListener(this);
		painel.add(add);
		
		del = new JButton("Excluir");
		del.setBounds(220,110,200,25);
		painel.add(del);
}

	@Override
	public void actionPerformed(ActionEvent e) {
if (e.getSource() == add){
	Cargo cargo = new Cargo();
	cargo.setNome(Cargo.getText());
	Setor novoSetor = (Setor)combobox.getSelectedItem();
	cargo.setSetor(novoSetor);
	DaoFactory.get().getCargoDAO().inserir(cargo);
	
}
		
	}
}