
package labyrintti.algot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import labyrintti.Labyrintti;
import labyrintti.Solmu;

/**
 * Luokka vastaa A*-algoritmiin pohjautuvan lyhimmän reitin etsinnän
 * toteuttamisesta.
 * 
 * Valmiissa toteutuksessa on tarkoitus hyödyntää pelkkiä omia tietorakenteita;
 * tällä hetkellä käytössä on vielä myös Javan kalustoa.
 * 
 * Algoritmi perustuu Wikipediasta (http://en.wikipedia.org/wiki/A*_search_algorithm)
 * löytyvään pseudokoodiin. HUOM! EI VIELÄ TOIMI TÄYSIN OIKEIN, ts. palauta
 * lyhintä reittiä.
 * 
 * @author Anu N.
 */

public class Astar {
            
    private Labyrintti labyrintti;
    private Solmu lahto;
    private Solmu maali;
    private PriorityQueue avoimet;
    private ArrayList<Solmu> kaydyt;
    private HashMap<Solmu, Solmu> mista_saapui;
    
    /**
     * Luokan konstruktori, joka saa parametrinaan matriisin (=labyrintti),
     * lähtösolmun sekä maalisolmun.
     * 
     * @param matriisi
     * @param start
     * @param end 
     */
    
    public Astar (Labyrintti labyrintti, Solmu lahto, Solmu maali) {
        this.labyrintti = labyrintti;
        this.lahto = lahto;
        this.maali = maali;
        this.avoimet = new PriorityQueue<Solmu>();
        this.mista_saapui = new HashMap<Solmu, Solmu>();
        this.kaydyt = new ArrayList<Solmu>();
        
    }
    
    /**
     * Metodi etsii ja tulostaa lyhimmän reitin labyrintin läpi lähtösolmusta
     * maalisolmuun.
     */
    public void search() {
        this.avoimet.add(lahto);
        this.lahto.set_g_score(0);
        this.lahto.set_f_score(this.maali);
        
        while(!this.avoimet.isEmpty()) {
            Solmu current = (Solmu) this.avoimet.poll();
           // System.out.println(current.toString());
            if (current.equals(maali)) {
                reconstruct_path(mista_saapui, maali);
            }
            this.avoimet.remove(current);
            this.kaydyt.add(current);
            
            ArrayList<Solmu> naapurit = this.labyrintti.getNaapurit(current);
            
            for (Solmu naapuri : naapurit) {
                
                if (!kaydyt.contains(naapuri)) {
                    int tentative_g_score = current.get_g_score() + labyrintti.dist_between(current, naapuri);
                    
                    if (!this.avoimet.contains(naapuri) || tentative_g_score < naapuri.get_g_score()) { 
                        mista_saapui.put(naapuri, current);
                        naapuri.set_g_score(tentative_g_score);
                        naapuri.set_f_score(maali); 
                    } 
                    if (!this.avoimet.contains(naapuri)) { 
                        this.avoimet.add(naapuri);
                    }
                }
                
            }
        }
    }

    private void reconstruct_path(HashMap<Solmu, Solmu> mista_saapui, Solmu current_node) {
        System.out.println(this.lahto.toString());
        Solmu s = this.maali;
        Stack<Solmu> pino = new Stack<Solmu>();
        while (!(s.equals(this.lahto))) {
            pino.push(s);
            s = mista_saapui.get(s);
        }
        while (!pino.empty()) {
            s = pino.pop();
            System.out.println(s.toString());
        }
        
        
          
    }

    
}
