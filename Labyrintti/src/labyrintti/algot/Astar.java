
package labyrintti.algot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import labyrintti.Labyrintti;
import labyrintti.tietorakenteet.Solmu;

/**
 * Luokka vastaa A*-algoritmiin pohjautuvan lyhimmän reitin etsinnän
 * toteuttamisesta.
 * 
 * Astar-luokan toteutuksessa on hyödynnetty Javan valmista kalustoa - ks. erit.
     * luokka Astar2, jossa on taustalla itse toteutetut tietorakenteet.
 * 
 * Toteutus perustuu Wikipediasta (http://en.wikipedia.org/wiki/A*_search_algorithm)
 * löytyvään A*-algoritmin pseudokoodiin. 
 * 
 * @author Anu N.
 * 
 */

public class Astar {
            
    private Labyrintti labyrintti;
    private Solmu lahto;
    private Solmu maali;
    private PriorityQueue avoimet;
    private ArrayList<Solmu> kaydyt;
    private HashMap<Solmu, Solmu> mista_saapui;
    
    /**
     * Luokan konstruktori, joka saa parametrinaan matriisin (=labyrintti),
     * lähtösolmun sekä maalisolmun.
     * 
     * @param matriisi
     * @param start
     * @param end 
     */
    
    public Astar (Labyrintti labyrintti, Solmu lahto, Solmu maali) {
        this.labyrintti = labyrintti;
        this.lahto = lahto;
        this.maali = maali;
        this.avoimet = new PriorityQueue<Solmu>();
        this.mista_saapui = new HashMap<Solmu, Solmu>();
        this.kaydyt = new ArrayList<Solmu>();
        
    }
    
    /**
     * Metodi etsii ja tulostaa lyhimmän reitin labyrintin läpi lähtösolmusta
     * maalisolmuun.
     */
    public void search() {
        this.avoimet.add(lahto);
        this.lahto.setMatkaAlkuun(0);
        this.lahto.setKokonaisKustannus(this.maali);
        
        while(!this.avoimet.isEmpty()) {
            Solmu nykyinen = (Solmu) this.avoimet.poll();
           // System.out.println(current.toString());
            if (nykyinen.equals(maali)) {
                tulostaPolku();
            }
            this.avoimet.remove(nykyinen);
            this.kaydyt.add(nykyinen);
            kasitteleNaapurit(nykyinen);
     
        }
    }
    
    /**
     * Metodi käy läpi labyrintti-Solmun naapurit ja päivittää lyhintä
     * reittiä ja etäisyysarviota naapurisolmuihin ja naapurisolmuista maaliin.
     * 
     * @param nykyinen 
     */
    private void kasitteleNaapurit(Solmu nykyinen) {
        ArrayList<Solmu> naapurit = this.labyrintti.getNaapurit2(nykyinen);
            
            for (Solmu naapuri : naapurit) {
                
                if (!kaydyt.contains(naapuri)) {
                    int arvioAlkuun = nykyinen.getMatkaAlkuun() + labyrintti.etaisyysValilla(nykyinen, naapuri);
                    
                    if (!this.avoimet.contains(naapuri) || arvioAlkuun < naapuri.getMatkaAlkuun()) { 
                        mista_saapui.put(naapuri, nykyinen);
                        naapuri.setMatkaAlkuun(arvioAlkuun);
                        naapuri.setKokonaisKustannus(maali); 
                    } 
                    if (!this.avoimet.contains(naapuri)) { 
                        this.avoimet.add(naapuri);
                    }
                }
                
            }
    }
    
    /**
     * Metodi rekonstruoi ja tulostaa lyhimmän polun labyrintin läpi.
     */
    private void tulostaPolku() {
        System.out.println("\nLyhyin polku lähdöstä (l) maaliin (m): \n");
        System.out.println(this.lahto.toString());
        Solmu s = this.maali;
        Stack<Solmu> pino = new Stack<Solmu>();
        while (!(s.equals(this.lahto))) {
            pino.push(s);
            s = mista_saapui.get(s);
        }
        while (!pino.empty()) {
            s = pino.pop();
            System.out.println(s.toString());
        }
        
          
    }

    
}
