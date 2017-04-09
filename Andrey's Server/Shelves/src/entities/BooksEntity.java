package entities;

import javax.persistence.*;

/**
 * Created by adaico on 26.03.17.
 */
@Entity
@Table(name = "myBooks", schema = "Shelves")
public class BooksEntity {
    private int bookId;
    private String bookName;
    private String bookAutor;
    private int bookPublYear;
    private String bookSeries;
    private int bookSerNum;
    private String bookGenre;
    private String bookAnnot;
    private int currentPage;
    private String myOpinion;

    @Id
    @Column(name = "bookId", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "bookName", nullable = false, length = 45)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "bookAutor", nullable = false, length = 45)
    public String getBookAutor() {
        return bookAutor;
    }

    public void setBookAutor(String bookAutor) {
        this.bookAutor = bookAutor;
    }

    @Basic
    @Column(name = "bookPublYear", nullable = false)
    public int getBookPublYear() {
        return bookPublYear;
    }

    public void setBookPublYear(int bookPublYear) {
        this.bookPublYear = bookPublYear;
    }

    @Basic
    @Column(name = "bookSeries", nullable = true, length = 45)
    public String getBookSeries() {
        return bookSeries;
    }

    public void setBookSeries(String bookSeries) {
        this.bookSeries = bookSeries;
    }

    @Basic
    @Column(name = "bookSerNum", nullable = false)
    public int getBookSerNum() {
        return bookSerNum;
    }

    public void setBookSerNum(int bookSerNum) {
        this.bookSerNum = bookSerNum;
    }

    @Basic
    @Column(name = "bookGenre", nullable = false, length = 45)
    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    @Basic
    @Column(name = "bookAnnot", nullable = true, length = 200)
    public String getBookAnnot() {
        return bookAnnot;
    }

    public void setBookAnnot(String bookAnnot) {
        this.bookAnnot = bookAnnot;
    }

    @Basic
    @Column(name = "currentPage", nullable = false)
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Basic
    @Column(name = "myOpinion", nullable = true, length = 200)
    public String getMyOpinion() {
        return myOpinion;
    }

    public void setMyOpinion(String myOpinion) {
        this.myOpinion = myOpinion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksEntity that = (BooksEntity) o;

        if (bookId != that.bookId) return false;
        if (bookPublYear != that.bookPublYear) return false;
        if (bookSerNum != that.bookSerNum) return false;
        if (currentPage != that.currentPage) return false;
        if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;
        if (bookAutor != null ? !bookAutor.equals(that.bookAutor) : that.bookAutor != null) return false;
        if (bookSeries != null ? !bookSeries.equals(that.bookSeries) : that.bookSeries != null) return false;
        if (bookGenre != null ? !bookGenre.equals(that.bookGenre) : that.bookGenre != null) return false;
        if (bookAnnot != null ? !bookAnnot.equals(that.bookAnnot) : that.bookAnnot != null) return false;
        if (myOpinion != null ? !myOpinion.equals(that.myOpinion) : that.myOpinion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (bookAutor != null ? bookAutor.hashCode() : 0);
        result = 31 * result + bookPublYear;
        result = 31 * result + (bookSeries != null ? bookSeries.hashCode() : 0);
        result = 31 * result + bookSerNum;
        result = 31 * result + (bookGenre != null ? bookGenre.hashCode() : 0);
        result = 31 * result + (bookAnnot != null ? bookAnnot.hashCode() : 0);
        result = 31 * result + currentPage;
        result = 31 * result + (myOpinion != null ? myOpinion.hashCode() : 0);
        return result;
    }
}
