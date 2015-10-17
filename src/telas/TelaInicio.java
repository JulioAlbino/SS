package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class TelaInicio extends TelaGenerica {
	
	private JList<String> jltDados, jltDados1, jltDados2;
	private JScrollPane jspRolagem, jspRolagem1, jspRolagem2;
	private JLabel TituloLista, TituloLista1, TituloLista2;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaInicio() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		painel.setLayout(null);
		painel.setBounds(10, 10, screenSize.width - 15,screenSize.height - 80);
		painel.setBorder(BorderFactory.createTitledBorder("TelaInicio"));
	
		TituloLista = new JLabel("Em aberto");
		TituloLista.setBounds(50, 60, 400, 30);
		
		TituloLista1 = new JLabel("Em andamento");
		TituloLista1.setBounds(450, 60, 500, 30);
		
		TituloLista2 = new JLabel("Ja terminadas");
		TituloLista2.setBounds(950, 60, 400,30);
		
		painel.add(TituloLista2);
		painel.add(TituloLista1);
		painel.add(TituloLista);
		
		Vector<String> dados = new Vector<String>();
		dados.add("Teste");
		jltDados = new JList<>(dados);
		jltDados.setBackground(Color.red);
		jspRolagem = new JScrollPane(jltDados);
		
		jspRolagem.setBounds(10, 90, 440, 200);
		painel.add(jspRolagem);
		
		jltDados1 = new JList<>(dados);
		jltDados1.setBackground(Color.yellow);
		jspRolagem1 = new JScrollPane(jltDados1);
		jspRolagem1.setBounds(455, 90, 440, 200);
		painel.add(jspRolagem1);

		jltDados2 = new JList<>(dados);
		jltDados2.setBackground(Color.green);
		jspRolagem2 = new JScrollPane(jltDados2);
		jspRolagem2.setBounds(900, 90, 440, 200);
		painel.add(jspRolagem2);
		
	}

}
