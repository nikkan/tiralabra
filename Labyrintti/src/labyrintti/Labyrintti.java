
package labyrintti;
import labyrintti.algot.Astar;
import labyrintti.algot.Keko;

/**
 *
 * @author Anu N.
 */
public class Labyrintti {

  
    public static void main(String[] args) {
        
        // testilabyrintin rakentamista
        /*Solmu[][] testilabyrintti = new Solmu[5][5];
        
        // Luodaan Solmu-oliot ja laitetaan ne matriisiin
        for (int i = 0; i < testilabyrintti.length; i++) {
            for (int j = 0; j < testilabyrintti.length; j++) {
                Solmu v = new Solmu(i, j); 
                testilabyrintti[i][j] = v;
            }
        } 
       
        Astar astar = new Astar(testilabyrintti, testilabyrintti[0][0], testilabyrintti[0][3]);*/
        Keko keko = new Keko(10);
        keko.heapInsert(19);
        keko.heapInsert(17);
        keko.heapInsert(3);
        keko.heapInsert(2);
        keko.heapInsert(1);
        keko.heapInsert(100);
        keko.heapInsert(36);
        keko.heapInsert(25);
        keko.heapInsert(7);
        //keko.printKeko();
        System.out.println(keko.heapDelMin());
        System.out.println(keko.heapDelMin());
        System.out.println(keko.heapDelMin());
        System.out.println(keko.heapDelMin());
        System.out.println(keko.heapDelMin());
        System.out.println(keko.heapDelMin());
        System.out.println(keko.heapDelMin());
        System.out.println(keko.heapDelMin());
        System.out.println(keko.heapDelMin());
    
        
        
}
}
