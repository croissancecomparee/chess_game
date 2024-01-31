package Model.piece;

import static java.lang.Math.abs;

public class CPawn extends CPiece{
    private String name="Pawn";

    public CPawn(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    };
    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo) {
        boolean res = (letterToNumber(letterToGo)<9)&(letterToNumber(letterToGo)>-1)&(numberToGo<9)&(numberToGo>-1);
        if (this.getColor() == 0) {
            if (this.getNumber()==2) {
                res = res&(letterToGo==this.getLetter())&((numberToGo-this.getNumber())<=2)&(numberToGo-this.getNumber())>=0;
            }
            else {
                res = res&(letterToGo==this.getLetter())&((numberToGo-this.getNumber())==1);
            }
        }
        else {
            if (this.getNumber()==7) {
                res = res&(letterToGo==this.getLetter())&((this.getNumber()-numberToGo)<=2)&(this.getNumber()-numberToGo)>=0;
            }
            else {
                res = res&(letterToGo==this.getLetter())&((this.getNumber()-numberToGo)==1);
            }
        }
        return res;
    }
}
