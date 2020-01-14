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
public enum EnumPrecoCombustivel {
    OLEO_DIESEL(1, 3.85, "Óleo Diesel"),
    GAS_COMUM(2, 3.95, "Gasolina Comum"),
    GAS_ADITIVADA(3, 4.15, "Gasolina Aditivada"),
    ALCOOL(4, 3.65, "Álcool");
    
    private final int codigo;
    private final double valor;
    private final String descricao;
    
    private EnumPrecoCombustivel(int codigo, double valor, String descricao) {
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
