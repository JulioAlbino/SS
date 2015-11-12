package telas;

import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import recursosParaTelas.ListaLocais;
import telasGenericas.TelaGenerica;
import dao.factory.DaoFactory;
import model.Local;

public class AdicionarNovoLocal extends TelaGenerica{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField Local;
	private JLabel textlocal, textResultado;
	private JButton add;

	//----


	public AdicionarNovoLocal() {

		painel.setBorder(BorderFactory.createTitledBorder("Adicionar Novo Local"));	
		
		textlocal = new JLabel("Local:");
		textlocal.setBounds(15, 50, 150, 20);
		painel.add(textlocal);
		
		Local= new JTextField();
		Local.setBounds(55, 50, 150, 28);
		painel.add(Local);
		
		add = new JButton("Adicionar");
		add.setBounds(15,110,200,25);
		add.addActionListener(this);
		painel.add(add);
		
		textResultado = new JLabel("");
		textResultado.setBounds(15, 140, 800, 20);
		painel.add(textResultado);
		
		//-------		
		listaLocais = new ListaLocais(DaoFactory.get().getLocalDAO().todos(), 500, 90, 600, 200);
		painel.add(listaLocais.getLista());
		
		jlbID.setBounds(500,300,200,25);
		painel.add(jlbID);
		
		jlbIDValor.setBounds(600,300,200,25);
		painel.add(jlbIDValor);
		
		jlbNome.setBounds(500, 330, 200, 25);
		painel.add(jlbNome);
		
		jtxtCampo.setBounds(600,330,400,25);
		painel.add(jtxtCampo);
		
		
		alterar.setBounds(500, 360, 350, 25);
		alterar.addActionListener(this);
		painel.add(alterar);
		
		remover.setBounds(860, 360, 250, 25);
		remover.addActionListener(this);
		painel.add(remover);
		visualizarLista(false);

}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add){
			Local local = new Local();
			local.setNome(Local.getText());
			if (DaoFactory.get().getLocalDAO().inserir(local)){
				textResultado.setText("Local "+Local.getText()+ " Cadastrado com Sucesso.");
				Local.setText(" ");
			}
		}
		
	}
	
	
}
