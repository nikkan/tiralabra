
package labyrintti.sovellus;

import labyrintti.tietorakenteet.Solmu;
import java.util.ArrayList;
import labyrintti.tietorakenteet.Keko;
import labyrintti.tietorakenteet.Pino;

/**
 * Luokka vastaa labyrinttien muodostamisesta. 
 * 
 * 
 * @author Anu N.
 */
public class Labyrintti {
    
    private Solmu[][] labyrintti;
    private Solmu lahto;
    private Solmu maali;
    
    /**
     * Konstruktori luo pyydetyn kokoisen labyrintin ja arpoo lähtö- ja
     * maalisolmut.
     * 
     * @param koko 
     */
    public Labyrintti(int koko) {
        this.labyrintti = new Solmu[koko][koko];
        // Luodaan Solmu-oliot ja laitetaan ne testilabyrinttiin
        for (int i=0; i<labyrintti.length; i++) {
            for (int j=0; j<labyrintti.length; j++) {
                Solmu v = new Solmu(i, j);
                labyrintti[i][j] = v;
            }
        }
        // arvotaan lähtö ja maali
        arvoLahtoJaMaali();
    }
    
    /**
     * Konstruktori luo 'fiksatun' 5*5 labyrintin testaustarkoituksiin.
     * 
     *   lähtö = l
     *   maali = m
     *   este = #
     * 
     *  [ ][ ][ ][ ][ ][ ][ ]
     *  [ ][ ][#][ ][ ][ ][ ]
     *  [l][ ][#][ ][m][ ][ ]
     *  [ ][ ][#][ ][ ][ ][ ]
     *  [ ][ ][#][ ][ ][ ][ ]
     *  [ ][ ][#][ ][ ][ ][ ]
     *  [ ][ ][ ][ ][ ][ ][ ]
     * 
     */
    public Labyrintti() {
        this.labyrintti = new Solmu[7][7];
        
        // Luodaan Solmu-oliot ja laitetaan ne testilabyrinttiin
        for (int i=0; i<labyrintti.length; i++) {
            for (int j=0; j<labyrintti.length; j++) {
                Solmu v = new Solmu(i, j);
                labyrintti[i][j] = v;
            }
        }
        /*
        Solmu s = labyrintti[2][2];
        s.setEste();
        s = labyrintti[2][3];
        s.setEste();
        s = labyrintti[2][4];
        s.setEste();
        s = labyrintti[2][1];
        s.setEste();
        s = labyrintti[2][5];
        s.setEste();
      */
        // Asetetaan testilabyrintin lähtö ja maali
        this.lahto = labyrintti[0][2];
        this.maali = labyrintti[4][2];
    
    }
    
