package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;
import org.eclipse.birt.report.engine.api.EngineException;

import relatorios.RelatorioTeste;

public class ToolBar implements ActionListener{

	private TelaInicio telaInicio;
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
			botaoInicio = new JMenuItem("Inicio"),
			botaoSair = new JMenuItem("Sair"),
			botaoRel = new JMenuItem("Relatorio Todos Pedidos"),
			botaoDeslogar = new JMenuItem("Deslogar");
	private JMenuBar barra = new JMenuBar();
	private JMenu iconeOS = new JMenu("Ordens de Servico");
	private JMenu iconeInicio = new JMenu("Inicio");
	private JMenu iconeADM = new JMenu("ADM");
	private JMenu iconeSair = new JMenu("Sair");
	private JMenu iconeRelatorio = new JMenu("Relatorio");
	public ToolBar() {

		botaoInicio.addActionListener(this);
		iconeInicio.add(botaoInicio);
		
		botaoLOSA[0] = new JMenuItem("Abrir nova OS");
		botaoLOSA[1] = new JMenuItem("Listar OS Abertas");
		botaoLOSA[2] = new JMenuItem("Listar OS Em execução");
		botaoLOSA[3] = new JMenuItem("Listar OS Finalizadas");
		botaoLOSA[4] = new JMenuItem("OSs Aguardando Finalizar");

		botaoADM[0] = new JMenuItem("Adicionar Novo Setor");
		botaoADM[1] = new JMenuItem("Adicionar Novo Local");
		botaoADM[2] = new JMenuItem("Adicionar Novo Cargo");
		botaoADM[3] = new JMenuItem("Adicionar Usuário");
		botaoADM[4] = new JMenuItem("Alterar Permissão de Usuário");

		for (int i = 0; i < 5; i++){
			botaoLOSA[i].addActionListener(this);
			iconeOS.add(botaoLOSA[i]);
			botaoADM[i].addActionListener(this);
			iconeADM.add(botaoADM[i]);
		}
		
		botaoRel.addActionListener(this);
		iconeRelatorio.add(botaoRel);
		
		
		botaoSair.addActionListener(this);
		iconeSair.add(botaoSair);
		botaoDeslogar.addActionListener(this);
		iconeSair.add(botaoDeslogar);
		
		//adiciona os itens a barra
		
		verificaPermissoes();
		
		

	}
	public void verificaPermissoes(){
		barra.add(iconeInicio);
		switch(TelaInicial.get().getUsuario().getCargo().getPermissao()){
		case 1:
			barra.add(iconeOS);
			barra.add(iconeADM);
			barra.add(iconeRelatorio);
			break;
		case 2:
			break;
		case 3:
			barra.add(iconeOS);
			barra.add(iconeRelatorio);
			break;
		}
		barra.add(iconeSair);

	}
	
	
	public JMenuBar getBarra() {
		return barra;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botao = e.getSource();
		
		if (botao.equals(botaoInicio)){
			TelaInicial.get().mostraPainel(getTelaInicio().getPainel());
		}
		else if (botao.equals(botaoLOSA[0])){
			telaNovaOS = new NovaOS();
			TelaInicial.get().mostraPainel(telaNovaOS.getPainel());
		}
		else if (botao.equals(botaoLOSA[1])){
			abertas = new ListaOSAbertas();
			TelaInicial.get().mostraPainel(abertas.getPainel());
		}
		else if (botao.equals(botaoLOSA[2])){
			exec = new ListaOSExecucao();
			TelaInicial.get().mostraPainel(exec.getPainel());
		}
		else if (botao.equals(botaoLOSA[3])){
			
			TelaInicial.get().mostraPainel(getListaOSFinalizadas().getPainel());
		}
		else if (botao.equals(botaoLOSA[4])){
			aguardando = new OSAguardandoFinalizar();
			TelaInicial.get().mostraPainel(aguardando.getPainel());
		}
		else if (botao.equals(botaoADM[0])){
			novoSetor = new AdicionarNovoSetor();
			TelaInicial.get().mostraPainel(novoSetor.getPainel());
		}
		else if (botao.equals(botaoADM[1])){
			novoLocal = new AdicionarNovoLocal();
			TelaInicial.get().mostraPainel(novoLocal.getPainel());
		}
		else if (botao.equals(botaoADM[2])){
			novoCargo = new AdicionarNovoCargo();
			TelaInicial.get().mostraPainel(novoCargo.getPainel());
		}
		else if (botao.equals(botaoADM[3])){
			telaNovoUsuario = new NovoUsuario();
			TelaInicial.get().mostraPainel(telaNovoUsuario.getPainel());
		}
		else if (botao.equals(botaoADM[4])){
			telaAlterarUsuario = new AlterarUsuario();
			TelaInicial.get().mostraPainel(getAlterarUsuario().getPainel());
		}
		else if (botao.equals(botaoDeslogar)){
			TelaInicial.get().deslogar();
		}
		else if (botao.equals(botaoSair)){
			TelaInicial.get().dispose();
		}
		else if (botao.equals(botaoRel)){
		    JFileChooser fc = new JFileChooser();
		    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        fc.setAcceptAllFileFilterUsed(false);
	        
	        fc.setFileFilter(new FileFilter() {
	            @Override
	            public String getDescription() {
	                return "Extensão PDF";
	            }
	            @Override
	            public boolean accept(File f) {
	                return f.getName().toLowerCase().endsWith("pdf");
	            }
	        });
            int returnVal = fc.showSaveDialog(TelaInicial.get());
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
					RelatorioTeste.executeReport(file);
					} 
                catch (EngineException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } 
        }//Else if botaoRel
    }//final do ActionPerformed
			
	//Funcoes da TOOLBAR
	public ListaOSFinalizadas getListaOSFinalizadas(){
		this.finalizadas = new ListaOSFinalizadas();
		return this.finalizadas;
	}
	
	public TelaInicio getTelaInicio(){
		this.telaInicio = new TelaInicio();
		return this.telaInicio;
	}
	public AdicionarNovoSetor getAdicionarNovoSetor(){
		return this.novoSetor;
	}
	
	public AdicionarNovoLocal getAdicionarNovoLocal(){
		return this.novoLocal;
	}
	
	public AdicionarNovoCargo getAdicionarNovoCargo(){
		return this.novoCargo;
	}
	
	
	public AlterarUsuario getAlterarUsuario(){
		return this.telaAlterarUsuario;
	}	
}