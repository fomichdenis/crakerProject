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
@Entity  @Table(name="attribute_object_types")
public class AttributeObjectType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
  private Long objectTypeID;
    @Id
  private Long attributeID;
  private String description;
    
    public Long getObjectsTypeID() {
        return objectTypeID;
    }

    public void setObjectsTypeID(Long objectTypeID) {
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
   
   

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objectTypeID != null ? objectTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttributeObjectType)) {
            return false;
        }
        AttributeObjectType other = (AttributeObjectType) object;
        if ((this.objectTypeID == null && other.objectTypeID != null) || (this.objectTypeID != null && !this.objectTypeID.equals(other.objectTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ent.AttributeObjectTypes[ id=" + objectTypeID + " ]";
    }
    
}
