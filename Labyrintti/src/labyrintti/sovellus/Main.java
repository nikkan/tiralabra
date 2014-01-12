
package labyrintti.sovellus;
import javax.swing.SwingUtilities;
import labyrintti.tietorakenteet.Solmu;
import labyrintti.algot.Astar;
import labyrintti.algot.AstarJaJPS;
import labyrintti.algot.Dijkstra;
import labyrintti.tietorakenteet.Keko;
import labyrintti.tietorakenteet.Pino;

/**
 * Luokan on tarkoitus vastata ainoastaan ohjelman 
 * käynnistämisestä; tällä hetkellä se on kuitenkin käytössä osin myös A*:n ja 
 * keon 'käsintestaukseen', mistä johtuvat myös vielä tällä hetkellä
 * mukana olevat poiskommentoidut osiot.
 * 
 * @author Anu N.
 */
public class Main {
    
   
    public static void main(String[] args) {
        
        // Luodaan uusi käyttöliittymäolio
        GUI kayttoliittyma = new GUI();
        // Käynnistetään käyttöliittymä
        SwingUtilities.invokeLater(kayttoliittyma);
       
        
        // Muutama suorituskykytesti  
        Labyrintti labyrintti = new Labyrintti();
        Solmu lahto = labyrintti.getLahto();
        Solmu maali = labyrintti.getMaali();
        
  
        System.out.println("\n\ntestausta:\n");
      
    
        System.out.println("Search omalla keolla 1000:");
        long a1 = System.nanoTime();
        for (int i=0; i<1000; ++i) {
             
            Astar astar = new Astar(labyrintti, lahto, maali);
            astar.searchOmallaKeolla();
        }
        long l1 = System.nanoTime();
        System.out.println(l1-a1);
        
        System.out.println("");
        
        System.out.println("Search Javan PriorityQueuella 1000:");
        long a2 = System.nanoTime();
        
        for (int j=0; j<1000; ++j) {
             
            Astar astar2 = new Astar(labyrintti, lahto, maali);
            astar2.searchJavanPriorityQueuella();
        }
        
        long l2 = System.nanoTime();
        System.out.println(l2-a2);
        
        System.out.println("");
        
        System.out.println("Search JPS:lla 1000:");
        long a3 = System.nanoTime();
        
        for (int j=0; j<1000; ++j) {
             
            AstarJaJPS astar4 = new AstarJaJPS(labyrintti, lahto, maali);
            astar4.searchOmallaKeollaJaJumpPointilla();
        }
        
        long l3 = System.nanoTime();
        System.out.println(l3-a3);
        
        System.out.println("");
        
        
        System.out.println("Search omalla keolla 10 000:");
        long Q1 = System.nanoTime();
        for (int i=0; i<10000; ++i) {
             
            Astar astar2 = new Astar(labyrintti, lahto, maali);
            astar2.searchOmallaKeolla();
        }
        long Q2 = System.nanoTime();
        System.out.println(Q2-Q1);
        
        System.out.println("");
        
        System.out.println("Search Javan PriorityQueuella 10 000:");
        long O1 = System.nanoTime();
        
        for (int j=0; j<10000; ++j) {
             
            Astar astar3 = new Astar(labyrintti, lahto, maali);
            astar3.searchJavanPriorityQueuella();
        }
        long O2 = System.nanoTime();
        System.out.println(O2-O1);
        
        System.out.println("");
        
        System.out.println("Search JPS:lla 10 000:");
        long b3 = System.nanoTime();
        
        for (int j=0; j<10000; ++j) {
             
            AstarJaJPS JPS = new AstarJaJPS(labyrintti, lahto, maali);
            JPS.searchOmallaKeollaJaJumpPointilla();
        }
        
        long c3 = System.nanoTime();
        System.out.println(c3-b3);
        
        System.out.println("");
        
        
}
}
