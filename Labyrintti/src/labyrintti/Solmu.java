
package labyrintti;

import java.util.ArrayList;

/**
 *
 * @author Anu N.
 */
public class Solmu implements Comparable {
    // solmulla on arvio lähtöön ja maaliin
    private int i;
    private int j;
    private int alkuun;
    private int kokomatka;
    private Solmu edellinen;
    
    public Solmu(int i, int j) {
        this.alkuun = Integer.MAX_VALUE;
        this.i = i;
        this.j = j;
    }
    
    // arviointifunktio laskee etäisyyden maalisolmuun
    public void SetKokomatka(Solmu maali) {
        this.kokomatka = Math.abs((this.i-maali.getX())+(this.j-maali.getY()))+getAlkuun();
    }
    
    public void setAlkuun(int a) {
        this.alkuun = a;
    }
 
    public int getAlkuun() {
        return this.alkuun;
    }
    
    public int getEtaisyys() {
        return this.kokomatka;
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
