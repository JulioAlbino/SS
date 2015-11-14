package telasGenericas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Pedido;
import recursosParaTelas.ListaPedidos;

public abstract class TelaGenericaListas extends TelaGenerica implements KeyListener{

	private static final long serialVersionUID = 10L;
	

	protected JLabel txtBusca = new JLabel("Buscar:");
	protected JTextField jtfBusca = new JTextField();
	protected JButton jbtSelecionar = new JButton("Abrir Selecionada");
	protected ListaPedidos listaPedidos;
	
	public TelaGenericaListas(){
		txtBusca.setBounds(10,40, 100,30);
		
		painel.add(txtBusca);
		
		jtfBusca.setBounds(70,40,200,30);
		jtfBusca.addKeyListener(this);
		painel.add(jtfBusca);
		
		jbtSelecionar.setBounds(20, 600,200,30);
		painel.add(jbtSelecionar);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void Buscar(List<Pedido> pedidos){
		painel.remove(listaPedidos.getLista());
		
		if (!pedidos.isEmpty()){
			listaPedidos = null;
			listaPedidos = new ListaPedidos(pedidos, 20, 90, 1300,500);
			painel.add(listaPedidos.getLista());
		}else { 
		listaPedidos.LimparLista(); 
			painel.add(listaPedidos.getLista());
		}
		painel.updateUI();
	}
	

}
