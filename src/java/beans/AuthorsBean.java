/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Authors;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ejb.Local;

/**
 *
 * @author fomichdenis
 */
@ManagedBean
@ViewScoped
//@Local
public class AuthorsBean implements Serializable {
    
    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<Authors> getAuthors() {
        return em.createQuery("select a from Authors a", Authors.class).getResultList();
    }
    
    public Authors getAuthorById(String id) {
        return em.createQuery("select a from Authors a where a.authorId = " + id, Authors.class).getSingleResult();
    }

    public void deleteAuthor(String aId) {
        if (aId == null) {
            return;
        }
        try {
            utx.begin();
            Authors a = em.find(Authors.class, new Long(aId));
            if(a!= null) {
                em.remove(a);
            }
            
            utx.commit();
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "DB Error:", ex.getLocalizedMessage()));
            ex.printStackTrace(System.err);
            try {
                utx.rollback();
            } catch (Exception exc) {
                exc.printStackTrace(System.err);
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "DB Error:", exc.getLocalizedMessage()));
            }
        }
    }
    
    public void createAuthor(AuthorsEditBean newA){
        if (newA == null || newA.getAuthorId() == null) {     
            return;
        }
        try {
            utx.begin();
            Authors ath = new Authors();
            ath.setAuthorId(newA.getAuthorId());
            ath.setAuthorName(newA.getAuthorName());
            ath.setAuthorSurname(newA.getAuthorSurname());
            ath.setYearBirthday(newA.getYearBirthday());
            ath.setDeathYear(newA.getDeathYear());
            ath.setInformation(newA.getInformation());
            if(ath!= null) {
                em.persist(ath);
            }
            
            utx.commit();
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "DB Error:", ex.getLocalizedMessage()));
            ex.printStackTrace(System.err);
            try {
                utx.rollback();
            } catch (Exception exc) {              
                exc.printStackTrace(System.err);
            }
        }
    }
    
    public void createAuthor(Long id, String name, String surname, Long yearB, Long yearD, String information){
        if (id == null) {     
            return;
        }
        try {
            utx.begin();
            Authors ath = new Authors();
            ath.setAuthorId(id);
            ath.setAuthorName(name);
            ath.setAuthorSurname(surname);
            ath.setYearBirthday(yearB);
            ath.setDeathYear(yearD);
            ath.setInformation(information);
            if(ath!= null) {
                em.persist(ath);
            }
            
            utx.commit();
        } catch (Exception ex) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "DB Error:", ex.getLocalizedMessage()));
            ex.printStackTrace(System.err);
            try {
                utx.rollback();
            } catch (Exception exc) {              
                exc.printStackTrace(System.err);
            }
        }
    }
}
