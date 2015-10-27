package telas;


import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenerica;
import dao.factory.DaoFactory;
import model.Cargo;


public class AlterarUsuario extends TelaGenerica{

	private static final long serialVersionUID = 13L;

	
	private JTextField jtxUsuario = new JTextField();
	private JLabel jlbUsuario = new JLabel("Usuário:");
	private JTextField jtxBusca = new JTextField();
	private JLabel jlbBusca = new JLabel("Buscar Usuário:");
	private JButton jbtBusca = new JButton("Buscar");
	
	private JLabel jlbNome = new JLabel("Nome:");
	private JTextField jtxNome = new JTextField();
	
	private JLabel jlbSenha = new JLabel("Senha:");
	private JTextField jtxSenha = new JTextField();
	
	private JLabel jlbCodigo = new JLabel("Codigo do Usuário:");
	private JLabel jlbCodigo2 = new JLabel("XX");
	
	private JComboBox<Cargo> combobox = new JComboBox<Cargo>();
	private JLabel jlbCombobox = new JLabel("Cargo");
	
	ListaPedidos listaBusca;
	//---------
	
	
	public AlterarUsuario() {


		int posJTX = 160;
		int posJLB = 15;
	painel.setBorder(BorderFactory.createTitledBorder("Painel Alterar Usuário"));	
	
	jlbBusca.setBounds(posJLB,25,200,25);
	painel.add(jlbBusca);
	
	jtxBusca.setBounds(posJTX,25,200,25);
	painel.add(jtxBusca);
	
	jbtBusca.setBounds(360,25,200,25);
	jbtBusca.addActionListener(this);
	painel.add(jbtBusca);
	
	jlbCodigo.setBounds(posJLB,100,160,25);
	painel.add(jlbCodigo);
	jlbCodigo2.setBounds(posJTX,100,200,25);
	painel.add(jlbCodigo2);
	
	jlbUsuario.setBounds(posJLB,140,160,25);
	painel.add(jlbUsuario);
	
	jtxUsuario.setBounds(posJTX,140,200,25);
	painel.add(jtxUsuario);
	
	jlbNome.setBounds(posJLB,170,160,25);
	painel.add(jlbNome);
	jtxNome.setBounds(posJTX, 170,200, 25);
	painel.add(jtxNome);
	
	jlbSenha.setBounds(posJLB,200,160,25);
	painel.add(jlbSenha);
	jtxSenha.setBounds(posJTX, 200,200, 25);
	painel.add(jtxSenha);
	
	List<Cargo> cargos = DaoFactory.get().getCargoDAO().todos();
	cargos.forEach((Cargo cargo) -> {
		combobox.addItem(cargo);
	});
	
	combobox.setBounds(posJTX, 230, 200, 25);
	painel.add(combobox);
	jlbCombobox.setBounds(posJLB, 230, 200,25);
	painel.add(jlbCombobox);
	
	listaBusca = new ListaPedidos(DaoFactory.get().getPedidoDAO().todos(), 500, 90, 600,200, "aberto");
	painel.add(listaBusca.getLista());
	
	
	
	
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();
		
		if (botao == jbtBusca){
			
		}
		
	}
	
	public void resultadoBusca(){
		
	}

		
	}
