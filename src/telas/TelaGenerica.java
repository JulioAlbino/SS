package telas;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class TelaGenerica extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel painel = new JPanel();
	
	public JPanel getPainel(){
		return painel;
	}

}
