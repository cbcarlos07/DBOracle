/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author administrador
 */
public class TableRenderer_Imagem extends JLabel implements TableCellRenderer{          
  
        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table,  
               Object value, boolean isSelected, boolean hasFocus, int row, int column) {  
  
            if (value instanceof ImageIcon) {  
                if (value != null) {  
                    ImageIcon d = (ImageIcon) value;  
                    setIcon(d);  
                } else {  
                    setText("");  
                    setIcon(null);  
                }  
            }  
  
          return this;  
        }  
  
        @Override  
        public void validate() {}  
        @Override  
        public void revalidate() {}  
        @Override  
        protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {}  
        @Override  
        public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}  
    }  
