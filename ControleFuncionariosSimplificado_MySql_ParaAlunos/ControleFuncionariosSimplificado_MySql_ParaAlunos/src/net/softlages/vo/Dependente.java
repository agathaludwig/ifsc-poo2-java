/*
 * Dependente.java
 *
 * Created on 26 de Setembro de 2006, 10:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.softlages.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Marcos Pisching
 */
public class Dependente implements Serializable {
    private Integer codigo;
    private String nome;
    private String sexo;
    private Date dataNasc;
    private int parentesco;
    private Funcionario funcionario;
    /** Creates a new instance of Dependente */
    public Dependente() {
       
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getParentesco() {
        return parentesco;
    }

    public void setParentesco(int parentesco) {
        this.parentesco = parentesco;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }   
    
    /**
     * Retorna um valor de código hash para o objeto.  Esta implementação computa
     * um valor de código hash baseado nos campos id deste objeto.
     * @return um valor de código hash para este objeto.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determina se outro objeto é igual a este Usuario.  O resultado é
     * <code>true</code> se e somente se o argumento não for nulo e for um objeto Usuario o qual
     * tem o mesmo valor para o campo id como este objeto.
     * @param object o objeto de referência com o qual comparar
     * @return <code>true</code> se este objeto é o mesmo como o argumento;
     * <code>false</code> caso contrário.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependente)) {
            return false;
        }
        Dependente other = (Dependente)object;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) return false;
        return true;
    }
    
    /**
     * Retorna uma representação literal deste objeto.  Esta implementação cria
     * uma representação baseada nos campos id.
     * @return uma representação literal deste objeto.
     */
    @Override
    public String toString() {
        return this.nome;
    }        
    
}
