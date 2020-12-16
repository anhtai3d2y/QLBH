/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MailHandle;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class VerifyEmail {
    public boolean verifyEmail(String str){
        return Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", str);
    }
}
