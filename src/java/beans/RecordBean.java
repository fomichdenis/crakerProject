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
import ent.Records;
import javax.ejb.Local;

/**
 *
 * @author fomichdenis
 */

@ManagedBean
@ViewScoped
//@Local
public class RecordBean {
    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<Records> getRecords() {
        return em.createQuery("select r from Records r", Records.class).getResultList();
    }
    
    public Records getRecordById(String id) {
        return em.createQuery("select r from Records r where r.recordId = " + id, Records.class).getSingleResult();
    }

    public void deleteRecord(String rId) {
        if (rId == null) {
            return;
        }
        try {
            utx.begin();
            Records r = em.find(Records.class, rId);
            if(r!= null) {
                em.remove(r);
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
    
    public void createRecord(RecordEditBean rec){
        if (rec == null || rec.getRecordId() == null) {     
            return;
        }
        try {
            utx.begin();
            Records r = new Records();
            r.setRecordId(rec.getRecordId());
            r.setUserId(rec.getUserId());
            r.setBookId(rec.getBookId());     
            r.setRate(rec.getRate()); 
            r.setDate(rec.getDate()); 
            r.setText(rec.getText()); 
            r.setProgress(rec.getProgress());
            r.setStatus(rec.getStatus());
            if(r!= null) {
                em.persist(r);
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
    
    public void createRecord(Long id, Long userId, Long bookId, Long rate, String date, String text, Long status, Long progress){
        if (id == null || userId == null || bookId == null) {     
            return;
        }
        try {
            utx.begin();
            Records r = new Records();
            r.setRecordId(id);
            r.setUserId(userId);
            r.setBookId(bookId);     
            r.setRate(rate); 
            r.setDate(date); 
            r.setText(text); 
            r.setProgress(progress);
            r.setStatus(status);
            if(r!= null) {
                em.persist(r);
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
