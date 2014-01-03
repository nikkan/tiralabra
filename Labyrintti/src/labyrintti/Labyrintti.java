
package labyrintti;

import labyrintti.tietorakenteet.Solmu;
import java.util.ArrayList;


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
     * Palauttaa listana Solmun s naapurit.
     * 
     * @param s
     * 
     * @return ArrayList<Solmu>, jossa solmun s naapurit
     */
    public ArrayList<Solmu> getNaapurit(Solmu s) {
        ArrayList<Solmu> naapurit = new ArrayList<Solmu>();
        // solmun s vasemmanpuoleinen naapuri
        if (s.getX() > 0) {
            Solmu naapuri = this.testilabyrintti[s.getX()-1][s.getY()];
            if (naapuri.onkoEste() != true) {
                naapurit.add(naapuri);
            }
        }
        // solmun s oikeanpuoleinen naapuri
        if (s.getX() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[s.getX()+1][s.getY()];
            if (naapuri.onkoEste() != true) {
                naapurit.add(naapuri);
            }
        }
        // solmun s yläpuolella oleva naapuri
        if (s.getY() > 0) {
            Solmu naapuri = this.testilabyrintti[s.getX()][s.getY()-1];
            if (naapuri.onkoEste() != true) {
                naapurit.add(naapuri);
            }
        }
        // solmun s alapuolella oleva naapuri
        if (s.getY() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[s.getX()][s.getY()+1];
            if (naapuri.onkoEste() != true) {
                naapurit.add(naapuri);
            }
        }
        return naapurit;
        
    }
    
    public int labyrintinKoko() {
        return this.testilabyrintti.length*this.testilabyrintti.length;
    }
    
    /**
     * Tulostaa labyrintin koordinaatit.
     */
    public void tulostaLabyrintti() {
        for (int i=0; i<testilabyrintti.length; i++) {
            for (int j=0; j<testilabyrintti.length; j++) {
                System.out.println(testilabyrintti[i][j].toString());
            }
        }
    }
    
    /**
     * Visualisoi labyrintin.
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
