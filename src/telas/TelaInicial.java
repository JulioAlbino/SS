package telas;

import javax.swing.JFrame;

public class TelaInicial extends JFrame {
	private Login login = new Login();
	
	public TelaInicial() {
		setTitle("Ordem de Servico");
		setLayout(null);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(login.getPainelLogin());
	}
	
	



}
