
package labyrintti.sovellus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Luokka vastaa taustapaneelin toteuttamisesta Labyrintti-ohjelman graafiseen
 * käyttöliittymään. 
 * 
 * @author Anu N.
 */
public class Tausta {
    private JPanel pelikentta;
    private JPanel tausta;
    private int koko;
    private JPanel mainPanel;
    private Labyrintti labyrintti;
    
    /**
     * Konstruktori luo pohjan labyrintille, sekä siihen sisältyvät ruudut 
     * (=JButtonit).
     * 
     * @param koko Kokonaisluku, joka kertoo halutun labyrintin koon.
     * @param mainPanel Paneli, johon labyrintti lisätään 
     */
    public Tausta(Labyrintti labyrintti, JPanel mainPanel) {
        this.koko = labyrintti.pituus();
        this.mainPanel = mainPanel;
        this.labyrintti = labyrintti;
        this.pelikentta = new JPanel(new GridLayout(1,1));
        
        // annetaan pelikentälle asetukset 
        this.pelikentta.setMaximumSize(new Dimension(400, 400));
        this.pelikentta.setMinimumSize(new Dimension(400, 400));
        this.pelikentta.setPreferredSize(new Dimension(400, 400));
        this.pelikentta.setBackground(Color.WHITE);
        
        // asetetaan GridBagConstraints
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(2,2,2,2);
        
        // luodaan tausta, johon ruudut asetetaan
        this.tausta = new JPanel(new GridLayout(this.koko,this.koko));
        this.tausta.setBackground(Color.white);
 
        // luodaan ruudut ja asetetaan ne tausta-paneliin
        this.luoRuudut(this.tausta);
        // lisätään tausta pelikenttään
        this.pelikentta.add(this.tausta);
        // lisätään pelikenttä mainPaneliin
        this.mainPanel.add(this.pelikentta, c);
    
    }
    
    /**
     * Palauttaa pelikentan eli labyrintin.
     * 
     * @return JPanel
     */
    public JPanel getLabyrintti() {
        return this.pelikentta;
    }
    
    /**
     * Luo pyydetyn kokoisen uuden labyrintin. 
     * 
     * @param koko 
     */
    public void uusiLabyrintti(int koko) {
        this.labyrintti = new Labyrintti(koko);
        this.labyrintti.arvoLahtoJaMaali();
    }
    
    /**
     * Palauttaa taustan, jolle ruudut asetetaan.
     * 
     * @return 
     */
    public JPanel getTausta() {
        return this.tausta;
    }
    
    /**
     * Palauttaa nykyisen koon.
     * 
     * @return int koko
     */
    public int getKoko() {
        return this.koko;
    }
    
    /**
     * Palauttaa uuden pelin, eli taustapaneelin, johon on asetettu
     * halutun koon verran ruutuja.
     * 
     * @param uusiKoko Uuden labyrintin koko
     * @return JPanel taustapaneeli, johon uudet ruudut on asetettu
     */
    public JPanel getUusiTausta(int uusiKoko) {
        this.koko = uusiKoko;
        this.tausta = new JPanel(new GridLayout(this.koko,this.koko));
        this.luoRuudut(this.tausta);   
        return this.tausta;
    }
    
   
    /**
     * Luokan yksityinen metodi, joka lisää ruudut taustaan. 
     * 
     * @param paneeli Taustapaneeli, johon ruudut (JButtonit) lisätään.
     */
    private void luoRuudut(JPanel paneeli) {
        
        for (int i=0; i<this.koko; ++i) {
            for (int j=0; j<this.koko; ++j) {
                boolean lahto = false;
                boolean maali = false;
                if (this.labyrintti.getLahto().getX() == i && this.labyrintti.getLahto().getY() == j) {
                    lahto = true;
                }
                if (this.labyrintti.getMaali().getX() == i && this.labyrintti.getMaali().getY() == j) {
                    maali = true;
                }
                Ruutu r = new Ruutu(i, j, lahto, maali, this.labyrintti);
                RuudunKuuntelija rk = new RuudunKuuntelija(r);
                r.addActionListener(rk);
                paneeli.add(r);
            }
        }
      
          
     }
       

    
}
