package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ToolBar implements ActionListener{

	private TelaInicio telaInicio = new TelaInicio();
	private NovaOS telaNovaOS;
	private ListaOSAbertas abertas;
	private ListaOSExecucao exec;
	private ListaOSFinalizadas finalizadas;
	private OSAguardandoFinalizar aguardando;
	private AdicionarNovoSetor novoSetor;
	private AdicionarNovoCargo novoCargo;
	private AdicionarNovoLocal novoLocal;
	private AlterarUsuario telaAlterarUsuario;
	private NovoUsuario telaNovoUsuario;
	//itens da toolbar
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
		botaoInicio.setActionCommand("telaInicio");

		botaoInicio.addActionListener(this);
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
		
		if (botao.equals(botaoInicio)){
			 
			if (telaInicio == null){
			telaInicio.dispose();
			}
			telaInicio = new TelaInicio();
			TelaInicial.get().mostraPainel(telaInicio.getPainel());
		}
		else if (botao.equals(botaoLOSA[0])){
			if (telaNovaOS != null){
				telaNovaOS.dispose();
			}
			telaNovaOS = new NovaOS();
			TelaInicial.get().mostraPainel(telaNovaOS.getPainel());
		}
		else if (botao.equals(botaoLOSA[1])){
			if (abertas != null){
				abertas.dispose();
			}
			abertas = new ListaOSAbertas();
			TelaInicial.get().mostraPainel(abertas.getPainel());
		}
		else if (botao.equals(botaoLOSA[2])){
			if (exec != null){
				exec.dispose();
			}
			exec = new ListaOSExecucao();
			TelaInicial.get().mostraPainel(exec.getPainel());
		}
		else if (botao.equals(botaoLOSA[3])){
			if (finalizadas != null){
				finalizadas.dispose();
			}
			finalizadas = new ListaOSFinalizadas();
			TelaInicial.get().mostraPainel(finalizadas.getPainel());
		}
		else if (botao.equals(botaoLOSA[4])){
			if (aguardando != null){
				aguardando.dispose();
			}
			aguardando = new OSAguardandoFinalizar();
			TelaInicial.get().mostraPainel(aguardando.getPainel());
		}
		else if (botao.equals(botaoADM[0])){
			if (novoSetor != null){
				novoSetor.dispose();
			}
			novoSetor = new AdicionarNovoSetor();
			TelaInicial.get().mostraPainel(novoSetor.getPainel());
		}
		else if (botao.equals(botaoADM[1])){
			if (novoLocal != null){
				novoLocal.dispose();
			}
			novoLocal = new AdicionarNovoLocal();
			TelaInicial.get().mostraPainel(novoLocal.getPainel());
		}
		else if (botao.equals(botaoADM[2])){
			if (novoCargo != null){
				novoCargo.dispose();
			}
			novoCargo = new AdicionarNovoCargo();
			TelaInicial.get().mostraPainel(novoCargo.getPainel());
		}
		else if (botao.equals(botaoADM[3])){
			if (telaNovoUsuario != null){
				telaNovoUsuario.dispose();
			}
			telaNovoUsuario = new NovoUsuario();
			TelaInicial.get().mostraPainel(telaNovoUsuario.getPainel());
		}
		else if (botao.equals(botaoADM[4])){
			if (telaAlterarUsuario != null){
				telaAlterarUsuario.dispose();
			}
			telaAlterarUsuario = new AlterarUsuario();
			TelaInicial.get().mostraPainel(telaAlterarUsuario.getPainel());
		}
		else if (botao.equals(botaoSair)){
			TelaInicial.get().dispose();
		}
	}
	
	public TelaInicio getTelaInicio(){
		return telaInicio;
	}
	
	public AlterarUsuario getAlterarUsuario(){
		if (telaAlterarUsuario == null){
			telaAlterarUsuario = new AlterarUsuario();
		}
		return telaAlterarUsuario;
	}
	
}
