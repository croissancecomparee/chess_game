import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
//                charging the driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // establishing the connection
                String BDD = "tpjavaimds5A";
                String url = "jdbc:mysql://172.16.23.115.3306/";
                String user = "IMDS5A";
                String password = "polytech";
                connection = DriverManager.getConnection(url, user, password);
                System.out.print("\nConnected");
            }
            catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
                System.out.print("\nError");
                System.exit(0);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}