
package labyrintti.algot;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Set;
import labyrintti.Solmu;

/**
 *
 * @author Anu N.
 */
public class Astar {
    
    /*Astar(G,w,a,b)
     * G on tutkittava verkko, a lähtösolmu, b kohdesolmu ja w kaaripainot kertova funktio
     * for kaikille solmuille v e V
     *  alkuun[v] = ääretön
     *  loppuun[v] = arvioi suora etäisyys v --> b
     *  polku[v] = NIL
     * alkuun[a] = 0
     * S = tyhjäjoukko
     * while (solmu b ei ole vielä joukossa S)
     *  valitse solmu u e V \ S jolle alkuun[v] + loppuun[v] on pienin
     *  S = S u {u}
     *  for (jokaiselle solmulle v e Adj[u] // kaikille u:n vierussolmuille v
     *     if alkuun[v] > alkuun [u] + w(u,v)
     *        alkuun[v] = alkuun[u]+w(u,v)
     *        polku[v] = u
     */
    
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
            
        }
    }
    
    
  
    

    

    
    
    
    
}