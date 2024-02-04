package Model.piece;

import Model.CPoint;

import java.util.List;

import static java.lang.Math.abs;

public class CPawn extends CPiece{

    public CPawn(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    }

    ;
    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo, boolean isCaseFree) {
        boolean res = (letterToNumber(letterToGo)<9)&(letterToNumber(letterToGo)>-1)&(numberToGo<9)&(numberToGo>-1);
        // the player tries to take a piece
        if (!isCaseFree) {
            if (this.getColor() == 0) {
                res = res & ((numberToGo - this.getNumber()) == 1) & (abs(letterToNumber(letterToGo)-letterToNumber(this.getLetter())) == 1);
            }
            else {
                res = res & ((this.getNumber() - numberToGo) == 1) & (abs(letterToNumber(letterToGo)-letterToNumber(this.getLetter())) == 1);
            }
        }

        // the player just advance his pawn
        else {
            if (this.getColor() == 0) {
                if (this.getNumber() == 2) {
                    res = res & (letterToGo == this.getLetter()) & ((numberToGo - this.getNumber()) <= 2) & (numberToGo - this.getNumber()) >= 0;
                } else {
                    res = res & (letterToGo == this.getLetter()) & ((numberToGo - this.getNumber()) == 1);
                }
            } else {
                if (this.getNumber() == 7) {
                    res = res & (letterToGo == this.getLetter()) & ((this.getNumber() - numberToGo) <= 2) & (this.getNumber() - numberToGo) >= 0;
                } else {
                    res = res & (letterToGo == this.getLetter()) & ((this.getNumber() - numberToGo) == 1);
                }
            }
        }
        return res;
    }
}
