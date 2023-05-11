import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


public class ReportsFromJasper {

    private Connection oracle;
    private JasperReport jasperReport;

    public ReportsFromJasper(Connection oracle) {
        this.oracle = oracle;
    }

    public void generateRepOne() throws JRException {
        Map<String, Object> parameters = new HashMap<>();
        jasperReport = JasperCompileManager.compileReport("Cherry_1.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , oracle);
        JasperViewer.viewReport(jasperPrint);
    }

    public void generateRepTwo(String condition, String condition2) throws JRException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("MAX_WAGA", condition);
        parameters.put("MAX_PREDKOSC",  condition2);
        jasperReport = JasperCompileManager.compileReport("Coffee.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , oracle);
        JasperViewer.viewReport(jasperPrint);
    }

    public void generateRepThree() throws JRException {
        Map<String, Object> parameters = new HashMap<>();
        jasperReport = JasperCompileManager.compileReport("Flower.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , oracle);
        JasperViewer.viewReport(jasperPrint);
    }

    public void generateRepFour(String condition) throws JRException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("NR_FAKTURY", condition);
        jasperReport = JasperCompileManager.compileReport("Coffee_Landscape.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , oracle);
        JasperViewer.viewReport(jasperPrint);
    }

}
