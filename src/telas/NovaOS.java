package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import telasGenericas.TelaGenerica;
import dao.factory.DaoFactory;
import model.Local;
import model.Pedido;
import model.Setor;

public class NovaOS extends TelaGenerica{

	private static final long serialVersionUID = 3L;
	private JLabel jlbDescricao = new JLabel("Defeito apresentado:");
	
	private JLabel jlbSetor = new JLabel("Setor: ");
	private List<Setor> setores = DaoFactory.get().getSetorDAO().todos();
	private JComboBox<Setor> comboboxSetor = new JComboBox<Setor>();
	
	private JLabel jlbLocal = new JLabel("Local:");
	private JComboBox<Local> comboboxLocal = new JComboBox<Local>();
	private List<Local> locais = DaoFactory.get().getLocalDAO().todos();
	
	private JTextArea jtxaDescricao = new JTextArea();
	private JLabel jlbDataValor;
	private JLabel jlbData = new JLabel("Data:");
	
	private JButton jbtCriar = new JButton("Abrir OS");
	
	public NovaOS() {
		
		painel.setBorder(BorderFactory.createTitledBorder("Nova OS"));
		
		jlbSetor.setBounds(15, 50, 110, 25);
		painel.add(jlbSetor);
		setores.forEach((Setor setor) -> {
			
			
			comboboxSetor.addItem(setor);
		});
		comboboxSetor.setBounds(70, 50, 150, 25);
		painel.add(comboboxSetor);
		
		jlbDescricao.setBounds(15, 100, 200, 25);
		painel.add(jlbDescricao);
		
		jtxaDescricao.setBounds(15, 140, 650, 170);
		jtxaDescricao.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		painel.add(jtxaDescricao);

		jlbLocal.setBounds(330, 50, 200, 25);
		painel.add(jlbLocal);
		locais.forEach((Local l) -> {
			comboboxLocal.addItem(l);
		});
		comboboxLocal.setBounds(380,50,200,25);
		painel.add(comboboxLocal);

		jlbData.setBounds(20,10,200,25);
		painel.add(jlbData);
		
		jlbDataValor = new JLabel(LocalDate.now().toString());
		jlbDataValor.setBounds(80, 10, 200, 25);
		painel.add(jlbDataValor);
		
		jbtCriar.setBounds(15, 350, 200, 25);
		jbtCriar.addActionListener(this);
		painel.add(jbtCriar);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtCriar){
			Setor novoSetor = (Setor) comboboxSetor.getSelectedItem();
			Local local = (Local) comboboxLocal.getSelectedItem();
			LocalDate date = LocalDate.parse(jlbDataValor.getText());
			
			Pedido novaOS = new Pedido(date, jtxaDescricao.getText(), 1,  TelaInicial.get().getUsuario(), local, novoSetor);
			
			if(DaoFactory.get().getPedidoDAO().inserir(novaOS)){
				JOptionPane.showMessageDialog(this, "Nova Ordem de Servico criada com Sucesso");
				jtxaDescricao.setText("");
				
				
			}
			
		}
		
	}
}
