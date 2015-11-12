package recursosParaTelas;

import java.util.List;

import javax.swing.event.ListSelectionEvent;

import model.Setor;
import telas.TelaInicial;
import telasGenericas.ListaGenerica;

public class ListaSetores extends ListaGenerica{

	public ListaSetores(List<?> lista, int x, int y, int width, int height) {
		super(lista, x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e){
	Setor setor = (Setor) lista.get(jltDados.getSelectedIndex());
		TelaInicial.get().getToolbar().getAdicionarNovoCargo().setSetor(setor);
	}

}
