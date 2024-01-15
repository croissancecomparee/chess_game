package gui;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Model.CCase;
import Model.CGame;
import Model.CPlateau;

public class FenetrePrincipale extends JFrame {

    private MonPanel myPanel;
    private JMenuBar menuBar;
    private JMenu mFichier;
    private JMenuItem miQuitter;
    private CCase myCase1;
    private CCase myCase2;
    private CPlateau myBoard;
    private CGame myGame;
    private JButton button;

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

        myGame = new CGame();
        myGame.drawPieces(myPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private Font getResizedFont(Font font, int newSize) {
        return font.deriveFont((float) newSize);
    }

    public void draw(Graphics g) {
        Graphics bufferGraphics;
        Image offscreen;


        setLocationRelativeTo(null);
        // On crée une image en mémoire de la taille du ContentPane
        offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight());
        // On récupère l'objet de type Graphics permettant de dessiner dans cette image
        bufferGraphics = offscreen.getGraphics();
        // On colore le fond de l'image en blanc
        bufferGraphics.setColor(Color.WHITE);
        // On dessine le plateau
        myGame.draw(bufferGraphics);

        g.drawImage(offscreen,0,0,null);
    }
}
