
package labyrintti.algot;

import labyrintti.tietorakenteet.Keko;
import java.util.ArrayList;
import java.util.PriorityQueue;
import labyrintti.Labyrintti;
import labyrintti.tietorakenteet.Pino;
import labyrintti.tietorakenteet.Solmu;

/**
 * Luokka vastaa A*-algoritmiin pohjautuvan lyhimmän reitin etsinnän
 * toteuttamisesta itse toteutettuihin tietorakenteisiin pohjaten (työn alla..).
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
    private Keko kaydyt;
    
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
        this.kaydyt = new Keko(this.labyrintti.labyrintinKoko());
    }
    
    /**
     * Metodi etsii ja tulostaa lyhimmän reitin labyrintin läpi lähtösolmusta
     * maalisolmuun käyttäen prioriteettijonon toteutuksena itse toteutettua
     * minimikeko-tietorakennetta.
     */
    public void searchOmallaKeolla() {
        this.avoimet1.lisaaKekoon(lahto);
        this.lahto.setMatkaAlkuun(0);
        this.lahto.setKokonaisKustannus(this.maali);
        
        while(!this.avoimet1.isEmpty()) {
            Solmu nykyinen = this.avoimet1.poistaPienin();
            if (nykyinen.equals(maali)) {
                tulostaPolku();
            }
   
            this.kaydyt.lisaaKekoon(nykyinen);
            kasitteleNaapurit(nykyinen);
     
        }
    }
    
    /**
     * Metodi etsii ja tulostaa lyhimmän reitin labyrintin läpi lähtösolmusta
     * maalisolmuun käyttäen prioriteettijonon toteutuksena Javan PriorityQueueta.
     */
    public void searchJavanPriorityQueuella() {
        this.avoimet2.add(lahto);
        this.lahto.setMatkaAlkuun(0);
        this.lahto.setKokonaisKustannus(this.maali);
        
        while(!this.avoimet2.isEmpty()) {
            Solmu nykyinen = (Solmu) this.avoimet2.poll();
            if (nykyinen.equals(maali)) {
                tulostaPolku();
            }
            
            //this.avoimet2.remove(nykyinen);
            this.kaydyt.lisaaKekoon(nykyinen);
            kasitteleNaapurit2(nykyinen);
        }
    }
    
    /**
     * Metodi käy läpi labyrintti-Solmun naapurit ja päivittää lyhintä
     * reittiä ja etäisyysarviota naapurisolmuihin ja naapurisolmuista maaliin.
     * 
     * @param nykyinen 
     */
    private void kasitteleNaapurit(Solmu nykyinen) {
   
        Keko naapurit = this.labyrintti.getNaapurit(nykyinen);
            
                for (int i=0; i<naapurit.getPituus(); ++i) {
                    Solmu naapuri = naapurit.palautaAlkioIndeksissa(i);
            
                if (!kaydyt.contains(naapuri)) {
                    int arvioAlkuun = nykyinen.getMatkaAlkuun() + labyrintti.etaisyysValilla(nykyinen, naapuri);
                    
                    if (!this.avoimet1.contains(naapuri) || arvioAlkuun < naapuri.getMatkaAlkuun()) { 
                        naapuri.setEdellinen(nykyinen);
                        naapuri.setMatkaAlkuun(arvioAlkuun);
                        naapuri.setKokonaisKustannus(maali); 
                    } 
                    if (!this.avoimet1.contains(naapuri)) { 
                        this.avoimet1.lisaaKekoon(naapuri);
                    }
                }
                
            }
    }
    
    /**
     * Vaihtoehtoinen toteutus metodille, joka käy läpi labyrintti-Solmun 
     * naapurit ja päivittää lyhintä reittiä ja etäisyysarviota naapurisolmuihin
     * ja naapurisolmuista maaliin.
     * 
     * Toteutus hyödyntää Javan PriorityQueueta, mikä mahdollistaa itse
     * toteutetun kekototeutuksen vertaamisen PriorityQueueen.
     * 
     * @param nykyinen 
     */
    private void kasitteleNaapurit2(Solmu nykyinen) {
        
        Keko naapurit = this.labyrintti.getNaapurit(nykyinen);
            
                for (int i=0; i<naapurit.getPituus(); ++i) {
                    Solmu naapuri = naapurit.palautaAlkioIndeksissa(i);
            
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
