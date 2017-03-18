package beans;

import Ent.Objects;
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


@ManagedBean
@ViewScoped
public class ObjectsBean implements Serializable {

    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<Objects> getObjects() {
        return em.createQuery("select c from Country c", Objects.class).getResultList();
    }

    public void deleteObjects(String cId) {
        if (cId == null) {
            return;
        }
        try {
            utx.begin();
            Objects c = em.find(Objects.class, cId);
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
    
    public void createObjects(ObjectsEditBean newC){
        if (newC == null || newC.getObjectsId() == null) {     
            return;
        }
        try {
            utx.begin();
            Objects co = new Objects();
            co.setId(newC.getId());
            co.setName(newC.getName());
            co.setObjectId(newC.getObjectsId());
            co.setObjectTypeId(newC.getObjectsTypeId());
            
//private Long id;
//private Long objectId;
//private String name; 
//private String description; 
//private Long objectTypeId; 
            
            if(co!= null) {
                em.persist(co);
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