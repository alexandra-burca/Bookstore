package login;
import java.sql.*;

/**
 * @author Alexandra
 *
 */
public class DBConnection {

    /**
     *
     */
    static final String DB_URL = "jdbc:mysql://localhost/library";
    /**
     *
     */
    static final String USER = "ale";
    /**
     *
     */
    static final String PASS = "test1234";

    /**
     * @return is a function
     */
    public static Connection connectDB() {
        Connection conn = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //open connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;

        }catch(Exception ex) {
            System.out.println("There was an error connecting to the data base.");
            return null;
        }
    }

}
