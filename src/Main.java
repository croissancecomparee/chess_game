import Model.DataAccesObject;
import Model.DatabaseConnection;
import gui.FenetrePrincipale;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Entrée with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        FenetrePrincipale frame = new FenetrePrincipale();
        frame.setVisible(true);
        DataAccesObject dao = new DataAccesObject();

        // creation of the database
        dao.createTable();

        dao.insertData("Toto",100);

        dao.retrieveData();

        DatabaseConnection.closeConnection();
        // Press Maj+F10 or click the green arrow button in the gutter to run the code.
    }
}