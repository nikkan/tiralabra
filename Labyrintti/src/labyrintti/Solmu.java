
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
    private int g_score;
    private int f_score; // lähtösolmusta solmuun + arvio maalisolmuun
    private boolean este;
    
    public Solmu(int x, int y) {
        this.g_score = Integer.MAX_VALUE;
        this.x = x;
        this.y = y;
        this.este = false;
    }
    
    /**
     * Arviointifunktio, joka laskee etäisyyden maalisolmuun.
     */
    public void set_f_score(Solmu maali) {
        this.f_score = Math.abs((this.x-maali.getX())+(this.y-maali.getY()))+get_g_score();
    }
    
    /**
     * Asettaa etäisyyden aloitussolmuun.
     * 
     * @param a 
     */
    public void set_g_score(int a) {
        this.g_score = a;
    }
    /**
     * Palauttaa etäisyyden aloitussolmuun.
     * 
     * @return int etäisyys alkuun
     */
    public int get_g_score() {
        return this.g_score;
    }
    
    /**
     * Palauttaa nykyisen kokonaisetäisyysarvion solmulle.
     * 
     * @return int etäisyysarvio
     */
    public int get_f_score() {
        return this.f_score;
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
        if (this.get_f_score() < toinen.get_f_score()) {
            return -1;
        }
        else if (this.get_f_score() > toinen.get_f_score()) {
            return 1;
        } else {
            return 0;
        }
        
    }
    
 
}
