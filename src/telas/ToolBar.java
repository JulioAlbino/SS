package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ToolBar implements ActionListener{
	//instancia as TELAS pra mostralas depois
	private TelaInicio telaInicio = new TelaInicio();
	private NovaOS telaNovaOS = new NovaOS();
	private ListaOSAbertas abertas = new ListaOSAbertas();
	private ListaOSExecucao exec = new ListaOSExecucao();
	private ListaOSFinalizadas finalizadas = new ListaOSFinalizadas();
	private OSAguardandoFinalizar aguardando = new OSAguardandoFinalizar();
	private AdicionarNovoSetor novoSetor = new AdicionarNovoSetor();
	
	private AlterarUsuario telaAlterarUsuario = new AlterarUsuario();
	private NovoUsuario telaNovoUsuario = new NovoUsuario();

	private JMenuItem botaoLOSA[] = new JMenuItem[5],
			botaoADM[] = new JMenuItem[5], 
			botaoInicio, botaoSair;
	private JMenuBar barra = new JMenuBar();
	private JMenu iconeOS = new JMenu("Ordens de Servico");
	private JMenu iconeInicio = new JMenu("Inicio");
	private JMenu iconeADM = new JMenu("ADM");
	private JMenu iconeSair = new JMenu("Sair");
	public ToolBar() {
		
		botaoInicio = new JMenuItem("Inicio");
		iconeInicio.add(botaoInicio);
		
		botaoLOSA[0] = new JMenuItem("Abrir nova OS");
		botaoLOSA[0].addActionListener(this);
		iconeOS.add(botaoLOSA[0]);
		
		botaoLOSA[1] = new JMenuItem("Listar OS Abertas");
		botaoLOSA[1].addActionListener(this);
		iconeOS.add(botaoLOSA[1]);
		
		botaoLOSA[2] = new JMenuItem("Listar OS Em execução");
		botaoLOSA[2].addActionListener(this);
		iconeOS.add(botaoLOSA[2]);
		
		botaoLOSA[3] = new JMenuItem("Listar OS Finalizadas");
		botaoLOSA[3].addActionListener(this);
		iconeOS.add(botaoLOSA[3]);
		
		botaoLOSA[4] = new JMenuItem("OSs Aguardando Finalizar");
		botaoLOSA[4].addActionListener(this);
		iconeOS.add(botaoLOSA[4]);
		
		botaoADM[0] = new JMenuItem("Adicionar Novo Setor");
		botaoADM[0].addActionListener(this);
		iconeADM.add(botaoADM[0]);
		
		botaoADM[1] = new JMenuItem("Adicionar Novo Local");
		botaoADM[1].addActionListener(this);
		iconeADM.add(botaoADM[1]);
		
		botaoADM[2] = new JMenuItem("Adicionar Novo Cargo");
		botaoADM[2].addActionListener(this);
		iconeADM.add(botaoADM[2]);
		
		botaoADM[3] = new JMenuItem("Adicionar Usuário");
		botaoADM[3].addActionListener(this);
		iconeADM.add(botaoADM[3]);
		
		botaoADM[4] = new JMenuItem("Alterar Permissão de Usuário");
		botaoADM[4].addActionListener(this);
		iconeADM.add(botaoADM[4]);
		
		botaoSair = new JMenuItem("Sair");
		botaoSair.addActionListener(this);;
		iconeSair.add(botaoSair);
		
		
		//adiciona os itens a barra
		barra.add(iconeInicio);
		barra.add(iconeOS);
		barra.add(iconeADM);
		barra.add(iconeSair);
	}
	public JMenuBar getBarra() {
		return barra;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();
		
		if (botao == botaoInicio){
			TelaInicial.get().mostraPainel(telaInicio.getPainel());
		}else if (botao == botaoLOSA[0]){
			TelaInicial.get().mostraPainel(telaNovaOS.getPainel());
		}
		else if (botao == botaoLOSA[1]){
			TelaInicial.get().mostraPainel(abertas.getPainel());
		}
		else if (botao == botaoLOSA[2]){
			TelaInicial.get().mostraPainel(exec.getPainel());
		}
		else if (botao == botaoLOSA[3]){
			TelaInicial.get().mostraPainel(finalizadas.getPainel());
		}
		else if (botao == botaoLOSA[4]){
			TelaInicial.get().mostraPainel(aguardando.getPainel());
		}
		else if (botao == botaoADM[0]){
			TelaInicial.get().mostraPainel(novoSetor.getPainel());
		}
		
		if (botao == botaoADM[3]){
			
			TelaInicial.get().mostraPainel(telaNovoUsuario.getPainel());
		}else if (botao == botaoADM[4]){
			TelaInicial.get().mostraPainel(telaAlterarUsuario.getPainel());
		}

		
		
	}
	
}
