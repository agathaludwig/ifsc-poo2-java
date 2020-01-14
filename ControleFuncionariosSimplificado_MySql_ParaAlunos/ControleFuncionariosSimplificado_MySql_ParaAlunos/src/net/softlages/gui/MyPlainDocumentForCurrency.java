/*
 * MyPlainDocumentForCurrency.java
 *
 * Created on 26 de Outubro de 2006, 11:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.softlages.gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author java
 */
public class MyPlainDocumentForCurrency extends PlainDocument{
    
    /** Creates a new instance of MyPlainDocumentForCurrency */
    public MyPlainDocumentForCurrency() {
    }
    
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
       String texto = getText(0, getLength());
       if (texto.length() < 13) {
           remove(0, getLength());
           StringBuffer strBuf = new StringBuffer(texto.replaceAll(",","")+str);
           
           if (strBuf.length() < 3) strBuf.insert(0,",");
           else strBuf.insert(strBuf.length() - 2, ",");
           super.insertString(0,strBuf.toString(),a);
           // 11.11 1111,11
       }
    }
    
}
