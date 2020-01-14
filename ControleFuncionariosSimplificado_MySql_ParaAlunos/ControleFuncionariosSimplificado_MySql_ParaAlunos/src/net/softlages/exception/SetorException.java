/*
 * SetorException.java
 *
 * Created on 15 de Outubro de 2006, 11:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.softlages.exception;

public class SetorException extends Exception{

	public SetorException(String message) {
		super(message);
	}
	public SetorException(Throwable cause){
		super(cause);
	}
}