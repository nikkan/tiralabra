
import labyrintti.sovellus.Labyrintti;
import labyrintti.tietorakenteet.Solmu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testiluokka vastaa Solmu-luokan testauksesta. 
 * 
 * @author Anu N.
 */
public class SolmuTest {
    
    Solmu solmu;
    Labyrintti labyrintti;
    
    
    public SolmuTest() {
    }
    
    @Before
    public void setUp() {
        this.solmu = new Solmu(1,3);
    }
    
    @Test
    public void setMatkaAlkuunAsettaaMatkanLahtoSolmuunOikein() {
        this.solmu.setMatkaAlkuun(3);
        String matkaAlkuun = ""+this.solmu.getMatkaAlkuun();
        assertEquals("3", matkaAlkuun);
    }
            
    @Test
    public void setKokonaisKustannusArvioiEtaisyydenMaaliinOikein() {
        this.solmu.setMatkaAlkuun(3);
        Solmu maali = new Solmu(0,3);
        this.solmu.setKokonaisKustannus(maali);
        String kokonaisKustannus = ""+this.solmu.getKokonaisKustannus();
        assertEquals("4", kokonaisKustannus);
    }
    
    @Test
    public void setKokonaiskustannusKokonaisluvullaToimiiOikein() {
        this.solmu.setMatkaAlkuun(3);
        this.solmu.setKokonaisKustannus(4);
        String kokonaisKustannus = ""+this.solmu.getKokonaisKustannus();
        assertEquals("4", kokonaisKustannus);
    }
    
    @Test
    public void setEdellinenToimiiOikein() {
        Solmu s = new Solmu(1,2);
        this.solmu.setEdellinen(s);
        String edellinen = this.solmu.getEdellinen().toString();
        assertEquals("x: 1, y: 2", edellinen);
    }
    
    @Test
    public void getXpalauttaaOikeanXkoordinaatin() {
        int x = this.solmu.getX();
        String xKoordinaatti = ""+x;
        assertEquals("1", xKoordinaatti);
    }
    
    @Test
    public void getYpalauttaaOikeanYkoordinaatin() {
        int y = this.solmu.getY();
        String yKoordinaatti = ""+y;
        assertEquals("3", yKoordinaatti);
    }
    
    @Test
    public void compareToToimiiOikein() {
        Solmu toinen = new Solmu(6,7);
        toinen.setKokonaisKustannus(9);
        this.solmu.setKokonaisKustannus(2);
        int vertaa = this.solmu.compareTo(toinen);
        String vastaus = ""+vertaa;
        assertEquals("-1", vastaus);
        
    }
            
  
}
