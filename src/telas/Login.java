package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import daoo.UsuarioDAO;
import model.Usuario;

public class Login extends JFrame implements ActionListener{
	private JTextField usuario;
	private JPasswordField senha;
	private JButton submit;
	private JPanel painelLogin = new JPanel();
	private JLabel ds,ds1,erro;
	public Login(){
		painelLogin.setLayout(null);
		painelLogin.setBounds(200, 200, 600, 200);
		painelLogin.setBorder(BorderFactory
				.createTitledBorder("Entrar no Sistema"));	
		
		erro = new JLabel();
		erro.setBounds(150, 30, 400, 25);
		painelLogin.add(erro);
		
		ds = new JLabel("Usuario:");
		ds.setBounds(150, 55, 70, 25);
		painelLogin.add(ds);
		
		ds1 = new JLabel("Senha:");
		ds1.setBounds(150, 80, 50, 25);
		painelLogin.add(ds1);
		
		usuario = new JTextField();
		usuario.setBounds(220, 55, 200, 25);
		painelLogin.add(usuario);
		
		senha = new JPasswordField();
		senha.setBounds(220, 80, 200, 25);
		senha.setVisible(true);
		painelLogin.add(senha);
		
		submit = new JButton("Entrar");
		submit.setBounds(200,110,200,25);;
		submit.addActionListener(this);
		painelLogin.add(submit);
	}
	
	public JPanel getPainelLogin() {
		return painelLogin;
	}

	public JTextField getUsuario() {
		return usuario;
	}

	public JPasswordField getSenha() {
		return senha;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UsuarioDAO userDAO = new UsuarioDAO();
		String pw = new String(senha.getPassword());
		
		Usuario userx = userDAO.logarUsuario(usuario.getText(), pw);
		
		
		//EncarregadoSS encarregado = new EncarregadoSS();
		//TelaInicial.get().mostraPainel(encarregado.getPainelEncarregadoSS());
		
		if (userx != null){
			painelLogin.setVisible(false);
			TelaInicial.get().logar(userx);
		}
		else {
			erro.setText("Usuario e ou senha nao conferem..");
			senha.setText("");
		}
		
		
		
	}
	
	
	
	
}
