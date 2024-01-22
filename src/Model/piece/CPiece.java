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
    private JButton button;
    private int widthButton=89;
    private int heightButton=60;

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
    public JButton getButton () {
        return button;
    }
    public void setButton (JButton newButton) {
        button = newButton;
    }

    public int getColor() {
        return color;
    }

    public void move(char letter, int number) {
        /* function that move a piece to coordinate in entry
        * the case is supposed to be free
        * */
        abscissa = letter;
        ordinate = number;
    }

    public void movingButton(int x, int y) {
        button.setBounds(x,y,widthButton,heightButton);
    }
    public void removeButtonFromPanel(MonPanel panel) {
        JButton button = getButton();
        if (button != null) {
            Container parent = button.getParent();
            if (parent != null) {
//            button.setVisible(false);
//            button.setEnabled(false);
                parent.remove(button);
                parent.revalidate();
                parent.repaint();
            }
            setButton(null);
            panel.remove(button);
            panel.repaint();
            button = null;
        }
    }
}
