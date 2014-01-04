
package labyrintti.tietorakenteet;

/**
 * Luokka mahdollistaa Solmu-olioiden tallentamisen taulukkoon ja etsimisen
 * taulukosta. Kesken, mietin vielä tarvitseeko tätä vai selviänkö pelkällä keolla.
 * 
 * @author Anu N.
 */
public class Solmulista {
    private Solmu[] lista;
    private int koko;
    private int pituus;
    
    public Solmulista(int n) {
        this.koko = n;
        this.lista = new Solmu[n];
        this.pituus = 0;
    }
    
    public void add(Solmu solmu) {
        this.pituus++;
        this.lista[this.pituus] = solmu;
    }
    
    public boolean contains(Solmu solmu) {
        
        
        return true;
    }
    
}
