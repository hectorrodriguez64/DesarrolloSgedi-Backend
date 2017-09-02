/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "email_app")
public class EmailApp implements Serializable {


    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "email_app")
    private String emailApp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password_email_app")
    private String passwordEmailApp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description_email_app")
    private String descriptionEmailApp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "hostname_email_app")
    private String hostnameEmailApp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "smtp_port")
    private int smtpPort;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_autentication")
    private boolean isAutentication;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_ssl")
    private boolean isSsl;

    public EmailApp() {
    }

    public EmailApp(String id) {
        this.id = id;
    }

    public EmailApp(String id, String emailApp, String passwordEmailApp, String descriptionEmailApp, String hostnameEmailApp, boolean estado, int smtpPort, boolean isAutentication, boolean isSsl) {
        this.id = id;
        this.emailApp = emailApp;
        this.passwordEmailApp = passwordEmailApp;
        this.descriptionEmailApp = descriptionEmailApp;
        this.hostnameEmailApp = hostnameEmailApp;
        this.estado = estado;
        this.smtpPort = smtpPort;
        this.isAutentication = isAutentication;
        this.isSsl = isSsl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailApp() {
        return emailApp;
    }

    public void setEmailApp(String emailApp) {
        this.emailApp = emailApp;
    }

    public String getPasswordEmailApp() {
        return passwordEmailApp;
    }

    public void setPasswordEmailApp(String passwordEmailApp) {
        this.passwordEmailApp = passwordEmailApp;
    }

    public String getDescriptionEmailApp() {
        return descriptionEmailApp;
    }

    public void setDescriptionEmailApp(String descriptionEmailApp) {
        this.descriptionEmailApp = descriptionEmailApp;
    }

    public String getHostnameEmailApp() {
        return hostnameEmailApp;
    }

    public void setHostnameEmailApp(String hostnameEmailApp) {
        this.hostnameEmailApp = hostnameEmailApp;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public boolean getIsAutentication() {
        return isAutentication;
    }

    public void setIsAutentication(boolean isAutentication) {
        this.isAutentication = isAutentication;
    }

    public boolean getIsSsl() {
        return isSsl;
    }

    public void setIsSsl(boolean isSsl) {
        this.isSsl = isSsl;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.EmailApp[ id=" + id + " ]";
    }
    
}
