/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "retention_tables")
@XmlRootElement

public class RetentionTables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sub_serie")
    private String subSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "document_type")
    private String documentType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "total_conservation")
    private String totalConservation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "procediments")
    private String procediments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRetentionTables")
    private List<Alerts> alertsList;

    public RetentionTables() {
    }

    public RetentionTables(Integer id) {
        this.id = id;
    }

    public RetentionTables(Integer id, String serie, String subSerie, String documentType, Date date, String totalConservation, String procediments) {
        this.id = id;
        this.serie = serie;
        this.subSerie = subSerie;
        this.documentType = documentType;
        this.date = date;
        this.totalConservation = totalConservation;
        this.procediments = procediments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSubSerie() {
        return subSerie;
    }

    public void setSubSerie(String subSerie) {
        this.subSerie = subSerie;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTotalConservation() {
        return totalConservation;
    }

    public void setTotalConservation(String totalConservation) {
        this.totalConservation = totalConservation;
    }

    public String getProcediments() {
        return procediments;
    }

    public void setProcediments(String procediments) {
        this.procediments = procediments;
    }

    @XmlTransient
    public List<Alerts> getAlertsList() {
        return alertsList;
    }

    public void setAlertsList(List<Alerts> alertsList) {
        this.alertsList = alertsList;
    }

   

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.RetentionTables[ id=" + id + " ]";
    }
    
}
