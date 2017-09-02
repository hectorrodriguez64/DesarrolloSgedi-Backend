/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "alerts")
@XmlRootElement

public class Alerts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @JoinColumn(name = "id_state", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private State idState;
    @JoinColumn(name = "id_documents", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Documents idDocuments;
    @JoinColumn(name = "id_retention_tables", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RetentionTables idRetentionTables;

    public Alerts() {
    }

    public Alerts(Integer id) {
        this.id = id;
    }

    public Alerts(Integer id, Date dateStart, Date dateEnd) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public State getIdState() {
        return idState;
    }

    public void setIdState(State idState) {
        this.idState = idState;
    }

    public Documents getIdDocuments() {
        return idDocuments;
    }

    public void setIdDocuments(Documents idDocuments) {
        this.idDocuments = idDocuments;
    }

    public RetentionTables getIdRetentionTables() {
        return idRetentionTables;
    }

    public void setIdRetentionTables(RetentionTables idRetentionTables) {
        this.idRetentionTables = idRetentionTables;
    }

   

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Alerts[ id=" + id + " ]";
    }
    
}
