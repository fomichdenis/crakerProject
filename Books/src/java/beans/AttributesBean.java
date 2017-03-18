package beans;

import Ent.Attributes;
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
public class AttributesBean implements Serializable {

    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<Attributes> getAttributes() {
        return em.createQuery("select c from Country c", Attributes.class).getResultList();
    }

    public void deleteAttributes(String cId) {
        if (cId == null) {
            return;
        }
        try {
            utx.begin();
           Attributes c = em.find(Attributes.class, cId);
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
    
    public void createAttributes(AttributesEditBean A){
        if (A == null || A.getAttributeId() == null) {     
            return;
        }
        try {
            utx.begin();
            Attributes a = new Attributes();
            a.setAttributeId(A.getAttributeId());
            a.setAttributeTypeId(A.getAttributeTypeId());
            a.setDescription(A.getDescription());
            a.setProperties(A.getProperties());
            a.setName(A.getName());
            a.setId(A.getId());
            
//    private Long id;
//    private Long attributeId; 
//    private Long AttributeTypeId; 
//    private String name; 
//    private String description; 
//    private String properties; 
            
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