/*
 * FuncionarioException.java
 *
 * Created on 18 de Outubro de 2006, 14:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.softlages.exception;

/**
 *
 * @author Cliente
 */
public class FuncionarioException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>FuncionarioException</code> without detail message.
     */
    public FuncionarioException() {
    }
    
    
    /**
     * Constructs an instance of <code>FuncionarioException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public FuncionarioException(String msg) {
        super(msg);
    }
    
    /**
     * Constructs an instance of <code>FuncionarioException</code> with the specified detail throwable cause
     * @param cause the exception cause
     */
    public FuncionarioException(Throwable cause){
        super(cause);
    }
}
