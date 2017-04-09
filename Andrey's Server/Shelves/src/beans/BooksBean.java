package beans;

import entities.BooksEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by adaico on 26.03.17.
 */
public class BooksBean {
    static private EntityManagerFactory emf;

    public BooksBean(EntityManagerFactory emf) {
        this.emf = emf;
    }

    static EntityManager getEM() {
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public List<BooksEntity> getAllElements() {
        return getEM().createQuery("SELECT c FROM BooksEntity c").getResultList();
    }

    public BooksEntity getElement(int bookId) {
        Query result = getEM().createQuery("SELECT c FROM BooksEntity c WHERE c.bookId = :bookId").setParameter("bookId", bookId);
        BooksEntity book = (BooksEntity) result.getSingleResult();
        return book;
    }



//    public List<Object> setElements() {
//
//    }

//    public static void main(String[] args) {
//        BooksBean bb = new BooksBean();
//        System.out.print(bb.getAllElements().toString());
//    }
}
