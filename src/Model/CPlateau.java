package Model;
import Model.piece.CPiece;

import java.awt.*;
import java.util.ArrayList;
import java.awt.Point;

public class CPlateau {
    // Attribut représentant la liste de cases
    private ArrayList<CCase> cases;
    private int weightCase = 80;
    private Point cointSuperieurGauche = new Point(0,0);
    private char[] letterCoordinate = new char[]{'A','B','C','D','E','F','G','H'};
    private Color[] color = new Color[]{Color.WHITE,new Color(152,129,242,100)};

    // Constructeur de la classe CPlateau
    public CPlateau() {
        // Initialisez la liste de cases dans le constructeur
        this.cases = new ArrayList<>();

        // ajout des valeurs:
        for (int i=1;i<10;i++) {
            for (int j=0;j<8;j++) {
                CCase nouvelleCase =
                    new CCase(
                        new Rectangle(
                                (int) cointSuperieurGauche.getX()+j*weightCase,
                                (int) cointSuperieurGauche.getY()+(9-i)*weightCase,
                                weightCase,weightCase),
                        this.color[(i+j)%2],
                        letterCoordinate[j],
                        i-1);
                this.cases.add(nouvelleCase);
            }
        }
    }

    public CCase getCase(int i,int j) {
        /* function that return Case with coordinate (i,j) avec i,j € [|1,8|]*/
//        System.out.print("\ni:"+i+"\tj:"+j);
        int k = 8*(j-1)+i;
//        System.out.print("\ncoordinate case "+k+":"+this.cases.get(8*j+i).getLetter()+","+this.cases.get(8*j+i).getNumber());
        return this.cases.get(8*(j-1)+i);
    }

    public CCase getCaseWithCoordinate(char letter, int j) {
        /* function that return Case with coordinate (a,j) avec a € [|A,H|] et j € [|1,8|]*/
        int i = 0;
        while (letter!=letterCoordinate[i]) {
            i++;
        }
//        System.out.print("\ncoordonnees:("+i+","+j+")");
        return getCase(i,j+1);
    }

    public CCase getCaseCoordinatePanel(int x, int y) {
        /* function that return Case with coordinate (x,y) avec x € [|0,640|] et y € [|0,720|] */
        int i = x/80 ;
        int j = y/80;
//        System.out.print("\ncoordonnees toto:("+i+","+j+")");
        return getCase(i,9-j+1);
    }

    public int getAbscissaCoordinate(char letter) {
        int i = 0;
        while (letter!=letterCoordinate[i]) {
            i++;
        }
        return weightCase*i;
    }

    public int getordinateCoordinate(int i) {
        return (9-i)*weightCase;
    }

    public int getWeightCase() {
        return weightCase;
    }
    public void draw(Graphics g) {
        for (int i=0;i<64;i++) {
            this.cases.get(i).draw(g);
        }
    }
}
