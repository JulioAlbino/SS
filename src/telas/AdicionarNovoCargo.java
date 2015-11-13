package telas;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import recursosParaTelas.ListaCargos;
import telasGenericas.TelaGenericaAdicionar;
import dao.factory.DaoFactory;
import model.Setor;
import model.Cargo;
public class AdicionarNovoCargo extends TelaGenericaAdicionar {

	private static final long serialVersionUID = 1L;
	private JTextField Cargo;
	private JLabel textCargo;
	private JButton add;
	private JButton del;
	private JComboBox<Setor> combobox = new JComboBox<Setor>(),
			combobox2 = new JComboBox<Setor>();
	private List<Setor> setores = DaoFactory.get().getSetorDAO().todos();
	private ListaCargos listaCargos;

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
		
		//--------
		
		listaCargos = new ListaCargos(DaoFactory.get().getCargoDAO().todos(), 500, 90, 600, 200);
		painel.add(listaCargos.getLista());
		visualizarLista(false);
		
		
		
		
		
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
else if (e.getSource().equals(alterar)){
efetuarAlteracao();
	atualizaLista();
	
}
else if (e.getSource().equals(remover)){
	
}
		
	}
	

	public void setarValor(Cargo cargoS){
		visualizarLista(true);
		jlbIDValor.setText(cargoS.getIdcargo().toString());
		jtxtCampo.setText(cargoS.getNome());
		
		painel.remove(combobox2);
		painel.updateUI();
		
		
		combobox2 = new JComboBox<Setor>();
		combobox2.setBounds(700, 300, 250, 28);
		setores = null;
		setores = DaoFactory.get().getSetorDAO().todos();
		setores.forEach((Setor setor) -> {
			if (!setor.equals(cargoS.getSetor())){
				combobox2.addItem(setor);	
			}
		});
		combobox2.addItem(cargoS.getSetor());
		combobox2.setSelectedItem(cargoS.getSetor());
		
		
		painel.add(combobox2);
		painel.updateUI();
	}

	@Override
	public void efetuarAlteracao() {
		Cargo cargox = new Cargo(Integer.valueOf(jlbIDValor.getText()), jtxtCampo.getText(), (Setor)combobox2.getSelectedItem() );
		DaoFactory.get().getCargoDAO().alterar(cargox);
		
	}

	@Override
	public void removerSelecionado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizaLista() {
		painel.remove(this.listaCargos.getLista());
		this.listaCargos.setLista(DaoFactory.get().getCargoDAO().todos());
		painel.add(this.listaCargos.getLista());
		painel.updateUI();
		
	}
}