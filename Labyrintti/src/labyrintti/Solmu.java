
package labyrintti;

import java.util.ArrayList;

/**
 *
 * @author Anu N.
 */
public class Solmu {
    // solmulla on arvio lähtöön ja maaliin
    private int i;
    private int j;
    private int alkuun;
    private int loppuun;
    private Solmu edellinen;
    
    public Solmu(int i, int j) {
        this.alkuun = Integer.MAX_VALUE;
        this.loppuun = 0;
        this.i = i;
        this.j = j;
    }
    
    // arviointifunktio laskee etäisyyden maalisolmuun
    public void SetLoppuun(Solmu maali) {
        this.loppuun = Math.abs((this.i-maali.getX())+(this.j-maali.getY()));
    }
    
    public void setAlkuun(int a) {
        this.alkuun = a;
    }
    
    public int getX() {
        return this.i;
    }
    
    public int getY() {
        return this.j;
    }
    
    public String toString() {
        return "x:"+this.i+"y:"+this.j;
    }
    
 
}
