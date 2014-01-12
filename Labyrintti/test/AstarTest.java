
import labyrintti.sovellus.Labyrintti;
import labyrintti.algot.Astar;
import labyrintti.tietorakenteet.Pino;
import labyrintti.tietorakenteet.Solmu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Luokka vastaa Astar-luokan testaamisesta. 
 * 
 * @author Anu N.
 */
public class AstarTest {
    
    Labyrintti labyrintti;
    Astar astar;
    Solmu lahto, maali;
    
    public AstarTest() {
    }
    
    @Before
    public void setUp() {
        this.labyrintti = new Labyrintti();
        this.lahto = labyrintti.getLahto();
        this.maali = labyrintti.getMaali();
        this.astar = new Astar(labyrintti, lahto, maali);
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
    public void searchOmallaKeollaLoytaaLyhimmanReitin() {
        
        this.astar.searchOmallaKeolla();
        Pino polku = this.astar.getPolku();
        
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
    public void searchJavanPriorityQueuellaLoytaaLyhimmanReitin() {
        
        this.astar.searchJavanPriorityQueuella();
        Pino polku = this.astar.getPolku();

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
    
    
  
}
