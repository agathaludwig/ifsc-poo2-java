/*
 * SetorTableModel.java
 *
 * Created on 12 de Março de 2006, 23:37
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package net.softlages.gui.tablecfg;

import java.util.*;
import java.text.*;
import javax.swing.table.*;
import net.softlages.vo.*;

/**
 *
 * @author Marcos André Pisching
 *
 *  Esta classe permite a exibição dos dados de uma List<Tarefas>
 *      em um JTable.
 */
public class SetorTableModel extends AbstractTableModel {
    private List<Setor> setores;
    //private List<Setor> setoresFiltrados;
    private boolean ordenarPorNome = true;
    /** Creates a new instance of TarefasTableModel */
    public SetorTableModel(List<Setor> setores) {
        this.setores = setores;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        Setor umSetor = setores.get(rowIndex);
        switch(columnIndex) {
            case 0: return umSetor.getCodigo();
            case 1: return umSetor.getNome();
            case 2: return umSetor.getLocal();
        }
        return null;
    }
    
    public int getRowCount() {
        return setores.size();
    }
    
    public int getColumnCount() {
        return 3;
    }
    
    public Setor getValoresSetor(int rowIndex) {
        //if (rowIndex > setoresFiltrados.size())
        //    return null;
        //else
            return setores.get(rowIndex);
    }
   
   
    public boolean isOrdenarPorNome() {
        return ordenarPorNome;
    }
    
    public void setOrdenarPorNome(boolean ordenarPorNome) {
        this.ordenarPorNome = ordenarPorNome;
    }
  
   
}
