package Model;

import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class Book {
    private int bookId;

    private String title;

    private int authorId;

    private int isbn;

    private int salePrice;

    public Book(){}

    public Book(int book_id, String title, int author_id, int isbn, int sale_price){
        this.bookId = book_id;
        this.title = title;
        this.authorId = author_id;
        this.isbn = isbn;
        this.salePrice = sale_price;
    }


    public int getBook_id() {
        return bookId;
    }

    public void setBook_id(int book_id) {
        this.bookId = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthor_id() {
        return authorId;
    }

    public void setAuthor_id(int author_id) {
        this.authorId = author_id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getSale_price() {
        return salePrice;
    }

    public void setSale_price(int sale_price) {
        this.salePrice = sale_price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                ", isbn=" + isbn +
                ", salePrice=" + salePrice +
                '}';
    }
}
