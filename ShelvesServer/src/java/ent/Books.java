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
@Table(name = "BOOKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b")
    , @NamedQuery(name = "Books.findByBookid", query = "SELECT b FROM Books b WHERE b.bookid = :bookid")
    , @NamedQuery(name = "Books.findByAnnotation", query = "SELECT b FROM Books b WHERE b.annotation = :annotation")
    , @NamedQuery(name = "Books.findByAuthorid", query = "SELECT b FROM Books b WHERE b.authorid = :authorid")
    , @NamedQuery(name = "Books.findByBookname", query = "SELECT b FROM Books b WHERE b.bookname = :bookname")
    , @NamedQuery(name = "Books.findByDate", query = "SELECT b FROM Books b WHERE b.date = :date")
    , @NamedQuery(name = "Books.findByGenre", query = "SELECT b FROM Books b WHERE b.genre = :genre")
    , @NamedQuery(name = "Books.findBySeries", query = "SELECT b FROM Books b WHERE b.series = :series")
    , @NamedQuery(name = "Books.findBySeriesnumber", query = "SELECT b FROM Books b WHERE b.seriesnumber = :seriesnumber")})
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKID")
    private Long bookid;
    @Size(max = 255)
    @Column(name = "ANNOTATION")
    private String annotation;
    @Column(name = "AUTHORID")
    private Long authorid;
    @Size(max = 255)
    @Column(name = "BOOKNAME")
    private String bookname;
    @Column(name = "DATE")
    private Long date;
    @Size(max = 255)
    @Column(name = "GENRE")
    private String genre;
    @Size(max = 255)
    @Column(name = "SERIES")
    private String series;
    @Column(name = "SERIESNUMBER")
    private Long seriesnumber;

    public Books() {
    }

    public Books(Long bookid) {
        this.bookid = bookid;
    }

    public Long getBookId() {
        return bookid;
    }

    public void setBookId(Long bookid) {
        this.bookid = bookid;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Long getAuthorId() {
        return authorid;
    }

    public void setAuthorId(Long authorid) {
        this.authorid = authorid;
    }

    public String getBookName() {
        return bookname;
    }

    public void setBookName(String bookname) {
        this.bookname = bookname;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Long getSeriesNumber() {
        return seriesnumber;
    }

    public void setSeriesNumber(Long seriesnumber) {
        this.seriesnumber = seriesnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookid != null ? bookid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.bookid == null && other.bookid != null) || (this.bookid != null && !this.bookid.equals(other.bookid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webServ2.service.Books[ bookid=" + bookid + " ]";
    }
    
}
