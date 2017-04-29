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
public class UsersEditBean implements Serializable {
    private Long userId;
    private String userName;
    private String userSurname;
    private String login;
    private String email;
    private String information;
    private Long sex;

    public void setInformation(String information) {
        this.information = information;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getInformation() {
        return information;
    }

    public Long getSex() {
        return sex;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

}
