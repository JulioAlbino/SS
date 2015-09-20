package telas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Usuario;

public class TelaInicial extends JFrame {
	
	
	private static TelaInicial telainicial;
	private static Usuario usuario;
	
	public static TelaInicial get(){
		if(telainicial == null){
			telainicial = new TelaInicial();
		}
		return telainicial;
	}
	
	public void mostraPainel(JPanel painel){
		getContentPane().removeAll();
		getContentPane().setVisible(false);
		getContentPane().setVisible(true);
		getContentPane().add(painel);
	}
	
	public TelaInicial() {
		setTitle("Ordem de Servico");
		setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setVisible(true);
		setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
public static void main(String[] args) {
		
		Login login = new Login();
		JPanel loginP = login.getPainelLogin();
		TelaInicial.get().mostraPainel(loginP);
		}

public void logar(Usuario usuarioLogado){
	
	TelaInicial.usuario = usuarioLogado;
	if (usuario.getCargo_idcargo() == 1){
		ToolBar toolbar = new ToolBar();
		TelaInicial.get().setJMenuBar(toolbar.getBarra());
		EncarregadoSS encarregado = new EncarregadoSS(); 
		mostraPainel(encarregado.getPainelEncarregadoSS());
	}
}


}
