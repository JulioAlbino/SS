package recursosParaTelas;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.List;
import telas.TelaInicial;
import telas.ViewOS;
import telasGenericas.ListaGenerica;
import model.Pedido;

public class ListaPedidos extends ListaGenerica{

	public ListaPedidos(List<Pedido> lista, int x, int y, int width, int height) {
		super(lista, x, y, width, height);
		
		
		if (!lista.isEmpty()){
		switch(lista.get(0).getSituacao()){
		case 1:
			jltDados.setBackground(Color.RED);
			break;
		case 2:
			jltDados.setBackground(Color.YELLOW);
			break;
		case 3:
			jltDados.setBackground(Color.GRAY);
			break;
		case 4:
			jltDados.setBackground(Color.GREEN);
			break;
		default:
			jltDados.setBackground(Color.GRAY);
			break;
		}
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() >= 2){
			Pedido p = (Pedido) lista.get(jltDados.getSelectedIndex());
			ViewOS view = new ViewOS(p);
			TelaInicial.get().mostraPainel(view.getPainel());
		}
	}
	
	
}