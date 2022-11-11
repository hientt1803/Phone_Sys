///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Ultils;
//
//import java.net.PasswordAuthentication;
//import java.util.Properties;
//import javax.mail.Session;
//import javax.mail.internet.MimeMessage;
//
///**
// *
// * @author HienTran
// */
//public class SendMail {
//    public static void send(String to,String sub,
//            String msg,final String user,final String pass){
//        
//        Properties props = new Properties();
//        
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        
//        Session session;
//        session = Session.getInstance(props, new javax.mail.Authenticator(){
//            @Override
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
//                return new PasswordAuthentication(user,pass);
//            }
//        });
//        
//        try {
//            MimeMessage message = new MimeMessage(session);
//        } catch (Exception e) {
//        }
//    
//    }
//    
//}
