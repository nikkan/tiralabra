
package labyrintti.sovellus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka vastaa Labyrintin Ruutujen (JButtoneita) kuuntelusta,
 * eli muuttaa klikatut ruudut labyrintin esteiksi.
 * 
 * @author Anu N.
 */
public class RuudunKuuntelija implements ActionListener {
    
    private Ruutu ruutu;

    /**
     * Konstruktori saa parametrikseen ruutu-olion, johon kuuntelija
     * on liitetty.
     * 
     * @param ruutu 
     */
    public RuudunKuuntelija(Ruutu ruutu) { 
        
        this.ruutu = ruutu;
       
    }
    
    /**
     * Asettaa klikatun ruudun estesolmuksi.
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        this.ruutu.asetaEste();
    }   
      
    
}
