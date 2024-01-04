package Model;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Point;

public class CPlateau {
    // Attribut représentant la liste de cases
    private ArrayList<CCase> cases;
    private int weightCase = 50;
    private Point cointSuperieurGauche = new Point(0,0);
    private char[] letterCoordinate = new char[]{'A','B','C','D','E','F','G','H'};
    private Color[] color = new Color[]{Color.GREEN,Color.PINK};

    // Constructeur de la classe CPlateau
    public CPlateau() {
        // Initialisez la liste de cases dans le constructeur
        this.cases = new ArrayList<>();

        // ajout des valeurs:
        for (int i=1;i<9;i++) {
            for (int j=0;j<8;j++) {
                CCase nouvelleCase = new CCase(new Rectangle((int) cointSuperieurGauche.getX()+j*weightCase,(int) cointSuperieurGauche.getY()+i*weightCase,weightCase,weightCase), this.color[(i+j)%2],letterCoordinate[j],i,true);
                this.cases.add(nouvelleCase);
            }
        }
    }

    public CCase getCase(int i,int j) {
        return this.cases.get(i*j);
    }

    public void draw(Graphics g) {
        for (int i=0;i<64;i++) {
            this.cases.get(i).draw(g);
        }
    }
}
