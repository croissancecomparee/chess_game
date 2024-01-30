package Model.piece;

public class CKnight extends CPiece{
    private String name = "Knight";

    public CKnight(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    }

    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo) {
        return false;
    }
}
