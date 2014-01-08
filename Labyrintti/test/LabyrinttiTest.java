
import java.util.ArrayList;
import labyrintti.Labyrintti;
import labyrintti.tietorakenteet.Keko;
import labyrintti.tietorakenteet.Solmu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tämä testiluokka vastaa Labyrintti-luokan testauksesta. 
 * 
 * Testejä pitää vielä muuttaa, kun saan Labyrintti-luokan järkevämmäksi eli
 * generoimaan suurempia labyrintteja 'automaattisesti'.
 * 
 * @author Anu N.
 */
public class LabyrinttiTest {
    
    Labyrintti testilabyrintti;
    
    public LabyrinttiTest() {
    }
    
  
    @Before
    public void setUp() {
        this.testilabyrintti = new Labyrintti();
    }
    
    @Test
    public void getSolmuPalauttaaSolmunKysytyssaKoordinaatissa() {
        String solmu = this.testilabyrintti.getSolmu(4, 2).toString();
        assertEquals("x: 4, y: 2", solmu);
    }
    
    @Test
    public void getLahtoPalauttaaLahtoSolmun() {
        String lahtoSolmu = this.testilabyrintti.getLahto().toString();
        assertEquals("x: 0, y: 1", lahtoSolmu);
    }
    
    @Test
    public void getMaaliPalauttaaMaaliSolmun() {
        String maaliSolmu = this.testilabyrintti.getMaali().toString();
        assertEquals("x: 3, y: 0", maaliSolmu);
    }
    
   /* @Test
    public void getNaapuritPalauttaaSolmunNaapurit() {
        Solmu solmu = this.testilabyrintti.getSolmu(1, 1);
        Keko naapurit = this.testilabyrintti.getNaapurit(solmu);
        String naapuri1 = naapurit.poistaPienin().toString();
        String naapuri2 = naapurit.poistaPienin().toString();
        String naapuri3 = naapurit.poistaPienin().toString();
        String kaikkiNaapurit = ""+naapuri1+" "+naapuri2+" "+naapuri3;
        assertEquals("x: 0, y: 1 x: 1, y: 2 x: 1, y: 0", kaikkiNaapurit);
    }*/
    
    @Test
    public void getNaapurit2PalauttaaSolmunNaapurit() {
        Solmu solmu = this.testilabyrintti.getSolmu(1, 1);
        ArrayList<Solmu> naapurit = this.testilabyrintti.getNaapurit2(solmu);
        String naapuri1 = naapurit.get(0).toString();
        String naapuri2 = naapurit.get(1).toString();
        String naapuri3 = naapurit.get(2).toString();
        String kaikkiNaapurit = ""+naapuri1+" "+naapuri2+" "+naapuri3;
        assertEquals("x: 0, y: 1 x: 1, y: 0 x: 1, y: 2", kaikkiNaapurit);
    }
    
    @Test
    public void etaisyysValillaPalauttaaSolmujenValisenEtaisyyden() {
        Solmu solmu1 = this.testilabyrintti.getSolmu(0, 0);
        Solmu solmu2 = this.testilabyrintti.getSolmu(1, 1);
        String etaisyysYksi = ""+this.testilabyrintti.etaisyysValilla(solmu1, solmu2);
        assertEquals("1", etaisyysYksi);
    }
    
    @Test
    public void esteVasemmallaPalauttaaTrueJosOnEste() {
        Solmu solmu1 = this.testilabyrintti.getSolmu(4, 1);
        String este = ""+this.testilabyrintti.esteVasemmalla(solmu1);
        assertEquals("true", este);
    }
    
    @Test
    public void esteVasemmallaPalauttaaFalseJosEiEstetta() {
        Solmu solmu1 = this.testilabyrintti.getSolmu(2, 3);
        String este = ""+this.testilabyrintti.esteVasemmalla(solmu1);
        assertEquals("false", este);
    }
    
    @Test
    public void esteOikeallaPalauttaaTrueJosOnEste() {
        Solmu solmu1 = this.testilabyrintti.getSolmu(1, 2);
        String este = ""+this.testilabyrintti.esteOikealla(solmu1);
        assertEquals("true", este);
    }
    
