package recursosParaTelas;

import java.util.List;

import javax.swing.event.ListSelectionEvent;

import model.Local;
import telas.TelaInicial;
import telasGenericas.ListaGenerica;

public class ListaLocais extends ListaGenerica{

	public ListaLocais(List<?> lista, int x, int y, int width, int height) {
		super(lista, x, y, width, height);

	}
	
	@Override
	public void valueChanged(ListSelectionEvent e){

		Local local = (Local) jltDados.getSelectedValue();
		
		TelaInicial.get().getToolbar().getAdicionarNovoLocal().setarValor(local);
	}
	

}
