package telas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class TelaGenerica extends JFrame{
	
	private static final long serialVersionUID = 1L;
	protected JPanel painel = new JPanel();
	
	
	public TelaGenerica(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		painel.setLayout(null);
		painel.setBounds(10, 10, screenSize.width - 15,screenSize.height - 80);
	}
	public JPanel getPainel(){
		return painel;
	}

}
