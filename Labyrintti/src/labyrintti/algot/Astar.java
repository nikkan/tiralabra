
package labyrintti.algot;

import java.util.ArrayList;
import java.util.PriorityQueue;
import labyrintti.Solmu;

/**
 *
 * @author Anu N.
 */
public class Astar {
        
    private Solmu[][] matriisi;
    private Solmu start;
    private Solmu end;
    private PriorityQueue avoimet;
    private ArrayList<Solmu> kaydyt;
    
    public Astar (Solmu[][] matriisi, Solmu start, Solmu end) {
        this.matriisi = matriisi;
        this.start = start;
        this.end = end;
        this.avoimet = new PriorityQueue<Solmu>();
        this.kaydyt = new ArrayList<Solmu>();
    }
    
    public ArrayList<Solmu> getKaydyt() {
        return kaydyt;
    }
    
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
            
        }
    }
    
    
  
    

    

    
    
    
    
}
