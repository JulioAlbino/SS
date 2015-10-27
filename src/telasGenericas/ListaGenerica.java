package telasGenericas;

import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JScrollPane;

public abstract class ListaGenerica {
	
	protected JScrollPane jspRolagem;
	protected List<?> lista;
	protected Vector<?> listaVector;
	protected JList<?> jltDados;
	protected int x,y,width,height;
	
	public ListaGenerica(List<?> lista, int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		listaVector = new Vector<>(lista);
		
		jltDados = new JList<>(listaVector);
		
		
		
		jspRolagem = new JScrollPane(jltDados);
		jspRolagem.setBounds(x, y, width, height);
		
	}

	public JScrollPane getLista(){
		return jspRolagem;
	}
	
	public void setLista(List<?> listaNova){
		this.lista = null;
		this.lista = listaNova;
		listaVector = null;
		jltDados = null;
		jspRolagem = null;
		
		listaVector = new Vector<>(lista);
		jltDados = new JList<>(listaVector);
		
		jspRolagem = new JScrollPane(jltDados);
		jspRolagem.setBounds(this.x,this.y,this.width,this.height);
		
	}
	

	
}
