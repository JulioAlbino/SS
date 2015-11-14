package telas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Pedido;
import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenerica;
import dao.factory.DaoFactory;

public class TelaInicio extends TelaGenerica implements KeyListener {
	
	private JLabel TituloLista = new JLabel("Em aberto"),
	TituloLista1 = new JLabel("Em andamento"), 
	TituloLista2 = new JLabel("Ja Finalizadas"),
			TituloLista3 = new JLabel("Aguardando Confirmação de Finalizacao");

	private JTextField campoBusca = new JTextField("Buscar");
	private JLabel jlbBusca = new JLabel("Buscar entre os Pedidos:");
	private static final long serialVersionUID = 512312L;
	
	private ListaPedidos aberto = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAbertos(), 10, 90, 441,200),
	andamento = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAndamento(), 455, 90, 441,200),
	finalizados  = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosFinalizados(), 900, 90, 441,200),
	aguardando = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAguardando(), 455, 310, 441,200);
	

	public TelaInicio() {
		painel.setBorder(BorderFactory.createTitledBorder("TelaInicio"));
		painel.add(aberto.getLista());
		painel.add(andamento.getLista());
		painel.add(finalizados.getLista());
		painel.add(aguardando.getLista());

		
		jlbBusca.setBounds(21,30,400,30);
		painel.add(jlbBusca);
		
		campoBusca.setBounds(230, 30, 400, 25);
		campoBusca.addKeyListener(this);
		painel.add(campoBusca);
		
		TituloLista.setBounds(50, 60, 400, 25);
		painel.add(TituloLista);
		TituloLista1.setBounds(450, 60, 500, 30);
		painel.add(TituloLista1);
		TituloLista2.setBounds(950, 60, 400,30);
		painel.add(TituloLista2);
		
		TituloLista3.setBounds(450, 285, 500, 30);
		painel.add(TituloLista3);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		efetuaBuscas();
		// TODO Auto-generated method stub
		
	}
	
	public void efetuaBuscas(){
		String busca = campoBusca.getText();
		painel.remove(aberto.getLista());
		painel.remove(andamento.getLista());
		painel.remove(finalizados.getLista());
		painel.remove(aguardando.getLista());
		
		List<Pedido> ListaAbertos = DaoFactory.get().getPedidoDAO().buscarPedidosAbertos(busca);
		List<Pedido> ListaAndamento = DaoFactory.get().getPedidoDAO().buscarPedidosEmAndamento(busca);
		List<Pedido> ListaFinalizados = DaoFactory.get().getPedidoDAO().buscarPedidosFinalizados(busca);
		List<Pedido> ListaAguardando = DaoFactory.get().getPedidoDAO().buscarPedidosAguardando(busca);
		
		
		if (!ListaAbertos.isEmpty()){
			aberto = null;
			aberto = new ListaPedidos(ListaAbertos, 10, 90, 441,200 );
			painel.add(aberto.getLista());
		}else { 
			aberto.LimparLista(); 
			painel.add(aberto.getLista());
		}
		
		if (!ListaAndamento.isEmpty()){
			andamento = null;
			andamento = new ListaPedidos(ListaAndamento, 455, 90, 441,200);
			painel.add(andamento.getLista());
		}else { 
			andamento.LimparLista(); 
			painel.add(andamento.getLista());
		}
		
		if (!ListaFinalizados.isEmpty()){
			finalizados = null;
			finalizados  = new ListaPedidos(ListaFinalizados, 900, 90, 441,200);
			painel.add(finalizados.getLista());
		}else { 
			finalizados.LimparLista(); 
			painel.add(finalizados.getLista());
		}
		
		if (!ListaAguardando.isEmpty()){
			aguardando = null;
			aguardando = new ListaPedidos(ListaAguardando, 455, 310, 441,200);
			painel.add(aguardando.getLista());	
		}
		else { 
			aguardando.LimparLista(); 
			painel.add(aguardando.getLista());
		}
		
		
		
		
		
		
		
		painel.updateUI();
		
		
		
		
	}
	

}
