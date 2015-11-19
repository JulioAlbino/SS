package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import dao.factory.DaoFactory;
import model.Local;
import model.Pedido;
import model.Setor;
import telasGenericas.TelaGenerica;

public class ViewOS extends TelaGenerica {
	
	private static final long serialVersionUID = 1983L;
	
	private Pedido pedidoAberto;
	private JLabel jlbDescricao = new JLabel("Defeito relatado:");
	
	private JLabel jlbSetor = new JLabel("Setor: ");
	private List<Setor> setores = DaoFactory.get().getSetorDAO().todos();
	private JComboBox<Setor> comboboxSetor = new JComboBox<Setor>();
	
	private JLabel jlbLocal = new JLabel("Local:");
	private JComboBox<Local> comboboxLocal = new JComboBox<Local>();
	private List<Local> locais = DaoFactory.get().getLocalDAO().todos();
	
	private JTextArea jtxaDescricao = new JTextArea();
	private JLabel jlbDataValor;
	private JLabel jlbData = new JLabel("Data:");
	
	private JLabel jlbUsuarioAbriu = new JLabel("Usuario que Abriu o Pedido:");
	private JLabel jlbUsuarioAbriuValor = new JLabel();
	
	//---------
	
	private JButton jbtIniciar = new JButton("Iniciar Resolução");
	private JButton jbtDeletar = new JButton("Deletar OS");
	private JButton jbtFinalizar = new JButton("Setar como Finalizado");
	private JButton jbtAlterar = new JButton("Alterar OS");
	
	
	private JLabel jlbEfetuar = new JLabel("Serviço Efetuado");
	private JTextArea jtxaEfetuar = new JTextArea();
	private JButton jbtEfetuar = new JButton("Salvar Informações de Serviço atualmente Realizado");
	private JButton jbtEnviarAutorizador = new JButton("Finalizar serviço");
	
	private JLabel jlbDataModificacao = new JLabel("Data da Ultima Modificação:");
	private JLabel jlbDataModificacaoValor = new JLabel();
	private JLabel jlbUsuarioResponsavel = new JLabel("Usuario Responsavel:");
	
	private JLabel jlbUsuarioResponsavelValor = new JLabel();
	
	private JLabel jlbSituacao = new JLabel("Situação da OS: ");
	private JLabel jlbSituacaoValor = new JLabel();
	
