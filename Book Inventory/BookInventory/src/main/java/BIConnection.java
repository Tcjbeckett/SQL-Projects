import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class BIConnection {

    public BasicDataSource connectToDb() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/BookInventory");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        return dataSource;
    }
}
