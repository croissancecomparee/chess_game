package Model.piece;

public class CTower extends CPiece{
    private String name = "Tower";

    public CTower(String unicodeC, int colorC, char abscissaC, int ordinateC) {
        super(unicodeC,colorC,abscissaC,ordinateC);
    };
    @Override
    public boolean getLegalMove(char letterToGo, int numberToGo) {
        return (letterToNumber(letterToGo)<9)&(letterToNumber(letterToGo)>-1)&(numberToGo<9)&(numberToGo>-1)&(letterToGo==this.getLetter() || numberToGo==this.getNumber());
    }
}
