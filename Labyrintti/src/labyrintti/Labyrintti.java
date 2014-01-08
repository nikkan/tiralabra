
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
        
        Keko naapurit = new Keko(8);
     
        // solmun s vasemmanpuoleinen naapuri
        if (solmu.getX() > 0) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()];
            lisaaNaapuri(naapurit, naapuri);
        }
        // solmun s oikeanpuoleinen naapuri
        if (solmu.getX() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()];
             lisaaNaapuri(naapurit, naapuri);
        }
        // solmun s yläpuolella oleva naapuri
        if (solmu.getY() > 0) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()-1];
             lisaaNaapuri(naapurit, naapuri);
        }
        // solmun s alapuolella oleva naapuri
        if (solmu.getY() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()+1];
             lisaaNaapuri(naapurit, naapuri);
        }
        
        // solmun s vinosti vasemmalla yläpuolella oleva naapuri
        if (solmu.getX() > 0 && solmu.getY() > 0) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()-1];
            lisaaNaapuri(naapurit, naapuri);
        }
        
        // solmun s vinosti oikealla yläpuolella oleva naapuri
        if (solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() > 0) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()-1];
            lisaaNaapuri(naapurit, naapuri);
        }
        
        // solmun s vinosti vasemmalla alapuolella oleva naapuri
        if (solmu.getX() > 0 && solmu.getY() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
        
        // solmun s vinosti oikealla alapuolella oleva naapuri
        if (solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
        
        return naapurit;
        
    }
   
    
    /**
     * Lisää naapurin (Solmu-olio) parametrina annettuun kekoon, jos Solmu
     * ei ole estesolmu.
     * 
     * @param naapurit
     * @param n 
     */
    private void lisaaNaapuri(Keko naapurit, Solmu naapuri) {
        if (naapuri.onkoEste() != true && naapuri.isVisited() != true) {
            naapurit.lisaaKekoon(naapuri);
        }
        
    }
    
    
    
    /**
     * Vaihtoehtoinen toteutus metodille, joka palauttaa Solmun naapurit.
     * 
     * Metodi käyttää Javan ArrayList-tietorakennetta, eli palauttaa naapurit
     * ArrayListina vertailun mahdollistamiseksi.
     * 
     * @param solmu
     * @return ArrayList<Solmu> eli ArrayList, jossa on solmun naapurit
     */
    public ArrayList<Solmu> getNaapurit2(Solmu solmu) {
        
        ArrayList<Solmu> naapurit = new ArrayList<Solmu>();
        // solmun s vasemmanpuoleinen naapuri
        if (solmu.getX() > 0) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s oikeanpuoleinen naapuri
        if (solmu.getX() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s yläpuolella oleva naapuri
        if (solmu.getY() > 0) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()-1];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s alapuolella oleva naapuri
        if (solmu.getY() < this.testilabyrintti.length-1) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()+1];
            lisaaNaapuri2(naapurit, naapuri);
        }
        return naapurit;
        
    }
    
    /**
     * Lisää naapurin (Solmu-olio) parametrina annettuun kekoon, jos Solmu
     * ei ole estesolmu.
     * 
     * Vaihtoehtoinen toteutus kun käytössä ArrayList itse toteutetun keon sijaan.
     * 
     * @param naapurit
     * @param naapuri 
     */
    private void lisaaNaapuri2(ArrayList<Solmu> naapurit, Solmu naapuri) {
         if (naapuri.onkoEste() != true && naapuri.isVisited() != true) {
                naapurit.add(naapuri);
         }
   
    }
    
    // TÄMÄ METODI ON TYÖN ALLA
    public Keko getJumpPointNaapurit(Solmu solmu) {
      
        Keko naapurit = new Keko(8);
        boolean esteYlapuolella = esteYlapuolella(solmu);
        boolean esteAlapuolella = esteAlapuolella(solmu);
        boolean esteOikealla = esteOikealla(solmu);
        boolean esteVasemmalla = esteVasemmalla(solmu);
        
        Solmu edellinen = solmu.getEdellinen();
        String suunta = suunta(solmu, edellinen);
        
        // 0) SUUNTA == TYHJA, LISÄTÄÄN KAIKKI NAAPURIT JOISSA EI ESTETTÄ
        if (suunta.equals("t")) {
           
            // solmun s vasemmanpuoleinen naapuri
            if (solmu.getX() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()];
                lisaaNaapuri(naapurit, naapuri);
            }
            // solmun s oikeanpuoleinen naapuri
            if (solmu.getX() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()];
                lisaaNaapuri(naapurit, naapuri);
            }
            // solmun s yläpuolella oleva naapuri
            if (solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // solmun s alapuolella oleva naapuri
            if (solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()+1];
                 lisaaNaapuri(naapurit, naapuri);
            }
            // solmun s vinosti oikealla yläpuolella oleva naapuri
            if (solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // solmun s vinosti oikealla alapuolella oleva naapuri
            if (solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // solmun s vinosti vasemmalla yläpuolella oleva naapuri
            if (solmu.getX() > 0 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // solmun s vinosti vasemmalla alapuolella oleva naapuri
            if (solmu.getX() > 0 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
            
            
        }
        
        // 1) SUUNTA OIKEALLE
        else if (suunta.equals("o")) {
         // lisätään solmun s oikeanpuoleinen naapuri
            if (solmu.getX() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä vinosti oikealla ylhäällä oleva naapuri?
            if (esteYlapuolella == true && solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä vinosti oikealla alapuolella oleva naapuri?
            if (esteAlapuolella == true && solmu.getX() < this.testilabyrintti.length-1 
                && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
        }
        
        // 2) SUUNTA VASEMMALLE
        else if (suunta.equals("v")) {
            // lisätään solmun vasemmanpuoleinen naapuri
            if (solmu.getX() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä vinosti oikealla alapuolella oleva naapuri?
            if (esteAlapuolella == true && solmu.getX() > 0 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }       
            // onko lisättävä vinosti vasemmalla yläpuolella oleva naapuri?
            if (esteYlapuolella == true && solmu.getX() > 0 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
        }
        
        // 3) SUUNTA YLÖS
        else if (suunta.equals("y")) {
            // lisätään solmun ylapuolella oleva naapuri
            if (solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti vasemmalla yläpuolella oleva naapuri?
            if (esteVasemmalla == true && solmu.getX() > 0 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            } 
            // onko lisättävä solmun vinosti oikealla yläpuolella oleva naapuri?
            if (esteOikealla == true && solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
        }
        
        // 4) SUUNTA ALAS
        else if (suunta.equals("a")) {
            // lisätään solmun s alapuolella oleva naapuri
            if (solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti vasemmalla alapuolella oleva naapuri?
            if (esteVasemmalla == true && solmu.getX() > 0 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti oikealla alapuolella oleva naapuri?
            if (esteOikealla == true && solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
            
        }
        
        // 5) SUUNTA VINOSTI OIKEALLE YLÖS
        else if (suunta.equals("oy")) {
             
            // lisätään solmun s oikeanpuoleinen naapuri
            if (solmu.getX() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()];
                lisaaNaapuri(naapurit, naapuri);
            }
            // solmun s yläpuolella oleva naapuri
            if (solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // lisätään solmun s vinosti oikealla yläpuolella oleva naapuri
            if (solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti vasemmalla yläpuolella oleva naapuri?
            if (esteVasemmalla && true && solmu.getX() > 0 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti oikealla alapuolella oleva naapuri?
            if (esteAlapuolella && true && solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
        }
        
        // 6) SUUNTA VINOSTI OIKEALLE ALAS
        else if (suunta.equals("oa")) {
            
            // lisätään solmun alapuolella oleva naapuri
            if (solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()+1];
                 lisaaNaapuri(naapurit, naapuri);
            }
            // lisätään solmun oikealla puolella oleva naapuri
            if (solmu.getX() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()];
                lisaaNaapuri(naapurit, naapuri);
            }
            // lisätään solmun s vinosti oikealla alapuolella oleva naapuri
            if (solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti oikealla yläpuolella oleva naapuri?
            if (solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti vasemmalla alapuolella oleva naapuri?
            if (solmu.getX() > 0 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
            
        }
        
        // 7) SUUNTA VINOSTI VASEMMALLE YLÖS
        else if (suunta.equals("vy")) {
            // lisätään solmun vasemmalla puolella oleva naapuri
            if (solmu.getX() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()];
                lisaaNaapuri(naapurit, naapuri);
            }
            // lisätään solmun s yläpuolella oleva naapuri
            if (solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // lisätään solmun s vinosti vasemmalla yläpuolella oleva naapuri
            if (solmu.getX() > 0 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti oikealla yläpuolella oleva naapuri?
            if (esteOikealla == true && solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti vasemmalla alapuolella oleva naapuri?
            if (solmu.getX() > 0 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
            
        }
        
        // 8) SUUNTA VINOSTI VASEMMALLE ALAS
        else if (suunta.equals("va")) {
            // lisätään solmun s alapuolella oleva naapuri
            if (solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()+1];
                 lisaaNaapuri(naapurit, naapuri);
            }
            // lisätään solmun s vasemmalla puolella oleva naapuri
            if (solmu.getX() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()];
                lisaaNaapuri(naapurit, naapuri);
            }
            // lisätään solmun s vinosti vasemmalla alapuolella oleva naapuri
            if (solmu.getX() > 0 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti vasemmalla yläpuolella oleva naapuri?
            if (solmu.getX() > 0 && solmu.getY() > 0) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()-1];
                lisaaNaapuri(naapurit, naapuri);
            }
            // onko lisättävä solmun vinosti oikealla alapuolella oleva naapuri?
            if (solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() < this.testilabyrintti.length-1) {
                Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()+1];
                lisaaNaapuri(naapurit, naapuri);
            }
              
        }
     
        return naapurit;
        
  
    }
    
    public boolean esteOikealla(Solmu solmu) {
     
        if (solmu.getX() < this.testilabyrintti.length-1) {
            Solmu oikeanpuoleinen = this.testilabyrintti[solmu.getX()+1][solmu.getY()];
            if (oikeanpuoleinen.onkoEste() == true) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean esteVasemmalla(Solmu solmu) {
        
        if (solmu.getX() > 0) {
            Solmu vasemmanpuoleinen = this.testilabyrintti[solmu.getX()-1][solmu.getY()];
            if (vasemmanpuoleinen.onkoEste() == true) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean esteYlapuolella(Solmu solmu) {
        
        if (solmu.getY() > 0) {
            Solmu ylapuolella = this.testilabyrintti[solmu.getX()][solmu.getY()-1];
            if (ylapuolella.onkoEste() == true) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean esteAlapuolella(Solmu solmu) {
        
        if (solmu.getY() < this.testilabyrintti.length-1) {
            Solmu alapuolella = this.testilabyrintti[solmu.getX()][solmu.getY()+1];
            if (alapuolella.onkoEste() == true) {
                return true;
            }
        }
        
        return false;
    }
    
    
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
        else if (nykyinen.getX() == edellinen.getX() && nykyinen.getY() > edellinen.getY() ) {
            return "y";
        }
        // suunta: alas
        else if (nykyinen.getX() == edellinen.getX() && nykyinen.getY() < edellinen.getY() ) {
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
        if (nykyinen.getX() == naapuri.getX() || nykyinen.getY() == naapuri.getY()) {
            return 1; // tämän voi vielä muuttaa, jos teen labyrinttiin esim. vaikeakulkuista maastoa,
                  // nyt oletusarvona kuitenkin, että etäisyys solmujen välillä on aina 1.
        } else {
            return (int) Math.sqrt(2);
        }
        
    } 
    
    
}
