
package labyrintti.tietorakenteet;


/**
 * Luokka vastaa labyrintin Solmu-olioiden toteuttamisesta. 
 * 
 * Luokka toteuttaa Comparable-rajapinnan.
 * 
 * @author Anu N.
 */

public class Solmu implements Comparable<Solmu> {
    private int x;
    private int y;
    private int matkaAlkuun;
    private int kokonaisKustannus; // lähtösolmusta solmuun + arvio maalisolmuun
    private boolean este;
    private Solmu edellinen;
    
    public Solmu(int x, int y) {
        this.matkaAlkuun = Integer.MAX_VALUE;
        this.x = x;
        this.y = y;
        this.este = false;
        this.edellinen = null;
    }
    
    /**
     * Arviointifunktio, joka laskee etäisyyden maalisolmuun.
     */
    public void setKokonaisKustannus(Solmu maali) {
        this.kokonaisKustannus = Math.abs((this.x-maali.getX())+(this.y-maali.getY()))+getMatkaAlkuun();
    }
    
    /**
     * Asettaa Solmulle kokonaislukuna annetun kokonaiskustannuksen.
     * 
     * Metodi käytännöllinen lähinnä testauksessa.
     * 
     * @param kustannus 
     */
    public void setKokonaisKustannus(int kustannus) {
        this.kokonaisKustannus = kustannus;
    }
    
    /**
     * Asettaa etäisyyden aloitussolmuun.
     * 
     * @param a 
     */
    public void setMatkaAlkuun(int alku) {
        this.matkaAlkuun = alku;
    }
    /**
     * Palauttaa etäisyyden aloitussolmuun.
     * 
     * @return int etäisyys alkuun
     */
    public int getMatkaAlkuun() {
        return this.matkaAlkuun;
    }
    
    /**
     * Asettaa parametrina annetun Solmu-olion viimeksi vierailluksi solmuksi 
     * lyhimmällä polulla labyrintin halki.
     * 
     * @param edellinen 
     */
    public void setEdellinen(Solmu edellinen) {
        this.edellinen = edellinen;
    }
    
    /**
     * Palauttaa viimeksi vieraillun Solmu-olion lyhimmällä reitillä labyrintin
     * halki.
     * 
     * @return Solmu edellinen solmu
     */
    public Solmu getEdellinen() {
        return this.edellinen;
    }
    
    /**
     * Palauttaa nykyisen kokonaisetäisyysarvion solmulle.
     * 
     * @return int kokonaiskustannus
     */
    public int getKokonaisKustannus() {
        return this.kokonaisKustannus;
    }
    
    
    /**
     * Palauttaa solmun x-koordinaatin labyrintissä.
     * 
     * @return int x-koordinaatti
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Palauttaa solmun y-koordinaatin labyrintissä.
     * 
     * @return int y-koordinaatti
     */
    public int getY() {
        return this.y;
    }
    
    /** 
     * Muuttaa solmun "esteeksi", johon ei pääse naapurisolmusta
     * asettamalla "este"-muuttujan arvoksi true.
     * 
     */
    public void setEste() {
        this.este = true;
    }
    
    /**
     * Palauttaa tiedon siitä, onko solmu este, johon ei pääse.
     * 
     * @return true, jos solmu on este, muuten false.
     */
    public boolean onkoEste() {
        return this.este;
    }
    
    /**
     * Palauttaa solmun koordinaatit merkkijonona.
     * 
     * @return String x-ja y-koorinaatti
     */
    public String toString() {
        return "x: "+this.x+", y: "+this.y;
    }
   
    
    /**
     * Vertaa solmujen etäisyysarvioita toisiinsa.
     * 
     * @param toinen eli verrattava Solmu
     * 
     * @return -1 jos verrattavan Solmun kokonaiskustannus on suurempi, 
     *          1 jos nykyisen Solmun kokonaiskustannus on suurempi,
     *          0 muuten
     */      
    @Override
    public int compareTo(Solmu toinen) {
        if (this.getKokonaisKustannus() < toinen.getKokonaisKustannus()) {
            return -1;
        }
        else if (this.getKokonaisKustannus() > toinen.getKokonaisKustannus()) {
            return 1;
        } else {
            return 0;
        }
        
    }
    
 
}
