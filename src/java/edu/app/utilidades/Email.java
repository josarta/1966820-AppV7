/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.utilidades;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author SENA
 */
public class Email {
    public static void sendModificacion(String para, String Nombres, String nombUsu, String clave) {
        final String user = "";//cambiará en consecuencia al servidor utilizado
        final String pass = "";

//1st paso) Obtener el objeto de sesión
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
            message.setSubject("Actualizacion de datos en Banco-Pedagogico");
            java.util.Date fecha = new Date();

            message.setContent(
                    "<center><img src='http://fs5.directupload.net/images/160530/khs5cmdc.jpg' title='Banco Pedagogico'></center>"
                    + "<h3> Actualizacion de datos en Banco-Pedagogico. "
                    + Nombres
                    + "</h3>"
                    + "Datos de Ingreso: "
                    + "<h4> Nombre Usuario : "
                    + nombUsu
                    + "</h4>"
                    + "<h4> Documento Usuario : "
                    + clave
                    + " </h4>"
                    + "Ultima Modificacion"
                    + fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds() + " - "
                    + fecha.getDay() + "/" + fecha.getMonth() + "/" + fecha.getYear(), "text/html");

            //3rd paso)send message
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static void sendClaves(String para, String Nombres, String clave) {
        final String user = "adsiwebjava@gmail.com";//cambiará en consecuencia al servidor utilizado
        final String pass = "adsi2020";

//1st paso) Obtener el objeto de sesión
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
            message.setSubject("Recordatorio Claves sistema ADSI 1966820");

            message.setContent(
                    "<center><img src='https://www.ingeniovirtual.com/wp-content/uploads/tipos-de-palabras-clave-o-keywords-1.jpg' title='ADSI 1966820'></center>"
                    + "<h3> Recordatorio Claves. "
                    + Nombres
                    + "</h3>"
                    + "Datos de Ingreso: "
                    + "<h4> Correo Usuario : "
                    + para
                    + "</h4>"
                    + "<h4> Clave Usuario : "
                    + clave
                    + " </h4>", "text/html");

            //3rd paso)send message
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static void sendBienvenido(String para, String Nombres, String nombUsu, String clave) {
        final String user = "";//cambiará en consecuencia al servidor utilizado
        final String pass = "";

//1st paso) Obtener el objeto de sesión
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
            message.setSubject("Bienvenido Banco-Pedagogico");

            message.setContent(
                    "<center><img src='http://fs5.directupload.net/images/160530/khs5cmdc.jpg' title='Banco Pedagogico'></center>"
                    + "<h3> Bienvenido. "
                    + Nombres
                    + "</h3>"
                    + "Datos de Ingreso: "
                    + "<h4> Nombre Usuario : "
                    + nombUsu
                    + "</h4>"
                    + "<h4> Documento Usuario : "
                    + clave
                    + " </h4>", "text/html");

            //3rd paso)send message
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static void send(String para, String sujeto, String mensaje) {

        final String user = "";//cambiará en consecuencia al servidor utilizado
        final String pass = "";

//1st paso) Obtener el objeto de sesión
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
            message.setSubject(sujeto);
            message.setContent(mensaje, "text/html;");
            //3rd paso)send message
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
    
}
