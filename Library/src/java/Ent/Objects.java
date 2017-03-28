/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ent;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author USSR
 */
@Entity  @Table(name="objects")
public class Objects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objectId != null ? objectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objects)) {
            return false;
        }
        Objects other = (Objects) object;
        if ((this.objectId == null && other.objectId != null) || (this.objectId != null && !this.objectId.equals(other.objectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ent.Objects[ id=" + objectId + " ]";
    }
    
}
