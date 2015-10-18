package telas;

import java.awt.Color;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JScrollPane;

import model.Pedido;

public class ListaTela {
	
	private JList<Pedido> jltDados;
	private JScrollPane jspRolagem;
	
	public ListaTela(List<Pedido> lista, int x, int y, int width, int height, String tipo ){
		
Vector<Pedido> pedidoV = new Vector<>(lista);
		
		jltDados = new JList<Pedido>(pedidoV);
		
		if (tipo == "aberto"){
		jltDados.setBackground(Color.RED);
		}
		else if (tipo == "andamento"){
		jltDados.setBackground(Color.YELLOW);
		}
		else if (tipo == "fechado") {
		jltDados.setBackground(Color.GRAY);
		}
		
		jspRolagem = new JScrollPane(jltDados);
		jspRolagem.setBounds(x, y, width, height);
		
}
	
	public JScrollPane getLista(){
		return jspRolagem;
	}
	
}