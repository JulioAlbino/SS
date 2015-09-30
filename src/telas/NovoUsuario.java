package telas;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class NovoUsuario extends TelaGenerica{
	
	private JTextField Ussuario;
	private JLabel textUssuario;
	private JTextField senha;
	private JLabel textsenha;
	private JButton add;
	private JButton del;


	public NovoUsuario() {
	painel.setLayout(null);
	painel.setBounds(10, 10, 1024, 768);
	painel.setBorder(BorderFactory.createTitledBorder("Painel Novo Usuário"));	
	
	textUssuario = new JLabel("Ussuario:");
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
	
	add = new JButton("Adicionar");
	add.setBounds(15,110,200,25);
	painel.add(add);
	
	del = new JButton("Excluir");
	del.setBounds(220,110,200,25);
	painel.add(del);

	
}


		
	}
