package recursosParaTelas;

import java.util.List;

import javax.swing.event.ListSelectionEvent;

import model.Cargo;
import telas.TelaInicial;
import telasGenericas.ListaGenerica;

public class ListaCargos extends ListaGenerica{

	public ListaCargos(List<?> lista, int x, int y, int width, int height) {
		super(lista, x, y, width, height);

	}
	
	@Override
	public void valueChanged(ListSelectionEvent e){

		Cargo cargo = (Cargo) jltDados.getSelectedValue();
		
		TelaInicial.get().getToolbar().getAdicionarNovoCargo().setarValor(cargo);
	}
	

}
