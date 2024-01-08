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
import java.util.ArrayList;

public class CGame {
    private CPlateau plateau;
    private ArrayList<CPiece> whitePieces;
    private ArrayList<CPiece> blackPieces;
    private char[] letterCoordinate = new char[]{'A','B','C','D','E','F','G','H'};

    public CGame() {
        plateau = new CPlateau();


        // initialisation of white pieces array
        this.whitePieces = new ArrayList<>();

        // adding white pawns
        for (int i=0;i<8;i++) {
            CPawn newPawn = new CPawn("\u2659",0,letterCoordinate[i],2);
        }

        // adding Knights L : Left, R : Right
        CKnight newKnightWL = new CKnight("\u2658",0,'B',1);
        CKnight newKnightWR = new CKnight("\u2658",0,'G',1);


        // adding bishops L : Left, R : Right
        CBishop newBishopWL = new CBishop("\u2657",0,'C',1);
        CBishop newBishopWR = new CBishop("\u2657",0,'F',1);

        // adding towers L : Left, R : Right
        CTower newTowerWL = new CTower("\u2656",0,'A',1);
        CTower newTowerWR = new CTower("\u2656",0,'H',1);

        // adding queen
        CQueen newQueenW = new CQueen("\u2655",0,'D',1);

        // adding king
        CKing newKingW = new CKing("\u2654",0,'E',1);



        // initialisation of black pieces array
        this.blackPieces = new ArrayList<>();

        // adding black pawns
        for (int i=0;i<8;i++) {
            CPawn newPawn = new CPawn("\u2659",0,letterCoordinate[i],2);
        }

        // adding Knights L : Left, R : Right
        CKnight newKnightBL = new CKnight("\u2658",0,'B',1);
        CKnight newKnightBR = new CKnight("\u2658",0,'G',1);


        // adding bishops L : Left, R : Right
        CBishop newBishopBL = new CBishop("\u2657",0,'C',1);
        CBishop newBishopBR = new CBishop("\u2657",0,'F',1);

        // adding towers L : Left, R : Right
        CTower newTowerBL = new CTower("\u2656",0,'A',1);
        CTower newTowerBR = new CTower("\u2656",0,'H',1);

        // adding queen
        CQueen newQueenB = new CQueen("\u2655",0,'D',1);

        // adding king
        CKing newKingB = new CKing("\u2654",0,'E',1);
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
            JButton button = new JButton(piece.getUnicode());
            button.setBounds(
                    plateau.getAbscissaCoordinate(piece.getLetter()),
                    plateau.getordinateCoordinate(piece.getNumber()),
                    plateau.getWeightCase(),
                    plateau.getWeightCase()
            );
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);

            panel.add(button);
        }
    }
}
