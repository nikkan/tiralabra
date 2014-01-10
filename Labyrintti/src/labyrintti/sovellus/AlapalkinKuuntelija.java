
package labyrintti.sovellus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka vastaa käyttöliittymässä olevan alapalkin nappien kuuntelusta.
 * 
 * @author Anu N.
 */
public class AlapalkinKuuntelija implements ActionListener {
    private Alapalkki alapalkki;
    private Tausta t;
    
    /**
     * Konstruktori.
     * 
     * @param ap Alapalkki
     * @param t Tausta
     */
    public AlapalkinKuuntelija(Alapalkki ap, Tausta t) {
        this.alapalkki = ap;
        this.t = t;
    }
    
    /**
     * Metodi toteuttaa toiminnot, jotka liittyvät alapalkissa olevien
     * nappien painallukseen.
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == alapalkki.get10x10()) {
            uusiLabyrintti(10);
        } 
        else if (ae.getSource() == alapalkki.get20x20()) {
            uusiLabyrintti(20);
        }
        else if (ae.getSource() == alapalkki.get40x40()) {
            uusiLabyrintti(40);
        }
        else if (ae.getSource() == alapalkki.getLopeta()) {
            System.exit(0);
            
        }
    }
    
    /**
     * Metodi luo halutun kokoisen uuden labyrintin.
     * 
     * @param koko 
     */
    private void uusiLabyrintti(int koko) {
        // poistetaan vanhat ruudut
        this.t.getLabyrintti().removeAll();
        this.t.getLabyrintti().validate();
        
          // luodaan uusi labyrintti (+muita nollauksia vielä tulossa mahdollisesti)
        this.t.uusiLabyrintti(koko);
        
        // haetaan uusi tausta labyrintille
        this.t.getLabyrintti().add(t.getUusiTausta(koko));
        
      
        
        // piirretään ja validoidaan uusi labyrintti
        this.t.getLabyrintti().repaint();
        this.t.getLabyrintti().validate();   
    }
    
    
    
}
