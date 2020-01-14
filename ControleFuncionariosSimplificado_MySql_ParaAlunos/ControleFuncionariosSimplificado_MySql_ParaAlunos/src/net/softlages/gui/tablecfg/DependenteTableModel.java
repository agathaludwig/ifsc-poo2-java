/*
 * DependenteTableModel.java
 *
 * Created on 21 de Outubro de 2006, 13:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.softlages.gui.tablecfg;

/**
 *
 * @author java
 */
import java.util.*;
import java.text.*;
import javax.swing.table.*;
import net.softlages.vo.*;

/**
 *
 * @author Marcos André Pisching
 *
 *  Esta classe permite a exibição dos dados de uma List<Dependente>
 *      em um JTable.
 */
public class DependenteTableModel extends AbstractTableModel {
    private List<Dependente> dependentes;
    
    private boolean ordenarPorNome = true;
    /** Creates a new instance of TarefasTableModel */
    public DependenteTableModel(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dependente umDependente = dependentes.get(rowIndex);
        switch(columnIndex) {
            case 0: return umDependente.getNome();
            case 1:
                if (umDependente.getSexo().compareToIgnoreCase("M") == 0)
                    return "Masculino";
                else
                    return "Feminino";
            case 2: return umDependente.getDataNasc();
            case 3:
                switch (umDependente.getParentesco()) {
                    case 0: return "Filho";
                    case 1: return "Conjuge";
                    case 2: return "Pai";
                    case 3: return "Mãe";
                    default: return "Não definido";
                }
        }
        return null;
    }
    
    public int getRowCount() {
        return dependentes.size();
    }
    
    public int getColumnCount() {
        return 4;
    }
    
    public Dependente getValoresDependente(int rowIndex) {
        //if (rowIndex > setoresFiltrados.size())
        //    return null;
        //else
        return dependentes.get(rowIndex);
    }
    
    
    public boolean isOrdenarPorNome() {
        return ordenarPorNome;
    }
    
    public void setOrdenarPorNome(boolean ordenarPorNome) {
        this.ordenarPorNome = ordenarPorNome;
    }
    
    
}
