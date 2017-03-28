package beans;



import Ent.AttributeObjectType;
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
public class AttributeObjectTypesBean implements Serializable {

    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<AttributeObjectType> getAttributeObjectTypes() {
        return em.createQuery("select aot attribute_object_types aot", AttributeObjectType.class).getResultList();
    }

    public void deleteAttributeObjectType(String cId) {
        if (cId == null) {
            return;
        }
        try {
            utx.begin();
           AttributeObjectType c = em.find(AttributeObjectType.class, cId);
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
    
    public void createAttributeObjectType(AttributeObjectTypesEditBean A){
        if (A == null || A.getObjectsTypeID() == null) {     
            return;
        }
        try {
            utx.begin();
            AttributeObjectType a = new AttributeObjectType();
            a.setAttributeID(A.getAttributeID());
            a.setDescription(A.getDescription());
            a.setObjectsTypeID(a.getObjectsTypeID());            
            if(a!= null) {
                em.persist(a);
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