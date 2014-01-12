
package labyrintti.tietorakenteet;

/**
 * Luokka vastaa pino-tietorakenteen toteutuksesta. 
 * 
 * Tietorakenteen toteutus pohjautuu Tietorakenteet ja algoritmit- kurssilla
 * esitettyyn pseudokoodiin.
 * 
 * Huom! Korjaa vielä esim. tilanne, jossa pino täyttyy!
 * 
 * @author Anu N.
 */
public class Pino {
    
    private Solmu[] taulukko;
    private int top;
    
    public Pino(int n) {
        
        this.top = -1;
        this.taulukko = new Solmu[n];
    }
    
    /**
     * Palauttaa pinon päällimmäisen alkion.
     * 
     * @return Solmu 
     */
    public Solmu pop() {
        
        if (!this.empty()) {
            Solmu pois = taulukko[this.top];
            this.top--;
            return pois;
            
        } return null;
    } 
        
    /**
     * Lisää pinon päälle uuden Solmu-alkion. 
     * 
     * Jos taulukko on täynnä, luodaan uusi taulukko, jonka koko
     * on kaksinkertainen.
     * 
     * @param x 
     */
    public void push(Solmu s) {
        
        if (full()) {
            this.taulukko = new Solmu[this.taulukko.length*2];
        }
        this.top++;
        taulukko[this.top] = s;
    }
    
    /**
     * Tarkistaa, onko pino tyhjä.
     * 
     * @return true, jos pino on tyhjä, muuten false
     */
    public boolean empty() {
        
        return this.top == -1;
    }
    
    /**
     * Tarkistaa, onko pino täysi.
     * 
     * @return true, jos pino on täysi, muuten false
     */
    public boolean full() {
        
        return this.top == taulukko.length-1;
    }
    
    public boolean contains(Solmu s) {
        
        for (int i=0; i<this.top; ++i) {
            if (taulukko[i] == s) {
                return true;
            } 
            
        } return false;
    }
    
    /**
     * Palauttaa pinon päällimmäisenä olevan Solmu-alkion indeksin.
     * 
     * @return int indeksi
     */
    public int getTop() {
        
        return this.top;
    }
    
    /**
     * Palauttaa pinotaulukon pituuden.
     * 
     * @return int taulukon pituus.
     */
    public int pinonPituus() {
        
        return this.taulukko.length;
    }
    
}
