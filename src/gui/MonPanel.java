package gui;

import java.awt.Graphics;
import javax.swing.JPanel;

public class MonPanel extends JPanel{
    private FenetrePrincipale maFenetrePrincipale;

    public MonPanel(FenetrePrincipale fenetrePrincipale) {
        maFenetrePrincipale = fenetrePrincipale;
    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      maFenetrePrincipale.draw(g);
    }

}
