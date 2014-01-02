
package labyrintti;


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
    
    public Solmu(int x, int y) {
        this.matkaAlkuun = Integer.MAX_VALUE;
        this.x = x;
        this.y = y;
        this.este = false;
    }
    
    /**
     * Arviointifunktio, joka laskee etäisyyden maalisolmuun.
     */
    public void setKokonaisKustannus(Solmu maali) {
        this.kokonaisKustannus = Math.abs((this.x-maali.getX())+(this.y-maali.getY()))+getMatkaAlkuun();
    }
    
    /**
     * Asettaa etäisyyden aloitussolmuun.
     * 
     * @param a 
     */
    public void setMatkaAlkuun(int a) {
        this.matkaAlkuun = a;
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
     * Palauttaa nykyisen kokonaisetäisyysarvion solmulle.
     * 
     * @return int etäisyysarvio
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
    
    public void setEste() {
        this.este = true;
    }
    
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
