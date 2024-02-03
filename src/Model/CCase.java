package Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import Model.piece.CPiece;

public class CCase{
    private char abscissa;
    private int ordinate;
    private Rectangle rectangle;
    private Color color;
    private Color baseColor;
    private CPiece relatedPiece = null;
    public CCase(Rectangle rectangle, Color color, String s, int i){
        this.rectangle = new Rectangle(0,0,50,50);
    }
    public CCase(Rectangle rectangle, Color color, char letter, int number) {
        this.rectangle = rectangle;
        this.abscissa = letter;
        this.ordinate = number;
        this.color = color;
        this.baseColor = color;
    }
    public char getLetter() {
        return abscissa;
    }
    public int getNumber() {
        return ordinate;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color newColor) {this.color = newColor;}
    public void resetColor() {this.color = this.baseColor; }
    public boolean isFree() {
        return relatedPiece==null;
    }
    public CPiece getPiece() {return relatedPiece;}
    public void setPiece(CPiece newPiece) {relatedPiece = newPiece;}
    public void draw(Graphics g) {
        // changing the pencil color:
        g.setColor(this.getColor());
        //drawing the rectangle here
        g.fillRect(
                (int) rectangle.getX(),
                (int) rectangle.getY(),
                (int) rectangle.getWidth(),
                (int) rectangle.getHeight()
        );
    }
}
