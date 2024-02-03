package Model.piece;
import gui.MonPanel;
import Model.CPoint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;


public abstract class CPiece {
    private String name;
    private String unicode;
    private int color; // 0 for white, 1 for black
    private char abscissa;
    private int ordinate;
    private boolean selected = false;
    private JTextArea textArea;
    private int widthTextArea=70;
    private int heightTextArea=60;

    public CPiece(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        unicode = unicodeC;
        color = colorC;
        abscissa = abscissaC;
        ordinate = ordinateC;
    }

    public String getUnicode() { return unicode; }

    public char getLetter() {
        return abscissa;
    }
    public int letterToNumber(char letter) {
        char[] letterCoordinate = new char[]{'A','B','C','D','E','F','G','H'};
        int i = 0;
        while (letter != letterCoordinate[i]) {
            i+=1;
        }
        return i;
    }
    public int getNumber() {
        return ordinate;
    }
    public boolean getSelected() {
        return selected;
    }
    public void setSelected(boolean newState) {
        selected = newState;
    }
    public JTextArea getTextArea () {
        return textArea;
    }
    public String getName() {return name;}
    public void setTextArea (JTextArea newTextArea) {
        textArea = newTextArea;
    }

    public void setUnicode(String newUnicode) {unicode = newUnicode;}

    public int getColor() {
        return color;
    }

    public void dispose() {
        abscissa = 'Z';
        ordinate = -1;
    }

    public void move(char letter, int number) {
        /* function that move a piece to coordinate in entry
        * the case is supposed to be free
        * */
//        System.out.print("\nmoving the piece to: "+letter+"\t"+number);
        abscissa = letter;
        ordinate = number;
    }

    public void movingTextArea(int x, int y) {
//        System.out.print("\nmoving to coordinate: "+x+"\t"+y);
        textArea.setBounds(x,y,widthTextArea,heightTextArea);
    }
    public void removeTextAreaFromPanel(MonPanel panel) {
        JTextArea textArea = getTextArea();
        if (textArea != null) {
            Container parent = textArea.getParent();
            if (parent != null) {
//            button.setVisible(false);
//            button.setEnabled(false);
                parent.remove(textArea);
                parent.revalidate();
                parent.repaint();
            }
            setTextArea(null);
            panel.remove(textArea);
            panel.repaint();
        }
    }

    // Function that check that the case where we want to go correspond to case available depending on the type of movement of the piece
    public abstract boolean getLegalMove(char letterToGo,int numberToGo, boolean isCaseFree);

    // Function that get all the intermediate cases between the beginning case and the case to go available, depending on the type of movement of the piece
    // we assume that the move is legal
    public List<CPoint<Character, Integer>> getIntermediateCases (char letterToGo, int numberToGo) {
        List<CPoint<Character, Integer>> res =new ArrayList<>();
        char[] letterCoordinate = new char[]{'A','B','C','D','E','F','G','H'};

        // getting the index of the letters
        int indexLetterToGo = letterToNumber(letterToGo);
        int indexLetter = letterToNumber(abscissa);

        // getting the direction
        int horizontalDirection = indexLetterToGo>indexLetter?1:(indexLetterToGo<indexLetter?-1:0);
        int verticalDirection = numberToGo>ordinate?1:(numberToGo<ordinate?-1:0);

        // run through the cases between
        int i = indexLetter;
        int j = ordinate;
        i += horizontalDirection;
        j += verticalDirection;
        while (i!=indexLetterToGo || j!=numberToGo) {
            res.add(new CPoint<>(letterCoordinate[i],j));

            i += horizontalDirection;
            j += verticalDirection;
        }

        return res;
    }
}
