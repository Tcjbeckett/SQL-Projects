import java.sql.Connection;

public class Main {

    public static void main(String[] args){

        DBFunction db = new DBFunction();

        //YOU HAVE TO PUT YOUR PASSWORD IN BELOW! MAKE SURE YOU DON'T UPLOAD THIS WITH YOUR PASSWORD!
        Connection conn=db.connect_to_db("tutdb", "postgres", " "); //Did you add the password to the db?
        //db.createTable(conn, "employee");

        //db.insert_row(conn, "employee", "Jewell", "United States");

        //db.update_name(conn, "employee", "Joseph", "Mike");

        //db.search_by_name(conn, "employee", "Jewell");
        //db.search_by_id(conn, "employee", 3);

        //db.delete_row_name(conn, "Employee", "Mike");
        //db.delete_row_id(conn, "Employee", 4);

        //db.delete_table(conn, "Employee");

        //db.read_data(conn, "employee");

    }




}
