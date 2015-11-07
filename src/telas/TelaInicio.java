package telas;

import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import recursosParaTelas.ListaPedidos;
import telasGenericas.TelaGenerica;
import dao.factory.DaoFactory;

public class TelaInicio extends TelaGenerica {
	
	private JLabel TituloLista = new JLabel("Em aberto"),
	TituloLista1 = new JLabel("Em andamento"), 
	TituloLista2 = new JLabel("Ja Finalizadas"),
			TituloLista3 = new JLabel("Aguardando Confirmação de Finalizacao");

	private static final long serialVersionUID = 5L;

	public TelaInicio() {
		painel.setBorder(BorderFactory.createTitledBorder("TelaInicio"));
		
		
		
		
		
		
		TituloLista.setBounds(50, 60, 400, 30);
		painel.add(TituloLista);
		TituloLista1.setBounds(450, 60, 500, 30);
		painel.add(TituloLista1);
		TituloLista2.setBounds(950, 60, 400,30);
		painel.add(TituloLista2);
		
		TituloLista3.setBounds(450, 285, 500, 30);
		painel.add(TituloLista3);
		mostraListas();
		
	}
	
	public void mostraListas(){
		ListaPedidos aberto = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAbertos(), 10, 90, 441,200);
		painel.add(aberto.getLista());
		
		ListaPedidos aberto2 = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAndamento(), 455, 90, 441,200);
		painel.add(aberto2.getLista());
		
		ListaPedidos aberto3 = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosFinalizados(), 900, 90, 441,200);
		painel.add(aberto3.getLista());
		
		ListaPedidos aberto4 = new ListaPedidos(DaoFactory.get().getPedidoDAO().todosAguardando(), 455, 310, 441,200);
		painel.add(aberto4.getLista());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
