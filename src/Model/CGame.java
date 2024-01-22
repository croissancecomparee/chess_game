package Model;
import Model.piece.CBishop;
import Model.piece.CPawn;
import Model.piece.CPiece;
import Model.piece.CKnight;
import Model.piece.CKing;
import Model.piece.CQueen;
import Model.piece.CTower;
import gui.MonPanel;
//import gui.FenetrePrincipale.MyMousteListener;

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

    private CPiece selectedPiece = null;
    private boolean isAPieceSelected = false;

//    private JButton button;

    public CGame() {
        plateau = new CPlateau();


        // initialisation of white pieces array
        this.whitePieces = new ArrayList<>();

        // adding white pawns
        for (int i=0;i<8;i++) {
            CPawn newPawn = new CPawn("\u2659",0,letterCoordinate[i],2);
            CCase relatedCase = plateau.getCaseWithCoordinate(letterCoordinate[i],2);
            relatedCase.setFree(false);
            relatedCase.setPiece(newPawn);
            this.whitePieces.add(newPawn);
        }

        // adding Knights L : Left, R : Right
        CKnight newKnightWL = new CKnight("\u2658",0,'B',1);
        CKnight newKnightWR = new CKnight("\u2658",0,'G',1);
        CCase relatedCase = plateau.getCaseWithCoordinate('B',1);
        relatedCase.setFree(false);
        relatedCase.setPiece(newKnightWL);
        relatedCase = plateau.getCaseWithCoordinate('G', 1);
        relatedCase.setFree(false);
        relatedCase.setPiece(newKnightWR);
        this.whitePieces.add(newKnightWL);
        this.whitePieces.add(newKnightWR);

        // adding bishops L : Left, R : Right
        CBishop newBishopWL = new CBishop("\u2657",0,'C',1);
        CBishop newBishopWR = new CBishop("\u2657",0,'F',1);
        relatedCase = plateau.getCaseWithCoordinate('C',1);
        relatedCase.setFree(false);
        relatedCase.setPiece(newBishopWL);
        relatedCase = plateau.getCaseWithCoordinate('F',1);
        relatedCase.setFree(false);
        relatedCase.setPiece(newBishopWR);
        this.whitePieces.add(newBishopWL);
        this.whitePieces.add(newBishopWR);

        // adding towers L : Left, R : Right
        CTower newTowerWL = new CTower("\u2656",0,'A',1);
        CTower newTowerWR = new CTower("\u2656",0,'H',1);
        plateau.getCaseWithCoordinate('A',1);
        relatedCase.setFree(false);
        relatedCase.setPiece(newTowerWL);
        relatedCase = plateau.getCaseWithCoordinate('H',1);
        relatedCase.setFree(false);
        relatedCase.setPiece(newTowerWR);
        this.whitePieces.add(newTowerWL);
        this.whitePieces.add(newTowerWR);

        // adding queen
        CQueen newQueenW = new CQueen("\u2655",0,'D',1);
        relatedCase = plateau.getCaseWithCoordinate('D',1);
        relatedCase.setFree(false);
        relatedCase.setPiece(newQueenW);
        this.whitePieces.add(newQueenW);

        // adding king
        CKing newKingW = new CKing("\u2654",0,'E',1);
        relatedCase = plateau.getCaseWithCoordinate('E',1);
        relatedCase.setFree(false);
        relatedCase.setPiece(newKingW);
        this.whitePieces.add(newKingW);


        // initialisation of black pieces array
        this.blackPieces = new ArrayList<>();

        // adding black pawns
        for (int i=0;i<8;i++) {
            CPawn newPawn = new CPawn("\u265F",1,letterCoordinate[i],7);
            relatedCase = plateau.getCaseWithCoordinate(letterCoordinate[i],7);
            relatedCase.setFree(false);
            relatedCase.setPiece(newPawn);
            this.blackPieces.add(newPawn);
        }

        // adding Knights L : Left, R : Right
        CKnight newKnightBL = new CKnight("\u265E",1,'B',8);
        CKnight newKnightBR = new CKnight("\u265E",1,'G',8);
        relatedCase = plateau.getCaseWithCoordinate('B',8);
        relatedCase.setFree(false);
        relatedCase.setPiece(newKnightBL);
        relatedCase = plateau.getCaseWithCoordinate('G',8);
        relatedCase.setFree(false);
        relatedCase.setPiece(newKnightBR);
        this.blackPieces.add(newKnightBL);
        this.blackPieces.add(newKnightBR);

        // adding bishops L : Left, R : Right
        CBishop newBishopBL = new CBishop("\u265D",1,'C',8);
        CBishop newBishopBR = new CBishop("\u265D",1,'F',8);
        relatedCase = plateau.getCaseWithCoordinate('C',8);
        relatedCase.setFree(false);
        relatedCase.setPiece(newBishopBL);
        relatedCase = plateau.getCaseWithCoordinate('F',8);
        relatedCase.setFree(false);
        relatedCase.setPiece(newBishopBR);
        this.blackPieces.add(newBishopBL);
        this.blackPieces.add(newBishopBR);

        // adding towers L : Left, R : Right
        CTower newTowerBL = new CTower("\u265C",1,'A',8);
        CTower newTowerBR = new CTower("\u265C",1,'H',8);
        relatedCase = plateau.getCaseWithCoordinate('A',8);
        relatedCase.setFree(false);
        relatedCase.setPiece(newTowerBL);
        relatedCase = plateau.getCaseWithCoordinate('H',8);
        relatedCase.setFree(false);
        relatedCase.setPiece(newTowerBR);
        this.blackPieces.add(newTowerBL);
        this.blackPieces.add(newTowerBR);

        // adding queen
        CQueen newQueenB = new CQueen("\u265B",1,'D',8);
        relatedCase = plateau.getCaseWithCoordinate('D',8);
        relatedCase.setFree(false);
        relatedCase.setPiece(newQueenB);
        this.blackPieces.add(newQueenB);

        // adding king
        CKing newKingB = new CKing("\u265A",1,'E',8);
        relatedCase = plateau.getCaseWithCoordinate('E',8);
        relatedCase.setFree(false);
        relatedCase.setPiece(newKingB);
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
            button = null;
        }

        // black
        for (CPiece piece : this.blackPieces) {
            JButton button = createChessButton(piece, plateau);
            panel.add(button);
            button = null;
        }

    }

    private JButton createChessButton(CPiece piece, CPlateau plateau) {
//        JButton existingButton = piece.getButton();
//        if (existingButton != null) {
//            Container parent = existingButton.getParent();
//            if (parent != null) {
//                parent.remove(existingButton);
//            }
//        }
//
//        JButton button = new JButton(piece.getUnicode()); //
//        button.setBounds(
//                plateau.getAbscissaCoordinate(piece.getLetter()),
//                plateau.getordinateCoordinate(piece.getNumber()),
//                89,60
//        );
//
//        Font originalFont = button.getFont();
////        Font resizedFont = new Font("Arial Unicode MS", originalFont.getStyle(), 50);
//        Font resizedFont = new Font(originalFont.getName(), Font.PLAIN, uniformFontSize);
//        button.setFont(resizedFont);
//
//        button.setOpaque(false);
//        button.setContentAreaFilled(false);
//        button.setBorderPainted(false);
//
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
////                plateau.getCaseWithCoordinate(piece.getLetter(),piece.getNumber()).setColor(Color.CYAN);
//                clickPiece(piece);
//            }
//        });
//
////        button.addMouseListener(new MyMouseListener());
//        piece.setButton(button);
//        return button;
        JButton existingButton = piece.getButton();
        if (existingButton != null) {
            Container parent = existingButton.getParent();
            if (parent != null) {
                parent.remove(existingButton);
            }
            piece.setButton(null);
        }

        piece.setButton(new JButton(piece.getUnicode())); //
        piece.getButton().setBounds(
                plateau.getAbscissaCoordinate(piece.getLetter()),
                plateau.getordinateCoordinate(piece.getNumber()),
                89,60
        );

        Font originalFont = piece.getButton().getFont();
//        Font resizedFont = new Font("Arial Unicode MS", originalFont.getStyle(), 50);
        Font resizedFont = new Font(originalFont.getName(), Font.PLAIN, uniformFontSize);
        piece.getButton().setFont(resizedFont);

        piece.getButton().setOpaque(false);
        piece.getButton().setContentAreaFilled(false);
        piece.getButton().setBorderPainted(false);

        piece.getButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                plateau.getCaseWithCoordinate(piece.getLetter(),piece.getNumber()).setColor(Color.CYAN);
                clickPiece(piece);
            }
        });

