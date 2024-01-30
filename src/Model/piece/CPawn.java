package Model.piece;

public class CPawn extends CPiece{
    private String name="Pawn";

    public CPawn(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    };
    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo) {
        return false;
    }
}
