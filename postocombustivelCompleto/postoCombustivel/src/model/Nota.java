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
public class Nota {
    private EnumPrecoCombustivel combustivel;
    private double qtdLitros;
    private double totalCombustivel;
    private double total500;
    private double total1000;
    private double totalOleo;
    private double total;
    private boolean avista;
    private int dias;

    public EnumPrecoCombustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(EnumPrecoCombustivel combustivel) {
        this.combustivel = combustivel;
    }

    public double getQtdLitros() {
        return qtdLitros;
    }

    public void setQtdLitros(double qtdLitros) {
        this.qtdLitros = qtdLitros;
    }

    public double getTotal500() {
        return total500;
    }

    public void setTotal500(double total500) {
        this.total500 = total500;
    }

    public double getTotal1000() {
        return total1000;
    }

    public void setTotal1000(double total1000) {
        this.total1000 = total1000;
    }

    public boolean isAvista() {
        return avista;
    }

    public void setAvista(boolean avista) {
        this.avista = avista;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getTotalCombustivel() {
        return totalCombustivel;
    }

    public void setTotalCombustivel(double totalCombustivel) {
        this.totalCombustivel = totalCombustivel;
    }

    public double getTotalOleo() {
        return totalOleo;
    }

    public void setTotalOleo(double totalOleo) {
        this.totalOleo = totalOleo;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}


