package Model.piece;
import gui.MonPanel;

import javax.swing.*;
import java.awt.*;

public abstract class CPiece {
    private String name;
    private String unicode;
    private int color; // 0 for white, 1 for black
    private char abscissa;
    private int ordinate;
    private boolean selected = false;
    private JTextArea textArea;
    private int widthTextArea=150;
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
        abscissa = letter;
        ordinate = number;
    }

    public void movingTextArea(int x, int y) {
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
            textArea = null;
        }
    }
}
