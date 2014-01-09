
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
    
   
     /*public Labyrintti() {
        this.testilabyrintti = new Solmu[10][10];
        for (int i=0; i<testilabyrintti.length; i++) {
            for (int j=0; j<testilabyrintti.length; j++) {
                Solmu v = new Solmu(i, j);
                testilabyrintti[i][j] = v;
            }
        }
        
        this.lahto = testilabyrintti[6][4];
        this.maali = testilabyrintti[8][4];
        
        
        Solmu s = testilabyrintti[7][4];
        s.setEste();
        s = testilabyrintti[7][5];
        s.setEste();
        s = testilabyrintti[7][6];
        s.setEste();
        s = testilabyrintti[8][5];
        s.setEste();
        s = testilabyrintti[7][3];
        s.setEste();
        s = testilabyrintti[7][2];
        s.setEste();
        s = testilabyrintti[7][1];
        s.setEste();
        /*Solmu s = testilabyrintti[0][2];
        s.setEste();
        s = testilabyrintti[0][3];
        s.setEste();
        s = testilabyrintti[0][4];
        s.setEste();
        s = testilabyrintti[0][5];
        s.setEste();
        s = testilabyrintti[0][7];
        s.setEste();
        s = testilabyrintti[1][8];
        s.setEste();
        s = testilabyrintti[2][8];
        s.setEste();
        s = testilabyrintti[3][8];
        s.setEste();
        s = testilabyrintti[4][9];
        s.setEste();
        s = testilabyrintti[3][7];
        s.setEste();
        s = testilabyrintti[2][0];
        s.setEste();
        s = testilabyrintti[3][0];
        s.setEste();
        s = testilabyrintti[2][8];
        s.setEste();
        s = testilabyrintti[4][0];
        s.setEste();
        s = testilabyrintti[4][3];
        s.setEste();
        s = testilabyrintti[4][4];
        s.setEste();
        s = testilabyrintti[5][0];
        s.setEste();
        s = testilabyrintti[5][3];
        s.setEste();
        s = testilabyrintti[5][5];
        s.setEste();
        s = testilabyrintti[5][6];
        s.setEste();
        s = testilabyrintti[5][7];
        s.setEste();
        s = testilabyrintti[6][0];
        s.setEste();
        s = testilabyrintti[6][1];
        s.setEste();
        s = testilabyrintti[6][2];
        s.setEste();
        s = testilabyrintti[6][3];
        s.setEste();
        s = testilabyrintti[6][5];
        s.setEste();
        s = testilabyrintti[6][6];
        s.setEste();
        s = testilabyrintti[6][7];
        s.setEste();
        s = testilabyrintti[7][5];
        s.setEste();
        s = testilabyrintti[7][6];
        s.setEste();
        s = testilabyrintti[7][7];
        s.setEste();
        s = testilabyrintti[4][5];
        s.setEste();
        */
       
        
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
     * Palauttaa keko-tietorakenteessa kaikki Solmun s naapurit (siis myös
     * vinosti ylä- ja alapuoella olevat naapurit).
     * 
     * @param solmu eli Solmu-olio
     * 
     * @return Keko, jossa solmun s naapurit
     */
    public Keko getNaapurit(Solmu solmu) {
        
        Keko naapurit = new Keko(8);
     
        lisaaKaikkiNaapurit(naapurit, solmu);
        
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
     * Metodi palauttaa ainoastaan 'suorat' naapurit.
     * 
     * @param solmu
     * @return ArrayList<Solmu> eli ArrayList, jossa on solmun naapurit
     */
    public ArrayList<Solmu> getNaapurit2(Solmu solmu) {
        
        ArrayList<Solmu> naapurit = new ArrayList<Solmu>();
        // solmun s vasemmanpuoleinen naapuri
        if (okLiikkuaVasemmalle(solmu)) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()-1][solmu.getY()];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s oikeanpuoleinen naapuri
        if (okLiikkuaOikealle(solmu)) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()+1][solmu.getY()];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s yläpuolella oleva naapuri
        if (okLiikkuaYlos(solmu)) {
            Solmu naapuri = this.testilabyrintti[solmu.getX()][solmu.getY()-1];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s alapuolella oleva naapuri
        if (okLiikkuaAlas(solmu)) {
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
    
    // TÄMÄ METODI ON VIELÄ TYÖN ALLA
    public Keko getJumpPointNaapurit(Solmu solmu, String suunta) {
      
        Keko naapurit = new Keko(8);
        boolean esteYlapuolella = esteYlapuolella(solmu);
        boolean esteAlapuolella = esteAlapuolella(solmu);
        boolean esteOikealla = esteOikealla(solmu);
        boolean esteVasemmalla = esteVasemmalla(solmu);
        
        // 0) SUUNTA == TYHJA, LISÄTÄÄN KAIKKI NAAPURIT JOISSA EI ESTETTÄ
        if (suunta.equals("t")) {
           
            lisaaKaikkiNaapurit(naapurit, solmu);
            
        }
        
        // 1) SUUNTA OIKEALLE
        else if (suunta.equals("o")) {
         // lisätään solmun s oikeanpuoleinen naapuri
         lisaaOikeaNaapuri(naapurit, solmu);
            
            // onko lisättävä vinosti oikealla ylhäällä oleva naapuri?
            if (esteYlapuolella == true) {
                lisaaOYnaapuri(naapurit, solmu);
            }
            // onko lisättävä vinosti oikealla alapuolella oleva naapuri?
            if (esteAlapuolella == true) {
                lisaaOAnaapuri(naapurit, solmu);
            }
        }
        
        // 2) SUUNTA VASEMMALLE
        else if (suunta.equals("v")) {
            // lisätään solmun vasemmanpuoleinen naapuri
            lisaaVasenNaapuri(naapurit, solmu);
            
            // onko lisättävä vinosti oikealla alapuolella oleva naapuri?
            if (esteAlapuolella == true) {
                lisaaOAnaapuri(naapurit, solmu);
            }       
            // onko lisättävä vinosti vasemmalla yläpuolella oleva naapuri?
            if (esteYlapuolella == true) {
                lisaaVYnaapuri(naapurit, solmu);
            }
        }
        
        // 3) SUUNTA YLÖS
        else if (suunta.equals("y")) {
            // lisätään solmun ylapuolella oleva naapuri
            lisaaYlapuoleinenNaapuri(naapurit, solmu);
            
            // onko lisättävä solmun vinosti vasemmalla yläpuolella oleva naapuri?
            if (esteVasemmalla == true) {
                lisaaVYnaapuri(naapurit, solmu);
            } 
            // onko lisättävä solmun vinosti oikealla yläpuolella oleva naapuri?
            if (esteOikealla == true) {
                lisaaOYnaapuri(naapurit, solmu);
            }
        }
        
        // 4) SUUNTA ALAS
        else if (suunta.equals("a")) {
            // lisätään solmun s alapuolella oleva naapuri
            lisaaAlapuoleinenNaapuri(naapurit, solmu);
            
            // onko lisättävä solmun vinosti vasemmalla alapuolella oleva naapuri?
            if (esteVasemmalla == true) {
                lisaaVAnaapuri(naapurit, solmu);
            }
            // onko lisättävä solmun vinosti oikealla alapuolella oleva naapuri?
            if (esteOikealla == true && okLiikkuaOA(solmu)) {
                lisaaOAnaapuri(naapurit, solmu);
            }
            
        }
        
        // 5) SUUNTA VINOSTI OIKEALLE YLÖS
        else if (suunta.equals("oy")) {
            // lisätään solmun s oikeanpuoleinen naapuri
            lisaaOikeaNaapuri(naapurit, solmu);
            
            // lisätään solmun s yläpuolella oleva naapuri
            lisaaYlapuoleinenNaapuri(naapurit, solmu);
            
            // lisätään solmun s vinosti oikealla yläpuolella oleva naapuri
            if (okLiikkuaOY(solmu)) {
                lisaaOYnaapuri(naapurit, solmu);
            }
            // onko lisättävä solmun vinosti vasemmalla yläpuolella oleva naapuri?
            if (esteVasemmalla == true) {
                lisaaVYnaapuri(naapurit, solmu);
            }
            // onko lisättävä solmun vinosti oikealla alapuolella oleva naapuri?
            if (esteAlapuolella == true ) {
                lisaaOAnaapuri(naapurit, solmu);
            }
        }
        
        // 6) SUUNTA VINOSTI OIKEALLE ALAS
        else if (suunta.equals("oa")) {
            
            // lisätään solmun alapuolella oleva naapuri
            lisaaAlapuoleinenNaapuri(naapurit, solmu);
            
            // lisätään solmun oikealla puolella oleva naapuri
            lisaaOikeaNaapuri(naapurit, solmu);
            
            // lisätään solmun s vinosti oikealla alapuolella oleva naapuri
            lisaaOAnaapuri(naapurit, solmu);
            
            // onko lisättävä solmun vinosti oikealla yläpuolella oleva naapuri? ESTETARRKISTUS!!
            if (esteYlapuolella == true) {
                lisaaOYnaapuri(naapurit, solmu);
            }
            // onko lisättävä solmun vinosti vasemmalla alapuolella oleva naapuri? ESTETARKISTUS!
            if (esteVasemmalla == true) {
                lisaaVAnaapuri(naapurit, solmu);
            }
            
        }
        
        // 7) SUUNTA VINOSTI VASEMMALLE YLÖS
        else if (suunta.equals("vy")) {
            // lisätään solmun vasemmalla puolella oleva naapuri
            lisaaVasenNaapuri(naapurit, solmu);
            
            // lisätään solmun s yläpuolella oleva naapuri
            lisaaYlapuoleinenNaapuri(naapurit, solmu);
            
            // lisätään solmun s vinosti vasemmalla yläpuolella oleva naapuri
            lisaaVYnaapuri(naapurit, solmu);
            
            // onko lisättävä solmun vinosti oikealla yläpuolella oleva naapuri?
            if (esteOikealla == true) {
                lisaaOYnaapuri(naapurit, solmu);
            } 
            // onko lisättävä solmun vinosti vasemmalla alapuolella oleva naapuri? ESTETARKISTUS!!!
            if (okLiikkuaVA(solmu)) {
                lisaaVAnaapuri(naapurit, solmu);
            }
            
        }
        
        // 8) SUUNTA VINOSTI VASEMMALLE ALAS
        else if (suunta.equals("va")) {
            // lisätään solmun s alapuolella oleva naapuri
            lisaaAlapuoleinenNaapuri(naapurit, solmu);
            
            // lisätään solmun s vasemmalla puolella oleva naapuri
            lisaaVasenNaapuri(naapurit, solmu);
            
            // lisätään solmun s vinosti vasemmalla alapuolella oleva naapuri
            lisaaVAnaapuri(naapurit, solmu);
            
            // onko lisättävä solmun vinosti vasemmalla yläpuolella oleva naapuri? ESTETARKISTUS PUUUTTUU!
            if (esteYlapuolella == true) {
                lisaaVYnaapuri(naapurit, solmu);
            }
            // onko lisättävä solmun vinosti oikealla alapuolella oleva naapuri? ESTETARKISTUS PUUTTUU!!
            if (esteOikealla == true) {
                lisaaOAnaapuri(naapurit, solmu);
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
    
    /**
     * Metodi tarkistaa, onko labyrintissa ok siirtyä solmusta solmu vasemman-
     * puoleiseen solmuun menemättä reunojen yli.
     *
     * @param solmu nykyinen Solmu
     * @return true, jos liikkuminen on ok, muuten false
     */
    public boolean okLiikkuaVasemmalle(Solmu solmu) {
        if (solmu.getX() > 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko labyrintissa ok siirtyä nykyisestä solmusta
     * oikeanpuoleiseen solmuun.
     * 
     * @param solmu nykyinen Solmu
     * @return true, jos liikkuminen on ok, muuten false
     */
    public boolean okLiikkuaOikealle(Solmu solmu) {
        if (solmu.getX() < this.testilabyrintti.length-1) {
            return true;
        } 
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko labyrintissa ok siirtyä nykyisestä solmusta
     * yläpuolella olevaan solmuun.
     * 
     * @param solmu nykyinen Solmu
     * @return true, jos liikkuminen on ok, muuten false
     */
    public boolean okLiikkuaYlos(Solmu solmu) {
        if (solmu.getY() > 0) {
            return true;
        }
        return false;
    }
   
    /**
     * Metodi tarkistaa, onko labyrintissa ok siirtyä nykyisestä solmusta
     * alapuolella olevaan solmuun.
     * 
     * @param solmu nykyinen Solmu
     * @return true, jos liikkuminen on ok, muuten false
     */
    public boolean okLiikkuaAlas(Solmu solmu) {
        if (solmu.getY() < this.testilabyrintti.length-1) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko labyrintissa ok siirtyä nykyisestä solmusta
     * vinosti oikealla yläpuolella olevaan solmuun.
     * 
     * @param solmu nykyinen Solmu
     * @return true, jos liikkuminen on ok, muuten false
     */
    public boolean okLiikkuaOY(Solmu solmu) {
        if (solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() > 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko labyrintissa ok siirtyä nykyisestä solmusta
     * vinosti oikealla alapuolella olevaan solmuun.
     * 
     * @param solmu nykyinen Solmu
     * @return true, jos liikkuminen on ok, muuten false
     */
    public boolean okLiikkuaOA(Solmu solmu) {
        if (solmu.getX() < this.testilabyrintti.length-1 && solmu.getY() < this.testilabyrintti.length-1) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko labyrintissa ok siirtyä nykyisestä solmusta
     * vinosti vasemmalla alapuolella olevaan solmuun.
     * 
     * @param solmu nykyinen Solmu
     * @return true, jos liikkuminen on ok, muuten false
     */
    public boolean okLiikkuaVA(Solmu solmu) {
        if (solmu.getX() > 0 && solmu.getY() < this.testilabyrintti.length-1) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, onko labyrintissa ok siirtyä nykyisestä solmusta
     * vinosti vasemmalla yläpuolella olevaan solmuun.
     * 
     * @param solmu nykyinen Solmu
     * @return true, jos liikkuminen on ok, muuten false
     */
    public boolean okLiikkuaVY(Solmu solmu) {
        if (solmu.getX() > 0 && solmu.getY() > 0) {
            return true;
        }
        return false;
    }
    
    public void lisaaKaikkiNaapurit(Keko naapurit, Solmu solmu) {
            
        lisaaVasenNaapuri(naapurit, solmu);
        lisaaOikeaNaapuri(naapurit, solmu);
        lisaaYlapuoleinenNaapuri(naapurit, solmu);
        lisaaAlapuoleinenNaapuri(naapurit, solmu);
        lisaaOYnaapuri(naapurit, solmu);
        lisaaOAnaapuri(naapurit, solmu);
        lisaaVYnaapuri(naapurit, solmu);
        lisaaVAnaapuri(naapurit, solmu);
        
    }
    
    public void lisaaVasenNaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaVasemmalle(nykyinen)) {
            Solmu naapuri = this.testilabyrintti[nykyinen.getX()-1][nykyinen.getY()];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    public void lisaaOikeaNaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaOikealle(nykyinen)) {
            Solmu naapuri = this.testilabyrintti[nykyinen.getX()+1][nykyinen.getY()];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    public void lisaaYlapuoleinenNaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaYlos(nykyinen)) {
            Solmu naapuri = this.testilabyrintti[nykyinen.getX()][nykyinen.getY()-1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    public void lisaaAlapuoleinenNaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaAlas(nykyinen)) {
            Solmu naapuri = this.testilabyrintti[nykyinen.getX()][nykyinen.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    public void lisaaOYnaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaOY(nykyinen)) {
            Solmu naapuri = this.testilabyrintti[nykyinen.getX()+1][nykyinen.getY()-1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    public void lisaaOAnaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaOA(nykyinen)) {
            Solmu naapuri = this.testilabyrintti[nykyinen.getX()+1][nykyinen.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    public void lisaaVAnaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaVA(nykyinen)) {
            Solmu naapuri = this.testilabyrintti[nykyinen.getX()-1][nykyinen.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    public void lisaaVYnaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaVY(nykyinen)) {
            Solmu naapuri = this.testilabyrintti[nykyinen.getX()-1][nykyinen.getY()-1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    /**
     * Palauttaa labyrintin koon.
     * 
     * @return int labyrintin koko
     */
    public int labyrintinKoko() {
        return this.testilabyrintti.length*this.testilabyrintti.length;
    }
    
    public int pituus() {
        return this.testilabyrintti.length;
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