//        button.addMouseListener(new MyMouseListener());
        return piece.getButton();
    }

    private Font getResizedFont(Font font, int newSize) {
        return font.deriveFont((float) newSize);
    }

    public void clickPiece(CPiece clickedPiece) {
        if (this.selectedPiece == null) {
            this.selectedPiece = clickedPiece;
            CCase startCase = plateau.getCaseWithCoordinate(clickedPiece.getLetter(),clickedPiece.getNumber());
            startCase.setColor(Color.CYAN);
            isAPieceSelected = true;
        }
        else {
            CCase lastCase = plateau.getCaseWithCoordinate(selectedPiece.getLetter(),selectedPiece.getNumber());
            lastCase.resetColor();
            this.selectedPiece = null;//clickedPiece;
//            CCase startCase = plateau.getCaseWithCoordinate(clickedPiece.getLetter(),clickedPiece.getNumber());
//            startCase.setColor(Color.CYAN);
        }
    }

    public CCase getCase(int x, int y) {
        return plateau.getCaseCoordinatePanel(x,y);
    }

    public boolean getSelected() {
        return isAPieceSelected;
    }

    public void setSelected(boolean newState) {
        this.isAPieceSelected = newState;
    }

    public void movingPiece(CPiece pieceToMove, char letter, int number, MonPanel panel) {
        /* function that move the piece to coordinate */
        // getting the case
        CCase caseToGo = plateau.getCaseWithCoordinate(letter, number);
        System.out.print("\ncoucouuggzgzu letter:"+caseToGo.getLetter()+"\tnumber:"+caseToGo.getNumber());
        // no piece on it
        if (caseToGo.getFree()) {
            CCase oldCase = plateau.getCaseWithCoordinate(pieceToMove.getLetter(),pieceToMove.getNumber());
            oldCase.setPiece(null);
            oldCase.setFree(true);
            oldCase.resetColor();

            pieceToMove.move(letter,number);
            System.out.print("\ncoucou letter: "+letter+"\nnumber: "+number);
            System.out.print("\nheeyy abscisse: "+plateau.getAbscissaCoordinate(letter)+"\nordonnee: "+plateau.getordinateCoordinate(number));
            pieceToMove.movingButton(plateau.getAbscissaCoordinate(letter),plateau.getordinateCoordinate(number));


            caseToGo.setFree(false);
            caseToGo.setPiece(pieceToMove);
            selectedPiece = null;
            isAPieceSelected = false;
        }
        // there is a piece on the case
        else {
            System.out.print("wesh");
            // checking the color of the piece0
            CPiece pieceOnTheCase = caseToGo.getPiece();
            // if opposite
            // then eat
            if (pieceOnTheCase.getColor() != pieceToMove.getColor()) {
                deletePiece(pieceOnTheCase.getColor(), pieceOnTheCase, panel);
                System.out.print("\nPiece on the case ?: "+caseToGo.getPiece());
                System.out.print("\nwhitepieces ? "+whitePieces.contains(pieceOnTheCase));
                System.out.print("\nblackpieces ?"+blackPieces.contains(pieceOnTheCase));
                pieceOnTheCase = null;


                CCase oldCase = plateau.getCaseWithCoordinate(pieceToMove.getLetter(),pieceToMove.getNumber());
                oldCase.setPiece(null);
                oldCase.setFree(true);
                oldCase.resetColor();

                pieceToMove.move(letter,number);
                System.out.print("\ncoucou walha letter: "+letter+"\nnumber: "+number);
                System.out.print("\nheeyy abscisse: "+plateau.getAbscissaCoordinate(letter)+"\nordonnee: "+plateau.getordinateCoordinate(number));
                pieceToMove.movingButton(plateau.getAbscissaCoordinate(letter),plateau.getordinateCoordinate(number));


                caseToGo.setFree(false);
                caseToGo.setPiece(pieceToMove);
                selectedPiece = null;
                isAPieceSelected = false;

                System.out.print("\nPiece on the case ?: "+caseToGo.getPiece());
            }
            // else
            // do nothing
            else {
                System.out.print("The case is already occupied");
            }
        }
    }

    public void deletePiece(int color, CPiece pieceToDelete, MonPanel panel) {
        if (color == 0) {
            whitePieces.remove(pieceToDelete);
            pieceToDelete.setButton(null);
        }
        else {
            blackPieces.remove(pieceToDelete);
            pieceToDelete.setButton(null);
        }
        plateau.getCaseWithCoordinate(pieceToDelete.getLetter(),pieceToDelete.getNumber()).setPiece(null);
        pieceToDelete.removeButtonFromPanel(panel);
    }

    public void moveSelected(char letter, int number, MonPanel panel) {
        movingPiece(selectedPiece, letter, number, panel);
    }
}
