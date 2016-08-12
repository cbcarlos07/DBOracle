/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author carlos.bruno
 */
class Colorir extends JLabel implements TableCellRenderer{
  public Component getTableCellRendererComponent(
     JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column){
     
     if(value == "EM SALA DE CIRURGIA"){
       setForeground(Color.BLUE);	
     }
     else{
       setForeground(Color.BLACK);		
     }
     
     setText(value.toString());
     	
     return this;   	
  }
  
  public void validate() {}
  public void revalidate() {}
  protected void firePropertyChange(String propertyName,
      Object oldValue, Object newValue) {}
  public void firePropertyChange(String propertyName,
      boolean oldValue, boolean newValue) {}  
}
