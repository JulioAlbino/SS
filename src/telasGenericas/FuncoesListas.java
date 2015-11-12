package telasGenericas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import recursosParaTelas.ListaLocais;

public abstract class FuncoesListas {
	protected ListaLocais listaLocais;
	protected JLabel jlbID = new JLabel("Local ID:");
	protected JLabel jlbIDValor = new JLabel("X");
	
	protected JLabel jlbNome = new JLabel("Local Nome:");
	
	 protected JTextField jtxtCampo = new JTextField();
	 
	 protected JButton alterar = new JButton("Efetuar Alteracoes");
	 protected JButton remover = new JButton("Remover Selecionado");

	public void visualizarLista(Boolean b){
		jlbID.setVisible(b);
		jlbIDValor.setVisible(b);
		jlbNome.setVisible(b);
		jtxtCampo.setVisible(b);
		alterar.setVisible(b);
		remover.setVisible(b);
	}
}
