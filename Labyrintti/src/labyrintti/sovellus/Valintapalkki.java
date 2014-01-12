
package labyrintti.sovellus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Luokka vastaa Labyrintti-ohjelman graafisessa käyttöliittymässä olevan
 * valintapalkin toteuttamisesta.
 * 
 * @author Anu N.
 */
public class Valintapalkki {
    
    private JButton astar;
    private JButton astarJPS;
    private JButton dijkstra;
    private JPanel palkki;
    private JLabel algoritmi;
    private JLabel tulos;

    
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
   
        
        // Luodaan ja lisätään nappi A* + JPS -algoritmin valintaa varten
        this.astarJPS = new JButton("A* + JPS");
        this.astarJPS.setVisible(true);
        this.palkki.add(this.astarJPS);
        
        // Luodaan ja lisätään nappi Dijkstran algoritmin valintaa varten
        this.dijkstra = new JButton("Dijkstra");
        this.dijkstra.setVisible(true);
        this.palkki.add(this.dijkstra);
        
        // Luodaan ja lisätään palkki A* + JPS -hakujen tuloksen ilmoittamista varten
        this.tulos = new JLabel();
        this.palkki.add(tulos);
        
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
    
    /**
     * Palauttaa valintapalkin napin, josta käyttäjä voi valita A*-algoritmin
     * suorittamisen.
     * 
     * @return JButton "Astar"
     */
    public JButton getastarNappi() {
        
        return this.astar;
    }
    
    /**
     * Palauttaa valintapalkin napin, josta käyttäjä voi valita A*+JPS-algoritmien
     * suorittamisen.
     * 
     * @return JButton "Astar+JPS"
     */
    public JButton getastarJPSNappi() {
        
        return this.astarJPS;
    }
   
    /**
     * Palauttaa valintapalkin napin, josta käyttäjä voi valita Dijkstran
     * algoritmin suorittamisen.
     * 
     * @return JButton "Dijkstra"
     */
    public JButton getDijkstraNappi() {
        
        return this.dijkstra;
    }
    
    /**
     * Palauttaa tekstikentän/nimikkeen, jossa on tekstinä "Valitse algo".
     * 
     * @return JLabel "Valitse algo"
     */
    public JLabel algoritmi() {
        
        return this.algoritmi;
    }
    
    /**
     * Palauttaa tekstikentän algoritmin suoritusajan tulostusta vasten.
     * 
     * @return JLabel
     */
    public JLabel getTulos() {
        
        return this.tulos;
    }
  


    
}
