
package labyrintti;
import labyrintti.algot.Astar;
import labyrintti.algot.Keko;
import labyrintti.Solmu;

/**
 * Luokan on tarkoitus vastata ainoastaan ohjelman käynnistämisestä;
 * tällä hetkellä käytössä osin myös A*:n ja keon 'käsintestaukseen'.
 * 
 * @author Anu N.
 */
public class Main {
    
   
    public static void main(String[] args) {
        
        
        Labyrintti labyrintti = new Labyrintti();
        
        labyrintti.visualisoiLabyrintti();
        Solmu lahto = labyrintti.getLahto();
        Solmu maali = labyrintti.getMaali();

        Astar astar = new Astar(labyrintti, lahto, maali);
        astar.search();
      
        // Minimikeon testausta kokonaisluvuilla
        /*Keko keko = new Keko(10);
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
        System.out.println(keko.heapDelMin());*/
      
}
}
