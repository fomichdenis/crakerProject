/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Users;
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
public class UsersBean implements Serializable {
    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<Users> getUsers() {
        return em.createQuery("select u from Users u", Users.class).getResultList();
    }
    
    public Users getUserById(String id) {
        return em.createQuery("select u from Users u where u.userId = " + id, Users.class).getSingleResult();
    }

    public void deleteUser(String uId) {
        if (uId == null) {
            return;
        }
        try {
            utx.begin();
            Users a = em.find(Users.class, new Long(uId));
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
    
    public void createUser(UsersEditBean newU){
        if (newU == null || newU.getUserId() == null) {     
            return;
        }
        try {
            utx.begin();
            Users user = new Users();
            user.setUserId(newU.getUserId());
            user.setUserName(newU.getUserName());
            user.setUserSurname(newU.getUserSurname());
            user.setPassword(newU.getPassword());
            user.setLogin(newU.getLogin());
            user.setSex(newU.getSex());
            user.setInformation(newU.getInformation());
            if(user != null) {
                em.persist(user);
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
    
    public void createUser(Long id, String name, String surname, String password, String login, Long sex, String information){
        if (id == null) {     
            return;
        }
        try {
            utx.begin();
            Users user = new Users();
            user.setUserId(id);
            user.setUserName(name);
            user.setUserSurname(surname);
            user.setPassword(password);
            user.setLogin(login);
            user.setSex(sex);
            user.setInformation(information);
            if(user != null) {
                em.persist(user);
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
