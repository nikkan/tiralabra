
package labyrintti;


/**
 * Luokka vastaa labyrintin Solmu-olioiden toteuttamisesta. 
 * 
 * Luokka toteuttaa Comparable-rajapinnan.
 * 
 * @author Anu N.
 */

public class Solmu implements Comparable {
    private int i;
    private int j;
    private int alkuun;
    private int kokomatka; // lähtösolmusta solmuun + arvio maalisolmuun
    
    public Solmu(int i, int j) {
        this.alkuun = Integer.MAX_VALUE;
        this.i = i;
        this.j = j;
    }
    
    /**
     * Arviointifunktio, joka laskee etäisyyden maalisolmuun.
     */
    public void SetKokomatka(Solmu maali) {
        this.kokomatka = Math.abs((this.i-maali.getX())+(this.j-maali.getY()))+getAlkuun();
    }
    
    /**
     * Asettaa etäisyyden aloitussolmuun.
     * 
     * @param a 
     */
    public void setAlkuun(int a) {
        this.alkuun = a;
    }
    /**
     * Palauttaa etäisyyden aloitussolmuun.
     * 
     * @return int etäisyys alkuun
     */
    public int getAlkuun() {
        return this.alkuun;
    }
    
    /**
     * Palauttaa nykyisen kokonaisetäisyysarvion solmulle.
     * 
     * @return int etäisyysarvio
     */
    public int getEtaisyys() {
        return this.kokomatka;
    }
    
    /**
     * Palauttaa solmun x-koordinaatin labyrintissä.
     * 
     * @return int x-koordinaatti
     */
    public int getX() {
        return this.i;
    }
    
    /**
     * Palauttaa solmun y-koordinaatin labyrintissä.
     * 
     * @return int y-koordinaatti
     */
    public int getY() {
        return this.j;
    }
    
    /**
     * Palauttaa solmun koordinaatit merkkijonona.
     * 
     * @return String x-ja y-koorinaatti
     */
    public String toString() {
        return "x:"+this.i+"y:"+this.j;
    }

    @Override
    public int compareTo(Object t) {
        Solmu toinen = (Solmu) t;
        if (this.getEtaisyys() > toinen.getEtaisyys()) {
            return -1;
        }
        else if (this.getEtaisyys() < toinen.getEtaisyys()) {
            return 1;
        } else {
            return 0;
        }
        
    }
    
 
}
