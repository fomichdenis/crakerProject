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
@Table(name = "RECORDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Records.findAll", query = "SELECT r FROM Records r")
    , @NamedQuery(name = "Records.findByRecordid", query = "SELECT r FROM Records r WHERE r.recordid = :recordid")
    , @NamedQuery(name = "Records.findByBookid", query = "SELECT r FROM Records r WHERE r.bookid = :bookid")
    , @NamedQuery(name = "Records.findByDate", query = "SELECT r FROM Records r WHERE r.date = :date")
    , @NamedQuery(name = "Records.findByProgress", query = "SELECT r FROM Records r WHERE r.progress = :progress")
    , @NamedQuery(name = "Records.findByRate", query = "SELECT r FROM Records r WHERE r.rate = :rate")
    , @NamedQuery(name = "Records.findByStatus", query = "SELECT r FROM Records r WHERE r.status = :status")
    , @NamedQuery(name = "Records.findByText", query = "SELECT r FROM Records r WHERE r.text = :text")
    , @NamedQuery(name = "Records.findByUserid", query = "SELECT r FROM Records r WHERE r.userid = :userid")})
public class Records implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RECORDID")
    private Long recordid;
    @Column(name = "BOOKID")
    private Long bookid;
    @Size(max = 255)
    @Column(name = "DATE")
    private String date;
    @Column(name = "PROGRESS")
    private Long progress;
    @Column(name = "RATE")
    private Long rate;
    @Column(name = "STATUS")
    private Long status;
    @Size(max = 255)
    @Column(name = "TEXT")
    private String text;
    @Column(name = "USERID")
    private Long userid;

    public Records() {
    }

    public Records(Long recordid) {
        this.recordid = recordid;
    }

    public Long getRecordId() {
        return recordid;
    }

    public void setRecordId(Long recordid) {
        this.recordid = recordid;
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

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
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
        hash += (recordid != null ? recordid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Records)) {
            return false;
        }
        Records other = (Records) object;
        if ((this.recordid == null && other.recordid != null) || (this.recordid != null && !this.recordid.equals(other.recordid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webServ2.service.Records[ recordid=" + recordid + " ]";
    }
    
}
