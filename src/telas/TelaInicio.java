package telas;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenerica;
import dao.factory.DaoFactory;

public class TelaInicio extends TelaGenerica {
	
	private JLabel TituloLista, TituloLista1, TituloLista2;

	private static final long serialVersionUID = 5L;

	public TelaInicio() {
		painel.setBorder(BorderFactory.createTitledBorder("TelaInicio"));
		
		TituloLista = new JLabel("Em aberto");
		TituloLista.setBounds(50, 60, 400, 30);
		
		TituloLista1 = new JLabel("Em andamento");
		TituloLista1.setBounds(450, 60, 500, 30);
		
		TituloLista2 = new JLabel("Ja terminadas");
		TituloLista2.setBounds(950, 60, 400,30);
		
		painel.add(TituloLista2);
		painel.add(TituloLista1);
		painel.add(TituloLista);
		mostraListas();
		
	}
	
	public void mostraListas(){
		ListaPedidos aberto = new ListaPedidos(DaoFactory.get().getPedidoDAO().todos(), 10, 90, 441,200, "aberto");
		painel.add(aberto.getLista());
		
		ListaPedidos aberto2 = new ListaPedidos(DaoFactory.get().getPedidoDAO().todos(), 455, 90, 441,200, "andamento");
		painel.add(aberto2.getLista());
		
		ListaPedidos aberto3 = new ListaPedidos(DaoFactory.get().getPedidoDAO().todos(), 900, 90, 441,200, "fechado");
		painel.add(aberto3.getLista());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
