/*
 * SetorCellRenderer.java
 *
 * Created on 12 de Março de 2006, 23:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package net.softlages.gui.tablecfg;

import java.util.*;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.table.*;
import net.softlages.vo.*;

/**
 *
 * @author Marcos André Pisching
 */
public class SetorCellRenderer extends DefaultTableCellRenderer{
    
    /** Creates a new instance of SetorCellRenderer */
    public SetorCellRenderer() {
        super();
    }
    
   public Component getTableCellRendererComponent (
            javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        JLabel label = (JLabel)super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        if (column != 1)
            label.setHorizontalAlignment(JLabel.CENTER);
        TableModel tm = table.getModel();
        Setor setor = ((SetorTableModel)tm).getValoresSetor(row);
        if (isSelected) {
            label.setForeground(Color.getHSBColor(100, 40, 190));
            label.setBackground(Color.GRAY);
        } else {
            label.setForeground(Color.BLACK);
            label.setBackground(Color.getHSBColor(100, 40, 190));
        }
        
        return label;
    }
    
}
