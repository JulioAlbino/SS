package telas;

import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import recursosParaTelas.ListaSetores;
import telasGenericas.TelaGenerica;
import dao.factory.DaoFactory;
import model.Setor;


public class AdicionarNovoSetor extends TelaGenerica{

	private static final long serialVersionUID = 1L;
	private JTextField LocalSetor;
	private JLabel textsetor;
	private JButton add = new JButton("Adicionar");
	private ListaSetores listaSetor;
	
	// ----
	
	private JLabel jlbSetorId = new JLabel("Setor ID: "),
					jlbSetorIdValor = new JLabel();
	private JLabel jlbSetorNome = new JLabel("Setor Nome: ");
	private JTextField jtxtSetorNome = new JTextField();
	private JButton alterar = new JButton("Efetuar Alteração no Setor Selecionado");
	private JButton remover = new JButton("Remover Setor Selecionado");
	
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
		
		jlbSetorId.setBounds(500,300,200,25);
		jlbSetorId.setVisible(false);
		painel.add(jlbSetorId);
		
		jlbSetorIdValor.setBounds(600,300,200,25);
		painel.add(jlbSetorIdValor);
		
		jlbSetorNome.setBounds(500, 330, 200, 25);
		jlbSetorNome.setVisible(false);
		painel.add(jlbSetorNome);
		jtxtSetorNome.setBounds(600,330,400,25);
		jtxtSetorNome.setVisible(false);
		painel.add(jtxtSetorNome);
		
		alterar.setBounds(500, 360, 350, 25);
		alterar.setVisible(false);
		alterar.addActionListener(this);
		painel.add(alterar);
		
		remover.setBounds(860, 360, 250, 25);
		remover.setVisible(false);
		remover.addActionListener(this);
		painel.add(remover);		
		
		
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
				Setor opa = new Setor(jtxtSetorNome.getText(), Integer.valueOf(jlbSetorIdValor.getText()));
				DaoFactory.get().getSetorDAO().alterar(opa);
				atualizaLista();
		}
		else if (botao.equals(remover)){
			Setor opa = new Setor(jtxtSetorNome.getText(), Integer.valueOf(jlbSetorIdValor.getText()));
			DaoFactory.get().getSetorDAO().excluir(opa);
			atualizaLista();
			}
	}
	
	public void mostraValor(){
		remover.setVisible(true);
		alterar.setVisible(true);
		jtxtSetorNome.setVisible(true);
		jlbSetorNome.setVisible(true);
		jlbSetorId.setVisible(true);
		
	}
	
	//metodos
	public void setSetor(Setor setor){
		jlbSetorIdValor.setText(setor.getIdsetor().toString());
		jtxtSetorNome.setText(setor.getNome());
	}
	public void atualizaLista(){
		painel.remove(this.listaSetor.getLista());
		this.listaSetor.setLista(DaoFactory.get().getSetorDAO().todos());
		painel.add(this.listaSetor.getLista());
		painel.updateUI();
	}
}