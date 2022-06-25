package Model;

public class Author {

    private int authorId;

    private String firstName;

    private String lastName;

    private int bookId;

    public Author () {}


    public int getAuthor_id() {
        return authorId;
    }

    public void setAuthor_id(int author_id) {
        this.authorId = author_id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public int getBook_id() {
        return bookId;
    }

    public void setBook_id(int book_id) {
        this.bookId = book_id;
    }
}
