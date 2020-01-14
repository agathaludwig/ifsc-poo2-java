/*
 * DependenteColumnModel.java
 *
 * Created on 21 de Outubro de 2006, 13:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.softlages.gui.tablecfg;

import java.awt.*;
import javax.swing.table.*;
import net.softlages.vo.*;
/**
 *
 * @author Marcos André Pisching
 */
public class DependenteColumnModel extends DefaultTableColumnModel{
    private TableColumn criaColuna(int columnIndex, int largura,
            FontMetrics fm, boolean resizeable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + " ");
        if (largura < larguraTitulo)
            largura = larguraTitulo;
        TableColumn col = new TableColumn(columnIndex);
        col.setCellRenderer(new DependenteCellRenderer());
        col.setHeaderRenderer(null);
        col.setHeaderValue(titulo);
        col.setPreferredWidth(largura);
        if (!resizeable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizeable);
        return col;
    }
    /** Creates a new instance of TarefasColumnModel */
    public DependenteColumnModel(FontMetrics fm) {
        int digito = fm.stringWidth("0");
        int letra = fm.stringWidth("M");
        addColumn(criaColuna(0, 30 * letra, fm, true, "Nome"));
        addColumn(criaColuna(1, 10 * letra, fm, false, "Sexo"));
        addColumn(criaColuna(2, 10 * digito, fm, false, "Nascimento"));
        addColumn(criaColuna(3, 10 * letra, fm, true, "Parentesco"));
    }
    
}
