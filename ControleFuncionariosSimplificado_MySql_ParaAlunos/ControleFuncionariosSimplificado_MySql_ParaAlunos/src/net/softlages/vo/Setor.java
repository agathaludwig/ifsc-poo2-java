/*
 * Setor.java
 *
 * Created on 16 de Mar�o de 2006, 15:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package net.softlages.vo;

import java.io.Serializable;

/**
 *
 * @author java
 */
public class Setor implements Serializable  {
    private Integer codigo;
    private String obs;
    private String nome;
    private String local;
    
    
    /** Creates a new instance of Setor */
    public Setor() {
    }
    
    public Setor(int codigo, String obs, String nome, String local) {
        this.codigo = codigo;
        this.obs = obs;
        this.nome = nome;
        this.local = local;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public String getObs() {
        return obs;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    
    /**
     * Retorna um valor de c�digo hash para o objeto.  Esta implementa��o computa
     * um valor de c�digo hash baseado nos campos id deste objeto.
     * @return um valor de c�digo hash para este objeto.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determina se outro objeto � igual a este Usuario.  O resultado �
     * <code>true</code> se e somente se o argumento n�o for nulo e for um objeto Usuario o qual
     * tem o mesmo valor para o campo id como este objeto.
     * @param object o objeto de refer�ncia com o qual comparar
     * @return <code>true</code> se este objeto � o mesmo como o argumento;
     * <code>false</code> caso contr�rio.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Setor)) {
            return false;
        }
        Setor other = (Setor)object;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) return false;
        return true;
    }
    
    /**
     * Retorna uma representa��o literal deste objeto.  Esta implementa��o cria
     * uma representa��o baseada nos campos id.
     * @return uma representa��o literal deste objeto.
     */
    @Override
    public String toString() {
        return this.nome;
    }    
    
}
