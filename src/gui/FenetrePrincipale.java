package gui;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;


import Model.DataAccesObject;
import Model.CCase;
import Model.CGame;
import Model.CPlateau;
import Model.piece.CPiece;

public class FenetrePrincipale extends JFrame {

    private MonPanel myPanel;
    private JMenuBar menuBar;
    private JMenu mFichier;
    private JMenuItem miQuitter;
    private CGame myGame;
    private DataAccesObject dao;

    public FenetrePrincipale() {

//        database connection when database connection available
//        this.dao = new DataAccesObject();
//
//        // creation of the database
//        dao.createTable();

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

        //this.setContentPane(myPanel);
        JButton button1 = new JButton("J1 won");
        JButton button2 = new JButton("J2 won");
        JButton button3 = new JButton("New Game");
        button1.setBounds(750,150,100,50);
        button2.setBounds(750,250,100,50);
        button3.setBounds(750,350,100,50);

        button1.addActionListener(new ActionListener() {
//            @Override
           public void actionPerformed(ActionEvent e) {
//               dao.insertData("J1",500);
//               dao.retrieveData();
               System.out.print("\nJ1 won ! ");
               restartGame();
            }
        });
        button2.addActionListener(new ActionListener() {
            //            @Override
            public void actionPerformed(ActionEvent e) {
//                dao.insertData("J2",500);
//                dao.retrieveData();
                System.out.print("\nJ2 won ! ");
                restartGame();
            }
        });
        button3.addActionListener(new ActionListener() {
            //            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
//                pack();
            }
        });

        myPanel.add(button1);
        myPanel.add(button2);
        myPanel.add(button3);

        JButton openFormButton = new JButton("Open the form");
        openFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFormPopup();
            }
        });

        myPanel.add(openFormButton);

//        dao.retrieveData();
    }

    private void openFormPopup() {
        JDialog formDialog = new JDialog(this, "Formulaire", true);
        formDialog.setSize(300, 200);
        formDialog.setLayout(new BorderLayout());

        // need to be filled
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        JTextField textField3 = new JTextField();

        JPanel formPanel = new JPanel(new GridLayout(3,2));
        formPanel.add(new JLabel("Champ 1:"));
        formPanel.add(textField1);
        formPanel.add(new JLabel("Champ 2:"));
        formPanel.add(textField2);
        formPanel.add(new JLabel("Champ 3:"));
        formPanel.add(textField3);

        JButton submitButton = new JButton("Soumettre");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Traitez les données du formulaire ici
                String value1 = textField1.getText();
                String value2 = textField2.getText();
                String value3 = textField3.getText();

                // Affichez les valeurs pour le moment
                JOptionPane.showMessageDialog(formDialog, "Valeur 1: " + value1 + "\nValeur 2: " + value2 + "\nValeur 3: " + value3);

                // Fermez la fenêtre du formulaire
                formDialog.dispose();
            }
        });

        formDialog.add(formPanel, BorderLayout.CENTER);
        formDialog.add(submitButton, BorderLayout.SOUTH);
        formDialog.setLocationRelativeTo(this);
        formDialog.setVisible(true);

    }

    public void restartGame() {
        System.out.print("\nNew game ! ");
        myGame.dispose();
        myGame = new CGame();
        myGame.drawPieces(myPanel);
        setLocationRelativeTo(null);
        repaint();
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
        myGame.draw(bufferGraphics, myPanel);

        g.drawImage(offscreen,0,0,null);
    }

    private void formMouseClicked(MouseEvent evt) {
        int sourisX = evt.getPoint().x;
        int sourisY = evt.getPoint().y;
        if (sourisX/80 <8 & sourisX>0 & sourisY/80<9 & sourisY>0) {
            CCase aCase = myGame.getCase(sourisX, sourisY);
            System.out.print("\n is case free ? " + aCase.isFree());
            System.out.print("\n is a piece selected ? " + myGame.isSelected());
            System.out.print("\nclicked case letter: " + aCase.getLetter() + "\tnumber: " + aCase.getNumber() + "\tcolor: " + aCase.getColor());
            if (myGame.isSelected()) {
                myGame.moveSelected(aCase.getLetter(), aCase.getNumber(), myPanel);
                myPanel.repaint();
            } else {
                if (aCase.isFree() == false) {
                    CPiece pieceSelected = aCase.getPiece();
                    System.out.print("\ncoucou" + pieceSelected + myGame.isSelected());
                    myGame.clickPiece(pieceSelected);
                    myPanel.repaint();
                    System.out.print("\ncoucou" + pieceSelected + myGame.isSelected());
                }
            }
        }
    }
}
