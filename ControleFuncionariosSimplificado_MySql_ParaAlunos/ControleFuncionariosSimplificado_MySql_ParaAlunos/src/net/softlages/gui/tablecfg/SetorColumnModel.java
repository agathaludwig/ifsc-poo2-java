/*
 * SetorColumnModel.java
 *
 * Created on 12 de Março de 2006, 23:54
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package net.softlages.gui.tablecfg;

import java.awt.*;
import javax.swing.table.*;
import net.softlages.vo.*;
/**
 *
 * @author Marcos André Pisching
 */
public class SetorColumnModel extends DefaultTableColumnModel{
    private TableColumn criaColuna(int columnIndex, int largura,
            FontMetrics fm, boolean resizeable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + " ");
        if (largura < larguraTitulo)
            largura = larguraTitulo;
        TableColumn col = new TableColumn(columnIndex);
        col.setCellRenderer(new SetorCellRenderer());
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
    public SetorColumnModel(FontMetrics fm) {
        int digito = fm.stringWidth("0");
        int letra = fm.stringWidth("M");
        addColumn(criaColuna(0, 3 * digito, fm, false, "Id"));
        addColumn(criaColuna(1, 20 * letra, fm, true, "Nome"));
        addColumn(criaColuna(2, 20 * letra, fm, false, "Local"));
    }
    
}
