/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ent.Books;
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
import javax.ejb.Stateless;

/**
 *
 * @author fomichdenis
 */
@ManagedBean
@ViewScoped
@Stateless
public class BooksBean implements Serializable {
    
    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    //@Override
    public List<Books> getBooks() {
        return em.createQuery("select b from Books b", Books.class).getResultList();
    }
    
    //@Override
    public Books getBookById(String id) {
        return em.createQuery("select b from Books b where b.bookId = " + id, Books.class).getSingleResult();
    }

    //@Override
    public void deleteBook(String bId) {
        if (bId == null) {
            return;
        }
        try {
            utx.begin();
            Books a = em.find(Books.class, new Long(bId));
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
    
    //@Override
    public void createBook(BooksEditBean newB){
        if (newB == null || newB.getBookId() == null) {     
            return;
            
        }
        try {
            utx.begin();
            Books book = new Books();
            book.setBookId(newB.getBookId());
            book.setBookName(newB.getBookName());
            book.setAuthorId(newB.getAuthorId());
            book.setAnnotation(newB.getAnnotation());
            book.setDate(newB.getDate());
            book.setSeries(newB.getSeries());
            book.setSeriesNumber(newB.getSeriesNumber());
            if(book != null) {
                em.persist(book);
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
    
    //@Override
    public void createBook(Long bookId, Long auhorId, String bookName, String annot, Long date, String series, Long seriesNumber){
        if (bookId == null) {     
            return;
            
        }
        try {
            utx.begin();
            Books book = new Books();
            book.setBookId(bookId);
            book.setBookName(bookName);
            book.setAuthorId(auhorId);
            book.setAnnotation(annot);
            book.setDate(date);
            book.setSeries(series);
            book.setSeriesNumber(seriesNumber);
            if(book != null) {
                em.persist(book);
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
