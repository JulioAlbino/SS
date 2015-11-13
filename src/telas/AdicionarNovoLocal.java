package telas;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import recursosParaTelas.ListaLocais;
import telasGenericas.TelaGenericaAdicionar;
import dao.factory.DaoFactory;
import model.Local;

public class AdicionarNovoLocal extends TelaGenericaAdicionar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField Local;
	private JLabel textlocal, textResultado;
	private JButton add;
	
	private ListaLocais listaLocais ;

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
		
		
		//-----

		listaLocais = new ListaLocais(DaoFactory.get().getLocalDAO().todos(), 500, 90, 600, 200);
		painel.add(listaLocais.getLista());
		visualizarLista(false);
	}

	public void setarValor(Local local){
		visualizarLista(true);
		jlbIDValor.setText(local.getId().toString());
		jtxtCampo.setText(local.getNome());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(add)){
			Local local = new Local();
			local.setNome(Local.getText());
			if (DaoFactory.get().getLocalDAO().inserir(local)){
				textResultado.setText("Local "+Local.getText()+ " Cadastrado com Sucesso.");
				Local.setText(" ");
			}
			atualizaLista();
		}
		else if (e.getSource().equals(alterar)){
			efetuarAlteracao();
			
		}
		else if (e.getSource().equals(remover)){
			removerSelecionado();
		}
		
	}

	@Override
	public void efetuarAlteracao() {
Local localx = new Local();
localx.setId(Integer.valueOf(jlbIDValor.getText()));
localx.setNome(jtxtCampo.getText());
DaoFactory.get().getLocalDAO().alterar(localx);
atualizaLista();
	
	}

	@Override
	public void removerSelecionado() {
		Local localx = new Local();
		localx.setId(Integer.valueOf(jlbIDValor.getText()));
		
		
		DaoFactory.get().getLocalDAO().excluir(localx);
		atualizaLista();
		
	}
	@Override
	public void atualizaLista(){
		painel.remove(this.listaLocais.getLista());
		this.listaLocais.setLista(DaoFactory.get().getLocalDAO().todos());
		painel.add(this.listaLocais.getLista());
		painel.updateUI();
	}



	



	
	
	
}
