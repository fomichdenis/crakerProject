package entities;

import javax.persistence.*;

/**
 * Created by adaico on 05.04.17.
 */
@Entity
@Table(name = "myInfo", schema = "Shelves")
public class UsersEntity {
    private int myId;
    private String myLogin;
    private String myName;
    private String mySex;
    private String mySketch;
    private String myBooks;

    @Id
    @Column(name = "myId", nullable = false)
    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    @Basic
    @Column(name = "myLogin", nullable = false, length = 45)
    public String getMyLogin() {
        return myLogin;
    }

    public void setMyLogin(String myLogin) {
        this.myLogin = myLogin;
    }

    @Basic
    @Column(name = "myName", nullable = false, length = 45)
    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    @Basic
    @Column(name = "mySex", nullable = true, length = 45)
    public String getMySex() {
        return mySex;
    }

    public void setMySex(String mySex) {
        this.mySex = mySex;
    }

    @Basic
    @Column(name = "mySketch", nullable = true, length = 100)
    public String getMySketch() {
        return mySketch;
    }

    public void setMySketch(String mySketch) {
        this.mySketch = mySketch;
    }

    @Basic
    @Column(name = "myBooks", nullable = true, length = 200)
    public String getMyBooks() {
        return myBooks;
    }

    public void setMyBooks(String myBooks) {
        this.myBooks = myBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (myId != that.myId) return false;
        if (myLogin != null ? !myLogin.equals(that.myLogin) : that.myLogin != null) return false;
        if (myName != null ? !myName.equals(that.myName) : that.myName != null) return false;
        if (mySex != null ? !mySex.equals(that.mySex) : that.mySex != null) return false;
        if (mySketch != null ? !mySketch.equals(that.mySketch) : that.mySketch != null) return false;
        if (myBooks != null ? !myBooks.equals(that.myBooks) : that.myBooks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = myId;
        result = 31 * result + (myLogin != null ? myLogin.hashCode() : 0);
        result = 31 * result + (myName != null ? myName.hashCode() : 0);
        result = 31 * result + (mySex != null ? mySex.hashCode() : 0);
        result = 31 * result + (mySketch != null ? mySketch.hashCode() : 0);
        result = 31 * result + (myBooks != null ? myBooks.hashCode() : 0);
        return result;
    }
}
