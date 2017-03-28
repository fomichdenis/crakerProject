package beans;



import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped @ManagedBean
public class ObjectsEditBean implements Serializable {
   
private Long objectId;
private String name; 
private String description; 
private Long objectTypeId; 


    public Long getObjectsId() {
        return objectId;
    }

    public void setObjectsId(Long objectId) {
        this.objectId = objectId;
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

    public Long getObjectsTypeId() {
        return objectTypeId;
    }

    public void setObjectsTypeId(Long objectTypeId) {
        this.objectTypeId = objectTypeId;
    }
    
}