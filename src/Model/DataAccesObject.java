package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccesObject {
    private Connection connection;

    public DataAccesObject() {
        // Initiate the connection
        this.connection = DatabaseConnection.getConnection();
    }

    public void retrieveData() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM table_scores";
//            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // treatment of result in the query
                String idScores = resultSet.getString("idScores");
                String pseudo = resultSet.getString("pseudo");
                int score = resultSet.getInt("score");
                System.out.print("\nid score: "+idScores+"\npseudo: "+pseudo+"\nscore: "+score);
            }

            resultSet.close();
            statement.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e);
        } finally {
            DatabaseConnection.closeConnection();
        }
    }

    public void createTable() {
        try {
            Statement statement = connection.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS table_scores (" +
                    "idScores INT PRIMARY KEY AUTO_INCREMENT," +
                    "pseudo VARCHAR(20)," +
                    "score INT" +
                    ")";

            statement.executeUpdate(createTableSQL);
            statement.close();
            System.out.print("\nTable created or already exists.");
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.print("\nError creating table.");
        }
    }

    public void insertData(String pseudo, int score) {
        // insertion query
        String insertQuery = "INSERT INTO table_scores (pseudo, score) VALUES (?,?)";

        // use of PreparedStatement for avoiding attack with SQL query injection
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // replacement of parameters of the query with real walues
            preparedStatement.setString(1,pseudo);
            preparedStatement.setInt(2, score);

            // Execution of the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check the number of affected rows
            if (rowsAffected > 0) {
                System.out.print("\nInsertion succeed ! ");
            }
            else {
                System.out.print("\nInsertion failed");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