	public ViewOS(Pedido pedido){
		this.pedidoAberto = pedido;
		painel.setBorder(BorderFactory.createTitledBorder("Ordem de Serviço codigo: " + pedido.getIdpedido()));
		
		//Setor
		jlbSetor.setBounds(15, 50, 110, 25);
		painel.add(jlbSetor);
		
		jlbUsuarioAbriu.setBounds(15, 80, 220, 25);
		painel.add(jlbUsuarioAbriu);
		
		jlbUsuarioAbriuValor.setBounds(230,80,300,25);
		jlbUsuarioAbriuValor.setText(pedido.getUsuario().getNome());
		painel.add(jlbUsuarioAbriuValor);
		
		setores.forEach((Setor setor) -> {
			if (setor.getIdsetor() == pedido.getSetor().getIdsetor()){
				comboboxSetor.addItem(setor);
				comboboxSetor.setSelectedItem(setor);
			}else {
				comboboxSetor.addItem(setor);
			}
		});
		comboboxSetor.setBounds(70, 50, 150, 25);
		comboboxSetor.setEnabled(false);
		painel.add(comboboxSetor);
		
		//Descricao
		jlbDescricao.setBounds(15, 115, 200, 25);
		painel.add(jlbDescricao);
		
		jtxaDescricao.setBounds(15, 140, 1000, 170);
		jtxaDescricao.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jtxaDescricao.setText(pedido.getDescricao());
		jtxaDescricao.setEditable(false);
		painel.add(jtxaDescricao);

		//Local
		jlbLocal.setBounds(330, 50, 200, 25);
		painel.add(jlbLocal);
		locais.forEach((Local l) -> {
			if (l.getId() == pedido.getLocal().getId()){
				comboboxLocal.addItem(l);
				comboboxLocal.setSelectedItem(l);
			}
			else {
				comboboxLocal.addItem(l);	
			}
		});
		comboboxLocal.setBounds(380,50,200,25);
		comboboxLocal.setEnabled(false);
		painel.add(comboboxLocal);

		//Data
		jlbData.setBounds(20,10,200,25);
		painel.add(jlbData);
		
		jlbDataValor = new JLabel(LocalDate.now().toString());
		jlbDataValor.setBounds(80, 10, 200, 25);
		jlbDataValor.setText(pedido.getDatahora().toString());
		painel.add(jlbDataValor);
		
		//--------------------------------------------------------
		
		//situacao
		jlbSituacao.setBounds(450, 100, 200, 25);
		painel.add(jlbSituacao);
		
		jlbSituacaoValor.setBounds(580, 100, 500, 25);
		jlbSituacaoValor.setText(pedido.getDsSituacao());
	    Font FONTE_NORMAL = new Font( "Verdana", Font.BOLD, 18 );  
		jlbSituacaoValor.setFont(FONTE_NORMAL);
		painel.add(jlbSituacaoValor);
		
		//botoes
		
		if (pedido.getSituacao() == 1){
			jbtIniciar.setBounds(15, 335, 200, 25);
			jbtIniciar.addActionListener(this);
			painel.add(jbtIniciar);	
		}
		
		if (TelaInicial.get().getUsuario().getCargo().getPermissao() != 2 && pedido.getSituacao()  < 4){
			jbtFinalizar.setBounds(445, 335, 200, 25);
			jbtFinalizar.addActionListener(this);
			painel.add(jbtFinalizar);
			jbtAlterar.setBounds(660, 335, 200, 25);
			jbtAlterar.addActionListener(this);
			jbtAlterar.setActionCommand("Alterar");
			painel.add(jbtAlterar);
		}
		if (TelaInicial.get().getUsuario().getCargo().getPermissao() != 2){
			adicionarBotaoDeletar();
		}
		
		
	
		
		
		
		jlbEfetuar.setBounds(15, 400, 200, 25);
		painel.add(jlbEfetuar);
		
		//dados
		//dataMod
		jlbDataModificacao.setBounds(15, 425, 300, 25);
		painel.add(jlbDataModificacao);
		jlbDataModificacaoValor.setBounds(230, 425, 200,25);
		jlbDataModificacaoValor.setText(pedido.getDataModificacao().toString());
		painel.add(jlbDataModificacaoValor);
		
		//usuarioResponsavel
		jlbUsuarioResponsavel.setBounds(430, 425, 200,25);
		painel.add(jlbUsuarioResponsavel);
		jlbUsuarioResponsavelValor.setBounds(600, 425, 200, 25);
		jlbUsuarioResponsavelValor.setText(pedidoAberto.getResponsavel().getNome());
		painel.add(jlbUsuarioResponsavelValor);
		
		
		jtxaEfetuar.setBounds(15, 450, 1000, 170);
		jtxaEfetuar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jtxaEfetuar.setText(pedido.getResolucao());
if (pedido.getSituacao() > 2){
		jtxaEfetuar.setEditable(false);	
		}
		painel.add(jtxaEfetuar);
		
		if (pedido.getSituacao() == 2){
			
			if (pedido.getResponsavel().getIdusuario() == TelaInicial.get().getUsuario().getIdusuario()){
				jbtEfetuar.setBounds(15,650, 450, 25);
				jbtEfetuar.addActionListener(this);
				painel.add(jbtEfetuar);	
				jbtEnviarAutorizador.setBounds(500, 650, 300, 25);
				jbtEnviarAutorizador.addActionListener(this);
				painel.add(jbtEnviarAutorizador);
			}
			
		}
		
		
	}
	
