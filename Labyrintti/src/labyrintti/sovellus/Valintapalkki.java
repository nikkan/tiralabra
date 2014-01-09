
package labyrintti.sovellus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Luokka vastaa Labyrintti-ohjelman graafisessa käyttöliittymässä olevan
 * valintapalkin toteuttamisesta.
 * 
 * @author Anu N.
 */
public class Valintapalkki {
    
    private JButton astar;
    private JButton astarJPS;
    // tee vielä Dijkstralle oma!
    private JPanel palkki;
    private JLabel algoritmi;
    private JLabel tulosAstar;
    private JLabel tulosAstarJPS;
    
   /**
    * Konstruktori luo pistepalkin ja siihen sisältyvät komponentit käyttöliittymään.
    * 
    * @param mainPanel Käyttöliittymän pääpaneli, johon Pistepalkki lisätään                     
    */
    public Valintapalkki(JPanel mainPanel) {
        // Luodaan palkki ja laitetaan sille asetukset
        this.palkki = new JPanel(new GridLayout(6, 1));
        this.palkki.setOpaque(true);
        this.palkki.setBackground(Color.LIGHT_GRAY);
        
        // Luodaan ja lisätään algoritminvalintakenttä
        this.algoritmi = new JLabel();
        this.algoritmi.setText("<html><strong>Valitse Algo: </strong></html>");
        this.palkki.add(this.algoritmi);
        
        // Luodaan ja lisätään nappi A*-algoritmin valintaa varten
        this.astar = new JButton("A*");
        this.astar.setVisible(true);
        this.palkki.add(this.astar);
        
        // Luodaan ja lisätään palkki A* -haun tuloksen ilmoittamista varten
        this.tulosAstar = new JLabel();
        this.palkki.add(tulosAstar);
        
        // Luodaan ja lisätään nappi A* + JPS -algoritmin valintaa varten
        this.astarJPS = new JButton("A* + JPS");
        this.astarJPS.setVisible(true);
        this.palkki.add(this.astarJPS);
        
        // Luodaan ja lisätään palkki A* + JPS -haun tuloksen ilmoittamista varten
        this.tulosAstarJPS = new JLabel();
        this.palkki.add(tulosAstarJPS);
        
        // Asetetaan GridBag-rajoitukset 
        GridBagConstraints c = new GridBagConstraints();
       
        c.gridx = 3;
        c.gridy = 1;
        c.gridheight = 2;
        c.insets = new Insets(2,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        
        // Lisätään palkki mainPaneliin
        mainPanel.add(this.palkki, c);
    }
    
    public JButton getastarNappi() {
        return this.astar;
    }
    
    public JButton getastarJPSNappi() {
        return this.astarJPS;
    }
   
    
    public JLabel algoritmi() {
        return this.algoritmi;
    }
    
    public JLabel getAstarTulos() {
        return this.tulosAstar;
    }
    
    public JLabel getAstarJaJPSTulos() {
        return this.tulosAstarJPS;
    }


    
}
