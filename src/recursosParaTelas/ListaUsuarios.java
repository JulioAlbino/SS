package recursosParaTelas;

import java.util.List;
import javax.swing.event.ListSelectionEvent;
import model.Usuario;
import telas.TelaInicial;
import telasGenericas.ListaGenerica;

public class ListaUsuarios extends ListaGenerica{
	
	public ListaUsuarios(List<Usuario> lista, int x, int y, int width, int height) {
		super(lista, x, y, width, height);
	}
@Override
	public void valueChanged(ListSelectionEvent e){
	Usuario user = (Usuario) this.lista.get(this.jltDados.getSelectedIndex());
		TelaInicial.get().getToolbar().getAlterarUsuario().setaUsuarioSelecionado(user);
	}
	
}
