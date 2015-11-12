package telasGenericas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class TelaGenericaAdicionar extends TelaGenerica {

	private static final long serialVersionUID = 10L;
	

	protected JLabel jlbID = new JLabel("Local ID:");
	protected JLabel jlbIDValor = new JLabel("X");
	
	protected JLabel jlbNome = new JLabel("Local Nome:");
	
	 protected JTextField jtxtCampo = new JTextField();
	 
	 protected JButton alterar = new JButton("Efetuar Alteracoes");
	 protected JButton remover = new JButton("Remover Selecionado");
	 
	
	public TelaGenericaAdicionar(){

		jlbID.setBounds(500,300,200,25);
		painel.add(jlbID);
		
		
		jlbIDValor.setBounds(600,300,200,25);
		painel.add(jlbIDValor);
		
		jlbNome.setBounds(500, 330, 200, 25);
		painel.add(jlbNome);
		
		jtxtCampo.setBounds(600,330,400,25);
		painel.add(jtxtCampo);
		
		
		alterar.setBounds(500, 360, 350, 25);
		alterar.addActionListener(this);
		painel.add(alterar);
		
		remover.setBounds(860, 360, 250, 25);
		remover.addActionListener(this);
		painel.add(remover);
	
		visualizarLista(true);
		
	}
	
	public void visualizarLista(Boolean b){
		jlbID.setVisible(b);
		jlbIDValor.setVisible(b);
		jlbNome.setVisible(b);
		jtxtCampo.setVisible(b);
		alterar.setVisible(b);
		remover.setVisible(b);
	}
	
	public abstract void efetuarAlteracao();
	
	public abstract void removerSelecionado();
	

}
