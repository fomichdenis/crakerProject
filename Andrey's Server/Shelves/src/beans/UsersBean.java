package beans;

import entities.BooksEntity;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * Created by adaico on 05.04.17.
 */
public class UsersBean {
    static private EntityManagerFactory emf;

    public UsersBean(EntityManagerFactory emf) {
        this.emf = emf;
    }

    static EntityManager getEM() {
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public UsersEntity getElement(int userId) {
        Query result = getEM().createQuery("SELECT c FROM UsersEntity c WHERE c.myId = :userId").setParameter("userId", userId);
        UsersEntity user = (UsersEntity) result.getSingleResult();
        return user;
    }
}
