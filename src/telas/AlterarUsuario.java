package telas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import recursosParaTelas.ListaUsuarios;
import telasGenericas.TelaGenerica;
import dao.factory.DaoFactory;
import model.Cargo;
import model.Usuario;

public class AlterarUsuario extends TelaGenerica implements KeyListener{

	private static final long serialVersionUID = 13L;

	private Usuario usuarioSelecionado;
	
	private JTextField jtxUsuario = new JTextField();
	private JLabel jlbUsuario = new JLabel("Usuário:");
	private JTextField jtxBusca = new JTextField();
	private JLabel jlbBusca = new JLabel("Buscar Usuário:");
	
	private JLabel jlbNome = new JLabel("Nome:");
	private JTextField jtxNome = new JTextField();
	
	private JLabel jlbSenha = new JLabel("Senha:");
	private JTextField jtxSenha = new JTextField();
	
	private JLabel jlbCodigo = new JLabel("Codigo do Usuário:");
	private JLabel jlbCodigo2 = new JLabel(" ");

	private JLabel jlbCombobox = new JLabel("Cargo");
	private ListaUsuarios listaUser;
	
	private JComboBox<Cargo> combobox = new JComboBox<Cargo>();
	
	private JButton jbtAlterar = new JButton("Efetuar Alterarações");
	private JButton jbtRemover = new JButton("Remover Selecionado");
	private List<Cargo> cargos = DaoFactory.get().getCargoDAO().todos();
	
	private int posJTX = 160;
	
	//---------
		
	public AlterarUsuario() {

		int posJLB = 15;
	painel.setBorder(BorderFactory.createTitledBorder("Painel Alterar Usuário"));	
	
	jlbBusca.setBounds(posJLB,25,200,25);
	painel.add(jlbBusca);
	
jtxBusca.setBounds(posJTX,25,200,25);
jtxBusca.addKeyListener(this);

	painel.add(jtxBusca);
	
	jlbCodigo.setBounds(posJLB,100,160,25);
	painel.add(jlbCodigo);
	jlbCodigo2.setBounds(posJTX,100,200,25);
	painel.add(jlbCodigo2);
	
	jlbUsuario.setBounds(posJLB,140,160,25);
	painel.add(jlbUsuario);
	
	jtxUsuario.setBounds(posJTX,140,200,25);
	jtxUsuario.setEnabled(false);
	painel.add(jtxUsuario);
	
	jlbNome.setBounds(posJLB,170,160,25);
	painel.add(jlbNome);
	jtxNome.setBounds(posJTX, 170,200, 25);
	jtxNome.setEnabled(false);
	painel.add(jtxNome);
	
	jlbSenha.setBounds(posJLB,200,160,25);
	painel.add(jlbSenha);
	jtxSenha.setBounds(posJTX, 200,200, 25);
	jtxSenha.setEnabled(false);
	painel.add(jtxSenha);
		

	
	

	
	jlbCombobox.setBounds(posJLB, 230, 200,25);
	painel.add(jlbCombobox);
	
	listaUser = new ListaUsuarios(DaoFactory.get().getUsuarioDAO().todos(), 500, 90, 600, 200);
	painel.add(listaUser.getLista());
	
	jbtAlterar.setBounds(100, 270, 200, 25);
	jbtAlterar.addActionListener(this);
	painel.add(jbtAlterar);
	
	jbtRemover.setBounds(100,310,200,25);
	jbtRemover.addActionListener(this);
	painel.add(jbtRemover);
	
}
	
	public void efetuaBusca(){
		List<Usuario> listaUsuarios = DaoFactory.get().getUsuarioDAO().buscarUsuario(jtxBusca.getText());
		painel.remove(listaUser.getLista());
		listaUser.setLista(listaUsuarios);
		painel.add(listaUser.getLista());
		painel.updateUI();
	}
	
	public void setaUsuarioSelecionado(Usuario user){
		this.usuarioSelecionado = user;
		jlbCodigo2.setText(user.getIdusuario().toString());
		
		jtxUsuario.setEnabled(true);
		jtxUsuario.setText(user.getLogin());
		
		jtxNome.setEnabled(true);
		jtxNome.setText(user.getNome());
		
		jtxSenha.setEnabled(true);
		jtxSenha.setText(user.getSenha());
		
		painel.remove(combobox);
		combobox = new JComboBox<Cargo>();
		combobox.setBounds(posJTX, 230, 200, 25);
		
		cargos.clear();
		DaoFactory.get().getCargoDAO().todos().forEach((Cargo cargod) -> {
				combobox.addItem(cargod);
		});
		combobox.addItem(user.getCargo());
		combobox.setSelectedItem(user.getCargo());
		painel.remove(combobox);
		painel.add(combobox);
		painel.updateUI();
		
	}
	
	
	public Boolean salvaAlteracaoNoBanco(){
		usuarioSelecionado.setNome(jtxNome.getText());
		usuarioSelecionado.setSenha(jtxSenha.getText());
		usuarioSelecionado.setLogin(jtxUsuario.getText());
		usuarioSelecionado.setCargo((Cargo)combobox.getSelectedItem());
		return (DaoFactory.get().getUsuarioDAO().alterar(usuarioSelecionado));
	}
	
	
	@Override
	public void keyPressed(KeyEvent e){}
	@Override
	public void keyReleased(KeyEvent e){efetuaBusca();}
	@Override
	public void keyTyped(KeyEvent e){}		  
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbtAlterar)){
			if (salvaAlteracaoNoBanco()){
				JOptionPane.showMessageDialog(this, "Usuario Alterado com Sucesso");
				efetuaBusca();
			}
			else {
				JOptionPane.showMessageDialog(this, "Problemas na hora de alterar o Usuario");
			}
			
		}
		else if (e.getSource().equals(jbtRemover)){
			if (DaoFactory.get().getUsuarioDAO().desativar(usuarioSelecionado)){
				JOptionPane.showMessageDialog(this, "Usuario Alterado com Sucesso");
				efetuaBusca();
			}
			else {
				JOptionPane.showMessageDialog(this, "Problemas na hora de remover o Usuario");
			}
		}
	}
	
	
	
}