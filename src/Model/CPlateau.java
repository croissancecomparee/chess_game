package Model;
import Model.piece.CPiece;
import gui.MonPanel;

import javax.swing.*;
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
        for (int i=1;i<9;i++) {
            for (int j=0;j<8;j++) {
                CCase nouvelleCase =
                    new CCase(
                        new Rectangle(
                                (int) cointSuperieurGauche.getX()+j*weightCase,
                                (int) cointSuperieurGauche.getY()+(9-i)*weightCase,
                                weightCase,weightCase),
                        this.color[(i+j)%2],
                        letterCoordinate[j],
                        i);
                this.cases.add(nouvelleCase);
            }
        }
    }

    public CCase getCase(int i,int j) {
        /* function that return Case with coordinate (i,j) avec i,j € [|1,8|]*/
        if (i<8 & i>-1 & j<9 & j>0) {
            //        System.out.print("\ni:"+i+"\tj:"+j);
            int k = 8 * (j - 1) + i;
            //        System.out.print("\ncoordinate case "+k+":"+this.cases.get(8*j+i).getLetter()+","+this.cases.get(8*j+i).getNumber());
            return this.cases.get(8 * (j - 1) + i);
        }
        else {
            System.out.print("\ncase out of limit\n");
            return null;
        }
    }

    public CCase getCaseWithCoordinate(char letter, int j) {
        /* function that return Case with coordinate (a,j) avec a € [|A,H|] et j € [|1,8|]*/
        int i = 0;
        while (letter!=letterCoordinate[i]) {
            i++;
        }
//        System.out.print("\ncoordonnees:("+i+","+j+")");
        return getCase(i,j);
    }

    public CCase getCaseCoordinatePanel(int x, int y) {
        /* function that return Case with coordinate (x,y) avec x € [|0,640|] et y € [|0,720|] */
        int i = x/80 ;
        int j = y/80;
//        System.out.print("\ncoordonnees toto:("+i+","+j+")");
        return getCase(i,9-j);
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
    public void draw(Graphics g, MonPanel panel) {
        for (int i=0;i<64;i++) {
            this.cases.get(i).draw(g);
        }
        for (int i=0;i<8;i++) {
            JLabel abscissa = new JLabel(Character.toString(letterCoordinate[i]));
            JLabel ordinate = new JLabel(i+1+"");
            abscissa.setBounds(
                    (int) cointSuperieurGauche.getX()+(i)*weightCase+30,
                    (int) cointSuperieurGauche.getY()+9*weightCase,
                    89,60
            );
            ordinate.setBounds(
                    (int) cointSuperieurGauche.getX()+(8)*weightCase+30,
                    (int) cointSuperieurGauche.getY()+(8-i)*weightCase,
                    89,60
            );

            Font originalFont = abscissa.getFont();
//            Font resizedFont = new Font(originalFont.getName(), Font.PLAIN, 2);
//            abscissa.setFont(resizedFont);
//            ordinate.setFont(resizedFont);
            panel.add(abscissa);
            panel.add(ordinate);
        }
    }
}
