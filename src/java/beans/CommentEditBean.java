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
public class CommentEditBean implements Serializable {
    
    private Long commentId;
    private Long bookId;
    private Long userId;
    private String date;
    private Long likes;
    private Long dislike;    

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    private String text;

    public Long getCommentId() {
        return commentId;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public Long getLikes() {
        return likes;
    }

    public Long getDislike() {
        return dislike;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public void setDislike(Long dislike) {
        this.dislike = dislike;
    }
    
}
