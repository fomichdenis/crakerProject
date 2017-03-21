package beans;

import Ent.AttributeObjectTypes;
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

    public List<AttributeObjectTypes> getAttributeObjectTypes() {
        return em.createQuery("Attribute Object Types", AttributeObjectTypes.class).getResultList();
    }

    public void deleteAttributeObjectTypes(String cId) {
        if (cId == null) {
            return;
        }
        try {
            utx.begin();
           AttributeObjectTypes c = em.find(AttributeObjectTypes.class, cId);
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
    
    public void createAttributes(AttributeObjectTypesEditBean A){
        if (A == null || A.getObjectTypeID() == null) {     
            return;
        }
        try {
            utx.begin();
            AttributeObjectTypes a = new AttributeObjectTypes();
            a.setAttributeID(A.getAttributeID());
            a.setDescription(A.getDescription());
            a.setObjectTypeID(a.getObjectTypeID());
            
//  private Long id;
//  private Long objectTypeID;
//  private Long attributeID;
//  private String description;
            
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