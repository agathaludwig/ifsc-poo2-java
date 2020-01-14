/*
 * DependenteCellRenderer.java
 *
 * Created on 21 de Outubro de 2006, 13:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.softlages.gui.tablecfg;

import java.text.DateFormat;
import java.util.*;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.table.*;
import net.softlages.vo.*;

/**
 *
 * @author Marcos André Pisching
 */
public class DependenteCellRenderer extends DefaultTableCellRenderer{
    
    /** Creates a new instance of DependenteCellRenderer */
    public DependenteCellRenderer() {
        super();
    }
    
    private Color corLinha(Dependente dependente) {
        switch (dependente.getParentesco()) {
            case 0: return Color.CYAN;
            case 1: return Color.YELLOW;
            case 2: return Color.GREEN;
            case 3: return Color.PINK;
            default: return Color.WHITE;
        }
    }
    
    
    public Component getTableCellRendererComponent(
            javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        value = formata(value);
        JLabel label = (JLabel)super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        if (column != 0)
            label.setHorizontalAlignment(JLabel.CENTER);
        TableModel tm = table.getModel();
        Dependente dependente = ((DependenteTableModel)tm).getValoresDependente(row);
        if (isSelected) {
            label.setForeground(corLinha(dependente));
            label.setBackground(Color.GRAY);
        } else {
            label.setForeground(Color.BLACK);
            label.setBackground(corLinha(dependente));
        }
        
        return label;
    }
    
    private Object formata(Object value) {
        if (value instanceof Date) {
            Date data = (Date)value;
            DateFormat df = DateFormat.getDateInstance();
            return df.format(data);
        } else if (value instanceof Boolean)
            return (Boolean)value ? "S": "N";
        else           
            return value;
    }
    
}
