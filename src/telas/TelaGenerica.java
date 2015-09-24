package telas;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class TelaGenerica extends JFrame{
	
	protected JPanel painel = new JPanel();
	
	public JPanel getPainel(){
		return painel;
	}

}
