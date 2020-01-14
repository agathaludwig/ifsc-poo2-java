/*
 * DependenteException.java
 *
 * Created on 21 de Outubro de 2006, 12:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.softlages.exception;

/**
 *
 * @author java
 */
public class DependenteException extends Exception{
    
    public DependenteException(String message) {
        super(message);
    }
    public DependenteException(Throwable cause){
        super(cause);
    }
}
