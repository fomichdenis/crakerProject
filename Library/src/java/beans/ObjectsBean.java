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
        return em.createQuery("select o from objects o", Objects.class).getResultList();
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
            co.setName(newC.getName());
            co.setObjectsId(newC.getObjectsId());
            co.setObjectsTypeId(newC.getObjectsTypeId());
            co.setDescription(newC.getDescription());            
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
    
    public void createObjects(Objects newC){
        if (newC == null || newC.getObjectsId() == null) {     
            return;
        }
        try {
            utx.begin();
            Objects co = new Objects();
            co.setName(newC.getName());
            co.setObjectsId(newC.getObjectsId());
            co.setObjectsTypeId(newC.getObjectsTypeId());
            co.setDescription(newC.getDescription());            
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
    
    public void createObjects(Long objectId, String name, Long objectsTypeId, String description){
        if (objectId == null || objectsTypeId == null) {     
            return;
        }
        try {
            utx.begin();
            Objects co = new Objects();
            co.setName(name);
            co.setObjectsId(objectId);
            co.setObjectsTypeId(objectsTypeId);
            co.setDescription(description);            
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
    
    public Objects getObjects(Long objectId) {
        return em.createQuery("select o from objects o where o.objectId = " + objectId, Objects.class).getSingleResult();
    }
    
    
}