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
    GRADUACAO("Graduação"),
    ESPECIALIZAÇÃO("Especialização"),
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado");
    
    private final String descricao;
    
    private EnumTitulacao(String descricao) {
        this.descricao = descricao;
    }
}
