/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.awt.*;  
import java.awt.geom.Rectangle2D;  
import java.awt.image.BufferedImage;

import java.io.IOException;  
import javax.imageio.ImageIO;


  
public class Fundo extends javax.swing.JDesktopPane{  
        BufferedImage b;  
        Rectangle2D rect;  
          
        public Fundo(){   
             
            try {  
                 //se você pegar uma Imagem dentro do mesmo jar/projeto  
                b = ImageIO.read(getClass().getResourceAsStream("/image/bg.png"));   
                  
                
                //ou, se você  pegar uma Imagem direto do sistema, use este          
         
                // b =   ImageIO.read(new File("<caminho da Imagem>"));  
                  
                //cria uma Imagem do tamanho 130x130,   
                //que vai se repetir ao longo do fundo, o tamanho é você quem escolhe.  
                rect  = new  Rectangle(0,0,1366,768);               
                      
                  
            } catch (IOException ex) {

            ex.printStackTrace(System.err);
        }
    }
          
        @Override   
        public void paintComponent(Graphics g){    
            /* 
             * Se você quiser que a Imagem seja uma só (extendida ao tamanho da tela, não replicada 
             * tire os comentários da  proxima linha 
             */  
              
             rect = new  Rectangle(0,0,this.getWidth(),this.getHeight());  
              
              
            TexturePaint p = new TexturePaint(b,rect);  
            Graphics2D g2 = (Graphics2D) g;  
            g2.setPaint(p);  
              
            g2.fillRect(0,0,this.getWidth(),this.getHeight());  
   
        }  
    } 
