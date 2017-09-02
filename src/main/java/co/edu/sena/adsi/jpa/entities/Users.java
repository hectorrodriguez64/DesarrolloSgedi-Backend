/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "users")
@XmlRootElement

public class Users implements Serializable {

  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "num_document")
    private String numDocument;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telephone")
    private int telephone;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "occupation")
    private String occupation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sex")
    private String sex;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    
    
    @JoinTable(name = "users_has_roles", joinColumns = {
        @JoinColumn(name = "id_roles", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_users", referencedColumnName = "id")})
    @ManyToMany
    private List<Roles> rolesList;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers")
    private List<Documents> documentsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers")
    private List<Formalities> formalitiesList;
    @JoinColumn(name = "id_cities", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cities idCities;
    @JoinColumn(name = "id_documents_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentsType idDocumentsType;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String lastName, String name, boolean active, String numDocument, int telephone, String sex, String email, String password) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.active = active;
        this.numDocument = numDocument;
        this.telephone = telephone;
        this.sex = sex;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getNumDocument() {
        return numDocument;
    }

    public void setNumDocument(String numDocument) {
        this.numDocument = numDocument;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @XmlTransient
    public List<Documents> getDocumentsList() {
        return documentsList;
    }

    public void setDocumentsList(List<Documents> documentsList) {
        this.documentsList = documentsList;
    }

    @XmlTransient
    public List<Formalities> getFormalitiesList() {
        return formalitiesList;
    }

    public void setFormalitiesList(List<Formalities> formalitiesList) {
        this.formalitiesList = formalitiesList;
    }

    public Cities getIdCities() {
        return idCities;
    }

    public void setIdCities(Cities idCities) {
        this.idCities = idCities;
    }

    public DocumentsType getIdDocumentsType() {
        return idDocumentsType;
    }

    public void setIdDocumentsType(DocumentsType idDocumentsType) {
        this.idDocumentsType = idDocumentsType;
    }

   

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Users[ id=" + id + " ]";
    }
    
}
