
import labyrintti.algot.AstarJaJPS;
import labyrintti.sovellus.Labyrintti;
import labyrintti.tietorakenteet.Pino;
import labyrintti.tietorakenteet.Solmu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Luokka vastaa AstarJaJPS -luokan testaamisesta.
 * 
 * @author Anu N.
 */
public class AstarJaJPSTest {
    Labyrintti labyrintti;
    AstarJaJPS astarJPS;
    Solmu lahto, maali;
    
    @Before
    public void setUp() {
        this.labyrintti = new Labyrintti();
        this.lahto = labyrintti.getLahto();
        this.maali = labyrintti.getMaali();
        this.astarJPS = new AstarJaJPS(labyrintti, lahto, maali);
    }
   
    @Test
    public void rekonstruoiPolkuToimiiOikein() {
        Solmu solmu1 = this.labyrintti.getSolmu(3, 1);
        Solmu solmu2 = this.labyrintti.getSolmu(4, 1);
        Solmu solmu3 = this.labyrintti.getSolmu(5, 3);
        
        maali.setEdellinen(solmu3);
        solmu3.setEdellinen(solmu2);
        solmu2.setEdellinen(solmu1);
        solmu1.setEdellinen(lahto);
        
        String polku = lahto+"; "+solmu1+"; "+solmu2+"; "+solmu3+"; "+maali;
        assertEquals("x: 0, y: 2; x: 3, y: 1; x: 4, y: 1; x: 5, y: 3; x: 4, y: 2", 
                polku);
    }
    
    @Test
    public void getPolkuPalauttaaPolun() {
        Solmu solmu1 = this.labyrintti.getSolmu(3, 1);
        Solmu solmu2 = this.labyrintti.getSolmu(4, 1);
        Solmu solmu3 = this.labyrintti.getSolmu(5, 3);
        
        maali.setEdellinen(solmu3);
        solmu3.setEdellinen(solmu2);
        solmu2.setEdellinen(solmu1);
        solmu1.setEdellinen(lahto);
        
        String polku = lahto+"; "+solmu1+"; "+solmu2+"; "+solmu3+"; "+maali;
        assertEquals("x: 0, y: 2; x: 3, y: 1; x: 4, y: 1; x: 5, y: 3; x: 4, y: 2", 
                polku);
    }
    
    @Test
    public void searchOmallaKeollaJaJumpPointillaLoytaaLyhimmanReitin() {
        
        this.astarJPS.searchOmallaKeollaJaJumpPointilla();
        Pino polku = this.astarJPS.getPolku();
        
        String solmu1 = polku.pop().toString();
        String solmu2 = polku.pop().toString();
        String solmu3 = polku.pop().toString();
        String solmu4 = polku.pop().toString();
        String solmu5 = polku.pop().toString();

        String lyhinPolku = solmu1+"; "+solmu2+"; "+solmu3+"; "+solmu4
                +"; "+solmu5;
        
        assertEquals("x: 0, y: 2; x: 1, y: 1; x: 2, y: 0; x: 3, y: 1; x: 4, y: 2", 
                lyhinPolku);
        
    }
   
    @Test
    public void suuntaPalauttaaOikeinNollasuunnan() {
        Solmu solmu1 = new Solmu(1,2);
        Solmu solmu2 = new Solmu(1,2);
        String nolla = this.astarJPS.suunta(solmu2, solmu1);
        assertEquals("t", nolla);
    }
    
    @Test
    public void suuntaPalauttaaOikeinOikealle() {
        Solmu solmu1 = new Solmu(1,2);
        Solmu solmu2 = new Solmu(2,2);
        String oikealle = this.astarJPS.suunta(solmu2, solmu1);
        assertEquals("o", oikealle);
    }
    
    @Test
    public void suuntaPalauttaaOikeinVasemmalle() {
        Solmu solmu1 = new Solmu(2,2);
        Solmu solmu2 = new Solmu(1,2);
        String vasemmalle = this.astarJPS.suunta(solmu2, solmu1);
        assertEquals("v", vasemmalle);
    }
    
    @Test
    public void suuntaPalauttaaOikeinAlas() {
        Solmu solmu1 = new Solmu(1,0);
        Solmu solmu2 = new Solmu(1,1);
        String alas = this.astarJPS.suunta(solmu2, solmu1);
        assertEquals("a", alas);
    }
    
