package com.fmt.Umd.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
    private  JavaMailSender mailSender;

	
	  public MailService(JavaMailSender mailSender) { this.mailSender =
	  mailSender; }
	 

	/*
	 * public void sendVerificationEmail(String to, String subject, String body) {
	 * SimpleMailMessage message = new SimpleMailMessage(); message.setTo(to);
	 * message.setSubject(subject); message.setText(body); mailSender.send(message);
	 * }
	 */
	  
	  
	  public int sendVerificationEmail(String to) {
		  Random random = new Random();
		  int randomNumber = random.nextInt(9000) + 1000;
		  
		  
		  String subjet="OTP VERIFICATION";
		  String body="pUT HE OTP FOR VERIFICATION :"+randomNumber;
		  
			System.setProperty("https.protocols", "TLSv1.1.2");
			String host="smtp.gmail.com";
			 Properties prop = new Properties();
			    /*prop.put("mail.smtp.host", "outlook.office365.com");*/
			    prop.put("mail.smtp.host", host);
		        prop.put("mail.smtp.port", 465);
	           prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		        prop.put("mail.smtp.auth", "true");
		        prop.put("mail.smtp.starttls.enable", "true"); //TLS
		System.out.println("=========Email sending==========");
		        Session session = Session.getInstance(prop,
		                new javax.mail.Authenticator() {
		                    protected PasswordAuthentication getPasswordAuthentication() {
		                        return new PasswordAuthentication("pandapravanjan3@gmail.com","bpmxejjzyrdymqwk");
		                    }
		                });
		        
		        session.setDebug(true);
		        try {
		            Message mes = new MimeMessage(session);
		            Address fromAddress = new InternetAddress("pandapravanjan3@gmail.com");
		            mes.setFrom(fromAddress);
		            mes.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		            mes.setSubject(subjet);
		            mes.setText(body);
		            Transport transport = session.getTransport("smtps");
		            transport.connect (host, 465, "pandapravanjan3@gmail.com", "bpmxejjzyrdymqwk");
		            transport.sendMessage(mes, mes.getAllRecipients());
		            transport.close();   
		            //Transport.send(mes);
		        }catch(Exception e) {
		        	e.printStackTrace();
		        }
		        return randomNumber;
		
		}
}
