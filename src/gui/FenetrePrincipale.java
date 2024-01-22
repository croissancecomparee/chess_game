package gui;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;


import Model.CCase;
import Model.CGame;
import Model.CPlateau;
import Model.piece.CPiece;

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

//        button = new JButton("\u2659");
//        button.setBounds(10, 10, 89, 60);
//        button.setFont(new Font("Arial Unicode MS", Font.PLAIN, 50));
//        button.setOpaque(false);
//        button.setContentAreaFilled(false);
//        button.setBorderPainted(false);


//        MyMouseListener myMouseListener = new MyMouseListener();
//        button.addMouseListener(new MouseListener() {
//
//        }
        myPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                formMouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

//        myPanel.add(button);
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

    private void formMouseClicked(MouseEvent evt) {
        int sourisX = evt.getPoint().x;
        int sourisY = evt.getPoint().y;
        CCase aCase = myGame.getCase(sourisX,sourisY);
        System.out.print("\n is case free ? "+aCase.getFree());
        System.out.print("\n is a piece selected ? "+myGame.getSelected());
        System.out.print("\ncoucouuu letter:"+aCase.getLetter()+"\tnumber:"+aCase.getNumber());
        if (myGame.getSelected()) {
            System.out.print("\ncoucouuu letter:"+aCase.getLetter()+"\tnumber:"+aCase.getNumber());
            myGame.moveSelected(aCase.getLetter(),aCase.getNumber(), myPanel);
        }
        else{
            if (aCase.getFree() == false) {
                CPiece pieceSelected = aCase.getPiece();
                myGame.setSelectedPiece(pieceSelected);
                myGame.setSelected(true);
                System.out.print("\ncoucou"+pieceSelected+myGame.getSelected());
            }
        }
    }

    private class MyMouseListener extends MouseAdapter {
        private int offsetX, offsetY;

        @Override
        public void mousePressed(MouseEvent e) {
            Component component = e.getComponent();
            offsetX = e.getX();
            offsetY = e.getY();
            component.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Component component = e.getComponent();
            int newX = component.getX() + e.getX() - offsetX;
            int newY = component.getY() + e.getY() - offsetY;

            component.setLocation(newX, newY);
            repaint();
        }
    }
}
