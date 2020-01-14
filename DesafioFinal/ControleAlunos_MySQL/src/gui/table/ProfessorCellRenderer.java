/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import model.Professor;

/**
 *
 * @author Aluno
 */
public class ProfessorCellRenderer extends DefaultTableCellRenderer {
    public ProfessorCellRenderer() {
        super();
    }
    
   public Component getTableCellRendererComponent (
            javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        JLabel label = (JLabel)super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        if (column != 1)
            label.setHorizontalAlignment(JLabel.CENTER);
        TableModel tm = table.getModel();
        Professor professor = ((ProfessorTableModel)tm).getValoresProfessor(row);
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
