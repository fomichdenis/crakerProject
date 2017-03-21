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
@Table(name="objectsTypes")
@Entity
public class ObjectTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
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
  


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objectTypeId != null ? objectTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjectTypes)) {
            return false;
        }
        ObjectTypes other = (ObjectTypes) object;
        if ((this.objectTypeId == null && other.objectTypeId != null) || (this.objectTypeId != null && !this.objectTypeId.equals(other.objectTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ent.ObjectTypes[ id=" + objectTypeId + " ]";
    }
    
}
