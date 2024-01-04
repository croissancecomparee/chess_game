package gui;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Model.CCase;
import Model.CPlateau;

public class FenetrePrincipale extends JFrame {

    private MonPanel myPanel;
    private JMenuBar menuBar;
    private JMenu mFichier;
    private JMenuItem miQuitter;
    private CCase myCase1;
    private CCase myCase2;
    private CPlateau myBoard;

    public FenetrePrincipale() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,800,600);
        setTitle("chess game");

        myPanel = new MonPanel(this);
        myPanel.setLayout(null);
        this.setContentPane(myPanel);

        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 440, 21);
        myPanel.add(menuBar);

        mFichier = new JMenu("Fichier");
        menuBar.add(mFichier);
        miQuitter = new JMenuItem("Quitter");
        mFichier.add(miQuitter) ;
    }

    public void draw(Graphics g) {
        Graphics bufferGraphics;
        Image offscreen;


        /*myCase1 = new CCase(new Rectangle(50,50,50,50), Color.GREEN,'A',1,true);
        myCase2 = new CCase(new Rectangle(100,50,50,50), Color.PINK,'B',1,true);*/
        myBoard = new CPlateau();

        // On crée une image en mémoire de la taille du ContentPane
        offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
        // On récupère l'objet de type Graphics permettant de dessiner dans cette image
        bufferGraphics = offscreen.getGraphics();
        // On colore le fond de l'image en blanc
        bufferGraphics.setColor(Color.WHITE);
        // On dessine le plateau
        myBoard.draw(bufferGraphics);

        g.drawImage(offscreen,0,0,null);
    }
}
