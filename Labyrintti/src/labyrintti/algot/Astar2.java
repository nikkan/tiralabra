
package labyrintti.algot;

import labyrintti.tietorakenteet.Keko;
import java.util.PriorityQueue;
import labyrintti.Labyrintti;
import labyrintti.tietorakenteet.Pino;
import labyrintti.tietorakenteet.Solmu;

/**
 * Luokka vastaa A*-algoritmiin pohjautuvan lyhimmän reitin etsinnän
 * toteuttamisesta itse toteutettuihin tietorakenteisiin pohjaten sekä mahdol-
 * listaa itse toteutetun minimikeon suorituskyvyn vertailun Javan PriorityQueueen.
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
    private Pino polku;
    
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
        this.polku = new Pino(this.labyrintti.labyrintinKoko());
    }
    
    /**
     * Metodi etsii lyhimmän reitin labyrintin läpi lähtösolmusta
     * maalisolmuun käyttäen prioriteettijonon toteutuksena itse toteutettua
     * minimikeko-tietorakennetta.
     */
    public void searchOmallaKeolla() {
        
        this.avoimet1.lisaaKekoon(lahto);
        this.lahto.setMatkaAlkuun(0);
        this.lahto.setKokonaisKustannus(this.maali);
        
     
        while(!this.avoimet1.isEmpty()) {
            //this.avoimet1.tulostaKeko();
            //System.out.println("---");
            Solmu nykyinen = this.avoimet1.poistaPienin();
            if (nykyinen.equals(maali)) {
                rekonstruoiPolku();
            }
   
            this.kaydyt.lisaaKekoon(nykyinen);
            kasitteleNaapuritJumpPoint(nykyinen);
     
        }
    }
    
    /**
     * Metodi etsii lyhimmän reitin labyrintin läpi lähtösolmusta
     * maalisolmuun käyttäen prioriteettijonon toteutuksena Javan PriorityQueueta.
     */
    public void searchJavanPriorityQueuella() {
        
        this.avoimet2.add(lahto);
        this.lahto.setMatkaAlkuun(0);
        this.lahto.setKokonaisKustannus(this.maali);
        
        while(!this.avoimet2.isEmpty()) {
            Solmu nykyinen = (Solmu) this.avoimet2.poll();
            if (nykyinen.equals(maali)) {
                rekonstruoiPolku();
            }
            
            this.kaydyt.lisaaKekoon(nykyinen);
            nykyinen.isVisited();
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
             //naapurit.tulostaKeko(); 
             //System.out.println("---");
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
     * TÄMÄ METODI ON VIELÄ TYÖN ALLA, EI TOIMI OIKEIN!
     * 
     * Yritän toteuttaa Jump Point Searchia toteuttamalla ensin
     * naapureiden läpikäymisen niin, ettei kaikkia 8 naapuria tarvitsisi
     * käydä joka kerta läpi.
     * 
     * @param nykyinen 
     */
    private void kasitteleNaapuritJumpPoint(Solmu nykyinen) {
        //Solmu edellinen = nykyinen.getEdellinen();
        //System.out.println("nykyinen: "+nykyinen.toString()+" edellinen: "+edellinen);
        //System.out.println("nykyinen: "+nykyinen);
        Keko naapurit = this.labyrintti.getJumpPointNaapurit(nykyinen); 
        //naapurit.tulostaKeko();// tulisko tähän JO pruunatut naapurit??
        //System.out.println("---");
                                                                
                for (int i=0; i<naapurit.getPituus(); ++i) {    
                    Solmu naapuri = naapurit.palautaAlkioIndeksissa(i);
            
                if (!kaydyt.contains(naapuri)) { // voisko solmussa olla visited -tieto??
                    int arvioAlkuun = nykyinen.getMatkaAlkuun() + labyrintti.etaisyysValilla(nykyinen, naapuri);
                    
                    if (!this.avoimet1.contains(naapuri) || arvioAlkuun < naapuri.getMatkaAlkuun()) { 
                        naapuri.setEdellinen(nykyinen); // vai pruunataanko naapurit tässä kohdassa?
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
     * toteutetun minimikeon vertaamisen PriorityQueueen.
     * 
     * @param nykyinen 
     */
    private void kasitteleNaapurit2(Solmu nykyinen) {
        //Solmu edellinen = nykyinen.getEdellinen();
        //System.out.println("nykyinen: "+nykyinen.toString()+" edellinen: "+edellinen); 
        Keko naapurit = this.labyrintti.getNaapurit(nykyinen);
        //System.out.println("nykyinen: "+nykyinen);
        //naapurit.tulostaKeko();
        //System.out.println("---");
            
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
     * Metodi rekonstruoi Pino-tietorakenteeseen lyhimmän polun labyrintin läpi.
     */
    public void rekonstruoiPolku() {
       
        Solmu s = this.maali;
    
        while (!(s.equals(this.lahto))) {
            this.polku.push(s);
            s = s.getEdellinen();
        }
     
    }
    
    /**
     * Palauttaa lyhimmän kuljetun polun.
     * 
     * @return Pino kuljettu polku lyhimmällä reitillä.
     */
    public Pino getPolku() {
        
        return this.polku;
    }
    
    /**
     * Metodi tulostaa lyhimmän polun labyrintin läpi.
     */
    public void tulostaPolku() {
        
        System.out.println("\nLyhyin polku lähdöstä (l) maaliin (m): \n");
        System.out.println(this.lahto.toString());
       
        while (!this.polku.empty()) {
            Solmu s = this.polku.pop();
            System.out.println(s.toString());
        }
        
    }

    
}
