/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fomichdenis
 */
@Entity
@Table(name = "AUTHORS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a")
    , @NamedQuery(name = "Authors.findByAuthorid", query = "SELECT a FROM Authors a WHERE a.authorid = :authorid")
    , @NamedQuery(name = "Authors.findByAuthorname", query = "SELECT a FROM Authors a WHERE a.authorname = :authorname")
    , @NamedQuery(name = "Authors.findByAuthorsurname", query = "SELECT a FROM Authors a WHERE a.authorsurname = :authorsurname")
    , @NamedQuery(name = "Authors.findByDeathyear", query = "SELECT a FROM Authors a WHERE a.deathyear = :deathyear")
    , @NamedQuery(name = "Authors.findByInformation", query = "SELECT a FROM Authors a WHERE a.information = :information")
    , @NamedQuery(name = "Authors.findByYearbirthday", query = "SELECT a FROM Authors a WHERE a.yearbirthday = :yearbirthday")})
public class Authors implements Serializable {

    @Column(name = "DEATHYEAR")
    private Long deathyear;
    @Column(name = "YEARBIRTHDAY")
    private Long yearbirthday;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTHORID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorid;
    @Size(max = 255)
    @Column(name = "AUTHORNAME")
    private String authorname;
    @Size(max = 255)
    @Column(name = "AUTHORSURNAME")
    private String authorsurname;
    @Size(max = 255)
    @Column(name = "INFORMATION")
    private String information;

    public Authors() {
    }

    public Authors(Long authorid) {
        this.authorid = authorid;
    }

    public Long getAuthorId() {
        return authorid;
    }

    public void setAuthorId(Long authorid) {
        this.authorid = authorid;
    }

    public String getAuthorName() {
        return authorname;
    }

    public void setAuthorName(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthorSurname() {
        return authorsurname;
    }

    public void setAuthorSurname(String authorsurname) {
        this.authorsurname = authorsurname;
    }


    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorid != null ? authorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authors)) {
            return false;
        }
        Authors other = (Authors) object;
        if ((this.authorid == null && other.authorid != null) || (this.authorid != null && !this.authorid.equals(other.authorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webServ2.service.Authors[ authorid=" + authorid + " ]";
    }

    public Long getDeathYear() {
        return deathyear;
    }

    public void setDeathYear(Long deathyear) {
        this.deathyear = deathyear;
    }

    public Long getYearBirthday() {
        return yearbirthday;
    }

    public void setYearBirthday(Long yearbirthday) {
        this.yearbirthday = yearbirthday;
    }
    
}
