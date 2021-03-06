import Dao.BookDao;
import Dao.JdbcBookDao;
import Model.Book;
import org.apache.commons.dbcp2.BasicDataSource;
import view.Menu;

import javax.sql.DataSource;
import java.util.Scanner;

public class BookInventoryCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_BOOKS = "Display Book Details";
    private static final String MAIN_MENU_OPTION_DISPLAY_ALL_BOOKS = "Display Book Details For All Books";

    private static final String MAIN_MENU_OPTION_DISPLAY_BOOKS_BY_AUTHOR_ID = "Display Book Details By Author Id";

    private static final String MAIN_MENU_OPTION_ADD_BOOK = "Add a New Book";
    private static final String MAIN_MENU_OPTION_UPDATE_SALE_PRICE = "Update Book Sale Price";
    private static final String MAIN_MAIN_OPTION_REMOVE_BOOK = "Remove a Book";
    private static final String MAIN_MENU_OPTIONS_DISPLAY_AUTHOR = "Display Author Details";
    private static final String MAIN_MENU_OPTIONS_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_BOOKS, MAIN_MENU_OPTION_DISPLAY_ALL_BOOKS, MAIN_MENU_OPTION_DISPLAY_BOOKS_BY_AUTHOR_ID, MAIN_MENU_OPTION_ADD_BOOK, MAIN_MENU_OPTION_UPDATE_SALE_PRICE, MAIN_MAIN_OPTION_REMOVE_BOOK, MAIN_MENU_OPTIONS_DISPLAY_AUTHOR, MAIN_MENU_OPTIONS_EXIT};

    public static BookDao bookDao;
    private Menu menu = new Menu(System.in, System.out);

    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args){

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(""); //inset url
        dataSource.setUsername(""); // insert username
        dataSource.setPassword(""); // insert password

        BookInventoryCLI application = new BookInventoryCLI(dataSource);

        bookDao = new JdbcBookDao(dataSource);

        application.run();

    }

    //constructor
    public BookInventoryCLI(DataSource dataSource) {

    }

    public BookInventoryCLI(Menu menu) {
        this.menu = new Menu(System.in, System.out);

    }

    private void run() {

        boolean running = true;

        String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            while (running ) {
                if (choice.equals("Display Book Details")) {

                    System.out.println("Please input a Book Id");
                    String userInput = scanner.nextLine();
                    System.out.println(bookDao.getBook(Integer.parseInt(userInput)));
                    run();

                } else if(choice.equals("Display Book Details For All Books")){
                    System.out.println(bookDao.getBooksByBookId());
                    run();

                }else if(choice.equals("Display Book Details By Author Id")){
                    System.out.println("Please input an Author Id");
                    String userInput = scanner.nextLine();
                    System.out.println(bookDao.getBooksByAuthorId(Integer.parseInt(userInput)));

                }else if(choice.equals("Add a New Book")){
                    String newBookTitle = getUserInput("Enter Book Title");
                    String newBookAuthorId = getUserInput("Enter Author Id");
                    String newBookIsbn = getUserInput("Enter ISBN");
                    String newBookSalePrice = getUserInput("Enter Sale Price");
                    Book newBook = new Book();
                    newBook.setTitle(newBookTitle);
                    newBook.setAuthor_id(Integer.parseInt(newBookAuthorId));
                    newBook.setIsbn(Integer.parseInt(newBookIsbn));
                    newBook.setSale_price(Integer.parseInt(newBookSalePrice));
                    newBook = bookDao.createBook(newBook);
                    System.out.println("\n*** " + newBook.getTitle() + " has been created ***");
                    run();

                }else if(choice.equals("Update Book Sale Price")){
                    String selectedBook = getUserInput("Enter the Book Id you would like to update");
                    String newSalePrice = getUserInput("Enter new sale price");
                    Book updatedBook = new Book();
                    updatedBook.setSale_price(Integer.parseInt(newSalePrice));
                    updatedBook.setBook_id(Integer.parseInt(selectedBook));
                    bookDao.updateBook(updatedBook);
                    System.out.println("\n*** The sale price has been updated to " + newSalePrice + " *** \n");
                    run();

                }else if(choice.equals("Remove a Book")){
                    String selectedBook = getUserInput("Enter the Book Id that you would like to remove");
                    bookDao.removeBook(Integer.parseInt(selectedBook));
                    System.out.println("\n*** The book has been removed *** \n");
                    run();

                }else if (choice.equals("Display Author Details")) {
                    System.out.println("I haven't written this code yet");
                    run();

                }else if(choice.equals("Exit")){
                    System.out.println("Goodbye");
                    running = false;
                }
            }

            System.out.println("Trust The Process");

    }

    private String getUserInput(String prompt){
        System.out.println(prompt + " >>> ");
        return new Scanner(System.in).nextLine();
    }


}

