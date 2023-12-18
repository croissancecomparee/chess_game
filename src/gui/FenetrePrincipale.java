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

        myContentPane = new MonPanel(this);
        //myContentPane.setLayout(new BorderLayout());
        setContentPane(myContentPane);

        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 440, 21);
        myContentPane.add(menuBar);

        mFichier = new JMenu("Fichier");
        menuBar.add(mFichier);
        miQuitter = new JMenuItem("Quitter");
        mFichier.add(miQuitter) ;

        myCase = new CCase(new Rectangle(50, 50, 50, 50), Color.BLUE, 'A', 1, true);
        draw(myContentPane.getGraphics());

    }


    public void draw(Graphics g) {
        Graphics bufferGraphics;
        Image offscreen;

        // creation of an image in memory with ContentPane dimension
        offscreen = createImage(this.getContentPane().getWidth(), this.getContentPane().getHeight());

        // Getting the object with Graphics type allowing to draw in this screen
        bufferGraphics = offscreen.getGraphics();

        // colorizing the background in white
        bufferGraphics.setColor(Color.WHITE);
        bufferGraphics.fillRect(0, 0, this.getContentPane().getWidth(), this.getContentPane().getHeight());

        // Drawing the object in the screen in memory to avoid flickering effect
        myCase.draw(bufferGraphics);

        // showing the memory image in the screen
        g.drawImage(offscreen, 0, 0, null);
    }

}
