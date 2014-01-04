
package labyrintti;
import labyrintti.algot.Astar;
import labyrintti.tietorakenteet.Keko;
import labyrintti.tietorakenteet.Solmu;
import labyrintti.algot.Astar2;

/**
 * Luokan on todennäköisesti tarkoitus vastata ainoastaan ohjelman 
 * käynnistämisestä; tällä hetkellä se on kuitenkin käytössä osin myös A*:n ja 
 * keon 'käsintestaukseen'.
 * 
 * @author Anu N.
 */
public class Main {
    
   
    public static void main(String[] args) {
        
        
        /*Labyrintti labyrintti = new Labyrintti();
        
        labyrintti.visualisoiLabyrintti();
        Solmu lahto = labyrintti.getLahto();
        Solmu maali = labyrintti.getMaali();

        Astar astar = new Astar(labyrintti, lahto, maali);
        astar.search();
        
        System.out.println("----");
        
        Astar2 astar2 = new Astar2(labyrintti, lahto, maali);
        astar2.search();*/
      
        // Minimikeon testausta Solmuilla
        Solmu s = new Solmu(1,2);
        s.setKokonaisKustannus(5);
        System.out.println("Solmu(1,2) kokonaiskustannus:"+s.getKokonaisKustannus());
        Solmu s2 = new Solmu(5,6);
        s2.setKokonaisKustannus(9);
        System.out.println("Solmu(5,6) kokonaiskustannus:"+s2.getKokonaisKustannus());
        Solmu s3 = new Solmu(2,4);
        s3.setKokonaisKustannus(2);
        System.out.println("Solmu(2,4) kokonaiskustannus:"+s3.getKokonaisKustannus());
        
        Keko keko = new Keko(3);
        keko.heapInsert(s);
        keko.heapInsert(s2);
        keko.heapInsert(s3);
        //keko.heapify(0);
        keko.printKeko();
        System.out.println("..");
        System.out.println(keko.heapDelMin());
        System.out.println(keko.heapDelMin());
        System.out.println(keko.heapDelMin());
        //System.out.println(keko.heapDelMin());
        //keko.heapify(0);
        //keko.printKeko();
        //System.out.println(keko.heapDelMin());
        
       
        
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
