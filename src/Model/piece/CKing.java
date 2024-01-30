package Model.piece;

import static java.lang.Math.abs;

public class CKing extends CPiece{
    private String name = "King";

    public CKing(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    };
    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo) {
        return abs(letterToNumber(letterToGo)-letterToNumber(this.getLetter())) == 1 || abs(numberToGo - this.getNumber()) == 1;
    }
}
