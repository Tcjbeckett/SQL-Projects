package Dao;

import Model.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplate (DataSource dataSource){
        this.jbdbTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Book getBook(int bookId) {
        Book book = null;

        return null;
    }
}
