import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DatabaseViewer extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public DatabaseViewer() {
        setTitle("Database Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);

        model = new DefaultTableModel();
        table = new JTable(model);
    }
}
