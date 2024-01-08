package Model.piece;
import java.awt.Graphics;

public abstract class CPiece {
    private String name;
    private String unicode;
    private int color_; // 0 for white, 1 for black
    private char abscissa;
    private int ordinate;

    public CPiece(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        unicode = unicodeC;
        color_ = colorC;
        abscissa = abscissaC;
        ordinate = ordinateC;
    }

    public String getUnicode() {
        return unicode;
    }

    public char getLetter() {
        return abscissa;
    }
    public int getNumber() {
        return ordinate;
    }
}
