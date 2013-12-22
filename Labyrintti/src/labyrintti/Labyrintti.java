
package labyrintti;
import labyrintti.algot.Astar;

/**
 *
 * @author Anu N.
 */
public class Labyrintti {

    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String[] args) {
        
        Solmu[][] testilabyrintti = new Solmu[5][5];
        
        for (int i = 0; i < testilabyrintti.length; i++) {
            for (int j = 0; j < testilabyrintti.length; j++) {
                Solmu v = new Solmu(i, j); 
                testilabyrintti[i][j] = v;
            }
        } 
       
        
        Astar astar = new Astar(testilabyrintti, testilabyrintti[0][0], testilabyrintti[0][3]); 
        
}
}
