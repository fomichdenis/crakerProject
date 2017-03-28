package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ViewScoped @ManagedBean
public class AttributeObjectTypesEditBean implements Serializable {
   

  private Long objectTypeID;
  private Long attributeID;
  private String description;

    public Long getObjectTypeID() {
        return objectTypeID;
    }

    public void setObjectTypeID(Long objectTypeID) {
        this.objectTypeID = objectTypeID;
    }

    public Long getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(Long attributeID) {
        this.attributeID = attributeID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
  
  
    

}
