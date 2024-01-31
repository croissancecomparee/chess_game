package Model;

public class CPoint<Character, Integer> {
    private Character letter;
    private Integer number;

    public CPoint(Character newLetter, Integer newNumber) {
        this.letter = newLetter;
        this.number = newNumber;
    }

    public Character getLetter() {return letter;}
    public Integer getNumber() {return number;}
}
