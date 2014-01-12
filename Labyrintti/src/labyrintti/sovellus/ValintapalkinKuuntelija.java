
package labyrintti.sovellus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import labyrintti.algot.Astar;
import labyrintti.algot.AstarJaJPS;
import labyrintti.tietorakenteet.Pino;

/**
 * Luokka vastaa Labyrintti-ohjelman graafisessa käyttöliittymässä olevan
 * valintapalkin nappien kuuntelusta.
 * 
 * @author Anu N.
 */
public class ValintapalkinKuuntelija implements ActionListener {
    private Valintapalkki valintapalkki;
    private Labyrintti labyrintti;
    private Astar astar;
    private AstarJaJPS jps;
    private Tausta t;
   
    
    /**
     * Konstruktori saa parametrikseen valintapalkin sekä luodun labyrintin.
     * 
     * @param valintapalkki
     * @param labyrintti 
     */
    public ValintapalkinKuuntelija(Valintapalkki valintapalkki, Labyrintti labyrintti, Tausta t) {
        this.valintapalkki = valintapalkki;
        this.labyrintti = labyrintti;
        this.palautaPalkki();
        this.t = t;
    }
    
    /**
     * Metodi toteuttaa valintapalkissa olevien nappien painalluksiin liittyvät
     * toiminnot, eli toteuttaa reittihaun labyrintissa valitulla algoritmilla
     * ja ilmoittaa tuloksen.
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.labyrintti = t.getL();
        if (ae.getSource() == this.valintapalkki.getastarNappi()) {
            this.astar = new Astar(labyrintti, labyrintti.getLahto(), labyrintti.getMaali());
            labyrintti.visualisoiLabyrintti();
            long aika1 = System.nanoTime();
            this.astar.searchJavanPriorityQueuella();
            long aika2 = System.nanoTime();
            Pino polku = astar.getPolku();
            Pino polkukopio = polku;
            piirraReitti(labyrintti, polkukopio);
            labyrintti.visualisoiKuljettuPolku(polku);
            astar.tulostaPolku();
            JLabel palkki = valintapalkki.getTulos();
            palkki.setText(""+((double)(aika2-aika1)/1000000)+" ms");
            palkki.setVisible(true);
            
        }
        if (ae.getSource() == this.valintapalkki.getastarJPSNappi()) {
            this.jps = new AstarJaJPS(labyrintti, labyrintti.getLahto(), labyrintti.getMaali());
            labyrintti.visualisoiLabyrintti();
            long aika1 = System.nanoTime();
            this.jps.searchOmallaKeollaJaJumpPointilla();
            long aika2 = System.nanoTime();
            Pino polku = this.jps.getPolku();
            Pino polkukopio = polku;
            piirraReitti(labyrintti, polkukopio);
            labyrintti.visualisoiKuljettuPolku(polku);
            this.jps.tulostaPolku();
            JLabel palkki = valintapalkki.getTulos();
            palkki.setText(""+((double)(aika2-aika1)/1000000)+" ms");
            palkki.setVisible(true);
        }
    }
    
    /**
     * Metodi palauttaa valintapalkin asetukset ennalleen, jotta haku voidaan
     * suorittaa uudestaan.
     * 
     */
    private void palautaPalkki() {
        this.valintapalkki.getTulos().setText("");
        this.valintapalkki.getTulos().setVisible(false);
    
    }
    
    
    /**
     * Metodi luo halutun kokoisen uuden labyrintin.
     * 
     * @param koko 
     */
    private void piirraReitti(Labyrintti labyrintti, Pino polku) {
        // poistetaan vanhat ruudut
        this.t.getLabyrintti().removeAll();
        this.t.getLabyrintti().validate();
        
        // haetaan uusi tausta labyrintille
        this.t.getLabyrintti().add(t.getKuljettuMatka(labyrintti, polku));
        
        // luodaan uusi labyrintti (+muita nollauksia vielä tulossa mahdollisesti)
        //this.t.uusiLabyrintti(koko);
        
        // piirretään ja validoidaan uusi labyrintti
        this.t.getLabyrintti().repaint();
        this.t.getLabyrintti().validate();   
    }
    
    
}
