package Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class CCase{
    private char letter;
    private int number;
    private Rectangle rectangle;
    private Color color;
    private boolean free;
    public CCase(){
        rectangle = new Rectangle(0,0,50,50);
    }
    public CCase(Rectangle rectangle, Color color, char letter, int number, boolean free) {
        this.rectangle = rectangle;
        this.letter = letter;
        this.number = number;
        this.color = color;
        this.free = free;
    }
    public char getLetter() {
        return letter;
    }
    public int getNumber() {
        return number;
    }
    public Color getColor() {
        return color;
    }
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
