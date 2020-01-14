/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import excecoes.ExcecaoReservatorio;

/**
 *
 * @author Aluno
 */
public class Reservatorio {
    private EnumPrecoCombustivel tipo;
    private double qtdAtual;
    private double qtdMaxima;
    private double qtdMin;

    public EnumPrecoCombustivel getTipo() {
        return tipo;
    }

    public void setTipo(EnumPrecoCombustivel tipo) {
        this.tipo = tipo;
    }

    public double getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(double qntAtual) {
        this.qtdAtual = qntAtual;
    }

    public double getQtdMaxima() {
        return qtdMaxima;
    }

    public void setQtdMaxima(double qtdMaxima) {
        this.qtdMaxima = qtdMaxima;
    }

    public double getQtdMin() {
        return qtdMin;
    }

    public void setQtdMin(double qtdMin) {
        this.qtdMin = qtdMin;
    }
    
    public void saida(double quantidade) throws ExcecaoReservatorio {
        if (quantidade <= qtdAtual) {
            this.qtdAtual -= quantidade;
            return;
        }
        throw new ExcecaoReservatorio("Quantidade insuficiente no reservatório.");
    }

     public void completar() {
         this.qtdMaxima = 100.00;   
         this.qtdAtual = this.qtdMaxima;
    }

    public Reservatorio(EnumPrecoCombustivel tipo) {
        this.tipo = tipo;
        this.qtdMaxima = 100.00;
        this.qtdAtual = this.qtdMaxima;
        this.qtdMin = 20.00;
    }
    
     
}
