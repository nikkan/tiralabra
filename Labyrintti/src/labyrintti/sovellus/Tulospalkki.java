
package labyrintti.sovellus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Luokka vastaa Labyrintti-ohjelman graafisessa käyttöliittymässä olevan
 * tulospalkin toteuttamisesta.
 * 
 * @author Anu N.
 */
public class Tulospalkki {
    private JPanel palkki;
    private JLabel tulos;
    
    /**
     * Konstruktori luo tulospalkin ja lisää sen käyttöliittymään.
     * 
     * @param mainPanel Käyttöliittymän pääpaneli, johon alapalkki lisätään             
     */
    public Tulospalkki(JPanel mainPanel) {
     
        // luodaan tulospalkki ja asetetaan sen asetukset
        this.palkki = new JPanel();
        this.palkki.setOpaque(true);
        this.palkki.setBackground(Color.LIGHT_GRAY);
        
        this.tulos = new JLabel();
        this.palkki.add(this.tulos);
      
        // Asetetaan GridBag-rajoitukset
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 2;
        c.gridheight = 2;
        c.insets = new Insets(2,0,0,0);
        c.fill = GridBagConstraints.BOTH;
        
        // lisätään palkki pääpaneliin
        mainPanel.add(this.palkki, c);
        
    }
    
    public JLabel getTuloskentta() {
        return this.tulos;
    }


    
}