    /**
     * Metodi arpoo labyrintille lähdön ja maalin.
     * 
     * Jos lähtö ja maali ovat sama solmu tai ne ovat toistensa
     * naapureita, arpomista jatketaan.
     * 
     */
    public void arvoLahtoJaMaali() {
        
        int min = 0;
        int max = this.labyrintti.length-1;
        
        // arvotaan lähtö
        int lahtoX = min + (int)(Math.random()*(max-min));
        int lahtoY = min + (int)(Math.random()*(max-min));
        lahtoY = min + (int)(Math.random()*(max-min)); // uusi random parantamassa satunnaisuutta
        this.lahto = this.labyrintti[lahtoX][lahtoY];
       
        // arvotaan maali
        int maaliX = min + (int)(Math.random()*(max-min));
        int maaliY = min + (int)(Math.random()*(max-min)); // uusi random parantamassa satunnaisuutta
        maaliY = min + (int)(Math.random()*(max-min));
        this.maali = this.labyrintti[maaliX][maaliY];
        
        // toistetaan maalin arpomista, kunnes lähtö ja maali
        // ovat eri eivätkä ne ole toistensa naapureita.
        while (this.maali.getX() == this.lahto.getX() && this.maali.getY() == this.lahto.getY() 
            || this.getNaapurit(lahto).contains(maali)) {
             maaliX = min + (int)(Math.random()*(max-min));
             maaliY = min + (int)(Math.random()*(max-min));
             this.maali = this.labyrintti[maaliX][maaliY];
        }
              
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
        return this.labyrintti[x][y];
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
     
        // solmun s vasemmanpuoleinen naapuri
        if (okLiikkuaVasemmalle(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()-1][solmu.getY()];
            lisaaNaapuri(naapurit, naapuri);
        }
        // solmun s oikeanpuoleinen naapuri
        if (okLiikkuaOikealle(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()+1][solmu.getY()];
            lisaaNaapuri(naapurit, naapuri);
        }
        // solmun s yläpuolella oleva naapuri
        if (okLiikkuaYlos(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()][solmu.getY()-1];
            lisaaNaapuri(naapurit, naapuri);
        }
        // solmun s alapuolella oleva naapuri
        if (okLiikkuaAlas(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()][solmu.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
        // solmun s vinosti oikealla yläpuolella oleva naapuri
        if (okLiikkuaOY(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()+1][solmu.getY()-1];
            lisaaNaapuri(naapurit, naapuri);
        }
        //solmun s vinosti oikealla alapuolella oleva naapuri
        if (okLiikkuaOA(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()+1][solmu.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
        // solmun s vinosti vasemmalla alapuolella oleva naapuri
        if (okLiikkuaVA(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()-1][solmu.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
        // solmun s vinosti vasemmalla yläpuolella oleva naapuri
        if (okLiikkuaVY(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()-1][solmu.getY()-1];
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
     * Metodi palauttaa ainoastaan 'suorat' naapurit.
     * 
     * @param solmu
     * @return ArrayList<Solmu> eli ArrayList, jossa on solmun naapurit
     */
    public ArrayList<Solmu> getNaapurit2(Solmu solmu) {
        
        ArrayList<Solmu> naapurit = new ArrayList<Solmu>();
        // solmun s vasemmanpuoleinen naapuri
        if (okLiikkuaVasemmalle(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()-1][solmu.getY()];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s oikeanpuoleinen naapuri
        if (okLiikkuaOikealle(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()+1][solmu.getY()];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s yläpuolella oleva naapuri
        if (okLiikkuaYlos(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()][solmu.getY()-1];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s alapuolella oleva naapuri
        if (okLiikkuaAlas(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()][solmu.getY()+1];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s vinosti oikealla yläpuolella oleva naapuri
        if (okLiikkuaOY(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()+1][solmu.getY()-1];
            lisaaNaapuri2(naapurit, naapuri);
        }
        //solmun s vinosti oikealla alapuolella oleva naapuri
        if (okLiikkuaOA(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()+1][solmu.getY()+1];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s vinosti vasemmalla alapuolella oleva naapuri
        if (okLiikkuaVA(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()-1][solmu.getY()+1];
            lisaaNaapuri2(naapurit, naapuri);
        }
        // solmun s vinosti vasemmalla yläpuolella oleva naapuri
        if (okLiikkuaVY(solmu)) {
            Solmu naapuri = this.labyrintti[solmu.getX()-1][solmu.getY()-1];
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
    
    /**
     * Palauttaa Jump Point Search -algoritmin mukaisesti esikäsitellyt
     * naapurit solmulle s, kun liikutaan annettuun suuntaan.
     * 
     * HUOM! TÄMÄ VAATII VIELÄ PILKKOMISTA!
     * 
     * @param solmu
     * @param suunta
     * 
     * @return Keko, jossa naapurit
     */
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
    
    /**
     * Tarkistaa, onko solmun oikealla puolella estettä.
     * 
     * @param solmu
     * @return true, jos löytyi este, muuten false
     */
    public boolean esteOikealla(Solmu solmu) {
     
        if (solmu.getX() < this.labyrintti.length-1) {
            Solmu oikeanpuoleinen = this.labyrintti[solmu.getX()+1][solmu.getY()];
            if (oikeanpuoleinen.onkoEste() == true) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Tarkistaa, onko solmun vasemmalla puolella estettä. 
     * 
     * @param solmu
     * @return true, jos löytyi este, muuten false
     */
    public boolean esteVasemmalla(Solmu solmu) {
        
        if (solmu.getX() > 0) {
            Solmu vasemmanpuoleinen = this.labyrintti[solmu.getX()-1][solmu.getY()];
            if (vasemmanpuoleinen.onkoEste() == true) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Tarkistaa, onko solmun yläpuolella estettä.
     * 
     * @param solmu
     * @return true, jos löytyi este, muuten false
     */
    public boolean esteYlapuolella(Solmu solmu) {
        
        if (solmu.getY() > 0) {
            Solmu ylapuolella = this.labyrintti[solmu.getX()][solmu.getY()-1];
            if (ylapuolella.onkoEste() == true) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Tarkistaa, onko solmun alapuolella estettä.
     * 
     * @param solmu
     * @return true, jos löytyi este, muuten false 
     */
    public boolean esteAlapuolella(Solmu solmu) {
        
        if (solmu.getY() < this.labyrintti.length-1) {
            Solmu alapuolella = this.labyrintti[solmu.getX()][solmu.getY()+1];
            if (alapuolella.onkoEste() == true) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Asettaa indeksissä(x,y) olevan solmun estesolmuksi.
     * @param x
     * @param y 
     */
    public void setEste(int x, int y) {
        this.getSolmu(x, y).setEste();
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
        if (solmu.getX() < this.labyrintti.length-1) {
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
        if (solmu.getY() < this.labyrintti.length-1) {
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
        if (solmu.getX() < this.labyrintti.length-1 && solmu.getY() > 0) {
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
        if (solmu.getX() < this.labyrintti.length-1 && solmu.getY() < this.labyrintti.length-1) {
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
        if (solmu.getX() > 0 && solmu.getY() < this.labyrintti.length-1) {
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
    
    /**
     * Käy kaikki solmun naapurit läpi ja lisää ne listaan, jos niissä ei ole
     * estettä eivätkä ne mene reunojen yli.
     * 
     * @param naapurit
     * @param solmu 
     */
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
    
    /**
     * Lisää solmun vasemmanpuoleisen naapurin naapurit-kekoon, jos ei mene
     * laitojen yli.
     * 
     * @param naapurit
     * @param nykyinen 
     */
    public void lisaaVasenNaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaVasemmalle(nykyinen)) {
            Solmu naapuri = this.labyrintti[nykyinen.getX()-1][nykyinen.getY()];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    /**
     * Lisää solmun oikeanpuoleisen naapurin naapurit-kekoon, jos ei mene laitojen
     * yli.
     * 
     * @param naapurit
     * @param nykyinen 
     */
    public void lisaaOikeaNaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaOikealle(nykyinen)) {
            Solmu naapuri = this.labyrintti[nykyinen.getX()+1][nykyinen.getY()];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    /**
     * Lisää solmun yläpuolella olevan naapurin naapurit-kekoon, jos ei mene
     * laitojen yli.
     * 
     * @param naapurit
     * @param nykyinen 
     */
    public void lisaaYlapuoleinenNaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaYlos(nykyinen)) {
            Solmu naapuri = this.labyrintti[nykyinen.getX()][nykyinen.getY()-1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    /**
     * Lisää solmun alapuolella olevan naapurin naapurit-kekoon, jos ei mene
     * laitojen yli.
     * 
     * @param naapurit
     * @param nykyinen 
     */
    public void lisaaAlapuoleinenNaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaAlas(nykyinen)) {
            Solmu naapuri = this.labyrintti[nykyinen.getX()][nykyinen.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    /**
     * Lisää solmun vinosti oikealla yläpuolella olevan naapurin naapurit-kekoon,
     * jos ei mene laitojen yli.
     * 
     * @param naapurit
     * @param nykyinen 
     */
    public void lisaaOYnaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaOY(nykyinen)) {
            Solmu naapuri = this.labyrintti[nykyinen.getX()+1][nykyinen.getY()-1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    /**
     * Lisää solmun vinosti oikealla alapuolella olevan naapurin naapurit-kekoon,
     * jos ei mene laitojen yli.
     * 
     * @param naapurit
     * @param nykyinen 
     */
    public void lisaaOAnaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaOA(nykyinen)) {
            Solmu naapuri = this.labyrintti[nykyinen.getX()+1][nykyinen.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    /**
     * Lisää solmun vinosti vasemmalla alapuolella olevan naapurin naapurit-kekoon,
     * jos ei mene laitojen yli.
     * 
     * @param naapurit
     * @param nykyinen 
     */
    public void lisaaVAnaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaVA(nykyinen)) {
            Solmu naapuri = this.labyrintti[nykyinen.getX()-1][nykyinen.getY()+1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    
    /**
     * Lisää solmun vinosti vasemmalla yläpuolella olevan naapurin naapurit-kekoon,
     * jos ei mene laitojen yli.
     * 
     * @param naapurit
     * @param nykyinen 
     */
    public void lisaaVYnaapuri(Keko naapurit, Solmu nykyinen) {
        if (okLiikkuaVY(nykyinen)) {
            Solmu naapuri = this.labyrintti[nykyinen.getX()-1][nykyinen.getY()-1];
            lisaaNaapuri(naapurit, naapuri);
        }
    }
    /**
     * Palauttaa labyrintin koon.
     * 
     * @return int labyrintin koko
     */
    public int labyrintinKoko() {
        return this.labyrintti.length*this.labyrintti.length;
    }
    
    /**
     * Palauttaa labyrintin seinämän pituuden.
     * 
     * @return int labyrintin seinämän pituus
     */
    public int pituus() {
        return this.labyrintti.length;
    }
    
    /**
     * Tulostaa labyrintissa olevien solmujen koordinaatit.
     */
    public void tulostaLabyrintti() {
        for (int i=0; i<labyrintti.length; i++) {
            for (int j=0; j<labyrintti.length; j++) {
                System.out.println(labyrintti[i][j].toString());
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
        for (int j=0; j<labyrintti.length; j++) {
            for (int i=0; i<labyrintti.length; i++) {
                if (labyrintti[i][j] == maali) {
                    System.out.print("[m]");
                } else if (labyrintti[i][j] == lahto) {
                    System.out.print("[l]");
                } else if (labyrintti[i][j].onkoEste() == true) {
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
     * Visualisoi labyrintin eli tulostaa matriisin, jossa näkyvät lähtö- ja
     * maalisolmu sekä esteet.
     */
    public void visualisoiKuljettuPolku(Pino polku) {
        System.out.println("LABYRINTTI: \n");
        System.out.println("lähtö = l");
        System.out.println("maali = m");
        System.out.println("este = #");
        System.out.println(" ");
        for (int j=0; j<labyrintti.length; j++) {
            for (int i=0; i<labyrintti.length; i++) {
                if (labyrintti[i][j] == maali) {
                    System.out.print("[m]");
                } else if (labyrintti[i][j] == lahto) {
                    System.out.print("[l]");
                } else if (polku.contains(this.getSolmu(i, j))) {
                    System.out.print("[p]");
                } else if ((getSolmu(i,j).isVisited() == true) ) {
                    System.out.print("[v]");
                } else if (labyrintti[i][j].onkoEste() == true) {
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
