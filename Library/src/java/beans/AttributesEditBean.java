package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ViewScoped @ManagedBean
public class AttributesEditBean implements Serializable {
   
private Long attributeId; 
private Long AttributeTypeId; 
private String name; 
private String description; 
private String properties; 



    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public Long getAttributeTypeId() {
        return AttributeTypeId;
    }

    public void setAttributeTypeId(Long AttributeTypeId) {
        this.AttributeTypeId = AttributeTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
    

}