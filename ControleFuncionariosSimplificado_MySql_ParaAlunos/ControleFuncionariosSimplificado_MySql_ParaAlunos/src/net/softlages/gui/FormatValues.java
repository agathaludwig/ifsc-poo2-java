/*
 * FormatValues.java
 *
 * Created on 24 de Outubro de 2006, 22:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.softlages.gui;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author java
 */
public class FormatValues {

    public static void formatDate(JFormattedTextField jftf) {
        MaskFormatter data=null;
        
        // CAMPO data
        try {
            data = new MaskFormatter("**/**/****");
            data.setPlaceholder("__________");
            data.setValidCharacters(" 0123456789_");
            data.install(jftf);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
   
    public static void formatCPF(JFormattedTextField jftf) {
        MaskFormatter cpf = null;
        
        try {
            cpf = new MaskFormatter("*********-**");
            cpf.setPlaceholder("____________");
            cpf.setValidCharacters(" 0123456789_");
            cpf.install(jftf);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void formatPhoneNumber(JFormattedTextField jftf) {
        MaskFormatter phone = null;
        
        try {
            phone = new MaskFormatter("(**)****-****");
            phone.setPlaceholder("_____________");
            phone.setValidCharacters(" 0123456789_");
            phone.install(jftf);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }        
    }

        public static void formatCurrency(JFormattedTextField jftf) {
        MaskFormatter currency = null;
        
        try {
            currency = new MaskFormatter("##.###.##0,00");
            //phone.setPlaceholder("_____________");
            currency.setValidCharacters(" 0123456789_.,");
            currency.install(jftf);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }        
    }
    
        
    public static String removeMaskCPF(String cpf) {
        char[] chars = new char[11];
        String str = null;
        for (int i = 0, c = 0; i < cpf.length(); i++) {
            if (cpf.charAt(i) != '-') {
                chars[c++] = cpf.charAt(i);
            }
        }
        str = str.copyValueOf(chars);
        return str;
    }  
}
