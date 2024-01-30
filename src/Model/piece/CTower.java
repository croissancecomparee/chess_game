package Model.piece;

public class CTower extends CPiece{
    private String name = "Tower";

    public CTower(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    };
    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo) {
        return (letterToGo==this.getLetter() || numberToGo==this.getNumber());
    }
}
