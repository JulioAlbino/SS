package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import dao.factory.DaoFactory;
import model.Local;
import model.Pedido;
import model.Setor;
import telasGenericas.TelaGenerica;

public class ViewOS extends TelaGenerica {
	
	private static final long serialVersionUID = 1983L;
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
	
	private JLabel resultado = new JLabel();
	
	//---------
	
	private JLabel jlbEfetuar = new JLabel("");
	private JTextArea jtxaEfetuar = new JTextArea();

	public ViewOS(Pedido pedido){
		painel.setBorder(BorderFactory.createTitledBorder("Ordem de Serviço codigo: " + pedido.getIdpedido()));
		
		resultado.setBounds(15, 330, 450,25);
		painel.add(resultado);
		
		jlbSetor.setBounds(15, 50, 110, 25);
		painel.add(jlbSetor);

		setores.forEach((Setor setor) -> {
			if (setor.getIdsetor() == pedido.getSetor().getIdsetor()){
				comboboxSetor.addItem(setor);
				comboboxSetor.setSelectedItem(setor);
			}else {
				comboboxSetor.addItem(setor);
			}
		});
		comboboxSetor.setBounds(70, 50, 150, 25);
		
		painel.add(comboboxSetor);
		
		
		jlbDescricao.setBounds(15, 100, 200, 25);
		painel.add(jlbDescricao);
		
		jtxaDescricao.setBounds(15, 140, 650, 170);
		jtxaDescricao.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jtxaDescricao.setEditable(false);
		jtxaDescricao.setText(pedido.getDescricao());
		painel.add(jtxaDescricao);

		jlbLocal.setBounds(330, 50, 200, 25);
		painel.add(jlbLocal);
		locais.forEach((Local l) -> {
			if (l.getId() == pedido.getLocal().getId()){
				comboboxLocal.addItem(l);
				comboboxLocal.setSelectedItem(l);
			}
			else {
				comboboxLocal.addItem(l);	
			}
		});
		comboboxLocal.setBounds(380,50,200,25);
		painel.add(comboboxLocal);

		jlbData.setBounds(20,10,200,25);
		painel.add(jlbData);
		
		jlbDataValor = new JLabel(LocalDate.now().toString());
		jlbDataValor.setBounds(80, 10, 200, 25);
		jlbDataValor.setText(pedido.getDatahora().toString());
		painel.add(jlbDataValor);
		
		//--------------------------------------------------------
		
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}