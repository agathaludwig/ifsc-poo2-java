/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author Aluno
 */
public class ExcecaoReservatorio extends Exception {

    /**
     * Creates a new instance of <code>ExcecaoReservatorio</code> without detail
     * message.
     */
    public ExcecaoReservatorio() {
    }

    /**
     * Constructs an instance of <code>ExcecaoReservatorio</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcecaoReservatorio(String msg) {
        super(msg);
    }
    
    public ExcecaoReservatorio(String msg, Exception causa) {
        super(msg, causa);
    }
}
