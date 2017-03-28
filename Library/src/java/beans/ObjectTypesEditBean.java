package beans;



import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ViewScoped @ManagedBean
public class ObjectTypesEditBean implements Serializable {
   
private Long objectTypeId ;
private String name ;
private String description;


    public Long getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Long objectTypeId) {
        this.objectTypeId = objectTypeId;
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
    
}