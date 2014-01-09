
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
            Solmu nykyinen = this.avoimet1.poistaPienin();
            if (nykyinen.equals(maali)) {
                rekonstruoiPolku();
            }
   
            this.kaydyt.lisaaKekoon(nykyinen);
            nykyinen.setVisited();
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
            nykyinen.setVisited();
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
        String suunta = suunta(nykyinen, nykyinen.getEdellinen());
        Keko naapurit = this.labyrintti.getJumpPointNaapurit(nykyinen, suunta); 
       
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
     * Metodi käsittelee naapurit JumpPointSearch -algoritmin mukaisesti
     * (D. Harabor & A. Grastien) 
     *
     * @param nykyinen 
     */
    private void kasitteleNaapuritJumpPoint(Solmu nykyinen) {
       
        String suunta = suunta(nykyinen, nykyinen.getEdellinen());
      
        Keko naapurit = this.labyrintti.getJumpPointNaapurit(nykyinen, suunta); 
                               
                for (int i=0; i<naapurit.getPituus(); ++i) {    
                    Solmu naapuri = naapurit.palautaAlkioIndeksissa(i);
            
                if (!kaydyt.contains(naapuri)) { 
                    int arvioAlkuun = nykyinen.getMatkaAlkuun() + labyrintti.etaisyysValilla(nykyinen, naapuri);
                    String suuntaNaapuriin = suunta(naapuri, nykyinen);
                    Solmu naapurisolmu = jump(nykyinen, suuntaNaapuriin);
                    
                    if (naapurisolmu != null && (!this.avoimet1.contains(naapurisolmu) || arvioAlkuun < naapurisolmu.getMatkaAlkuun())) {
                        naapurisolmu.setEdellinen(nykyinen);
                        naapurisolmu.setMatkaAlkuun(arvioAlkuun);
                        naapurisolmu.setKokonaisKustannus(maali);
                        avoimet1.lisaaKekoon(naapurisolmu);
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
        
       String suunta = suunta(nykyinen, nykyinen.getEdellinen());
      
        Keko naapurit = this.labyrintti.getJumpPointNaapurit(nykyinen, suunta); 
                               
                for (int i=0; i<naapurit.getPituus(); ++i) {    
                    Solmu naapuri = naapurit.palautaAlkioIndeksissa(i);
            
                if (!kaydyt.contains(naapuri)) { 
                    int arvioAlkuun = nykyinen.getMatkaAlkuun() + labyrintti.etaisyysValilla(nykyinen, naapuri);
                    String suuntaNaapuriin = suunta(naapuri, nykyinen);
                    Solmu naapurisolmu = jump(nykyinen, suuntaNaapuriin);
                    
                    if (naapurisolmu != null && (!this.avoimet2.contains(naapurisolmu) || arvioAlkuun < naapurisolmu.getMatkaAlkuun())) {
                        naapurisolmu.setEdellinen(nykyinen);
                        naapurisolmu.setMatkaAlkuun(arvioAlkuun);
                        naapurisolmu.setKokonaisKustannus(maali);
                        avoimet2.add(naapurisolmu);
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
    
    /**
     * Palauttaa suunnan edellisestä solmusta nykyiseen.
     * 
     * @param nykyinen
     * @param edellinen
     * @return  String "t", jos edellistä solmua ei ole asetettu
     *                 "o", jos suunta on oikealle
     *                 "v", jos suunta on vasemmalle
     *                 "oy", jos suunta on vinosti oikealle ylös
     *                 "oa", jos suunta on vinosti okealle alas
     *                 "vy", jos suunta on vinosti vasemmalle ylös
     *                 "va", jos suunta on vinosti vasemmalle alas
     * 
     */
    public String suunta(Solmu nykyinen, Solmu edellinen) {
        
        if (edellinen == null) {
            return "t";
        } 
        // suunta: oikealle
        else if (nykyinen.getX() > edellinen.getX() && nykyinen.getY() == edellinen.getY() ) {
            return "o";
        }
        // suunta: vasen
        else if (nykyinen.getX() < edellinen.getX() && nykyinen.getY() == edellinen.getY() ) {
            return "v";
        }
        // suunta: ylos
        else if (nykyinen.getX() == edellinen.getX() && nykyinen.getY() < edellinen.getY() ) {
            return "y";
        }
        // suunta: alas
        else if (nykyinen.getX() == edellinen.getX() && nykyinen.getY() > edellinen.getY() ) {
            return "a";
        }
        // suunta: vinosti oikealle ylös
        else if (nykyinen.getX() > edellinen.getX() && nykyinen.getY() < edellinen.getY() ) {
            return "oy";
        }  
        // suunta: vinosti oikealle alas
        else if (nykyinen.getX() > edellinen.getX() && nykyinen.getY() > edellinen.getY() ) {
            return "oa";
        }
        // suunta: vinosti vasemmalle ylös
        else if (nykyinen.getX() < edellinen.getX() && nykyinen.getY() < edellinen.getY() ) {
            return "vy";
        }
        // suunta: vinosti vasemmalle alas
        else if (nykyinen.getX() < edellinen.getX() && nykyinen.getY() > edellinen.getY() ) {
            return "va";
        }
        
        return "t";
    }
    
    public Solmu jump(Solmu nykyinen, String suunta) {
        Solmu n = step(nykyinen, suunta);
        if (n == null) {
            return null;
        }
        if (n == this.maali) {
            return n;
        }
        
        // tutkitaan, onko n:llä 'pakotettuja naapureita - jos on, palautetaan n
        if (this.labyrintti.esteVasemmalla(n) == true
                || this.labyrintti.esteOikealla(n)== true
                || this.labyrintti.esteYlapuolella(n) == true
                || this.labyrintti.esteAlapuolella(n) == true) {
            return n;
        }      
           
       // lopuksi vielä diagonaaliset suunnat!!!!!!
       if (suunta.equals("oy") || suunta.equals("oa") || suunta.equals("va") || suunta.equals("vy")) {
           // 1. jos suunta oikealle ylös, katsotaan ylös ja oikealle
           if (suunta.equals("oy")) {
               if (jump(n, "y") != null) {
                   return n;
               } 
               if (jump(n, "o") != null) {
                   return n;
               }
           }
           // 2. jos suunta oikealle alas, katsotaan alas ja oikealle
           if (suunta.equals("oa")) {
               if (jump(n, "o") != null) {
                   return n;
               }
               if (jump(n, "a") != null) {
                   return n;
               }
           }
           // 3. jos suunta vasemmalle alas, katsotaan alas ja vasemmalle
           if (suunta.equals("va")) {
               if (jump(n, "v") != null) {
                   return n;
               }
               if (jump(n, "a") != null) {
                   return n;
               }
           }
           // 4. jos suunta vasemmalle ylös, katsotaan ylös ja vasemmalle
           if (suunta.equals("vy")) {
               if (jump(n, "v") != null) {
                   return n;
               }
               if (jump(n, "y") != null) {
                   return n;
               }
          
            }
        }
        return jump(n, suunta);
        
    }
    
    // tämän voisi ehkä siirtää labyrinttiluokkaan, tai sinne mihin teen näille omat metodit..
    public Solmu step(Solmu solmu, String suunta) {
       
        if (suunta.equals("o") && solmu.getX() < this.labyrintti.pituus()-1) {
            Solmu oikeanpuoleinen = this.labyrintti.getSolmu((solmu.getX()+1),(solmu.getY()));
            if (oikeanpuoleinen.onkoEste() != true) {
                return oikeanpuoleinen;
            }
        }
        else if (suunta.equals("v") && solmu.getX() > 0) {
            Solmu vasemmanpuoleinen = this.labyrintti.getSolmu((solmu.getX()-1), (solmu.getY()));
            if (vasemmanpuoleinen.onkoEste() != true) {
                return vasemmanpuoleinen;
            }
        } 
        else if (suunta.equals("y") && solmu.getY() > 0) {
            Solmu ylapuolella = this.labyrintti.getSolmu((solmu.getX()), (solmu.getY()-1));
            if (ylapuolella.onkoEste() != true) {
                return ylapuolella;
            }
        }
        else if (suunta.equals("a") && solmu.getY() < this.labyrintti.pituus()-1) {
            Solmu alapuolella = this.labyrintti.getSolmu((solmu.getX()), (solmu.getY()+1));
            if (alapuolella.onkoEste() != true) {
                return alapuolella;
            }
        }
        else if (suunta.equals("oy") && solmu.getX() < this.labyrintti.pituus()-1 && solmu.getY() > 0) {
            Solmu oy = this.labyrintti.getSolmu((solmu.getX()+1), (solmu.getY()-1));
            if (oy.onkoEste() != true) {
                return oy;
            }
        }
        else if (suunta.equals("vy") && solmu.getX() > 0 && solmu.getY() > 0) {
            Solmu vy = this.labyrintti.getSolmu((solmu.getX()-1),(solmu.getY()-1));
            if (vy.onkoEste() != true) {
                return vy;
            }
        } 
        else if (suunta.equals("oa") && solmu.getX() < this.labyrintti.pituus()-1 && solmu.getY() < this.labyrintti.pituus()-1) {
            Solmu oa = this.labyrintti.getSolmu((solmu.getX()+1),(solmu.getY()+1));
            if (oa.onkoEste() != true) {
                return oa;
            }
        } 
        else if (suunta.equals("va") && solmu.getX() > 0 && solmu.getY() < this.labyrintti.pituus()-1) {
            Solmu va = this.labyrintti.getSolmu((solmu.getX()-1), (solmu.getY()+1));
            if (va.onkoEste() != true) {
                return va;
            }
        }
        
        return null;
    }

    
}
