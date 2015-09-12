package telas;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaInicial extends JFrame {
	
	
	private static TelaInicial telainicial;
	
	public static TelaInicial get(){
		if(telainicial == null){
			telainicial = new TelaInicial();
		}
		return telainicial;
	}
	
	public void mostraPainel(JPanel painel){
		getContentPane().removeAll();
		getContentPane().add(painel);
	}
	
	public TelaInicial() {
		setTitle("Ordem de Servico");
		setLayout(null);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
public static void main(String[] args) {
		
		Login login = new Login();
		JPanel loginP = login.getPainelLogin();
		TelaInicial.get().mostraPainel(loginP);
		}
	
public void teste(){
	System.out.println("Teste");
}


}
