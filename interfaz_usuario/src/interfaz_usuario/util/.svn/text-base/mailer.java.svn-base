/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package interfaz_usuario.util;

/**
 *
 * @author Marco-PC
 */
//import javax.activation.*;
import enlace_datos.util.resulOp;



import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

 public class mailer {

     public mailer() {
     }

     
     public static void SendMail(String from, String to, String toCC, String toBCC, String asunto, String cuerpo, boolean isAuth) {
         
         Address[] listaToCC = getRecipients(toCC); // si toCC es mas de un correo, deben venir separados por comas
         Address[] listaToBCC = getRecipients(toBCC); // si toBCC es mas de un correo, deben venir separados por comas
         Properties prop = new Properties();
         prop.put("mail.smtp.host", "mail.usac.edu.gt");                
         //prop.put("mail.smtp.localhost", "siif.usac.edu.gt"); // Descomentar para pruebas
         Session session = null;
         
         //para la autenticacion
         if(isAuth){
             prop.put("mail.smtp.auth", "true");
             SMTPAuthentication auth = new SMTPAuthentication();
             session = Session.getInstance(prop, auth);
         }
         else{
             session = Session.getInstance(prop);
         }
         
         try {
             
             Message msg = getMessage(session, from, to, listaToCC, listaToBCC, cuerpo, asunto);
             Transport.send(msg);
             utils.setADFMensaje(new resulOp(resulOp.OPE_OK,"Se ha enviado un correo electrónico para notificar a los interesados"));
         } catch (Exception e) {
             utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,e.getMessage()));
         }
     }
     
     private static Address[] getRecipients(String correos){
         Address[] listaToCC = null;
         if(correos.trim().length()>0){
             String listaCC[] = correos.split(",");
             int cantMailCC = listaCC.length;
             listaToCC = new Address[cantMailCC];
             for (int i = 0; i < cantMailCC; i++) {
                 try {
                     listaToCC[i] = new InternetAddress(listaCC[i]);
                 } catch (AddressException ex) {
                     ex.printStackTrace();
                 }
             }
         }        
         return listaToCC;
     }

     // metodo q recibe los parametros from, to, texto, asunto... la sesion viene de la autenticacion
     private static MimeMessage getMessage(Session session, String from, String to, Address[] toCC, Address[] listaToBCC, String ntexto, String asunto) {

         try {

             MimeMessage msg = new MimeMessage(session);
             msg.setSubject(asunto);
             msg.setText(ntexto);
             msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
             msg.addRecipients(Message.RecipientType.CC, toCC);
             msg.addRecipients(Message.RecipientType.BCC, listaToBCC);
             msg.setFrom(new InternetAddress(from, from));
             return msg;

         } catch (java.io.UnsupportedEncodingException ex) {

             utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,ex.getMessage()));
             return null;

         } catch (MessagingException ex) {

             utils.setADFMensaje(new resulOp(resulOp.OPE_WARN,ex.getMessage()));
             return null;

         }

     }

 }

class SMTPAuthentication extends javax.mail.Authenticator {

    public PasswordAuthentication getPasswordAuthentication() {
        String username = "notificacionsiif@usac.edu.gt";
        String password = "Reintegro2016.";

        return new PasswordAuthentication(username, password);

    }

}

