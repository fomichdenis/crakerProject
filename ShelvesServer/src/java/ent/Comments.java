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
@Table(name = "COMMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c")
    , @NamedQuery(name = "Comments.findByCommentid", query = "SELECT c FROM Comments c WHERE c.commentid = :commentid")
    , @NamedQuery(name = "Comments.findByBookid", query = "SELECT c FROM Comments c WHERE c.bookid = :bookid")
    , @NamedQuery(name = "Comments.findByDate", query = "SELECT c FROM Comments c WHERE c.date = :date")
    , @NamedQuery(name = "Comments.findByDislike", query = "SELECT c FROM Comments c WHERE c.dislike = :dislike")
    , @NamedQuery(name = "Comments.findByLikes", query = "SELECT c FROM Comments c WHERE c.likes = :likes")
    , @NamedQuery(name = "Comments.findByText", query = "SELECT c FROM Comments c WHERE c.text = :text")
    , @NamedQuery(name = "Comments.findByUserid", query = "SELECT c FROM Comments c WHERE c.userid = :userid")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENTID")
    private Long commentid;
    @Column(name = "BOOKID")
    private Long bookid;
    @Size(max = 255)
    @Column(name = "DATE")
    private String date;
    @Column(name = "DISLIKE")
    private Long dislike;
    @Column(name = "LIKES")
    private Long likes;
    @Size(max = 255)
    @Column(name = "TEXT")
    private String text;
    @Column(name = "USERID")
    private Long userid;

    public Comments() {
    }

    public Comments(Long commentid) {
        this.commentid = commentid;
    }

    public Long getCommentId() {
        return commentid;
    }

    public void setCommentId(Long commentid) {
        this.commentid = commentid;
    }

    public Long getBookId() {
        return bookid;
    }

    public void setBookId(Long bookid) {
        this.bookid = bookid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getDislike() {
        return dislike;
    }

    public void setDislike(Long dislike) {
        this.dislike = dislike;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userid;
    }

    public void setUserId(Long userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentid != null ? commentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.commentid == null && other.commentid != null) || (this.commentid != null && !this.commentid.equals(other.commentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webServ2.service.Comments[ commentid=" + commentid + " ]";
    }
    
}
