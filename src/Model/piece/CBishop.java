package Model.piece;

import Model.CPoint;

import java.util.List;

import static java.lang.Math.abs;

public class CBishop extends CPiece{
    private String name = "Bishop";

    public CBishop(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    };
    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo, boolean isCaseFree) {
        return (letterToNumber(letterToGo)<9)&(letterToNumber(letterToGo)>-1)&(numberToGo<9)&(numberToGo>-1)&abs(letterToNumber(letterToGo)-letterToNumber(this.getLetter())) == abs(numberToGo - this.getNumber());
    }
}
