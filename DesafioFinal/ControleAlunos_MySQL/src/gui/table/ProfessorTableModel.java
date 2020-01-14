/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Professor;

/**
 *
 * @author Aluno
 */
public class ProfessorTableModel extends AbstractTableModel {

    private ArrayList<Professor> professores;
    private boolean ordenarPorNome = true;

    public ProfessorTableModel(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Professor umProfessor = professores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return umProfessor.getMatricula();
            case 1:
                return umProfessor.getNome();
            case 2:
                return umProfessor.getTitulacao();
            case 3:
                return umProfessor.getSalario();
        }
        return null;
    }

    public int getRowCount() {
        return professores.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Professor getValoresProfessor(int rowIndex) {
        return professores.get(rowIndex);
    }

    public boolean isOrdenarPorNome() {
        return ordenarPorNome;
    }

    public void setOrdenarPorNome(boolean ordenarPorNome) {
        this.ordenarPorNome = ordenarPorNome;
    }

}
