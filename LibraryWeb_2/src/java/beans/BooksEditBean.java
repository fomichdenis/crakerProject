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
public class BooksEditBean implements Serializable {
    
    private Long bookId;
    private String bookName;
    private Long authorId;
    private Long date;
    private String annotation;
    private String series;
    private Long seriesNumber;
    private String genre;

    public void setDate(Long date) {
        this.date = date;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setSeriesNumber(Long seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getDate() {
        return date;
    }

    public String getAnnotation() {
        return annotation;
    }

    public String getSeries() {
        return series;
    }

    public Long getSeriesNumber() {
        return seriesNumber;
    }

    public String getGenre() {
        return genre;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getBookName() {
        return bookName;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getAuthorId() {
        return authorId;
    }

}
