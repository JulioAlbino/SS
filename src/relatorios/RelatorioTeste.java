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
	        config.setBIRTHome("/home/rafael/Downloads/birt-runtime-4_4_2/ReportEngine");
	        config.setLogConfig("/home/rafael", Level.FINEST);
	        Platform.startup(config);
	        final IReportEngineFactory FACTORY = (IReportEngineFactory) Platform
	            .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
	        engine = FACTORY.createReportEngine(config);       
	 
	        // Open the report design
	        IReportRunnable design = null;
	        design = engine.openReportDesign("/home/rafael/Downloads/birt-runtime-2_2_0/ReportEngine/samples/hello_world.rptdesign"); 
	        IRunAndRenderTask task = engine.createRunAndRenderTask(design);        
	 
	        PDFRenderOption PDF_OPTIONS = new PDFRenderOption();
	        PDF_OPTIONS.setOutputFileName("/home/rafael/rel.pdf");
	        PDF_OPTIONS.setOutputFormat("pdf");
	 
	        task.setRenderOption(PDF_OPTIONS);
	        task.run();
	        task.close();
	        engine.destroy();
	    } catch(final Exception EX) {
	        EX.printStackTrace();
	    } finally {
	       Platform.shutdown();
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
