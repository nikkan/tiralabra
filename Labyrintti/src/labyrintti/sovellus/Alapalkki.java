
package labyrintti.sovellus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Luokka vastaa käyttöliittymässä olevan alapalkin toteuttamisesta.
 * 
 * @author Anu N.
 */
public class Alapalkki {
    private JPanel alapalkki;
    private JButton uusi1, uusi2, uusi3, lopeta;
    
    /**
     * Konstruktori luo alapalkin ja siihen sisältyvät napit käyttöliittymään.
     * 
     * @param mainPanel Käyttöliittymän pääpaneli, johon alapalkki lisätään                
     */
    public Alapalkki(JPanel mainPanel ) {
        // luodaan alapalkki ja asetetaan taustaväri 
        this.alapalkki = new JPanel();
        this.alapalkki.setBackground(Color.black);
        
        // luodaan napit ja asetetaan ne klikattaviksi
        this.uusi1 = new JButton("Uusi 10x10");
        this.uusi1.setEnabled(true);
        this.uusi1.setFocusPainted(false);
        this.uusi2 = new JButton("Uusi 20x20");
        this.uusi2.setFocusPainted(false);
        this.uusi2.setEnabled(true);
        this.uusi3 = new JButton("Uusi 40x40");
        this.uusi3.setEnabled(true);
        this.uusi3.setFocusPainted(false);
        this.lopeta = new JButton("Lopeta");
        
        // lisätään napit alapalkkiin
        this.alapalkki.add(this.uusi1);
        this.alapalkki.add(this.uusi2);
        this.alapalkki.add(this.uusi3);
        this.alapalkki.add(this.lopeta);
        
        // Asetetaan alapalkin GridBag-rajoitukset 
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 5;
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 5;
        c.insets = new Insets(2,2,2,2);
        
        // lisätään alapalkki ja GridBag-rajoitukset mainPaneliin
        mainPanel.add(alapalkki, c);
        
    }
    
    
    public JButton get10x10() {
        return this.uusi1;
    }
    
    public JButton get20x20() {
        return this.uusi2;
    }
    
    public JButton get40x40() {
        return this.uusi3;
    }
    
    public JButton getLopeta() {
        return this.lopeta;
    }
    
    


    
}
