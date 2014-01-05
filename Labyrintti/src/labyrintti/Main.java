
package labyrintti;
import labyrintti.algot.Astar;
import labyrintti.tietorakenteet.Keko;
import labyrintti.tietorakenteet.Solmu;
import labyrintti.algot.Astar2;

/**
 * Luokan on tarkoitus vastata ainoastaan ohjelman 
 * käynnistämisestä; tällä hetkellä se on kuitenkin käytössä osin myös A*:n ja 
 * keon 'käsintestaukseen'.
 * 
 * @author Anu N.
 */
public class Main {
    
   
    public static void main(String[] args) {
        
       
        Labyrintti labyrintti = new Labyrintti();
        
        labyrintti.visualisoiLabyrintti();
        Solmu lahto = labyrintti.getLahto();
        Solmu maali = labyrintti.getMaali();
        
      
        long alkuaika = System.nanoTime();
        Astar astarPelkkaaJavanKalustoa = new Astar(labyrintti, lahto, maali);
        astarPelkkaaJavanKalustoa.search();
        long loppuaika = System.nanoTime();
        System.out.print("\nAjankäyttö pelkällä Javan valmiilla kalustolla: ");
        System.out.print(loppuaika-alkuaika);
        System.out.println(" nanosekuntia");
        
        
        
        long alkuaika1 = System.nanoTime();
        Astar2 astarOmallaKeolla = new Astar2(labyrintti, lahto, maali);
        astarOmallaKeolla.searchOmallaKeolla();
        long loppuaika1 = System.nanoTime();
        System.out.print("\nAjankäyttö omalla keolla: ");
        System.out.print(loppuaika1-alkuaika1);
        System.out.println(" nanosekuntia");
        
        System.out.println("****");
        
        long alkuaika2 = System.nanoTime();
        Astar2 astarJavanPriorityQueuella = new Astar2(labyrintti, lahto, maali);
        astarJavanPriorityQueuella.searchJavanPriorityQueuella();
        long loppuaika2 = System.nanoTime();
        System.out.print("\nAjankäyttö Javan PriorityQueuella: ");
        System.out.print(loppuaika2-alkuaika2);
        System.out.println(" nanosekuntia");

}
}
