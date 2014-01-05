
package labyrintti;

import labyrintti.tietorakenteet.Solmu;
import java.util.ArrayList;
import labyrintti.tietorakenteet.Keko;


/**
 * Luokka vastaa labyrinttien muodostamisesta. 
 * 
 * LUOKAN TOTEUTUS ON VIELÄ KESKEN, TARKOITUS
 * ON MM. ETTÄ HALUTUN KOKOISET LABYRINTIT GENEROITAISIIN 'SATUNNAISESTI'.
 * 
 * @author Anu N.
 */
public class Labyrintti {
    
    private Solmu[][] testilabyrintti;
    private Solmu lahto;
    private Solmu maali;
    
    public Labyrintti() {
        this.testilabyrintti = new Solmu[5][5];
        
        // Luodaan Solmu-oliot ja laitetaan ne testilabyrinttiin
        for (int i=0; i<testilabyrintti.length; i++) {
            for (int j=0; j<testilabyrintti.length; j++) {
                Solmu v = new Solmu(i, j);
                testilabyrintti[i][j] = v;
            }
        }
        
        // Laitetaan testilabyrinttiin muutamia estesolmuja
        Solmu s = testilabyrintti[2][0];
        s.setEste();
        s = testilabyrintti[2][1];
        s.setEste();
        s = testilabyrintti[2][2];
        s.setEste();
        s = testilabyrintti[3][1];
        s.setEste();
        
        // Asetetaan testilabyrintin lähtö ja maali
        this.lahto = testilabyrintti[0][1];
        this.maali = testilabyrintti[3][0];
    }
    
    /**
     * Palauttaa annetuissa koordinaateissa olevan Solmu-olion.
     * 
     * @param x
     * @param y
     * 
     * @return Solmu annetuissa x- ja y-koordinaateissa
     */
    public Solmu getSolmu(int x, int y) {
        return this.testilabyrintti[x][y];
    }
    
    /**
     * Palauttaa labyrintin lähtösolmun.
     * 
     * @return Solmu (lähtösolmu-olio)
     */
    public Solmu getLahto() {
        return this.lahto;
    }
    
    /**
     * Palauttaa labyrintin maalisolmun.
     * 
     * @return Solmu (maalisolmu-olio)
     */
    public Solmu getMaali() {
        return this.maali;
    }
    
    /**
     * Palauttaa keko-tietorakenteessa Solmun s naapurit.
     * 
     * @param solmu eli Solmu-olio
     * 
     * @return Keko, jossa solmun s naapurit
     */
    public Keko getNaapurit(Solmu solmu) {
        Keko naapurit = new Keko(4);
        //int laskuri = 0;
        // solmun s vasemmanpuoleinen naapuri
        if (solmu.getX() > 0) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()];
            if (naapuri.onkoEste() != true) {
                naapurit.lisaaKekoon(naapuri);
            }
        }
        // solmun s oikeanpuoleinen naapuri
        if (solmu.getX() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()];
            if (naapuri.onkoEste() != true) {
                naapurit.lisaaKekoon(naapuri);
            }
        }
        // solmun s yläpuolella oleva naapuri
        if (solmu.getY() > 0) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()-1];
            if (naapuri.onkoEste() != true) {
                naapurit.lisaaKekoon(naapuri);
            }
        }
        // solmun s alapuolella oleva naapuri
        if (solmu.getY() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()+1];
            if (naapuri.onkoEste() != true) {
                naapurit.lisaaKekoon(naapuri);
            }
        }
        return naapurit;
        
    }
    
    /**
     * Vaihtoehtoinen toteutus metodille, joka palauttaa Solmun naapurit.
     * 
     * Metodi käyttää Javan ArrayList-tietorakennetta, eli palauttaa naapurit
     * ArrayListina.
     * 
     * @param solmu
     * @return ArrayList<Solmu> eli ArrayList, jossa on solmun naapurit
     */
    public ArrayList<Solmu> getNaapurit2(Solmu solmu) {
        ArrayList<Solmu> naapurit = new ArrayList<Solmu>();
        // solmun s vasemmanpuoleinen naapuri
        if (solmu.getX() > 0) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()];
            if (naapuri.onkoEste() != true) {
                naapurit.add(naapuri);
            }
        }
        // solmun s oikeanpuoleinen naapuri
        if (solmu.getX() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()];
            if (naapuri.onkoEste() != true) {
                naapurit.add(naapuri);
            }
        }
        // solmun s yläpuolella oleva naapuri
        if (solmu.getY() > 0) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()-1];
            if (naapuri.onkoEste() != true) {
                naapurit.add(naapuri);
            }
        }
        // solmun s alapuolella oleva naapuri
        if (solmu.getY() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()+1];
            if (naapuri.onkoEste() != true) {
                naapurit.add(naapuri);
            }
        }
        return naapurit;
        
    }
    
    /**
     * Palauttaa labyrintin koon.
     * 
     * @return int labyrintin koko
     */
    public int labyrintinKoko() {
        return this.testilabyrintti.length*this.testilabyrintti.length;
    }
    
    /**
     * Tulostaa labyrintissa olevien solmujen koordinaatit.
     */
    public void tulostaLabyrintti() {
        for (int i=0; i<testilabyrintti.length; i++) {
            for (int j=0; j<testilabyrintti.length; j++) {
                System.out.println(testilabyrintti[i][j].toString());
            }
        }
    }
    
    /**
     * Visualisoi labyrintin eli tulostaa matriisin, jossa näkyvät lähtö- ja
     * maalisolmu sekä esteet.
     */
    public void visualisoiLabyrintti() {
        System.out.println("LABYRINTTI: \n");
        System.out.println("lähtö = l");
        System.out.println("maali = m");
        System.out.println("este = #");
        System.out.println(" ");
        for (int j=0; j<testilabyrintti.length; j++) {
            for (int i=0; i<testilabyrintti.length; i++) {
                if (testilabyrintti[i][j] == maali) {
                    System.out.print("[m]");
                } else if (testilabyrintti[i][j] == lahto) {
                    System.out.print("[l]");
                } else if (testilabyrintti[i][j].onkoEste() == true) {
                    System.out.print("[#]");
                    
                } else {
                    System.out.print("[ ]");
                } 
            }
                System.out.println("");
            
        
    }
        System.out.println("");
    }
    
    /**
     * Palauttaa etäisyyden solmun ja sen naapurisolmun välillä.
     * 
     * @param nykyinen
     * @param naapuri
     * @return etäisyys kokonaislukuna
     */
    public int etaisyysValilla(Solmu nykyinen, Solmu naapuri) {
        return 1; // tämän voi vielä muuttaa, jos teen labyrinttiin esim. vaikeakulkuista maastoa,
                  // nyt oletusarvona kuitenkin, että etäisyys solmujen välillä on aina 1.
    }
  
    
}
