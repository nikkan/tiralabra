
package labyrintti.sovellus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import labyrintti.algot.Astar2;

/**
 * Luokka vastaa Labyrintti-ohjelman graafisessa käyttöliittymässä olevan
 * valintapalkin nappien kuuntelusta.
 * 
 * @author Anu N.
 */
public class ValintapalkinKuuntelija implements ActionListener {
    private Valintapalkki valintapalkki;
    private Labyrintti labyrintti;
    private Astar2 astar;
    
    /**
     * Konstruktori saa parametrikseen valintapalkin sekä luodun labyrintin.
     * 
     * @param valintapalkki
     * @param labyrintti 
     */
    public ValintapalkinKuuntelija(Valintapalkki valintapalkki, Labyrintti labyrintti) {
        this.valintapalkki = valintapalkki;
        this.labyrintti = labyrintti;
        this.palautaPalkki();
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
        if (ae.getSource() == this.valintapalkki.getastarNappi()) {
            this.astar = new Astar2(labyrintti, labyrintti.getLahto(), labyrintti.getMaali());
            labyrintti.visualisoiLabyrintti();
            long aika1 = System.nanoTime();
            this.astar.searchOmallaKeolla();
            long aika2 = System.nanoTime();
            JLabel palkki = valintapalkki.getAstarTulos();
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
        this.valintapalkki.getAstarTulos().setText("");
        this.valintapalkki.getAstarTulos().setVisible(false);
    }
    
    
    
}
