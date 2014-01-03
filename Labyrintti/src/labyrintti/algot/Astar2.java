
package labyrintti.algot;

import labyrintti.tietorakenteet.Keko;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import labyrintti.Labyrintti;
import labyrintti.tietorakenteet.Pino;
import labyrintti.tietorakenteet.Solmu;

/**
 * Luokka vastaa A*-algoritmiin pohjautuvan lyhimmän reitin etsinnän
 * toteuttamisesta itse toteutettuihin tietorakenteisiin pohjaten.
 * 
 * Toteutus perustuu Wikipediasta (http://en.wikipedia.org/wiki/A*_search_algorithm)
 * löytyvään A*-algoritmin pseudokoodiin. 
 * 
 * @author Anu N.
 */
public class Astar2 {
                
    private Labyrintti labyrintti;
    private Solmu lahto;
    private Solmu maali;
    private Keko avoimet1;
    private PriorityQueue avoimet2;
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
    
    public Astar2 (Labyrintti labyrintti, Solmu lahto, Solmu maali) {
        this.labyrintti = labyrintti;
        this.lahto = lahto;
        this.maali = maali;
        this.avoimet1 = new Keko(this.labyrintti.labyrintinKoko());
        this.avoimet2 = new PriorityQueue<Solmu>();
        //this.mista_saapui = new HashMap<Solmu, Solmu>();
        this.kaydyt = new ArrayList<Solmu>();
        
    }
    
    /**
     * Metodi etsii ja tulostaa lyhimmän reitin labyrintin läpi lähtösolmusta
     * maalisolmuun.
     */
    public void search() {
        this.avoimet2.add(lahto);
        this.lahto.setMatkaAlkuun(0);
        this.lahto.setKokonaisKustannus(this.maali);
        
        while(!this.avoimet2.isEmpty()) {
            Solmu nykyinen = (Solmu) this.avoimet2.poll();
           // System.out.println(current.toString());
            if (nykyinen.equals(maali)) {
                tulostaPolku();
            }
            this.avoimet2.remove(nykyinen);
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
        ArrayList<Solmu> naapurit = this.labyrintti.getNaapurit(nykyinen);
            
            for (Solmu naapuri : naapurit) {
                
                if (!kaydyt.contains(naapuri)) {
                    int arvioAlkuun = nykyinen.getMatkaAlkuun() + labyrintti.etaisyysValilla(nykyinen, naapuri);
                    
                    if (!this.avoimet2.contains(naapuri) || arvioAlkuun < naapuri.getMatkaAlkuun()) { 
                        naapuri.setEdellinen(nykyinen);
                        naapuri.setMatkaAlkuun(arvioAlkuun);
                        naapuri.setKokonaisKustannus(maali); 
                    } 
                    if (!this.avoimet2.contains(naapuri)) { 
                        this.avoimet2.add(naapuri);
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
        Pino pino = new Pino(labyrintti.labyrintinKoko());
        while (!(s.equals(this.lahto))) {
            pino.push(s);
            s = s.getEdellinen();
        }
        while (!pino.empty()) {
            s = pino.pop();
            System.out.println(s.toString());
        }
        
          
    }

    
}
