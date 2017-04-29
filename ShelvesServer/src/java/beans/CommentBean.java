/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import ent.Comments;
import javax.ejb.Local;



/**
 *
 * @author fomichdenis
 */
@ManagedBean
@ViewScoped
//@Local
public class CommentBean {
    
    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<Comments> getComments() {
        return em.createQuery("select c from Comments c", Comments.class).getResultList();
    }
    
    public Comments getCommentById(String id) {
        return em.createQuery("select c from Comments c where c.commentId = " + id, Comments.class).getSingleResult();
    }

    public void deleteComment(String cId) {
        if (cId == null) {
            return;
        }
        try {
            utx.begin();
            Comments c = em.find(Comments.class, cId);
            if(c!= null) {
                em.remove(c);
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
    
    public void createComment(CommentEditBean com){
        if (com == null || com.getCommentId() == null) {     
            return;
        }
        try {
            utx.begin();
            Comments c = new Comments();
            c.setCommentId(com.getCommentId());
            c.setBookId(com.getBookId());
            c.setUserId(com.getUserId());     
            c.setDate(com.getDate()); 
            c.setLikes(com.getLikes()); 
            c.setDislike(com.getDislike()); 
            c.setText(com.getText());
            if(c!= null) {
                em.persist(c);
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
    public void createComment(Long id, Long bookId, Long userId, String date, Long likes, Long dislike, String text){
        if (id == null || userId == null || bookId == null) {     
            return;
        }
        try {
            utx.begin();
            Comments c = new Comments();
            c.setCommentId(id);
            c.setBookId(bookId);
            c.setUserId(userId);     
            c.setDate(date); 
            c.setLikes(likes); 
            c.setDislike(dislike); 
            c.setText(text);
            if(c!= null) {
                em.persist(c);
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
