/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author fomichdenis
 */
@ViewScoped @ManagedBean
public class AuthorsEditBean implements Serializable  {
    private Long authorId;
    private String authorName;
    private String authorSurname;
    private Long yearBirthday;
    private Long deathYear;
    private String information;

    public void setDeathYear(Long deathYear) {
        this.deathYear = deathYear;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Long getDeathYear() {
        return deathYear;
    }

    public String getInformation() {
        return information;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public Long getYearBirthday() {
        return yearBirthday;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public void setYearBirthday(Long yearBirthday) {
        this.yearBirthday = yearBirthday;
    }
}
