package servicos;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class CoresJTable implements TableCellRenderer{

  public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
  

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
        table, value, isSelected, hasFocus, row, column);
    ((JLabel) renderer).setOpaque(true);
    Color foreground, background;

    if (isSelected) {
      foreground = new Color(0, 0, 0);
      background = new Color(184, 207, 229);

    } else {
      if (row % 2 == 0) {
        foreground = new Color(0, 0, 0);
        background = new Color(184, 231, 177);
      } else {
        foreground = new Color(0, 0, 0);
        background = new Color(255, 255, 255);
      }
    }
    renderer.setForeground(foreground);
    renderer.setBackground(background);
    return renderer;
  }
}
