/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;

/**
 *
 * @author agatha
 */
public class CalculoSalario {
    private double comissao, salarioBruto, inss, irpf, salarioFamilia, salarioLiquido;
    private int bonus;
    private Vendedor vendedor;

    
        
    public void calcularComissao(Vendedor vendedor) {
        if (vendedor.getTotalVendas() < 50000) {
            comissao = 0.02*vendedor.getTotalVendas();
        }
        else if (vendedor.getTotalVendas() > 150000) {
            comissao = 0.07*vendedor.getTotalVendas();
        }
        else {
            comissao = 0.05*vendedor.getTotalVendas();
        }
    }
    public void calcularSalBruto(Vendedor vendedor) {
        salarioBruto = vendedor.getSalBase()+comissao;
    }
    public void calcularBonus(Vendedor vendedor) {
        if (vendedor.getTotalVendas() >= 100000) {
            bonus = 1000;
        }
        else {
            bonus = 0;
        }
    }
    public void calcularINSS() {
        if (salarioBruto <= 965.67) {
            inss = 0.08*salarioBruto;
        }
        else if (salarioBruto <= 1609.45) {
            inss = 0.09*salarioBruto;
        }
        else if (salarioBruto <= 3218.90) {
            inss = 0.11*salarioBruto;
        }
        else {
            inss = 0.11*3218.90;
        }
    }
    public void calcularIRPF() {
        if (salarioBruto > 3582) {
            irpf = (0.275*salarioBruto)-662.94;
        }
        else if (salarioBruto > 2866.7) {
            irpf = (0.225*salarioBruto)-483.84;
        }
        else if (salarioBruto > 2175) {
            irpf = (0.15*salarioBruto)-268.84;
        }
        else if (salarioBruto > 1434.59) {
            irpf = (0.075*salarioBruto)-268.84;
        }
        else {
            irpf = 0;
        }
    }
    public void calcularSalarioFamilia(Vendedor vendedor) {
         if (salarioBruto <= 10000) {
            salarioFamilia = 405 * vendedor.getNumDependentes();
        }
        else if (salarioBruto <= 20000) {
            salarioFamilia = 210 * vendedor.getNumDependentes();
        }
        else {
            salarioFamilia = 0;
        }
    }
    public void calcularSalarioLiquido() {
        salarioLiquido = salarioBruto - irpf - inss + bonus + salarioFamilia;
    }
    
    public String imprimirFPg(Vendedor vendedor) {
        DecimalFormat df = new DecimalFormat("R$ ##,###,##0.00");
        StringBuilder sb = new StringBuilder();
        sb.append("F O L H A  D E  P A G A M E N T O\n\n");
        sb.append("Nome.................: ").append(vendedor.getNome()).append("\n");
        sb.append("Salário base.....: ").append(df.format(vendedor.getSalBase())).append("\n");
        sb.append("Total de vendas: ").append(df.format(vendedor.getTotalVendas())).append("\n");
        sb.append("-----------------------------------\n");
        sb.append("Comissão.......: ").append(df.format(this.comissao)).append("\n");
        sb.append("Salário bruto...: ").append(df.format(this.salarioBruto)).append("\n");
        sb.append("-------------------------------------\n");
        sb.append("Bônus..............: ").append(df.format(this.bonus)).append("\n");
        sb.append("Salário família: ").append(df.format(this.salarioFamilia)).append("\n");
        sb.append("-------------------------------------\n");
        sb.append("IRPF...........(-):  ").append(df.format(this.irpf)).append("\n");
        sb.append("INSS...........(-): ").append(df.format(this.inss)).append("\n");
        sb.append("-------------------------------------\n");
        sb.append("Salário líquido: ").append(df.format(this.salarioLiquido)).append("\n");
        sb.append("-------------------------------------\n");
        sb.append("Observações: Número de dependentes: ").append(Integer.toString(vendedor.getNumDependentes())).append("\n");
        
        return sb.toString();
        
    }
}
