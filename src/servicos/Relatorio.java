/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import model.conexao.ConnectionFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author root
 */
public class Relatorio {
   Connection conn;
   
   public void relatorio (Object dataInicio, Object dataFim, Object total){
       try{
           conn = ConnectionFactory.getConnection();
           String arquivo = System.getProperty("user.dir") + "/src/relatorio/Relatorio_.jrxml";
           JasperDesign design = JRXmlLoader.load(arquivo);
           
           JasperReport jr = JasperCompileManager.compileReport(design);
           
           HashMap valores = new HashMap();
           valores.put("dtinicio",dataInicio);
           valores.put("dtfim",dataFim);
           valores.put("total",total);
           
           JasperPrint impressao = JasperFillManager.fillReport(jr,valores,conn);
           
           JasperViewer jrViewer = new JasperViewer(impressao, false);
           
           jrViewer.setVisible(true);
           jrViewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
           
           
       }
       catch(JRException e){
           JOptionPane.showMessageDialog(null, "Erro no relatorio");
       }
   }
}
