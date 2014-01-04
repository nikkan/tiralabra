
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
        Solmu pois = taulukko[this.top];
        this.top--;
        return pois;
    } 
    
    /**
     * Lisää pinon päälle uuden Solmu-alkion.
     * 
     * @param x 
     */
    public void push(Solmu s) {
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
    
}
