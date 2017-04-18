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
public class RecordEditBean implements Serializable {
    
    private Long recordId;
    private Long bookId;
    private Long userId;
    private Long rate;
    private String date;
    private String text;
    private Long progress;
    private Long status;

    public Long getRecordId() {
        return recordId;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRate() {
        return rate;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public Long getProgress() {
        return progress;
    }

    public Long getStatus() {
        return status;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
    
}