	public void adicionarBotaoDeletar(){
		jbtDeletar.setBounds(230, 335, 200, 25);
		jbtDeletar.addActionListener(this);
		painel.add(jbtDeletar);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();
		
		
		if (botao.equals(jbtEfetuar)){
			pedidoAberto.setDataModificacao(LocalDate.now());
			pedidoAberto.setResolucao(jtxaEfetuar.getText());
			pedidoAberto.setResponsavel(TelaInicial.get().getUsuario());
			if(DaoFactory.get().getPedidoDAO().efetuarTrabalho(pedidoAberto)){
				JOptionPane.showMessageDialog(this, "Alterações Salvas com Sucesso");
			}
			else {
				JOptionPane.showMessageDialog(this, "Ocorreu algum problema com o salvamento no Banco de Dados");
			}
		}
		
		else if (botao.equals(jbtIniciar)){
			pedidoAberto.setSituacao(2);
			pedidoAberto.setResponsavel(TelaInicial.get().getUsuario());
			if (DaoFactory.get().getPedidoDAO().efetuarTrabalho(pedidoAberto)){
				JOptionPane.showMessageDialog(this, "Você assumiu essa OS, status modificado para Em Andamento");
			}
			
			ViewOS view = new ViewOS(pedidoAberto);
			TelaInicial.get().mostraPainel(view.getPainel());
		}
		
		else if (botao.equals(jbtDeletar)){
			if(DaoFactory.get().getPedidoDAO().excluir(pedidoAberto)){
				JOptionPane.showMessageDialog(this, "OS removida com Sucesso");
				TelaInicial.get().mostraPainel(TelaInicial.get().getToolbar().getTelaInicio().getPainel());
			}
		}
		
		else if (botao.equals(jbtFinalizar)){
			pedidoAberto.setSituacao(4);
			if (DaoFactory.get().getPedidoDAO().alterar(pedidoAberto)){
				JOptionPane.showMessageDialog(this, "OS Finalizada com Sucesso");
				TelaInicial.get().mostraPainel(TelaInicial.get().getToolbar().getListaOSFinalizadas().getPainel());
			}
		}
		
		else if (e.getActionCommand().equals("Alterar")){
				if(!comboboxSetor.isEnabled()){
				comboboxSetor.setEnabled(true);
				comboboxLocal.setEnabled(true);
				jtxaDescricao.setEditable(true);
				jbtAlterar.setText("Efetuar Alteração");
				JOptionPane.showMessageDialog(this, "Alteracoes liberadas");
				}
				else {
					jbtAlterar.setText("Alterar");
					comboboxSetor.setEnabled(false);
					comboboxLocal.setEnabled(false);
					jtxaDescricao.setEditable(false);
					
					pedidoAberto.setSetor((Setor) comboboxSetor.getSelectedItem());
					pedidoAberto.setLocal((Local) comboboxLocal.getSelectedItem());
					pedidoAberto.setDescricao(jtxaDescricao.getText());
					if (DaoFactory.get().getPedidoDAO().alterar(pedidoAberto)){
						JOptionPane.showMessageDialog(this, "Alteracoes Salvas com Sucesso");
					}else {
						JOptionPane.showMessageDialog(this, "Erro, revise seu banco de dados");
					}
					
				}
			
			
		}
		//
		else if (botao.equals(jbtEnviarAutorizador)){
			if (DaoFactory.get().getPedidoDAO().finalizarParaAutorizar(pedidoAberto)){
				pedidoAberto.setSituacao(3);
				jlbSituacaoValor.setText("Aguardando Finalização");
				JOptionPane.showMessageDialog(this, "Finalizada com Sucesso, aguardando autorizador para fechar");	
			}
			else {
				JOptionPane.showMessageDialog(this, "Problemas na hora de Finalizar");
			}
			
			
		}
		
	}
}