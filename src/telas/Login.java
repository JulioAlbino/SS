package telas;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	private JTextField usuario;
	private JPasswordField senha;
	private JButton submit;
	private JPanel painelLogin = new JPanel();
	private JLabel ds,ds1;
	public Login(){
		painelLogin.setLayout(null);
		painelLogin.setBounds(10, 10, 600, 200);
		painelLogin.setBorder(BorderFactory
				.createTitledBorder("Entrar no Sistema"));	
		
		ds = new JLabel("Usuário:");
		ds.setBounds(150, 30, 50, 25);
		painelLogin.add(ds);
		
		ds1 = new JLabel("Senha:");
		ds1.setBounds(150, 55, 50, 25);
		painelLogin.add(ds1);
		
		usuario = new JTextField();
		usuario.setBounds(200, 30, 200, 25);
		painelLogin.add(usuario);
		
		senha = new JPasswordField();
		senha.setBounds(200, 55, 200, 25);
		senha.setVisible(true);
		painelLogin.add(senha);
		
		submit = new JButton("Entrar");
		submit.setBounds(200,80,200,25);;
		painelLogin.add(submit);
	}
	
	public JPanel getPainelLogin() {
		return painelLogin;
	}
	
}
