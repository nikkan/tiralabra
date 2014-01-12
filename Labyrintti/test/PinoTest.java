
import labyrintti.tietorakenteet.Pino;
import labyrintti.tietorakenteet.Solmu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testiluokka vastaa Pino-luokan testaamisesta
 * 
 * @author Anu N.
 */
public class PinoTest {
    
    Pino  pino;
    Solmu solmu1;
    Solmu solmu2;
    Solmu solmu3;
    
    public PinoTest() {
    }
    
    @Before
    public void setUp() {
        this.pino = new Pino(3);
        this.solmu1 = new Solmu(1,5);
        this.solmu2 = new Solmu(5,2);
        this.solmu3 = new Solmu(8,10);
    }
    
    @Test
    public void pushJaPopToimivatOikeinYhdellaAlkiolla() {
        this.pino.push(solmu1);
        String otetaanPinosta = this.pino.pop().toString();
        assertEquals("x: 1, y: 5", otetaanPinosta);   
    }
    
    @Test
    public void pushJaPopToimivatOikeinUseammallaAlkiolla() {
        this.pino.push(solmu2);
        this.pino.push(solmu3);
        this.pino.push(solmu1);
        this.pino.pop();
        this.pino.pop();
        String alinSolmu = this.pino.pop().toString();
        assertEquals("x: 5, y: 2", alinSolmu);
    }
    
    @Test
    public void pushKaksinkertaistaaPinonKoonJosPinoTaysi() {
        this.pino.push(solmu1);
        this.pino.push(solmu2);
        this.pino.push(solmu3);
        Solmu solmu4 = new Solmu(2,6);
        this.pino.push(solmu4);
        String pituusJaTop = ""+this.pino.pinonPituus()+", "+this.pino.getTop();
        assertEquals("6, 3", pituusJaTop);
    }
    
    @Test
    public void metodiEmptyKertooJosPinoOnTyhja() {
        String tyhja = ""+this.pino.empty();
        assertEquals("true", tyhja);
    }
    
    @Test
    public void metodiEmptyKertooJosPinoEiOleTyhja() {
        this.pino.push(solmu1);
        String tyhja = ""+this.pino.empty();
        assertEquals("false", tyhja);
    }
    
    @Test
    public void metodiFullKertooJosPinoOnTaysi() {
        this.pino.push(solmu1);
        this.pino.push(solmu2);
        this.pino.push(solmu3);
        String taysi = ""+this.pino.full();
        assertEquals("true", taysi);
    } 
    
    @Test
    public void metodiFullKertooJosPinoEiOleTaysi() {
        this.pino.push(solmu1);
        String taysi = ""+this.pino.full();
        assertEquals("false", taysi);
    }
             
 }
