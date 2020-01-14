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
public enum EnumPrecoOleo {
    OLEO500(1, 10.25, "Frasco de 500ml"),
    OLEO1000(2, 20.45, "Frasco de 1l");
    
    private int codigo;
    private double valor;
    private String descricao;
    
    private EnumPrecoOleo(int codigo, double valor, String descricao) {
        this.codigo = codigo;
        this.valor = valor;
        this.descricao = descricao;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
}

