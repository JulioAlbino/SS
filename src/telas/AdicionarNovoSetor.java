package telas;

import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import recursosParaTelas.ListaSetores;
import telasGenericas.TelaGenericaAdicionar;
import dao.factory.DaoFactory;
import model.Setor;


public class AdicionarNovoSetor extends TelaGenericaAdicionar{

	private static final long serialVersionUID = 1231312L;
	private JTextField LocalSetor;
	private JLabel textsetor;
	private JButton add = new JButton("Adicionar");
	private ListaSetores listaSetor;
	
	public AdicionarNovoSetor() {

		painel.setBorder(BorderFactory.createTitledBorder("Adicionar Novo Setor"));	
		
		textsetor = new JLabel("Setor:");
		textsetor.setBounds(15, 50, 150, 20);
		painel.add(textsetor);
		
		LocalSetor= new JTextField();
		LocalSetor.setBounds(55, 50, 150, 28);
		painel.add(LocalSetor);
		
		add.addActionListener(this);
		add.setBounds(15,110,200,25);
		painel.add(add);
		
		listaSetor = new ListaSetores(DaoFactory.get().getSetorDAO().todos(), 500, 90, 600, 200);
		painel.add(listaSetor.getLista());
		
		visualizarLista(false);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();
		
		if (botao.equals(add)){
			Setor novoSetor = new Setor();
			novoSetor.setNome(LocalSetor.getText());
			if (DaoFactory.get().getSetorDAO().inserir(novoSetor)){
				LocalSetor.setText(" ");
				atualizaLista();
			}
		}
		else if (botao.equals(alterar)){
			efetuarAlteracao();
	
		}
		else if (botao.equals(remover)){
			removerSelecionado();
			}
	}
	

	//metodos
	public void setarValor(Setor setor){
		visualizarLista(true);
		jlbIDValor.setText(setor.getIdsetor().toString());
		jtxtCampo.setText(setor.getNome());
	}
	
	
	public void atualizaLista(){
		painel.remove(this.listaSetor.getLista());
		this.listaSetor.setLista(DaoFactory.get().getSetorDAO().todos());
		painel.add(this.listaSetor.getLista());
		painel.updateUI();
	}
	@Override
	public void efetuarAlteracao() {
		Setor setor = new Setor();
		setor.setIdsetor(Integer.valueOf(jlbIDValor.getText()));
		setor.setNome(jtxtCampo.getText());
		DaoFactory.get().getSetorDAO().alterar(setor);
		atualizaLista();
	}
	@Override
	public void removerSelecionado() {
		Setor setor = new Setor(Integer.valueOf(jlbIDValor.getText()));
		DaoFactory.get().getSetorDAO().desativar(setor);
		atualizaLista();
		visualizarLista(false);
		
	}
}