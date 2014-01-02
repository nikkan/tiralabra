/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrintti;

import java.util.ArrayList;


/**
 * Luokka vastaa labyrinttien muodostamisesta. LUOKKA ON VIELÄ KESKEN, TARKOITUS
 * ON ETTÄ HALUTUN KOKOISET LABYRINTIT GENEROITAISIIN 'SATUNNAISESTI'.
 * @author Anu N.
 */
public class Labyrintti {
    
    private Solmu[][] testilabyrintti;
    private Solmu lahto;
    private Solmu maali;
    
    public Labyrintti() {
        this.testilabyrintti = new Solmu[5][5];
        
        // Luodaan Solmu-oliot ja laitetaan ne matriisiin
        for (int i=0; i<testilabyrintti.length; i++) {
            for (int j=0; j<testilabyrintti.length; j++) {
                Solmu v = new Solmu(i, j);
                testilabyrintti[i][j] = v;
            }
        }
        
        Solmu s = testilabyrintti[2][0];
        s.setEste();
        s = testilabyrintti[2][1];
        s.setEste();
        s = testilabyrintti[2][2];
        s.setEste();
        s = testilabyrintti[1][3];
        s.setEste();
        s = testilabyrintti[3][1];
        s.setEste();
        
        this.lahto = testilabyrintti[0][1];
        this.maali = testilabyrintti[3][0];
    }
    
    public Solmu getSolmu(int x, int y) {
        return this.testilabyrintti[x][y];
    }
    
    public Solmu getLahto() {
        return this.lahto;
    }
    
    public Solmu getMaali() {
        return this.maali;
    }
    
    
    public ArrayList<Solmu> getNaapurit(Solmu s) {
        ArrayList<Solmu> naapurit = new ArrayList<Solmu>();
        // solmun s vasemmanpuoleinen naapuri
        if (s.getX() > 0 && s.onkoEste() != true) {
            naapurit.add(this.testilabyrintti[s.getX()-1][s.getY()]);
        }
        // solmun s oikeanpuoleinen naapuri
        if (s.getX() < this.testilabyrintti.length-1 && s.onkoEste() != true) {
            naapurit.add((this.testilabyrintti[s.getX()+1][s.getY()]));
        }
        // solmun s yläpuolella oleva naapuri
        if (s.getY() > 0 && s.onkoEste() != true) {
            naapurit.add(this.testilabyrintti[s.getX()][s.getY()-1]);
        }
        // solmun s alapuolella oleva naapuri
        if (s.getY() < this.testilabyrintti.length-1 && s.onkoEste() != true) {
            naapurit.add((this.testilabyrintti[s.getX()][s.getY()+1]));
        }
        return naapurit;
        
    }
    
    public void tulostaLabyrintti() {
        for (int i=0; i<testilabyrintti.length; i++) {
            for (int j=0; j<testilabyrintti.length; j++) {
                System.out.println(testilabyrintti[i][i].toString());
            }
        }
    }
    
    public int dist_between(Solmu current, Solmu naapuri) {
        return 1; // tämän voi muuttaa, jos haluaa labyrinttiin esim. vaikeakulkuista maastoa!
        // TÄMÄ PITÄÄKIN ITSEASIASSA MUUTTAA, KOSKA JOKA TAPAUKSESSA ON ESTEITÄ JOISTA EI PÄÄSE YLI!!
    }
  
    
}
