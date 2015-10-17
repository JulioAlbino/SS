package telas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.factory.DaoFactory;
import model.Cargo;
import model.Usuario;


public class NovoUsuario extends TelaGenerica implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField Ussuario, nome;
	private JLabel textUssuario;
	private JTextField senha;
	private JLabel textsenha, textcombo, textnome;
	private JButton add;
	private JComboBox<Cargo> combobox = new JComboBox<Cargo>();
	private List<Cargo> cargos = DaoFactory.get().getCargoDAO().todos();

	public NovoUsuario() {
	painel.setLayout(null);
	painel.setBounds(10, 10, 1024, 768);
	painel.setBorder(BorderFactory.createTitledBorder("Adicionar Novo Usuário"));	
	
	textUssuario = new JLabel("Usuario:");
	textUssuario.setBounds(15, 50, 150, 20);
	painel.add(textUssuario);
	
	Ussuario= new JTextField();
	Ussuario.setBounds(75, 50, 150, 28);
	painel.add(Ussuario);
	
	textsenha = new JLabel("Senha:");
	textsenha.setBounds(15, 80, 150, 20);
	painel.add(textsenha);
	
	senha= new JTextField();
	senha.setBounds(75, 80, 150, 28);
	painel.add(senha);
	
	textnome = new JLabel("Nome:");
	textnome.setBounds(15, 110, 150, 20);
	painel.add(textnome);
	
	nome = new JTextField();
	nome.setBounds(75, 110, 150, 28);
	painel.add(nome);
	
	cargos.forEach((Cargo cargo) -> {
		combobox.addItem(cargo);
	});
	
	
	textcombo = new JLabel("Cargo:");
	textcombo.setBounds(15, 140, 150, 20);
	painel.add(textcombo);
	
	combobox.setBounds(75, 140, 200, 28);
	painel.add(combobox);
	
	
	
	add = new JButton("Adicionar");
	add.setBounds(15,200,200,25);
	add.addActionListener(this);
	painel.add(add);
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add){
			Usuario newUser = new Usuario();
			newUser.setNome(nome.getText());
			newUser.setLogin(textUssuario.getText());
			newUser.setSenha(senha.getText());
			
			Cargo cargo = cargos.get(combobox.getSelectedIndex());
			newUser.setCargo(cargo);
			
			if(DaoFactory.get().getUsuarioDAO().inserir(newUser)){
				System.out.println("Inserido com Sucesso");
			}
			else {
				System.out.println("Nao foi");
			}
			
			
			
		}
		
	}


		
	}
