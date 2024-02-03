package Model;
import Model.piece.CBishop;
import Model.piece.CPawn;
import Model.piece.CPiece;
import Model.piece.CKnight;
import Model.piece.CKing;
import Model.piece.CQueen;
import Model.piece.CTower;
import Model.CPoint;
import gui.MonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CGame {
    private CPlateau plateau;
    private ArrayList<CPiece> pieces;
    private char[] letterCoordinate = new char[]{'A','B','C','D','E','F','G','H'};
    private int uniformFontSize = 53;

    private CPiece selectedPiece = null;

//    private JTextArea TextArea;

    public CGame() {
        plateau = new CPlateau();

        // initialisation of white pieces array
        this.pieces = new ArrayList<>();

        // adding white pawns
        for (int i=0;i<8;i++) {
            CPawn newPawn = new CPawn("\u2659",0,letterCoordinate[i],2);
            CCase relatedCase = plateau.getCaseWithCoordinate(letterCoordinate[i],2);
            relatedCase.setPiece(newPawn);
//            System.out.print(" x: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+ relatedCase.getPiece());
            this.pieces.add(newPawn);
        }

        // adding Knights L : Left, R : Right
        CKnight newKnightWL = new CKnight("\u2658",0,'B',1);
        CKnight newKnightWR = new CKnight("\u2658",0,'G',1);
        CCase relatedCase = plateau.getCaseWithCoordinate('B',1);
        relatedCase.setPiece(newKnightWL);
        relatedCase = plateau.getCaseWithCoordinate('G', 1);
        relatedCase.setPiece(newKnightWR);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        this.pieces.add(newKnightWL);
        this.pieces.add(newKnightWR);

        // adding bishops L : Left, R : Right
        CBishop newBishopWL = new CBishop("\u2657",0,'C',1);
        CBishop newBishopWR = new CBishop("\u2657",0,'F',1);
        relatedCase = plateau.getCaseWithCoordinate('C',1);
        relatedCase.setPiece(newBishopWL);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        relatedCase = plateau.getCaseWithCoordinate('F',1);
        relatedCase.setPiece(newBishopWR);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        this.pieces.add(newBishopWL);
        this.pieces.add(newBishopWR);

        // adding towers L : Left, R : Right
        CTower newTowerWL = new CTower("\u2656",0,'A',1);
        CTower newTowerWR = new CTower("\u2656",0,'H',1);
        relatedCase = plateau.getCaseWithCoordinate('A',1);
        relatedCase.setPiece(newTowerWL);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        relatedCase = plateau.getCaseWithCoordinate('H',1);
        relatedCase.setPiece(newTowerWR);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        this.pieces.add(newTowerWL);
        this.pieces.add(newTowerWR);

        // adding queen
        CQueen newQueenW = new CQueen("\u2655",0,'D',1);
        relatedCase = plateau.getCaseWithCoordinate('D',1);
        relatedCase.setPiece(newQueenW);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        this.pieces.add(newQueenW);

        // adding king
        CKing newKingW = new CKing("\u2654",0,'E',1);
        relatedCase = plateau.getCaseWithCoordinate('E',1);
        relatedCase.setPiece(newKingW);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        this.pieces.add(newKingW);

        // adding black pawns
        for (int i=0;i<8;i++) {
            CPawn newPawn = new CPawn("\u265F",1,letterCoordinate[i],7);
            relatedCase = plateau.getCaseWithCoordinate(letterCoordinate[i],7);
            relatedCase.setPiece(newPawn);
            System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
            this.pieces.add(newPawn);
        }

        // adding Knights L : Left, R : Right
        CKnight newKnightBL = new CKnight("\u265E",1,'B',8);
        CKnight newKnightBR = new CKnight("\u265E",1,'G',8);
        relatedCase = plateau.getCaseWithCoordinate('B',8);
        relatedCase.setPiece(newKnightBL);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        relatedCase = plateau.getCaseWithCoordinate('G',8);
        relatedCase.setPiece(newKnightBR);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        this.pieces.add(newKnightBL);
        this.pieces.add(newKnightBR);

        // adding bishops L : Left, R : Right
        CBishop newBishopBL = new CBishop("\u265D",1,'C',8);
        CBishop newBishopBR = new CBishop("\u265D",1,'F',8);
        relatedCase = plateau.getCaseWithCoordinate('C',8);
        relatedCase.setPiece(newBishopBL);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        relatedCase = plateau.getCaseWithCoordinate('F',8);
        relatedCase.setPiece(newBishopBR);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        this.pieces.add(newBishopBL);
        this.pieces.add(newBishopBR);

        // adding towers L : Left, R : Right
        CTower newTowerBL = new CTower("\u265C",1,'A',8);
        CTower newTowerBR = new CTower("\u265C",1,'H',8);
        relatedCase = plateau.getCaseWithCoordinate('A',8);
        relatedCase.setPiece(newTowerBL);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        relatedCase = plateau.getCaseWithCoordinate('H',8);
        relatedCase.setPiece(newTowerBR);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        this.pieces.add(newTowerBL);
        this.pieces.add(newTowerBR);

        // adding queen
        CQueen newQueenB = new CQueen("\u265B",1,'D',8);
        relatedCase = plateau.getCaseWithCoordinate('D',8);
        relatedCase.setPiece(newQueenB);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        this.pieces.add(newQueenB);

        // adding king
        CKing newKingB = new CKing("\u265A",1,'E',8);
        relatedCase = plateau.getCaseWithCoordinate('E',8);
        relatedCase.setPiece(newKingB);
        System.out.print("\nx: "+relatedCase.getLetter()+" y: "+relatedCase.getNumber()+"\t"+ relatedCase.getPiece());
        this.pieces.add(newKingB);
    }

    /*// A voir si c plus simple de passer par une fonction ou pas
    public void initPieces(int color) {

    }*/

    public void draw(Graphics g, MonPanel panel) {
        this.plateau.draw(g,panel);
    }

    public void drawPieces(MonPanel panel) {
        for (CPiece piece : this.pieces) {
            JTextArea textArea = createChessTextArea(piece, plateau);

            textArea.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (isSelected()) {
                        System.out.print("\na piece is selected");
                        CCase aCase = plateau.getCaseWithCoordinate(piece.getLetter(),piece.getNumber());
                        System.out.print("\nclicked case letter: "+aCase.getLetter()+"\tnumber: "+aCase.getNumber());
                        moveSelected(aCase.getLetter(),aCase.getNumber(), panel);
                        panel.repaint();
                    }
                    else {
                        clickPiece(piece);
                        panel.repaint();
                        System.out.print("\npiece cliquee: " + piece);
                    }
                }
            });
            panel.add(textArea);
        }
    }

    private JTextArea createChessTextArea(CPiece piece, CPlateau plateau) {
        // create the textArea
        JTextArea existingTextArea = piece.getTextArea();
        if (existingTextArea != null) {
            Container parent = existingTextArea.getParent();
            if (parent != null) {
                parent.remove(existingTextArea);
            }
            piece.setTextArea(null);
        }

        piece.setTextArea(new JTextArea(piece.getUnicode())); //
        piece.getTextArea().setBounds(
                plateau.getAbscissaCoordinate(piece.getLetter()),
                plateau.getordinateCoordinate(piece.getNumber()),
                89,60
        );

        Font originalFont = piece.getTextArea().getFont();
        Font resizedFont = new Font(originalFont.getName(), Font.PLAIN, uniformFontSize);
        piece.getTextArea().setFont(resizedFont);

        piece.getTextArea().setOpaque(false);
        return piece.getTextArea();
    }

