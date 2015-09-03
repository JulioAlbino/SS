package telas;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ToolBar{
	private JMenuItem botaoSaidas, botaoReceitas, botaoInicio, botaoSair;
	private JMenuBar barra;
	public ToolBar() {
		barra = new JMenuBar();
		
		JMenu iconeInicio = new JMenu("�nicio");
		botaoInicio = new JMenuItem("Inicio");
		iconeInicio.add(botaoInicio);
		barra.add(iconeInicio);

		JMenu iconeReceitas = new JMenu("Receitas");
		botaoReceitas = new JMenuItem("Receitas");
		iconeReceitas.add(botaoReceitas);
		barra.add(iconeReceitas);
		
		JMenu iconeSaidas = new JMenu("Sa�das");
		botaoSaidas = new JMenuItem("Sa�das");
		iconeSaidas.add(botaoSaidas);
		barra.add(iconeSaidas);
		
		JMenu iconeSair = new JMenu("Sair");
		botaoSair = new JMenuItem("Sair");
		
		iconeSair.add(botaoSair);
		barra.add(iconeSair);
	}
	public JMenuBar getBarra() {
		return barra;
	}
	
}
