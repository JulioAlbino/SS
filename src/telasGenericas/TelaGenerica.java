package telasGenericas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import telas.TelaInicial;

public abstract class TelaGenerica extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	protected JPanel painel = new JPanel();
	protected JLabel jlbUsuarioLogado = new JLabel("Usuario Logado:"),
			jlbUsuarioLogadoValor = new JLabel();
	
	
	public TelaGenerica(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		painel.setLayout(null);
		painel.setBounds(10, 10, screenSize.width - 15,screenSize.height - 80);
		
		jlbUsuarioLogado.setBounds(800,10, 400, 30);
		painel.add(jlbUsuarioLogado);
		
		jlbUsuarioLogadoValor.setBounds(950,10,400,30);
		jlbUsuarioLogadoValor.setText(TelaInicial.get().getUsuario().getNome());
		painel.add(jlbUsuarioLogadoValor);
	}
	public JPanel getPainel(){
		return painel;
	}

}