    @Test
    public void esteOikeallaPalauttaaFalseJosEiOleEstetta() {
        Solmu solmu1 = this.testilabyrintti.getSolmu(1, 3);
        String este = ""+this.testilabyrintti.esteOikealla(solmu1);
        assertEquals("false", este);
    }
    
    @Test
    public void esteYlapuolellaPalauttaaTrueJosOnEste() {
        Solmu solmu1 = this.testilabyrintti.getSolmu(2, 3);
        String este = ""+this.testilabyrintti.esteYlapuolella(solmu1);
        assertEquals("true", este);
    }
    
    @Test
    public void esteYlapuolellaPalautaaFalseJosEiOleEstetta() {
        Solmu solmu1 = this.testilabyrintti.getSolmu(1, 3);
        String este = ""+this.testilabyrintti.esteYlapuolella(solmu1);
        assertEquals("false", este);
    }
    
    @Test
    public void esteAlapuolellaPalauttaaTrueJosOnEste() {
        Solmu solmu1 = this.testilabyrintti.getSolmu(3, 0);
        String este = ""+this.testilabyrintti.esteAlapuolella(solmu1);
        assertEquals("true", este);
    }
    
    @Test
    public void esteAlapuolellaPalauttaaFalseJosEiOleEstetta() {
        Solmu solmu1 = this.testilabyrintti.getSolmu(1, 3);
        String este = ""+this.testilabyrintti.esteAlapuolella(solmu1);
        assertEquals("false", este);
    }
    
    /*@Test
    public void suuntaPalauttaaOikeinNollasuunnan() {
        Solmu solmu1 = new Solmu(1,2);
        Solmu solmu2 = new Solmu(1,2);
        String nolla = this.testilabyrintti.suunta(solmu2, solmu1);
        assertEquals("t", nolla);
    }
    
    @Test
    public void suuntaPalauttaaOikeinOikealle() {
        Solmu solmu1 = new Solmu(1,2);
        Solmu solmu2 = new Solmu(2,2);
        String oikealle = this.testilabyrintti.suunta(solmu2, solmu1);
        assertEquals("o", oikealle);
    }
    
    @Test
    public void suuntaPalauttaaOikeinVasemmalle() {
        Solmu solmu1 = new Solmu(2,2);
        Solmu solmu2 = new Solmu(1,2);
        String vasemmalle = this.testilabyrintti.suunta(solmu2, solmu1);
        assertEquals("v", vasemmalle);
    }
    
    @Test
    public void suuntaPalauttaaOikeinYlos() {
        Solmu solmu1 = new Solmu(1,0);
        Solmu solmu2 = new Solmu(1,1);
        String ylos = this.testilabyrintti.suunta(solmu2, solmu1);
        assertEquals("y", ylos);
    }
    
    @Test
    public void suuntaPalauttaaOikeinAlas() {
        Solmu solmu1 = new Solmu(1,1);
        Solmu solmu2 = new Solmu(1,0);
        String alas = this.testilabyrintti.suunta(solmu2, solmu1);
        assertEquals("a", alas);
    }
    
    @Test
    public void suuntaPalauttaaOikeinOY() {
        Solmu solmu1 = new Solmu(0,3);
        Solmu solmu2 = new Solmu(1,2);
        String oy = this.testilabyrintti.suunta(solmu2, solmu1);
        assertEquals("oy", oy);
    }
    
    @Test
    public void suuntaPalauttaaOikeinVA() {
        Solmu solmu1 = new Solmu(1,2);
        Solmu solmu2 = new Solmu(0,3);
        String va = this.testilabyrintti.suunta(solmu2, solmu1);
        assertEquals("va", va);
    }
    
    @Test
    public void suuntaPalauttaaoikeinOA() {
        Solmu solmu1 = new Solmu(0,1);
        Solmu solmu2 = new Solmu(1,2);
        String oa = this.testilabyrintti.suunta(solmu2, solmu1);
        assertEquals("oa", oa);
    }
    
    @Test
    public void suuntaPalauttaaOikeinVY() {
        Solmu solmu1 = new Solmu(1,1);
        Solmu solmu2 = new Solmu(0,0);
        String vy = this.testilabyrintti.suunta(solmu2, solmu1);
        assertEquals("vy", vy);
    }*/
    
    
    
    
}
