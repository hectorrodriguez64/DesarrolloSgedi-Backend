/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Cities;
import co.edu.sena.adsi.jpa.entities.Cities_;
import co.edu.sena.adsi.jpa.entities.Departaments;
import co.edu.sena.adsi.jpa.entities.DocumentsType;
import co.edu.sena.adsi.jpa.entities.Users;
import co.edu.sena.adsi.jpa.entities.Users_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.w3c.dom.DocumentType;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "co.edu.sena_Dsgedi1_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    public Users findUsersByEmail(String email) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> users = cq.from(Users.class);
        cq.where(cb.equal(users.get(Users_.email), email));
        TypedQuery<Users> q = getEntityManager().createQuery(cq);
        try {
            return (Users) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    /**
     * Busca usuario por numDocumento
     *
     * @param numDocument
     * @return Usuario
     */
    public Users findUsersByNumDocument(String numDocument) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> users = cq.from(Users.class);
        cq.where(cb.equal(users.get(Users_.numDocument), numDocument));
        TypedQuery<Users> q = getEntityManager().createQuery(cq);
        try {
            return (Users) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
public List<Users> findUsers(Integer idUsers, String sex, Boolean activo,
            String numDocument, String email, Integer idCities, Integer idDepartament,
            Integer idDocument_Type){
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> usuario = cq.from(Users.class);
        
        Predicate data = cb.conjunction();
        
        if(idUsers != null){
            data = cb.and(data, cb.equal(usuario.get(Users_.id), idUsers));
        }
        
        if(sex != null){
            data = cb.and(data, cb.equal(usuario.get(Users_.sex), sex));
        }
        
        if(activo != null){
            data = cb.and(data, cb.equal(usuario.get(Users_.active), activo));
        }
        
        if(numDocument != null){
            data = cb.and(data, cb.equal(usuario.get(Users_.numDocument), numDocument));
        }
        
        if(email != null){
            data = cb.and(data, cb.equal(usuario.get(Users_.email), email));
        }
        
        if(idCities != null){
            data = cb.and(data, cb.equal(usuario.get(Users_.idCities), new Cities(idCities)));
        }
        
        if(idDepartament != null){
            Join<Users, Cities> joinCiudad = usuario.join(Users_.idCities);
            data = cb.and(data, cb.equal(joinCiudad.get(Cities_.idDepartaments), new Departaments(idDepartament)));
        }
        
        if(idDocument_Type != null){
            data = cb.and(data, cb.equal(usuario.get(Users_.idDocumentsType), new DocumentsType(idDocument_Type)));
        }
        
        cq.where(data);
        cq.orderBy(cb.asc(usuario.get(Users_.lastName)));
        TypedQuery<Users> tq = em.createQuery(cq);
        
        try {
            return tq.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    
}
