import Dao.BookDao;
import Dao.JdbcBookDao;
import org.apache.commons.dbcp2.BasicDataSource;
import view.Menu;

import javax.sql.DataSource;
import java.util.Scanner;

public class BookInventoryCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_BOOKS = "Display Book Details";
    private static final String MAIN_MENU_OPTION_DISPLAY_ALL_BOOKS = "Display Book Details For All Books";
    private static final String MAIN_MENU_OPTIONS_DISPLAY_AUTHOR = "Display Author Details";
    private static final String MAIN_MENU_OPTIONS_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_BOOKS, MAIN_MENU_OPTION_DISPLAY_ALL_BOOKS, MAIN_MENU_OPTIONS_DISPLAY_AUTHOR, MAIN_MENU_OPTIONS_EXIT};

    public static BookDao bookDao;
    private Menu menu = new Menu(System.in, System.out);

    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args){

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/BookInventory");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

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

                }else if (choice.equals("Display Author Details")) {
                    System.out.println("I haven't written this code yet");
                    run();

                }else if(choice.equals("Exit")){
                    run();
                }
            }

            System.out.println("Trust The Process");

    }


}

