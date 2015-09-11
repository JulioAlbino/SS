package telas;


import java.text.SimpleDateFormat;

import java.util.Date;


import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EncarregadoSS extends JFrame{
	private String datasis;
	private String horasis;
	//kaskaksa
	private JLabel NumeSS;
	private JLabel descri;
	private JLabel preventiva;
	private JLabel coretiva;
	private JLabel Afetaprod;
	private JLabel horafinal;
	private JLabel horainicial;
	private JLabel data;
	private JLabel areaexecutante;
	private JLabel setor;
	private JPanel painelEncarregadoSS = new JPanel();
	private JCheckBox boxpreventiva;
	private JCheckBox boxcoretiva;	
	private JCheckBox boxAfetaprod;	
	private JTextArea textdescri;
	private JTextField textsetor;
	private JTextField textareaexecutante;
	private JLabel defitdata;
	private JLabel defihoraini;
	
	public EncarregadoSS() {
	painelEncarregadoSS.setLayout(null);
	painelEncarregadoSS.setBounds(10, 10, 990, 660);
	painelEncarregadoSS.setBorder(BorderFactory.createTitledBorder("Painel Encarregado"));	
	
	setor= new JLabel("Setor:");
	setor.setBounds(15, 50, 100, 50);
	painelEncarregadoSS.add(setor);
	
	textsetor = new JTextField();
	textsetor.setBounds(55, 67, 150, 20);
	painelEncarregadoSS.add(textsetor);
	
	descri= new JLabel("Defeito apresentado:");
	descri.setBounds(15, 100, 200, 50);
	painelEncarregadoSS.add(descri);
	
	textdescri = new JTextArea();
	textdescri.setBounds(15, 140, 650, 170);
	painelEncarregadoSS.add(textdescri);
	
	coretiva= new JLabel("Coretiva:");
	coretiva.setBounds(15, 300, 200, 50);
	painelEncarregadoSS.add(coretiva);
	
	boxcoretiva= new JCheckBox();
	boxcoretiva.setBounds(70, 300, 30, 50);
	painelEncarregadoSS.add(boxcoretiva);
	
	
	preventiva= new JLabel("Preventiva:");
	preventiva.setBounds(150, 300, 200, 50);
	painelEncarregadoSS.add(preventiva);
	
	boxpreventiva= new JCheckBox();
	boxpreventiva.setBounds(220, 300, 30, 50);
	painelEncarregadoSS.add(boxpreventiva);
	
	Afetaprod= new JLabel("Afetou a produção:");
	Afetaprod.setBounds(300, 300, 200, 50);
	painelEncarregadoSS.add(Afetaprod);
	
	boxAfetaprod= new JCheckBox();
	boxAfetaprod.setBounds(410, 300, 30, 50);
	painelEncarregadoSS.add(boxAfetaprod);
	
	areaexecutante= new JLabel("Area executante:");
	areaexecutante.setBounds(250, 50, 100, 50);
	painelEncarregadoSS.add(areaexecutante);
	
	textareaexecutante = new JTextField();
	textareaexecutante.setBounds(355, 67, 150, 20);
	painelEncarregadoSS.add(textareaexecutante);
	
	NumeSS= new JLabel("Numero SS:");
	NumeSS.setBounds(15, 10, 100, 50);
	painelEncarregadoSS.add(NumeSS);
	
	horafinal= new JLabel("Hora Final:");
	horafinal.setBounds(450, 10, 100, 50);
	painelEncarregadoSS.add(horafinal);
	
	horainicial= new JLabel("Hora Inicial:");
	horainicial.setBounds(280, 10, 100, 50);
	painelEncarregadoSS.add(horainicial);
	
	Date horaHoje = new Date();
	SimpleDateFormat formatahora = new SimpleDateFormat("HH:mm");
	String horasis = formatahora.format(horaHoje);	 
	
	defihoraini= new JLabel(horasis);
	defihoraini.setBounds(350, 10, 100, 50);
	painelEncarregadoSS.add(defihoraini);
	
	data= new JLabel("Data:");
	data.setBounds(150, 10, 100, 50);
	painelEncarregadoSS.add(data);
	
//coloca data de abertura ss
Date dataHoje = new Date();
SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
String datasis = formataData.format(dataHoje);

defitdata= new JLabel(datasis);
	defitdata.setBounds(183, 10, 100, 50);
	painelEncarregadoSS.add(defitdata);

}

	public JPanel getPainelEncarregadoSS() {
		return painelEncarregadoSS;
	}

		
	}







