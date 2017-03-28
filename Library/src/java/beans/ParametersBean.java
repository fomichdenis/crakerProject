package beans;



import Ent.Parameter;
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
public class ParametersBean implements Serializable {

    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction utx;

    public List<Parameter> getParameters() {
        return em.createQuery("select p from parameters p", Parameter.class).getResultList();
    }

    public void deleteParameter(String cId) {
        if (cId == null) {
            return;
        }
        try {
            utx.begin();
           Parameter c = em.find(Parameter.class, cId);
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
    
    public void createParameter(ParametersEditBean newC){
        if (newC == null || newC.getParamId() == null) {     
            return;
        }
        try {
            utx.begin();
            Parameter co = new Parameter();
            co.setAttributeId(newC.getAttributeId());
            co.setDate(newC.getDate());
            co.setNumValue(newC.getNumValue());
            co.setObjectId(newC.getObjectId());
            co.setParamId(newC.getParamId());
            co.setReferenceId(co.getReferenceId());
            co.setTextValue(co.getTextValue());          
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
    
    public void createParameter(Parameter newC){
        if (newC == null || newC.getParamId() == null) {     
            return;
        }
        try {
            utx.begin();
            Parameter co = new Parameter();
            co.setAttributeId(newC.getAttributeId());
            co.setDate(newC.getDate());
            co.setNumValue(newC.getNumValue());
            co.setObjectId(newC.getObjectId());
            co.setParamId(newC.getParamId());
            co.setReferenceId(co.getReferenceId());
            co.setTextValue(co.getTextValue());          
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
    
    public void createParameter(Long attributeId, String date, Long numValue, Long objectId, Long paramId, Long referenceId, String textValue){
        if (attributeId == null || objectId == null || paramId == null) {     
            return;
        }
        try {
            utx.begin();
            Parameter co = new Parameter();
            co.setAttributeId(attributeId);
            co.setDate(date);
            co.setNumValue(numValue);
            co.setObjectId(objectId);
            co.setParamId(paramId);
            co.setReferenceId(referenceId);
            co.setTextValue(textValue);          
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
    
    public Parameter getObjectParameter(Long objectId, Long attributeId) {
        return em.createQuery("select p from parameters p where p.objectId = " + objectId + "and p.attributeId = " + attributeId, Parameter.class).getSingleResult();
    }
    
    public List<Parameter> getObjectParameters(Long objectId) {
        return em.createQuery("select p from parameters p where p.objectId = " + objectId, Parameter.class).getResultList();
    }
    
}