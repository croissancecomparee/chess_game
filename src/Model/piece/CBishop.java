package Model.piece;

import static java.lang.Math.abs;

public class CBishop extends CPiece{
    private String name = "Bishop";

    public CBishop(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    };
    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo) {
        return abs(letterToNumber(letterToGo)-letterToNumber(this.getLetter())) == abs(numberToGo - this.getNumber());
    }
}
