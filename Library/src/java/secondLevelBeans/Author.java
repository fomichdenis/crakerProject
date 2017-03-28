/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondLevelBeans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author fomichdenis
 */
@Entity
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;
    private Long birthdayYear;
    private Long deathYear;
    private String information;
    private String name;
    private String surname;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getBirthdayYear() {
        return birthdayYear;
    }

    public Long getDeathYear() {
        return deathYear;
    }

    public String getInformation() {
        return information;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setBirthdayYear(Long birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public void setDeathYear(Long deathYear) {
        this.deathYear = deathYear;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorId != null ? authorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authorId == null && other.authorId != null) || (this.authorId != null && !this.authorId.equals(other.authorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "secondLevelBeans.Author[ id=" + authorId + " ]";
    }
    
}
