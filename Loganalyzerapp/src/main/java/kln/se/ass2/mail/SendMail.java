package kln.se.ass2.mail;

import kln.se.ass2.mysqlrepostery.Connect;
import kln.se.ass2.mysqlrepostery.Maillist;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail implements Mail {

    public void sendmail(){

        String from = "softconsassiment2@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("softconsassiment2@gmail.com", "asanka2020");
            }
        });
        Connect maillist = new Maillist();

        List<String> emailToAddresses =maillist.getmailaddress();
        String emails = null;

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            StringBuilder sb = new StringBuilder();

            int i = 0;
            for (String email : emailToAddresses) {
                sb.append(email);
                i++;
                if (emailToAddresses.size() > i) {
                    sb.append(", ");
                }
            }

            emails = sb.toString();

            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(sb.toString()));

            message.setSubject("Error notification");

            message.setText("There are some errors in the log");

            System.out.println("sending...");

            Transport.send(message);
            System.out.println("Sent message successfully!!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
