package gui;

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MonPanel extends JPanel {
    // Reference sur la fenetPrincipales;

    private FenetrePrincipale maFenetrePrincipale;

    public MonPanel(FenetrePrincipale fenetrePrincipale) {
        maFenetrePrincipale = fenetrePrincipale;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // On appel la methode dessiner de la fenetre principale...
        maFenetrePrincipale.draw(g);
    }
}
