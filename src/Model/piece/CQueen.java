package Model.piece;

import static java.lang.Math.abs;

public class CQueen extends CPiece{
    private String name = "Queen";

    public CQueen(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    };
    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo) {
        return (letterToNumber(letterToGo)<9)&(letterToNumber(letterToGo)>-1)&(numberToGo<9)&(numberToGo>-1)&(abs(letterToNumber(letterToGo)-letterToNumber(this.getLetter())) == abs(numberToGo - this.getNumber())) || (letterToGo==this.getLetter() || numberToGo==this.getNumber());
    }
}
