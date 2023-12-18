package gui;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Model.CCase;

public class FenetrePrincipale extends JFrame {

    private JPanel myContentPane;
    private JMenuBar menuBar;
    private JMenu mFichier;
    private JMenuItem miQuitter;
    private CCase myCase;

    public FenetrePrincipale() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,800,600);
        setTitle("chess game");

        myContentPane = new JPanel();
        myContentPane.setLayout(null);
        setContentPane(myContentPane);

        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 440, 21);
        myContentPane.add(menuBar);

        mFichier = new JMenu("Fichier");
        menuBar.add(mFichier);
        miQuitter = new JMenuItem("Quitter");
        mFichier.add(miQuitter) ;

        myCase = new CCase(new Rectangle(50,50,50,50), Color.BLUE,'A',1,true);
        myCase.draw(getGraphics());

    }
}
