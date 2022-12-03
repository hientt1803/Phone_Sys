/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesystem.edu.ultil;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author NP
 */
public class Email {

    public static int ranDom;
    public static boolean sendEmail(String to) {
        String from = "minhdeluong2003@gmail.com";
        String password = "ctsiuiwbkesgcexv";

        // Properties: Khai báo các thuộc tính
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Create Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }

        };

        // Phiên làm việc
        Session session = Session.getInstance(props, auth);

        // Gửi mail
        //  String to = "dutkpc03072@fpt.edu.vn";
        // Tạo 1 tin nhắn
        MimeMessage msq = new MimeMessage(session);
        try {
            // Kiểu nội dung
            msq.addHeader("Content-type", "text/HTML; charset= UTF-8");

            // Người gửi
            msq.setFrom(from);

            // Người nhận 
            msq.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            // Tiêu đề
            msq.setSubject("Quên mật khẩu");

            // Quy định ngày gửi
            msq.setSentDate(new Date());

            // Nội dung
            Random rand = new Random();
            int ranNum = rand.nextInt(9999);
            msq.setText("Mã code: " + ranNum);
            ranDom = ranNum;
            
            // Gửi mail
            Transport.send(msq);
            System.out.println("Gửi mail thành công");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Gửi mail thất bại");
            return false;
        }
    }

//    public static void main(String[] args) {
//        Random rand = new Random();
//        int ranNum = rand.nextInt(9999);
//        System.out.println(ranNum);
//        
//        Email.sendEmail("dutkpc03072@fpt.edu.vn");
//
//    }
}
