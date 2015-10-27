package recursosParaTelas;

import java.awt.Color;
import java.util.List;

import telasGenericas.ListaGenerica;
import model.Pedido;

public class ListaPedidos extends ListaGenerica{

	public ListaPedidos(List<Pedido> lista, int x, int y, int width, int height, String tipo) {
		super(lista, x, y, width, height);
		
			
					
					if (tipo == "aberto"){
					jltDados.setBackground(Color.RED);
					}
					else if (tipo == "andamento"){
					jltDados.setBackground(Color.YELLOW);
					}
					else if (tipo == "fechado") {
					jltDados.setBackground(Color.GRAY);
					}
					

					
			} 
		
		
		
	}