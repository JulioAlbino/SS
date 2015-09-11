package telas;


import javax.swing.JFrame;

public class Encarregado extends JFrame {
	
	private EncarregadoSS encarregadoss = new EncarregadoSS();
	public Encarregado() {
		setTitle("Ordem de Servico");
		setLayout(null);
		setSize(1024, 720);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(encarregadoss.getPainelEncarregadoSS());
		
		
		
	}
	

}
