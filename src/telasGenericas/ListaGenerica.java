package telasGenericas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public abstract class ListaGenerica implements ListSelectionListener, MouseListener {
	
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
		this.lista = lista;
		
		listaVector = new Vector<>(lista);
		
		setLista(lista);
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
		jltDados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jltDados.addListSelectionListener(this);
		jltDados.addMouseListener(this);
		jspRolagem = new JScrollPane(jltDados);
		jspRolagem.setBounds(this.x,this.y,this.width,this.height);
		
	}
	@Override
	public void valueChanged(ListSelectionEvent e){
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
