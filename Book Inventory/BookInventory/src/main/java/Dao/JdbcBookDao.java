package Dao;

import Model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Book getBook(int bookId) {
        Book book = null;
        String sql = "SELECT * FROM book WHERE book_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookId);
        while(results.next()){
            book = mapToBook(results);
        }

        return book;
    }

    @Override
    public List<Book> getBooksByBookId(){
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Book book = mapToBook(results);
            books.add(book);
        }

        return books;
    }


    private Book mapToBook(SqlRowSet results){
        Book book = new Book();
        book.setBook_id(results.getInt("book_id"));
        book.setTitle(results.getString("title"));
        book.setAuthor_id(results.getInt("author_id"));
        book.setIsbn(results.getInt("isbn"));
        book.setSale_price(results.getInt("sale_price"));
        return book;
    }
}
