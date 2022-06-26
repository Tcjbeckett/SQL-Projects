package Dao;

import Model.Book;

import java.util.List;

public interface BookDao {

    Book getBook(int bookId);

    List<Book> getBooksByBookId();

    List<Book> getBooksByAuthorId(int authorId);

    Book createBook(Book newBook);

    Book updateBook(Book updatedBook);
    //**updateBook updates sale price only**//

    public void removeBook(int bookId);
}
