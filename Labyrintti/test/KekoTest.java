
import labyrintti.tietorakenteet.Keko;
import labyrintti.tietorakenteet.Solmu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testiluokka vastaa Keko-luokan testaamisesta
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
    public void lisaaKekoonToimiiOikeinKolmellaAlkiolla() {
        this.keko.lisaaKekoon(solmu1);
        this.keko.lisaaKekoon(solmu2);
        this.keko.lisaaKekoon(solmu3);
        String solmu = this.keko.palautaAlkioIndeksissa(0).toString()+"; "+
                this.keko.palautaAlkioIndeksissa(1)+"; "+this.keko.palautaAlkioIndeksissa(2);
        assertEquals("x: 3, y: 9; x: 1, y: 2; x: 8, y: 1", solmu);
    }
    
    @Test
    public void metodiVanhempiPalauttaaOikeinSolmunVanhemmanIndeksin1() {
        this.keko.lisaaKekoon(solmu1);
        this.keko.lisaaKekoon(solmu2);
        this.keko.lisaaKekoon(solmu3);
        String vanhempi = ""+this.keko.vanhempi(2);
        assertEquals("0", vanhempi);
    }
    
    @Test
    public void metodiVanhempiPalauttaaOikeinSolmunVanhemmanIndeksin2() {
        this.keko.lisaaKekoon(solmu1);
        this.keko.lisaaKekoon(solmu2);
        this.keko.lisaaKekoon(solmu3);
        String vanhempi = ""+this.keko.vanhempi(1);
        assertEquals("0", vanhempi);
    }
    
    @Test
    public void metodiVasenPalauttaaSolmunVasemmanLapsenIndeksin() {
        this.keko.lisaaKekoon(solmu1);
        this.keko.lisaaKekoon(solmu2);
        this.keko.lisaaKekoon(solmu3);
        String vasen = ""+this.keko.vasen(0);
        assertEquals("1", vasen);
    }
    
    @Test 
    public void metodiOikeaPalauttaaSolmunOikeanLapsenIndeksin() {
        this.keko.lisaaKekoon(solmu1);
        this.keko.lisaaKekoon(solmu2);
        this.keko.lisaaKekoon(solmu3);
        String oikea = ""+this.keko.oikea(0);
        assertEquals("2", oikea);
    }
    
    @Test
    public void poistaPieninToimiiOikeinKolmelleTestialkiolle1() {
        this.keko.lisaaKekoon(solmu1);
        this.keko.lisaaKekoon(solmu2);
        this.keko.lisaaKekoon(solmu3);
        String pienin = this.keko.poistaPienin().toString();
        assertEquals("x: 3, y: 9", pienin);
    }
    
    @Test
    public void poistaPieninToimiioikeinKolmelleTestialkiolle2() {
        this.keko.lisaaKekoon(solmu1);
        this.keko.lisaaKekoon(solmu2);
        this.keko.lisaaKekoon(solmu3);
        this.keko.poistaPienin();
        String pienin = this.keko.poistaPienin().toString();
        assertEquals("x: 8, y: 1", pienin);   
    }
    
    @Test
    public void poistaPieninToimiioikeinKolmelleTestialkiolle3() {
        this.keko.lisaaKekoon(solmu1);
        this.keko.lisaaKekoon(solmu2);
        this.keko.lisaaKekoon(solmu3);
        this.keko.poistaPienin();
        this.keko.poistaPienin();
        String pienin = this.keko.poistaPienin().toString();
        assertEquals("x: 1, y: 2", pienin);  
    }
    
    @Test
    public void isEmptyKertooJosKekoOnTyhja() {
        String tyhja = ""+this.keko.isEmpty();
        assertEquals("true", tyhja);
    }
    
    @Test
    public void isEmptyKertooJosKekoEiOleTyhja() {
        this.keko.lisaaKekoon(solmu1);
        String tyhja = ""+this.keko.isEmpty();
        assertEquals("false", tyhja);
    }
    
    @Test
    public void containsKertooJosKysyttyAlkioOnKeossa() {
        this.keko.lisaaKekoon(solmu1);
        this.keko.lisaaKekoon(solmu2);
        this.keko.lisaaKekoon(solmu3);
        String onKeossa = ""+this.keko.contains(solmu2);
        assertEquals("true", onKeossa);
    }
    
    @Test
    public void containsKertooJosKysyttyAlkioEiOleKeossa() {
        Solmu s = new Solmu(11,12);
        this.keko.lisaaKekoon(solmu1);
        this.keko.lisaaKekoon(solmu2);
        String eiOleKeossa = ""+this.keko.contains(s);
        assertEquals("false", eiOleKeossa);
    }
    
    
    
    
  
}
