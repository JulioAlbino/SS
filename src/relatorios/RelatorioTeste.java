package relatorios;


import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import java.util.logging.Level;
public class RelatorioTeste {
	public static void executeReport() throws EngineException {
		 
	    IReportEngine engine = null;
	    EngineConfig config = null;
	 
	    try {
	        config = new EngineConfig();          
	        config.setBIRTHome("src/relatorios/engine");
	        config.setLogConfig("/home/rafael", Level.FINEST);
	        Platform.startup(config);
	        final IReportEngineFactory FACTORY = (IReportEngineFactory) Platform
	            .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
	        engine = FACTORY.createReportEngine(config);       
	 
	        // Open the report design
	        IReportRunnable design = null;
	        
	        String ReportDesign = "src/relatorios/teste.rptdesign"; 
	        
	        design = engine.openReportDesign(ReportDesign); 
	        IRunAndRenderTask task = engine.createRunAndRenderTask(design);        
	 
	        PDFRenderOption PDF_OPTIONS = new PDFRenderOption();
	        
	        String OutputFile = "/home/rafael/rel.pdf";
	        
	        PDF_OPTIONS.setOutputFileName(OutputFile);
	        PDF_OPTIONS.setOutputFormat("pdf");
	 
	        task.setRenderOption(PDF_OPTIONS);
	        task.run();
	        task.close();
	        engine.destroy();
	    } catch(final Exception EX) {
	        EX.printStackTrace();
	    } finally {
	       Platform.shutdown();
	       System.out.println("Relatorio terminado");
	    }
	}
 
	public static void main(String[] args) {
  // TODO Auto-generated method stub
    try
    {
     executeReport();
    }
    catch(Exception e)
    {
     e.printStackTrace();
    }
 }
}
