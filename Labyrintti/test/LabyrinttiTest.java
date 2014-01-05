
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
    
    @Test
    public void getNaapuritPalauttaaSolmunNaapurit() {
        Solmu solmu = this.testilabyrintti.getSolmu(1, 1);
        Keko naapurit = this.testilabyrintti.getNaapurit(solmu);
        String naapuri1 = naapurit.poistaPienin().toString();
        String naapuri2 = naapurit.poistaPienin().toString();
        String naapuri3 = naapurit.poistaPienin().toString();
        String kaikkiNaapurit = ""+naapuri1+" "+naapuri2+" "+naapuri3;
        assertEquals("x: 0, y: 1 x: 1, y: 2 x: 1, y: 0", kaikkiNaapurit);
    }
    
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
    
    
}
