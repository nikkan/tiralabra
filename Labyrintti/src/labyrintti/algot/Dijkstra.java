
package labyrintti.algot;

import labyrintti.sovellus.Labyrintti;
import labyrintti.tietorakenteet.Keko;
import labyrintti.tietorakenteet.Pino;
import labyrintti.tietorakenteet.Solmu;

/**
 * Luokka vastaan Dijkstran algoritmiin perustuvan reittihaun
 * toteuttamisesta labyrintissa.
 * 
 * Toteutus on muuten sama kuin A*-luokan toteutus, mutta
 * kokonaiskustannus on kaikille solmuille sama.
 * 
 * @author Anu N.
 */
public class Dijkstra {
    
    private Labyrintti labyrintti;
    private Solmu lahto;
    private Solmu maali;
    private Keko avoimet1; 
    private Pino polku;
    
    /**
     * Luokan konstruktori, joka saa parametrinaan matriisin (=labyrintti),
     * lähtösolmun sekä maalisolmun.
     * 
     * @param matriisi
     * @param start
     * @param end 
     */
    
    public Dijkstra(Labyrintti labyrintti, Solmu lahto, Solmu maali) {
        
        this.labyrintti = labyrintti;
        this.lahto = lahto;
        this.maali = maali;
        this.avoimet1 = new Keko(this.labyrintti.labyrintinKoko()*8);
        this.polku = new Pino(this.labyrintti.labyrintinKoko());
    }
    
    /**
     * Metodi etsii lyhimmän reitin labyrintin läpi lähtösolmusta
     * maalisolmuun käyttäen prioriteettijonon toteutuksena itse toteutettua
     * minimikeko-tietorakennetta.
     */
    public boolean search() {
        
        this.avoimet1.lisaaKekoon(lahto);
        this.lahto.setMatkaAlkuun(0);
        this.lahto.setKokonaisKustannus(0);
        
        while(!this.avoimet1.isEmpty()) {
            Solmu nykyinen = this.avoimet1.poistaPienin();
       
            if (nykyinen.equals(maali)) {
                rekonstruoiPolku();
                return true;
            }
         
            nykyinen.setVisited();
            kasitteleNaapurit(nykyinen);
            
        } return false;
        
    }
    
    /**
     * Metodi käy läpi labyrintti-Solmun naapurit ja päivittää lyhintä
     * reittiä ja etäisyysarviota naapurisolmuihin ja naapurisolmuista maaliin.
     * 
     * Naapuri lisätään avoimet1-kekoon, jos siellä ei ole vielä käyty
     * ja se ei ole jo avoimissa. Arvoja voidaan myös päivittää, jos
     * solmun kustannusarvio paranee.
     * 
     * @param nykyinen 
     */
    private void kasitteleNaapurit(Solmu nykyinen) {
     
        Keko naapurit = this.labyrintti.getNaapurit(nykyinen); 
       
                for (int i=0; i<naapurit.getPituus(); ++i) {    
                    
                    Solmu naapuri = naapurit.palautaAlkioIndeksissa(i);
            
                if (!naapuri.isVisited()) { 
                    
                    int arvioAlkuun = nykyinen.getMatkaAlkuun() 
                        + labyrintti.etaisyysValilla(nykyinen, naapuri);
                    
                    if (!this.avoimet1.contains(naapuri) || arvioAlkuun < naapuri.getMatkaAlkuun()) { 
                        naapuri.setEdellinen(nykyinen);
                        naapuri.setMatkaAlkuun(arvioAlkuun);
                        naapuri.setKokonaisKustannus(arvioAlkuun);
                    
                        if (!this.avoimet1.contains(naapuri)) { 
                            this.avoimet1.lisaaKekoon(naapuri); 
                        } else {
                            this.avoimet1.paivita(avoimet1.haeIndeksi(naapuri));
                          
                        }
                        
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
        
        this.polku.push(s);
     
    }
    
    /**
     * Metodi palauttaa Dijkstran löytämän polun labyrintin läpi.
     * 
     * @return Pino -tietorakenteessa kuljettu polku 
     */
    public Pino getPolku() {
        
        return this.polku;
    }
    
    /**
     * Metodi tulostaa lyhimmän polun labyrintin läpi.
     */
    public void tulostaPolku() {
        
        System.out.println("\nLyhyin polku lähdöstä (l) maaliin (m): \n");
       
        while (!this.polku.empty()) {
            
            Solmu s = this.polku.pop();
            System.out.println(s.toString());
        }
        
    }
    
    /**
     * Metodi tulostaa solmut, joissa on käyty.
     */
    public void tulostaKaydyt() {
        
        for (int i=0; i<this.labyrintti.pituus(); ++i) {
            for (int j=0; j<this.labyrintti.pituus(); ++j) {
                
                Solmu s = this.labyrintti.getSolmu(i, j);
                
                if (s.isVisited() == true) {
                    System.out.println("käyty: "+s);
                }
            }
        }
    }
    
}
