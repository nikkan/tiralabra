
import labyrintti.tietorakenteet.Keko;
import labyrintti.tietorakenteet.Solmu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anu N.
 */
public class KekoTest {
    
    Keko keko;
    Solmu solmu1, solmu2, solmu3;
    
   
    public KekoTest() {
    }
   
    @Before
    public void setUp() {
        this.keko = new Keko(3);
        this.solmu1 = new Solmu(1,2);
        this.solmu1.setKokonaisKustannus(8);
        this.solmu2 = new Solmu(3,9);
        this.solmu2.setKokonaisKustannus(1);
        this.solmu3 = new Solmu(8,1);
        this.solmu3.setKokonaisKustannus(5);
    }
    
    @Test
    public void konstruktoriAsettaaKeonOikeinAlkutilaan() {
        int koko = this.keko.getKoko();
        int pituus = this.keko.getPituus();
        String vastaus = ""+koko+", "+pituus;
        assertEquals("3, 0", vastaus);
    }
    
    @Test
    public void heapInsertToimiiOikeinYhdellaAlkiolla() {
        this.keko.heapInsert(solmu1);
        String solmu = this.keko.palautaAlkioIndeksissa(0).toString();
        assertEquals("x: 1, y: 2", solmu);
    }
    
    @Test
    public void metodiVanhempiPalauttaaOikeinSolmunVanhemmanIndeksin1() {
        this.keko.heapInsert(solmu1);
        this.keko.heapInsert(solmu2);
        this.keko.heapInsert(solmu3);
        String vanhempi = ""+this.keko.vanhempi(2);
        assertEquals("0", vanhempi);
    }
    
    @Test
    public void metodiVanhempiPalauttaaOikeinSolmunVanhemmanIndeksin2() {
        this.keko.heapInsert(solmu1);
        this.keko.heapInsert(solmu2);
        this.keko.heapInsert(solmu3);
        String vanhempi = ""+this.keko.vanhempi(1);
        assertEquals("0", vanhempi);
    }
    
    @Test
    public void metodiVasenPalauttaaSolmunVasemmanLapsenIndeksin() {
        this.keko.heapInsert(solmu1);
        this.keko.heapInsert(solmu2);
        this.keko.heapInsert(solmu3);
        String vasen = ""+this.keko.vasen(0);
        assertEquals("1", vasen);
    }
    
    @Test 
    public void metodiOikeaPalauttaaSolmunOikeanLapsenIndeksin() {
        this.keko.heapInsert(solmu1);
        this.keko.heapInsert(solmu2);
        this.keko.heapInsert(solmu3);
        String oikea = ""+this.keko.oikea(0);
        assertEquals("2", oikea);
    }
    
    @Test
    public void heapDelMinToimiiOikeinKolmelleTestialkiolle1() {
        this.keko.heapInsert(solmu1);
        this.keko.heapInsert(solmu2);
        this.keko.heapInsert(solmu3);
        String pienin = this.keko.heapDelMin().toString();
        assertEquals("x: 3, y: 9", pienin);
    }
    
    @Test
    public void heapDelMinToimiioikeinKolmelleTestialkiolle2() {
        this.keko.heapInsert(solmu1);
        this.keko.heapInsert(solmu2);
        this.keko.heapInsert(solmu3);
        this.keko.heapDelMin();
        String pienin = this.keko.heapDelMin().toString();
        assertEquals("x: 8, y: 1", pienin);   
    }
    
    @Test
    public void heapDelMinToimiioikeinKolmelleTestialkiolle3() {
        this.keko.heapInsert(solmu1);
        this.keko.heapInsert(solmu2);
        this.keko.heapInsert(solmu3);
        this.keko.heapDelMin();
        this.keko.heapDelMin();
        String pienin = this.keko.heapDelMin().toString();
        assertEquals("x: 1, y: 2", pienin);  
    }
    
    
    
  
}
