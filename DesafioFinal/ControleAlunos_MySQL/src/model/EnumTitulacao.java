/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aluno
 */
public enum EnumTitulacao {
    GRADUACAO(1, "Graduação"),
    ESPECIALIZAÇÃO(2, "Especialização"),
    MESTRADO(3, "Mestrado"),
    DOUTORADO(4, "Doutorado");
    
    private final int cbNumber;
    private final String descricao;
    
    private EnumTitulacao(int cbNumber, String descricao) {
        this.cbNumber = cbNumber;
        this.descricao = descricao;
    }
    @Override
    public String toString(){ 
            return descricao;
    }
}
