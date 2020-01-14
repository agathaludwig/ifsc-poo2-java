/*  
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Java
 */
public class Professor {
    private int matricula;
    private String nome;
    //private EnumTitulacao titulacao;
    private String titulacao;
    private Double salario;

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /*
    
    public EnumTitulacao getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(EnumTitulacao titulacao) {
        this.titulacao = titulacao;
    }
*/    

    /**
     * @return the titulacao
     */
    public String getTitulacao() {
        return titulacao;
    }

    /**
     * @param titulacao the titulacao to set
     */
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }        

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.matricula;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }

    
}