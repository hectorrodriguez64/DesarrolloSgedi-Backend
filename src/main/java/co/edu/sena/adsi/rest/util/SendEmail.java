 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.util;

import co.edu.sena.adsi.jpa.entities.EmailApp;
import co.edu.sena.adsi.jpa.entities.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author adsi1261718
 */
public class SendEmail {
    /**
     * Envia email al usuario en el momento del registro
     * @param configEmail
     * @param users
     * @param passwordAsignada 
     */
    public void sendEmailRegistroUsuario(EmailApp configEmail, Users users, String passwordAsignada) {
        try {

            HtmlEmail email = new HtmlEmail();
            email.setHostName(configEmail.getHostnameEmailApp());
            email.setSmtpPort(configEmail.getSmtpPort());
            email.setAuthenticator(new DefaultAuthenticator(configEmail.getEmailApp(), configEmail.getPasswordEmailApp()));
            if (configEmail.getIsAutentication()) {
                email.setAuthentication(configEmail.getEmailApp(), configEmail.getPasswordEmailApp());
            }
            email.setSSLOnConnect(configEmail.getIsSsl());
            email.setFrom(configEmail.getEmailApp());
            email.setCharset("UTF-8");
            email.setSubject("Bienvenido al ADSI.");

            StringBuilder sb = new StringBuilder();
            sb.append("<div><h1>Bienvenido al ADSI</h1>");
            sb.append("<h3 style='display:inline-block'>Email: </h3>");
            sb.append(users.getEmail());
            sb.append("    <h3 style='display:inline-block'>Password: </h3>");
            sb.append(passwordAsignada);
            sb.append("    <h3 style='display:inline-block'>Número de Identificación: </h3>");
            sb.append(users.getNumDocument());
            sb.append("    <h3 style='display:inline-block'>Nombres: </h3>");
            sb.append(users.getName());
            sb.append("    <h3 style='display:inline-block'>Apellidos: </h3>");
            sb.append(users.getLastName());
            sb.append("<p>Agradecemos su registro.</p>");
           
            email.setHtmlMsg(sb.toString());

            email.addTo(users.getEmail());
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
