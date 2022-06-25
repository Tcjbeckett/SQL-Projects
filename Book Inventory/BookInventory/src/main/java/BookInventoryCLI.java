import Dao.BookDao;
import Dao.JdbcBookDao;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class BookInventoryCLI {

    public static BookDao bookDao;


    public static void main(String[] args) {
        
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:postgresql://localhost:5432/BookInventory");
            dataSource.setUsername("postgres");
            dataSource.setPassword("postgres1");

        BookInventoryCLI application = new BookInventoryCLI(dataSource);

        bookDao = new JdbcBookDao(dataSource);

        application.run();

    }

    //constructor
    public BookInventoryCLI(DataSource dataSource){

    }

    private void run(){

        System.out.println(bookDao.getBook(5));
        System.out.println("trust");

    }
}
