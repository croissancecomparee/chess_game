package Model.piece;
import javax.swing.*;
import java.awt.Graphics;

public abstract class CPiece {
    private String name;
    private String unicode;
    private int color_; // 0 for white, 1 for black
    private char abscissa;
    private int ordinate;
    private boolean selected = false;
    private JButton button;
    private int widthButton=89;
    private int heightButton=60;

    public CPiece(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        unicode = unicodeC;
        color_ = colorC;
        abscissa = abscissaC;
        ordinate = ordinateC;
    }

    public String getUnicode() { return unicode; }

    public char getLetter() {
        System.out.print("\nLetter:"+abscissa);
        return abscissa;
    }
    public int getNumber() {
        System.out.print("\nNumber:"+ordinate);
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
}
