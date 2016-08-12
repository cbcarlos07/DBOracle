package servicos;

//package servicos;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class FuncoesTela{

     LookAndFeel lf = UIManager.getLookAndFeel();
     protected static JRootPane rootPane;
     
     // org.fife.plaf.Office2003.Office2003LookAndFeel
     
     public  void install(){
    //    try {
            //outras opcoes
            /*
             * javax.swing.plaf.metal.MetalLookAndFeel
            */
            
        //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel ");
    
        //} catch (InstantiationException ex1) {
    
        //} catch (ClassNotFoundException ex2) {
    
        //} catch (UnsupportedLookAndFeelException ex3) {
    
        //} catch (IllegalAccessException ex4) {
    
        //}
        
         
          try {  
              
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
        //  TelaPrincipal telaPrincipal = new TelaPrincipal();
         // SwingUtilities.updateComponentTreeUI(telaPrincipal);  
          }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {  
          } 
     }

    /**
     *
     * @param ji
     */
    public void setAcessibilidade( final JInternalFrame ji) {  
        JRootPane meurootpane = ji.getRootPane();  
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");  
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {  
  
            @Override
            public void actionPerformed(ActionEvent e) {  
                ji.dispose();
                
            }  
        });  
        /*
        
        meurootpane = ji.getRootPane();  
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "F5");  
        meurootpane.getRootPane().getActionMap().put("F5", new AbstractAction("F5") {  
  
            @Override
            public void actionPerformed(ActionEvent e) {  
                TelaVendaAPrazo.jb_finalizar.doClick();
                
            }  
        });  
        */
    }
public void setAcessibilidade( final JDialog di) {  
        JRootPane meurootpane = di.getRootPane();  
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");  
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {  
  
            @Override
            public void actionPerformed(ActionEvent e) {  
                di.dispose();
                
            }  
        });  
    }

    
     
}

//usa assim faz uma instacia de um objeto na tela principal
/*
FuncoesTela aparencia = new FuncoesTela();
aparencia.Install();*/
//depois instacia normalmete a tela principal

