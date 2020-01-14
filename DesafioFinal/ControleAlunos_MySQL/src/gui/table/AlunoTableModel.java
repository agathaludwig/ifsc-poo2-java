/*
 * DependenteTableModel.java
 *
 * Created on 21 de Outubro de 2006, 13:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.table;

/**
 *
 * @author java
 */
import java.util.*;
import javax.swing.table.*;
import model.Aluno;

public class AlunoTableModel extends AbstractTableModel {
    private ArrayList<Aluno> alunos;
    
    private boolean ordenarPorNome = true;
    /** Creates a new instance of TarefasTableModel */
    public AlunoTableModel(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno umAluno = alunos.get(rowIndex);
        switch(columnIndex) {
            case 0: return umAluno.getMatricula();
            case 1: return umAluno.getNome();
            case 2: return umAluno.getCpf();
            case 3: return umAluno.getRenda();
        }
        return null;
    }
    
    public int getRowCount() {
        return alunos.size();
    }
    
    public int getColumnCount() {
        return 4;
    }
    
    public Aluno getValoresAlunos(int rowIndex) {
        return alunos.get(rowIndex);
    }
    
    
    public boolean isOrdenarPorNome() {
        return ordenarPorNome;
    }
    
    public void setOrdenarPorNome(boolean ordenarPorNome) {
        this.ordenarPorNome = ordenarPorNome;
    }
    
}
