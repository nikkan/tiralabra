
import labyrintti.Labyrintti;
import labyrintti.algot.Astar2;
import labyrintti.tietorakenteet.Pino;
import labyrintti.tietorakenteet.Solmu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Luokka vastaa Astar2-luokan testaamisesta. 
 * 
 * @author Anu N.
 */
public class Astar2Test {
    
    Labyrintti labyrintti;
    Astar2 astar2;
    Solmu lahto, maali;
    
    public Astar2Test() {
    }
    
    @Before
    public void setUp() {
        this.labyrintti = new Labyrintti();
        this.lahto = labyrintti.getLahto();
        this.maali = labyrintti.getMaali();
        this.astar2 = new Astar2(labyrintti, lahto, maali);
    }
    
    // MUUTTUNUT, KOSKA LISÄTTY DIAGONAALISET NAAPURIT! KORJAA!
    /*@Test
    public void searchOmallaKeollaLoytaaLyhimmanReitin() {
        
        this.astar2.searchOmallaKeolla();
        Pino polku = this.astar2.getPolku();
        polku.pop();
        String solmu1 = polku.pop().toString();
        String solmu2 = polku.pop().toString();
        String solmu3 = polku.pop().toString();
        String solmu4 = polku.pop().toString();
        String solmu5 = polku.pop().toString();
        String solmu6 = polku.pop().toString();
        String solmu7 = polku.pop().toString();
        String solmu8 = polku.pop().toString();
        String solmu9 = polku.pop().toString();

        String lyhinPolku = solmu1+"; "+solmu2+"; "+solmu3+"; "+solmu4
                +"; "+solmu5+"; "+solmu6+"; "+solmu7+"; "+solmu8+"; "+solmu9;
        
        assertEquals("x: 1, y: 2; x: 1, y: 3; x: 2, y: 3; x: 3, y: 3; x: 3, y: 2; x: 4, y: 2; "
                + "x: 4, y: 1; x: 4, y: 0; x: 3, y: 0", lyhinPolku);
        
    }
    */
    @Test
    public void searchJavanPriorityQueuellaLoytaaLyhimmanReitin() {
        
        this.astar2.searchJavanPriorityQueuella();
        Pino polku = this.astar2.getPolku();
        polku.pop();
        String solmu1 = polku.pop().toString();
        String solmu2 = polku.pop().toString();
        String solmu3 = polku.pop().toString();
        String solmu4 = polku.pop().toString();
        String solmu5 = polku.pop().toString();
        String solmu6 = polku.pop().toString();
        String solmu7 = polku.pop().toString();
        String solmu8 = polku.pop().toString();
        String solmu9 = polku.pop().toString();

        String lyhinPolku = solmu1+"; "+solmu2+"; "+solmu3+"; "+solmu4
                +"; "+solmu5+"; "+solmu6+"; "+solmu7+"; "+solmu8+"; "+solmu9;
       
        assertEquals("x: 1, y: 2; x: 1, y: 3; x: 2, y: 3; x: 3, y: 3; x: 3, y: 2; x: 4, y: 2; "
                + "x: 4, y: 1; x: 4, y: 0; x: 3, y: 0", lyhinPolku);
        
    }
  
}
