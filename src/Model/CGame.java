package Model;
import Model.piece.CBishop;
import Model.piece.CPawn;
import Model.piece.CPiece;
import Model.piece.CKnight;
import Model.piece.CKing;
import Model.piece.CQueen;
import Model.piece.CTower;
import gui.MonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CGame {
    private CPlateau plateau;
    private ArrayList<CPiece> whitePieces;
    private ArrayList<CPiece> blackPieces;
    private char[] letterCoordinate = new char[]{'A','B','C','D','E','F','G','H'};
    private int uniformFontSize = 53;

//    private JButton button;

    public CGame() {
        plateau = new CPlateau();


        // initialisation of white pieces array
        this.whitePieces = new ArrayList<>();

        // adding white pawns
        for (int i=0;i<8;i++) {
            CPawn newPawn = new CPawn("\u2659",0,letterCoordinate[i],2);
            this.whitePieces.add(newPawn);
        }

        // adding Knights L : Left, R : Right
        CKnight newKnightWL = new CKnight("\u2658",0,'B',1);
        CKnight newKnightWR = new CKnight("\u2658",0,'G',1);
        this.whitePieces.add(newKnightWL);
        this.whitePieces.add(newKnightWR);

        // adding bishops L : Left, R : Right
        CBishop newBishopWL = new CBishop("\u2657",0,'C',1);
        CBishop newBishopWR = new CBishop("\u2657",0,'F',1);
        this.whitePieces.add(newBishopWL);
        this.whitePieces.add(newBishopWR);

        // adding towers L : Left, R : Right
        CTower newTowerWL = new CTower("\u2656",0,'A',1);
        CTower newTowerWR = new CTower("\u2656",0,'H',1);
        this.whitePieces.add(newTowerWL);
        this.whitePieces.add(newTowerWR);

        // adding queen
        CQueen newQueenW = new CQueen("\u2655",0,'D',1);
        this.whitePieces.add(newQueenW);

        // adding king
        CKing newKingW = new CKing("\u2654",0,'E',1);
        this.whitePieces.add(newKingW);


        // initialisation of black pieces array
        this.blackPieces = new ArrayList<>();

        // adding black pawns
        for (int i=0;i<8;i++) {
            CPawn newPawn = new CPawn("\u265F",0,letterCoordinate[i],7);
            this.blackPieces.add(newPawn);
        }

        // adding Knights L : Left, R : Right
        CKnight newKnightBL = new CKnight("\u265E",0,'B',8);
        CKnight newKnightBR = new CKnight("\u265E",0,'G',8);
        this.blackPieces.add(newKnightBL);
        this.blackPieces.add(newKnightBR);

        // adding bishops L : Left, R : Right
        CBishop newBishopBL = new CBishop("\u265D",0,'C',8);
        CBishop newBishopBR = new CBishop("\u265D",0,'F',8);
        this.blackPieces.add(newBishopBL);
        this.blackPieces.add(newBishopBR);

        // adding towers L : Left, R : Right
        CTower newTowerBL = new CTower("\u265C",0,'A',8);
        CTower newTowerBR = new CTower("\u265C",0,'H',8);
        this.blackPieces.add(newTowerBL);
        this.blackPieces.add(newTowerBR);

        // adding queen
        CQueen newQueenB = new CQueen("\u265B",0,'D',8);
        this.blackPieces.add(newQueenB);

        // adding king
        CKing newKingB = new CKing("\u265A",0,'E',8);
        this.blackPieces.add(newKingB);
    }

    /*// A voir si c plus simple de passer par une fonction ou pas
    public void initPieces(int color) {

    }*/

    public void draw(Graphics g) {
        this.plateau.draw(g);
    }

    public void drawPieces(MonPanel panel) {
        // white
        for (CPiece piece : this.whitePieces) {
            JButton button = createChessButton(piece, plateau);
            panel.add(button);
        }

        // black
        for (CPiece piece : this.blackPieces) {
            JButton button = createChessButton(piece, plateau);
            panel.add(button);
        }

    }

    private JButton createChessButton(CPiece piece, CPlateau plateau) {
        JButton button = new JButton(piece.getUnicode()); //
        button.setBounds(
                plateau.getAbscissaCoordinate(piece.getLetter()),
                plateau.getordinateCoordinate(piece.getNumber()),
                89,60
        );

        Font originalFont = button.getFont();
//        Font resizedFont = new Font("Arial Unicode MS", originalFont.getStyle(), 50);
        Font resizedFont = new Font(originalFont.getName(), originalFont.getStyle(), uniformFontSize);
        button.setFont(resizedFont);

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Votre logique en réponse au clic sur le bouton
            }
        });

        return button;
    }

    private Font getResizedFont(Font font, int newSize) {
        return font.deriveFont((float) newSize);
    }
}
