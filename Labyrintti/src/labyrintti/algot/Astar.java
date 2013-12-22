
package labyrintti.algot;

import java.util.ArrayList;
import java.util.PriorityQueue;
import labyrintti.Solmu;

/**
 * Luokka vastaa A*-algoritmiin pohjautuvan lyhimmän reitin etsinnän
 * toteuttamisesta.  
 * 
 * @author Anu N.
 */
public class Astar {
        
    private Solmu[][] matriisi;
    private Solmu start;
    private Solmu end;
    private PriorityQueue avoimet;
    private ArrayList<Solmu> kaydyt;
    
    /**
     * Luokan konstruktori, joka saa parametrinaan matriisin (=labyrintti),
     * lähtösolmun sekä maalisolmun.
     * 
     * @param matriisi
     * @param start
     * @param end 
     */
    public Astar (Solmu[][] matriisi, Solmu start, Solmu end) {
        this.matriisi = matriisi;
        this.start = start;
        this.end = end;
        this.avoimet = new PriorityQueue<Solmu>();
        this.kaydyt = new ArrayList<Solmu>();
    }
    /**
     * Palauttaa listan, joka sisältää vieraillut solmut.
     * 
     * @return kaydyt-lista, joka sisältää Solmu-olioita
     */
    private ArrayList<Solmu> getKaydyt() {
        return kaydyt;
    }
    /**
     * Varsinainen etsintäalgoritmin toteutus, kesken... lähdin toteuttamaan 
     * tätä Wikipedia-sivulta (http://en.wikipedia.org/wiki/A*_search_algorithm)
     * löytyvään pseudokoodiin pohjaten, mutta saatan vielä muuttaa toteutusta.
     * 
     */
    private void search() {
        this.avoimet.add(start);
        this.start.setAlkuun(0);
        this.start.SetKokomatka(this.end);
        
        while(!this.avoimet.isEmpty()) {
            Solmu v = (Solmu) this.avoimet.poll();
            if (v.equals(end)) {
                break;
            }
            this.avoimet.remove(v);
            this.kaydyt.add(v);
            
            //...
        }
    }
    
    
  
    

    

    
    
    
    
}
