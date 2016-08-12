/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 *
 * @author carlos.bruno
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
 
 
public class ColorRender extends DefaultTableCellRenderer {
 
    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
 
        super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
         
        // seta o resultado p/ falso porque isso sera usado em varias Jtables do sistema
        boolean result = false;
        try{
// no nosso exemplo 
 
if (table.getName() != null) { // p/ não escrever um null cada vez que carregar uma célula
                if (table.getName().equals("jTable1")) {
                    result = (Boolean) table.getModel().getValueAt(row, 3);
                }
                if (table.getName().equals("titulosAutorizacao")) {
                    result = (Boolean) table.getModel().getValueAt(row, 6);
                }
            }
        }
        catch (java.lang.NullPointerException ex){
            System.out.println(ex.getMessage());
        }
         
        //se for uma linha selecionada
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            // se o checkbox estiver selecionado
            // pinta a linha inteira
            if (result) {
                setBackground(Color.YELLOW);
                setForeground(Color.RED);
                setFont(new Font("Verdana",Font.BOLD,10));
            } else {
 
                // se não , colore alternado as linhas
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                    setForeground(Color.black);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(Color.black);
                }
            }
        }
        return this;
    }
}