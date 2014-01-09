
package labyrintti.sovellus;
import javax.swing.SwingUtilities;
import labyrintti.algot.Astar;
import labyrintti.tietorakenteet.Solmu;
import labyrintti.algot.Astar2;
import labyrintti.tietorakenteet.Keko;

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
        Labyrintti labyrintti = new Labyrintti();
        
        /*Solmu s = labyrintti.getSolmu(3, 3);
        Keko keko = labyrintti.getNaapurit(s);
        keko.tulostaKeko();
        System.out.println("-----");
        keko = labyrintti.getJumpPointNaapurit(s);
        keko.tulostaKeko();*/
        //labyrintti.visualisoiLabyrintti();
        //Solmu lahto = labyrintti.getLahto();
        //Solmu maali = labyrintti.getMaali();
        
      
        /*long alkuaika = System.nanoTime();
        Astar astarPelkkaaJavanKalustoa = new Astar(labyrintti, lahto, maali);
        astarPelkkaaJavanKalustoa.search();
        long loppuaika = System.nanoTime();
        System.out.print("\nAjankäyttö pelkällä Javan valmiilla kalustolla: ");
        System.out.print(loppuaika-alkuaika);
        System.out.println(" nanosekuntia\n");*/
        
       /* System.out.println("****");
        
        long alkuaika1 = System.nanoTime();
        Astar2 astarOmallaKeolla = new Astar2(labyrintti, lahto, maali);
        astarOmallaKeolla.searchOmallaKeolla();
        astarOmallaKeolla.tulostaPolku();
        astarOmallaKeolla.tulostaKaydyt();
        long loppuaika1 = System.nanoTime();
        System.out.print("\nAjankäyttö omalla keolla: ");
        System.out.print(loppuaika1-alkuaika1);
        System.out.println(" nanosekuntia\n");
        
        System.out.println("****");
        
        /*long alkuaika2 = System.nanoTime();
        Astar2 astarJavanPriorityQueuella = new Astar2(labyrintti, lahto, maali);
        astarJavanPriorityQueuella.searchJavanPriorityQueuella();
        astarJavanPriorityQueuella.tulostaPolku();
        astarJavanPriorityQueuella.tulostaKaydyt();
        long loppuaika2 = System.nanoTime();
        System.out.print("\nAjankäyttö Javan PriorityQueuella: ");
        System.out.print(loppuaika2-alkuaika2);
        System.out.println(" nanosekuntia");*/
        
        
        
        /*System.out.println("\n\nLisää testausta:\n");
      
    
        System.out.println("Search omalla keolla:");
        long a1 = System.nanoTime();
        for (int i=0; i<1000; ++i) {
             
            Astar2 astar2 = new Astar2(labyrintti, lahto, maali);
            astar2.searchOmallaKeolla();
        }
        long l1 = System.nanoTime();
        System.out.println(l1-a1);
        
        System.out.println("");
        
        System.out.println("Search Javan PriorityQueuella:");
        long a2 = System.nanoTime();
        
        for (int j=0; j<1000; ++j) {
             
            Astar2 astar2 = new Astar2(labyrintti, lahto, maali);
            astar2.searchJavanPriorityQueuella();
        }
        long l2 = System.nanoTime();
        System.out.println(l2-a2);
        
        System.out.println("");
        */
        
}
}