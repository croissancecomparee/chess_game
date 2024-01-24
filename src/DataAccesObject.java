import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccesObject {
    private Connection connection;

    public DataAccesObject() {
        // Initiate the connection
        this.connection = DatabaseConnection.getConnection();
    }

    public void retrieveData() {
        try {
            String sql = "SELECT * FROM table_scores";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // treatment of result in the query
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                System.out.print(resultSet.getString(1)+" "+resultSet.getInt(2));

            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e);
        }
    }
}
