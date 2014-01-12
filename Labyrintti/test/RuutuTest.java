
import labyrintti.sovellus.Labyrintti;
import labyrintti.sovellus.Ruutu;
import labyrintti.tietorakenteet.Solmu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Testiluokka vastaa Ruutu-olion metodien testauksesta.
 * 
 * @author Anu N.
 */
public class RuutuTest {
    
    private Ruutu ruutu; 
    private Labyrintti labyrintti;
    
    public RuutuTest() {
    }
    
    @Before
    public void setUp() {
        this.labyrintti = new Labyrintti();
        this.ruutu = new Ruutu(3, 1, false, false, false, false, false, labyrintti);
    }
    
    @Test
    public void getXKoordPalauttaaXkoordinaatin() {
        String x = ""+this.ruutu.getXKoord();
        assertEquals("3", x);
    }
    
    @Test
    public void getYKoordPalauttaaYkoordinaatin() {
        String y = ""+this.ruutu.getYKoord();
        assertEquals("1", y);
    }
    
    @Test
    public void asetaEsteAsettaaSolmunEsteeksi() {
        this.ruutu.asetaEste();
        Solmu s = labyrintti.getSolmu(3, 1);
        String este = ""+s.onkoEste();
        assertEquals("true", este);
    }
}