    @Test
    public void suuntaPalauttaaOikeinYlos() {
        Solmu solmu1 = new Solmu(1,1);
        Solmu solmu2 = new Solmu(1,0);
        String ylos = this.astarJPS.suunta(solmu2, solmu1);
        assertEquals("y", ylos);
    }
    
    @Test
    public void suuntaPalauttaaOikeinOY() {
        Solmu solmu1 = new Solmu(0,3);
        Solmu solmu2 = new Solmu(1,2);
        String oy = this.astarJPS.suunta(solmu2, solmu1);
        assertEquals("oy", oy);
    }
    
    @Test
    public void suuntaPalauttaaOikeinVA() {
        Solmu solmu1 = new Solmu(1,2);
        Solmu solmu2 = new Solmu(0,3);
        String va = this.astarJPS.suunta(solmu2, solmu1);
        assertEquals("va", va);
    }
    
    @Test
    public void suuntaPalauttaaoikeinOA() {
        Solmu solmu1 = new Solmu(0,1);
        Solmu solmu2 = new Solmu(1,2);
        String oa = this.astarJPS.suunta(solmu2, solmu1);
        assertEquals("oa", oa);
    }
    
    @Test
    public void suuntaPalauttaaOikeinVY() {
        Solmu solmu1 = new Solmu(1,1);
        Solmu solmu2 = new Solmu(0,0);
        String vy = this.astarJPS.suunta(solmu2, solmu1);
        assertEquals("vy", vy);
    }
    
    @Test
    public void stepAskeltaaOikeinOikealle() {
        Solmu solmu1 = new Solmu(0,0);
        Solmu solmu2 = new Solmu(0,1);
        this.astarJPS.step(solmu1, "o");
        String solmu = solmu2.toString();
        assertEquals("x: 0, y: 1", solmu);
    }
    
    @Test
    public void stepAskeltaaOikeinVasemmalle() {
        Solmu solmu1 = new Solmu(0,1);
        Solmu solmu2 = new Solmu(0,0);
        this.astarJPS.step(solmu1, "v");
        String solmu = solmu2.toString();
        assertEquals("x: 0, y: 0", solmu);
    }
    
    @Test
    public void stepAskeltaaOikeinYlos() {
        Solmu solmu1 = new Solmu(1,1);
        Solmu solmu2 = new Solmu(1,0);
        this.astarJPS.step(solmu1, "y");
        String solmu = solmu2.toString();
        assertEquals("x: 1, y: 0", solmu);
    }
    
    @Test
    public void stepAskeltaaOikeinAlas() {
        Solmu solmu1 = new Solmu(1,1);
        Solmu solmu2 = new Solmu(1,2);
        this.astarJPS.step(solmu1, "y");
        String solmu = solmu2.toString();
        assertEquals("x: 1, y: 2", solmu);
    }
    
    @Test
    public void stepAskeltaaOikeinOY() {
        Solmu solmu1 = new Solmu(1,1);
        Solmu solmu2 = new Solmu(0,2);
        this.astarJPS.step(solmu1, "y");
        String solmu = solmu2.toString();
        assertEquals("x: 0, y: 2", solmu);
    }
    
    @Test
    public void stepAskeltaaOikeinOA() {
        Solmu solmu1 = new Solmu(0,0);
        Solmu solmu2 = new Solmu(1,1);
        this.astarJPS.step(solmu1, "y");
        String solmu = solmu2.toString();
        assertEquals("x: 1, y: 1", solmu);
    }
    
    @Test
     public void stepAskeltaaOikeinVY() {
        Solmu solmu1 = new Solmu(1,1);
        Solmu solmu2 = new Solmu(0,0);
        this.astarJPS.step(solmu1, "y");
        String solmu = solmu2.toString();
        assertEquals("x: 0, y: 0", solmu);
    }
    
    @Test
    public void stepAskeltaaOikeinVA() {
        Solmu solmu1 = new Solmu(0,2);
        Solmu solmu2 = new Solmu(1,1);
        this.astarJPS.step(solmu1, "y");
        String solmu = solmu2.toString();
        assertEquals("x: 1, y: 1", solmu);
    }
    
    
    
}
