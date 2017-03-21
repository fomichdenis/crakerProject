package beans;

import Ent.ObjectTypes;
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
public class ObjectTypesBean implements Serializable {

    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<ObjectTypes> getObjectTypes() {
        return em.createQuery("Object Types", ObjectTypes.class).getResultList();
    }

    public void deleteObjectTypes(String cId) {
        if (cId == null) {
            return;
        }
        try {
            utx.begin();
           ObjectTypes c = em.find(ObjectTypes.class, cId);
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
    
    public void createObjectTypes(ObjectTypesEditBean newC){
        if (newC == null || newC.getObjectTypeId() == null) {     
            return;
        }
        try {
            utx.begin();
            ObjectTypes co = new ObjectTypes();
            co.setName(newC.getName());
            co.setDescription(newC.getDescription());
            co.setObjectTypeId(newC.getObjectTypeId());
//private Long id;
//   private Long objectTypeId ;
//   private String name ;
//   private String description;
            
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