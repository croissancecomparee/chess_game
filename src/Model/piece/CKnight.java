package Model.piece;

import static java.lang.Math.abs;

public class CKnight extends CPiece{
    private String name = "Knight";

    public CKnight(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    }

    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo, boolean isCaseFree) {
        return (letterToNumber(letterToGo)<9)&(letterToNumber(letterToGo)>-1)&(numberToGo<9)&(numberToGo>-1)&(abs(letterToNumber(letterToGo)-letterToNumber(this.getLetter()))==1 & abs(numberToGo - this.getNumber())==2)||(abs(letterToNumber(letterToGo)-letterToNumber(this.getLetter()))==2 & abs(numberToGo - this.getNumber())==1);
    }
}