//    private Font getResizedFont(Font font, int newSize) {
//        return font.deriveFont((float) newSize);
//    }

    public void clickPiece(CPiece clickedPiece) {
        if (this.selectedPiece == null) {
            // when none piece are selected, so we click on a piece
            this.selectedPiece = clickedPiece;
            setSelectedPiece(clickedPiece);
            System.out.print("\npiece cliquée: "+clickedPiece);
            CCase startCase = plateau.getCaseWithCoordinate(clickedPiece.getLetter(),clickedPiece.getNumber());
            System.out.print("\nclickpiece letter: "+clickedPiece.getLetter()+" number: "+clickedPiece.getNumber());
            startCase.setColor(Color.CYAN);
            System.out.print("\ncouleur: "+startCase.getColor());
        }
        else {
            // normally we don't go there, unselect the piece just in case in order to avoid bugx²²
            System.out.print("\nselected letter: "+selectedPiece.getLetter()+" number: "+selectedPiece.getNumber());
            this.selectedPiece = null;
        }
    }

    public CCase getCase(int x, int y) {
        return plateau.getCaseCoordinatePanel(x,y);
    }

    public boolean isSelected() { return selectedPiece!=null; }

    public void setSelectedPiece(CPiece newSelectedPiece) {
        selectedPiece = newSelectedPiece;
    }

    public void movingPiece(CPiece pieceToMove, char letter, int number, MonPanel panel) {
        /* function that move the piece to coordinate */
        // getting the case
        CCase caseToGo = plateau.getCaseWithCoordinate(letter, number);
        System.out.print("\nmoving piece to case: letter:"+caseToGo.getLetter()+"\tnumber:"+caseToGo.getNumber());
        // no piece on it
        // checking if it is a legal move or not
        if (pieceToMove.getLegalMove(letter, number, caseToGo.isFree())) {
            System.out.print("\nThe move is legal");

            // getting all the intermediate cases between the beginning case and the case to go
            List<CPoint<Character, Integer>> listInterCases =pieceToMove.getIntermediateCases(letter,number);
            // checking that all the intermediate cases are empty
            boolean isAllEmpty = true; // true by default, in case the list is empty
            if (!listInterCases.isEmpty()) {
                System.out.print("\nthere is intermediate case");
                System.out.print("\ntaille liste: "+listInterCases.size());
                for (CPoint<Character, Integer> cPoint : listInterCases) {
                    isAllEmpty = isAllEmpty & plateau.getCaseWithCoordinate(cPoint.getLetter(), cPoint.getNumber()).isFree();
                    System.out.print("\nCase verified letter: " + cPoint.getLetter() + "\tnumber: " + cPoint.getNumber() + "\test-elle vide ? " + isAllEmpty);
                }
            }
            else {
                System.out.print("\nno intermediate case");
            }

            if (isAllEmpty) {
                System.out.print("\nNo intermediate occupied case");

                if (caseToGo.isFree()) {
                    System.out.print("\nsetselected case libre letter:" + pieceToMove.getLetter() + "\tnumber:" + pieceToMove.getNumber());
                    CCase oldCase = plateau.getCaseWithCoordinate(pieceToMove.getLetter(), pieceToMove.getNumber());
                    plateau.getCaseWithCoordinate(pieceToMove.getLetter(), pieceToMove.getNumber()).setPiece(null);
                    plateau.getCaseWithCoordinate(pieceToMove.getLetter(), pieceToMove.getNumber()).resetColor();
                    System.out.print("\ncouleur oldcase: " + oldCase.getColor());
                    System.out.print("\nmoving piece from case: letter:" + oldCase.getLetter() + "\tnumber:" + oldCase.getNumber());
                    System.out.print("\nthe piece on the old case: "+oldCase.getPiece());

                    pieceToMove.move(letter, number);
                    System.out.print("\ncase to go letter: " + letter + "\tnumber: " + number);
                    System.out.print("\nmoving to this case abscisse: " + plateau.getAbscissaCoordinate(letter) + "\tordonnee: " + plateau.getordinateCoordinate(number));
                    pieceToMove.movingTextArea(plateau.getAbscissaCoordinate(letter), plateau.getordinateCoordinate(number));

                    caseToGo.setPiece(pieceToMove);
                    System.out.print("\nmoving piece to case: letter:"+caseToGo.getLetter()+"\tnumber:"+caseToGo.getNumber()+"\t"+caseToGo.getPiece()+"\n");
                    //            plateau.getCaseWithCoordinate(letter, number-1).setColor(Color.GREEN);
                    selectedPiece = null;
                }
                // there is a piece on the case
                else {
                    // checking the color of the piece0
                    CPiece pieceOnTheCase = caseToGo.getPiece();
                    System.out.print("\npiece: " + caseToGo.getPiece());
                    // if opposite
                    // then eat
                    if (pieceOnTheCase.getColor() != pieceToMove.getColor()) {
                        pieces.remove(pieceOnTheCase);
                        deletePiece(caseToGo.getPiece(), panel);
                        pieceOnTheCase.move('Z', -1);
                        pieceOnTheCase.movingTextArea(1000, 10000);
                        System.out.print("\nPiece on the case ?: " + caseToGo.getPiece());
                        System.out.print("\npieces in the table? " + pieces.contains(pieceOnTheCase));

                        CCase oldCase = plateau.getCaseWithCoordinate(pieceToMove.getLetter(), pieceToMove.getNumber());
                        oldCase.setPiece(null);
                        plateau.getCaseWithCoordinate(pieceToMove.getLetter(), pieceToMove.getNumber()).resetColor();
                        //                oldCase.resetColor();
                        //
                        pieceToMove.move(letter, number);
                        System.out.print("\ncase to go letter: " + letter + "\nnumber: " + number);
                        System.out.print("\ncase to go abscisse: " + plateau.getAbscissaCoordinate(letter) + "\nordonnee: " + plateau.getordinateCoordinate(number));
                        pieceToMove.movingTextArea(plateau.getAbscissaCoordinate(letter), plateau.getordinateCoordinate(number));
                        //
                        caseToGo.setPiece(pieceToMove);
                        selectedPiece = null;

                        System.out.print("\nPiece on the case ?: " + caseToGo.getPiece());
                    }
                    // else
                    // do nothing
                    else {
                        if (pieceToMove.getLetter() == letter & pieceToMove.getNumber() == number) {
                            selectedPiece = null;
                            plateau.getCaseWithCoordinate(pieceToMove.getLetter(), pieceToMove.getNumber()).resetColor();
                        }
                        System.out.print("The case is already occupied");
                    }
                }
            }
            else {
                System.out.print("\nA case is occupied between the destination case and the departure case");
            }
        }
        else {
            if (pieceToMove.getLetter() == letter & pieceToMove.getNumber() == number) {
                selectedPiece = null;
                plateau.getCaseWithCoordinate(pieceToMove.getLetter(), pieceToMove.getNumber()).resetColor();
            }
            System.out.print("\nThe move is not legal\n");
        }
    }

    public void deletePiece(CPiece pieceToDelete, MonPanel panel) {
//        pieces.remove(pieceToDelete);
//        System.out.print("\n ou es tu ?"+pieces.contains(pieceToDelete));
        pieceToDelete.setUnicode("");
//        pieceToDelete.setTextArea(null);
//        plateau.getCaseWithCoordinate(pieceToDelete.getLetter(),pieceToDelete.getNumber()).setPiece(null);
//        pieceToDelete.removeTextAreaFromPanel(panel);
//        pieceToDelete.dispose();
    }

    public void moveSelected(char letter, int number, MonPanel panel) {
        movingPiece(selectedPiece, letter, number, panel);
    }

    public void dispose() {
        for (CPiece piece : this.pieces) {
            piece.move('Z', -1);
            piece.movingTextArea(1000, 10000);
        }
    }
}
