/*
 * Funcionario.java
 *
 * Created on 16 de Março de 2006, 15:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package net.softlages.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author java
 */
public class Funcionario implements Serializable {
    private Integer codigo;
    private String nome;
    private String fone;
    private String cpf;
    private Date dataNasc;
    private char sexo;
    private String celular;
    private String email;
    private double salario;
    private String obs;
     
    //private Integer setorCodigo; declaracao errada - não é uma associação de classes
    private Setor setor; //declaracao correta - representando uma associacao de classes
    private List<Dependente> dependentes;
    
    /** Creates a new instance of Funcionario */
    public Funcionario() {
        dependentes = new ArrayList<Dependente>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }
    
    public void addDependente(Dependente dep) {
        getDependentes().add(dep);
        dep.setFuncionario(this);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }


    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario)object;
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
        return this.nome + " " + this.cpf;
    }        
    
}
