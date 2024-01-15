package Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class CCase{
    private char abscissa;
    private int ordinate;
    private Rectangle rectangle;
    private Color color;
    private boolean free;
    public CCase(Rectangle rectangle, Color color, String s, int i, boolean free){
        this.rectangle = new Rectangle(0,0,50,50);
    }
    public CCase(Rectangle rectangle, Color color, char letter, int number, boolean free) {
        this.rectangle = rectangle;
        this.abscissa = letter;
        this.ordinate = number;
        this.color = color;
        this.free = free;
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
    public boolean getFree() {
        return free;
    }
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
