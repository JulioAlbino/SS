package recursosParaTelas;

import java.util.List;

import javax.swing.event.ListSelectionEvent;

import model.Setor;
import telas.TelaInicial;
import telasGenericas.ListaGenerica;

public class ListaLocais extends ListaGenerica implements FuncoesListas{

	public ListaLocais(List<?> lista, int x, int y, int width, int height) {
		super(lista, x, y, width, height);

	}
	
	@Override
	public void valueChanged(ListSelectionEvent e){

		
		
		TelaInicial.get().getToolbar().getAdicionarNovoCargo().mostraValor();
	}
	

}