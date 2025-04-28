import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    public static java.sql.Connection connection;

    public static java.sql.Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiktakdb", "root", "");
        return connection;
    }
}