package telas;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import telas.ToolBar;
import model.Usuario;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 4L;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static TelaInicial telainicial;
	private Usuario usuario;
	private static ToolBar toolbar = new ToolBar();
	
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
	
public ToolBar getToolbar(){
	return toolbar;
}
	
	public TelaInicial() {
		setTitle("Ordem de Servico");
		setLayout(null);
		setSize(screenSize.width, screenSize.height);
		setVisible(true);
		setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}

public static void main(String[] args) {
		Login login = new Login();
		TelaInicial.get().mostraPainel(login.getPainelLogin());
		}

public void logar(Usuario usuarioLogado){
	this.usuario = usuarioLogado;
	TelaInicial.get().setJMenuBar(toolbar.getBarra());
	mostraPainel(toolbar.getTelaInicio().getPainel());
}//final do metodo logar

public Usuario getUsuario() {
	return usuario;
}
}//final da classe