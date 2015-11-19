package telas;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JComboBox<Setor> combobox = new JComboBox<Setor>(),
			combobox2 = new JComboBox<Setor>();
	private JComboBox<String> comboboxPermissao = new JComboBox<String>();
	private JComboBox<String> comboboxPermissao2 = new JComboBox<String>();
	private List<Setor> setores = DaoFactory.get().getSetorDAO().todos();
	private ListaCargos listaCargos;
	
	final String admin="Administrador", funcionario="Funcionario", encarregado="Encarregado";

	public AdicionarNovoCargo() {
		painel.setBorder(BorderFactory.createTitledBorder("Adicionar Novo Cargo"));	
		
		textCargo = new JLabel("Nome do Cargo:");
		textCargo.setBounds(15, 50, 230, 20);
		painel.add(textCargo);
		
		Cargo = new JTextField();
		Cargo.setBounds(150, 50, 150, 28);
		painel.add(Cargo);
		
		setores.forEach((Setor setor) -> {
			combobox.addItem(setor);
		});
		
		
		comboboxPermissao.setBounds(55, 115, 200, 28);
		comboboxPermissao.addItem(admin);
		comboboxPermissao.addItem(funcionario);
		comboboxPermissao.addItem(encarregado);
		painel.add(comboboxPermissao);
		
		combobox.setBounds(55, 80, 200, 28);
		painel.add(combobox);
		
		add = new JButton("Adicionar");
		add.setBounds(15,150,200,25);
		add.addActionListener(this);
		painel.add(add);
	
		
		//--------
		
		listaCargos = new ListaCargos(DaoFactory.get().getCargoDAO().todos(), 500, 90, 600, 200);
		painel.add(listaCargos.getLista());
		visualizarLista(false);
		
}

	@Override
	public void actionPerformed(ActionEvent e) {
if (e.getSource().equals(add)){
	Cargo cargo = new Cargo();
	cargo.setNome(Cargo.getText());
	Setor novoSetor = (Setor)combobox.getSelectedItem();
	cargo.setSetor(novoSetor);
	cargo.setPermissao(comboboxPermissao.getSelectedIndex()+1);
	if (DaoFactory.get().getCargoDAO().inserir(cargo)){
		atualizaLista();	
	}
	else {
		JOptionPane.showMessageDialog(this, "Problemas Com o Banco de Dados favor Verificar");
	}	
}
else if (e.getSource().equals(alterar)){
efetuarAlteracao();
	atualizaLista();
	
}
else if (e.getSource().equals(remover)){
	removerSelecionado();
	atualizaLista();
}
		
	}
	

	public void setarValor(Cargo cargoS){
		visualizarLista(true);
		jlbIDValor.setText(cargoS.getIdcargo().toString());
		jtxtCampo.setText(cargoS.getNome());
		
		painel.remove(combobox2);
		painel.remove(comboboxPermissao2);
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
		
		comboboxPermissao2 = new JComboBox<String>();
		comboboxPermissao2.removeAllItems();
		comboboxPermissao2.setBounds(700, 360, 250, 28);
		comboboxPermissao2.addItem(admin);
		comboboxPermissao2.addItem(funcionario);
		comboboxPermissao2.addItem(encarregado);
		
		switch(cargoS.getPermissao()){
		case 1:
			comboboxPermissao2.setSelectedItem(admin);
			break;
		case 2:
			comboboxPermissao2.setSelectedItem(funcionario);
			break;
		case 3:
			comboboxPermissao2.setSelectedItem(encarregado);
			break;
		default:
			comboboxPermissao2.setSelectedItem(funcionario);
			break;
		}
		
		painel.add(comboboxPermissao2);
		painel.add(combobox2);
		painel.updateUI();
	}

	@Override
	public void efetuarAlteracao() {
		Cargo cargox = new Cargo(Integer.valueOf(jlbIDValor.getText()), jtxtCampo.getText(), (Setor)combobox2.getSelectedItem(), true, comboboxPermissao2.getSelectedIndex()+1 );
		if(DaoFactory.get().getCargoDAO().alterar(cargox)){
			JOptionPane.showMessageDialog(this, "Alteracoes efetuadas com Sucesso");
		}
		else {
			JOptionPane.showMessageDialog(this, "Problemas no Banco, chame o Suporte");
		}
		
	}

	@Override
	public void removerSelecionado() {
		Cargo cargox = new Cargo(Integer.valueOf(jlbIDValor.getText()), jtxtCampo.getText(), (Setor)combobox2.getSelectedItem(), true, comboboxPermissao2.getSelectedIndex()+1);
		if(DaoFactory.get().getCargoDAO().desativar(cargox)){
			JOptionPane.showMessageDialog(this, "Cargo removido com Sucesso");
		}else {
			JOptionPane.showMessageDialog(this, "Problemas no Banco, chame o Suporte");
		}
		visualizarLista(false);
	}

	@Override
	public void atualizaLista() {
		painel.remove(this.listaCargos.getLista());
		this.listaCargos.setLista(DaoFactory.get().getCargoDAO().todos());
		painel.add(this.listaCargos.getLista());
		painel.updateUI();
		
	}
	@Override
	public void visualizarLista(Boolean b){
		jlbID.setVisible(b);
		jlbIDValor.setVisible(b);
		jlbNome.setVisible(b);
		jtxtCampo.setVisible(b);
		alterar.setVisible(b);
		remover.setVisible(b);
		combobox2.setVisible(b);
		comboboxPermissao2.setVisible(b);
	}
}