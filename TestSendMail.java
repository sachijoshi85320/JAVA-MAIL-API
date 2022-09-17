package com.mycompany.mailapiwork;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class TestSendMail {
    public static void sendMail(String recipient_mail){
        Properties props=new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");//687       
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        String from_email="senderto@gmail.com";
        String from_email_pass="fincvfhsmpsgiktw";
        Session session=Session.getInstance(props,new Authenticator() {
 
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from_email,from_email_pass);
            }
        });  
        //session.setDebug(true);
        Message message=prepareMessage(session,from_email, recipient_mail);
        try{
            Transport.send(message);
        }
        catch(MessagingException e) 
        {
            System.out.println(e);
        }
        System.out.println("Message sent successfully");
    }
    private static Message prepareMessage(Session session , String from_email,String recipient_mail){
        MimeMessage message=new MimeMessage(session);
       try{
        message.setFrom(new InternetAddress(from_email));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient_mail));
        message.setSubject("Please have a look");
        message.setText("This is my first mail demo message");
       }
       catch(MessagingException e){
           System.out.println(e);
       }
        return message;
    }
}
