package Dao;

import Model.Book;

import java.util.List;

public interface BookDao {

    Book getBook(int bookId);

    List<Book> getBooksByBookId();

    List<Book> getBooksByAuthorId(int authorId);

    Book createBook(Book newBook);
}
