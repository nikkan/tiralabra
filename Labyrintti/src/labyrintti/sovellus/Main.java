
package labyrintti.sovellus;
import javax.swing.SwingUtilities;
import labyrintti.tietorakenteet.Solmu;
import labyrintti.algot.Astar;
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
        
        //1.DEMO GUILLA 
        // Luodaan uusi käyttöliittymäolio
        GUI kayttoliittyma = new GUI();
        // Käynnistetään käyttöliittymä
        SwingUtilities.invokeLater(kayttoliittyma);
       /*
        */
        //2. DEMO KIRJKL.
        Labyrintti labyrintti = new Labyrintti();
        Solmu lahto = labyrintti.getLahto();
        Solmu maali = labyrintti.getMaali();
        
        //Solmu s = labyrintti.getSolmu(3, 3);
        //Keko keko = labyrintti.getNaapurit(s);
        //keko.tulostaKeko();
        //System.out.println("-----");
        //keko = labyrintti.getJumpPointNaapurit(s);
        //keko.tulostaKeko();
        labyrintti.visualisoiLabyrintti();
        //Solmu lahto = labyrintti.getLahto();
        //Solmu maali = labyrintti.getMaali();
        
      /*
        
        System.out.println("****");
        
        /*long alkuaika1 = System.nanoTime();
        Astar2 astarOmallaKeolla = new Astar2(labyrintti, lahto, maali);
        astarOmallaKeolla.searchOmallaKeolla();
        astarOmallaKeolla.tulostaPolku();
        //System.out.println("käydyt solmut:");
        //astarOmallaKeolla.tulostaKaydyt();
        long loppuaika1 = System.nanoTime();
        System.out.print("\nAjankäyttö omalla keolla: ");
        System.out.print(loppuaika1-alkuaika1);
        System.out.println(" nanosekuntia\n");
        
        System.out.println("****");
        /*
        long alkuaika11 = System.nanoTime();
        Dijkstra dijkstra = new Dijkstra(labyrintti, lahto, maali);
        dijkstra.search();
        Pino polku = dijkstra.getPolku();
        labyrintti.visualisoiKuljettuPolku(polku);
        dijkstra.tulostaPolku();
        //System.println("käydyt solmut:");
        //astarOmallaKeolla2.tulostaKaydyt();
        long loppuaika11 = System.nanoTime();
        System.out.print("\nAjankäyttö omalla keolla: ");
        System.out.print(loppuaika11-alkuaika11);
        System.out.println(" nanosekuntia\n");
        
        /*
        long alkuaika2 = System.nanoTime();
        Astar2 astarJavanPriorityQueuella = new Astar2(labyrintti, lahto, maali);
        astarJavanPriorityQueuella.searchJavanPriorityQueuella();
        Pino polku = astarJavanPriorityQueuella.getPolku();
        labyrintti.visualisoiKuljettuPolku(polku);
        astarJavanPriorityQueuella.tulostaPolku();
       
        //System.out.println("käydyt solmut:");
        //astarJavanPriorityQueuella.tulostaKaydyt();
        long loppuaika2 = System.nanoTime();
        System.out.print("\nAjankäyttö Javan PriorityQueuella: ");
        System.out.print(loppuaika2-alkuaika2);
        System.out.println(" nanosekuntia");
        
        
        /*
        System.out.println("\n\nLisää testausta:\n");
      
    
        System.out.println("Search omalla keolla 1000:");
        long a1 = System.nanoTime();
        for (int i=0; i<1000; ++i) {
             
            Astar2 astar2 = new Astar2(labyrintti, lahto, maali);
            astar2.searchOmallaKeolla();
        }
        long l1 = System.nanoTime();
        System.out.println(l1-a1);
        
        System.out.println("");
        
        System.out.println("Search Javan PriorityQueuella 1000:");
        long a2 = System.nanoTime();
        
        for (int j=0; j<1000; ++j) {
             
            Astar2 astar2 = new Astar2(labyrintti, lahto, maali);
            astar2.searchJavanPriorityQueuella();
        }
        long l2 = System.nanoTime();
        System.out.println(l2-a2);
        
        System.out.println("");
        
        
        System.out.println("Search omalla keolla 10 000:");
        long Q1 = System.nanoTime();
        for (int i=0; i<10000; ++i) {
             
            Astar2 astar2 = new Astar2(labyrintti, lahto, maali);
            astar2.searchOmallaKeolla();
        }
        long Q2 = System.nanoTime();
        System.out.println(Q2-Q1);
        
        System.out.println("");
        
        System.out.println("Search Javan PriorityQueuella 10 000:");
        long O1 = System.nanoTime();
        
        for (int j=0; j<10000; ++j) {
             
            Astar2 astar2 = new Astar2(labyrintti, lahto, maali);
            astar2.searchJavanPriorityQueuella();
        }
        long O2 = System.nanoTime();
        System.out.println(O2-O1);
        
        System.out.println("");
        */
        
}
}
