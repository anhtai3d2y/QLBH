/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MailHandle;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.Authenticator;
import javax.swing.JOptionPane;
/**
 *
 * @author acer
 */
public class MailHandle {
    public static int SendPincode(String to, String sub){
        
        
        Random rd = new Random();
        
        int pincode = 100000 + rd.nextInt(899999);
        
        String msg = "KMA-Gear đã nhận được yêu cầu sử dụng địa chỉ email này để đăng ký tài khoản tại KMA-Gear.\n\nMã xác minh của bạn là: " + String.valueOf(pincode) + "\n\nNhập mã theo yêu cầu để cho KMA-Gear biết rằng có thể liên hệ với bạn tại địa chỉ email này.\n\nNếu bạn không nhận ra KMA-Gear thì có thể ai đó đã cung cấp nhầm địa chỉ email của bạn. Bạn có thể bỏ qua email này mà không gặp vấn đề gì.\n" +
"\n" +
"Trân trọng!\n" +
"Đội ngũ KMA-Gear";
        final String user = "kmagearmanagement@gmail.com";
        final String pass = "Phamduytai27112k";
        
        
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, pass);
            }
        });
        
        try {
            MimeMessage message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            
            Transport.send(message);
            
            
        } catch (MessagingException e) {
            
            throw new RuntimeException(e);
        }
        return pincode;
    }
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {;
        SendPincode("anhtai3d2y@gmail.com", "Mã xác minh đăng lý tài khoản KMA-Gear");
    }
}
