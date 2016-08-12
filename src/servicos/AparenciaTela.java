package servicos;

//package servicos;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class AparenciaTela {

     LookAndFeel lf = UIManager.getLookAndFeel();
     
     // org.fife.plaf.Office2003.Office2003LookAndFeel
     
     public  void Install(){
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
          }catch(Exception e) {  
          e.printStackTrace();  
          } 
     }
     
     public void iconeTela (JFrame f){
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src/image/logoham.png");
            f.setIconImage(icon);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "erro! ", 0);
        }
    }
     public void iconeTela (JDialog d){
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src/image/logoham.png");
            d.setIconImage(icon);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "erro! ", 0);
        }
    }
   public static void teclaEsc(final JInternalFrame frame){
       JRootPane meurootpane = frame.getRootPane();  
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");  
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {  
  
            @Override
            public void actionPerformed(ActionEvent e) {  
                frame.dispose();
                
            }  
        });  
   }  
   
   public static void teclaEscFrame(final JFrame frame){
       JRootPane meurootpane = frame.getRootPane();  
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");  
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {  
  
            @Override
            public void actionPerformed(ActionEvent e) {  
                frame.dispose();
                
            }  
        });  
   }  
}

//usa assim faz uma instacia de um objeto na tela principal
/*
AparenciaTela aparencia = new AparenciaTela();
aparencia.Install();*/
//depois instacia normalmete a tela principal

