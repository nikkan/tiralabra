
package labyrintti.sovellus;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author Anu N.
 */
public class Ruutu extends JButton {
    
    private ImageIcon kaantopuoli;
    private ImageIcon oikeapuoli;
    private int xKoord;
    private int yKoord;
    private Labyrintti labyrintti;
   
    /**
     * Konstruktori asettaa kortille oikean puolen ja kääntöpuolen, sekä
     * mustan ohuen rajauksen.
     * 
     * 
     * @param oikeapuoli Kortin eli napin DisabledIcon (ImageIcon)
     * @param kaantopuoli Kortin eli napin Icon (ImageIcon)
     */
    public Ruutu(int x, int y, boolean lahto, boolean maali, boolean polku, boolean kayty, boolean este, Labyrintti labyrintti) {
        super();
        this.xKoord = x;
        this.yKoord = y;
        this.labyrintti = labyrintti;
        
        super.setOpaque(false);
        super.setBorder(new LineBorder(Color.BLACK, 1));
        super.setEnabled(true);
        super.setFocusPainted(false);
        
        // Ruudun väri (=kuva, ImageIcon) riippuu siitä, onko ruutu
        // lähtö-, maali- tai estesolmu, kuuluuko se polulle tai
        // onko siellä käyty.
        if (lahto == true) {
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/lahto.gif");
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/lahto.gif");
        } else if (maali == true) {
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/maali.gif");
            this.kaantopuoli = new ImageIcon("src/labyrintti/kuvat/maali.gif");
        } else if (este == true) {
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/este.gif");
            this.kaantopuoli = new ImageIcon("src/labyrintti/kuvat/este.gif");
        } else if (polku == true) {
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/kayty.gif");
            this.kaantopuoli = new ImageIcon("src/labyrintti/kuvat/kayty.gif");
        } else if (kayty == true) {
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/polku.gif");
            this.kaantopuoli = new ImageIcon("src/labyrintti/kuvat/polku.gif");
        } else {
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/valkoinen.gif");
            this.kaantopuoli = new ImageIcon("src/labyrintti/kuvat/este.gif");
        }
        
        super.setIcon(oikeapuoli);
        super.setDisabledIcon(kaantopuoli);
        
    }
    
    /**
     * Palauttaa Ruudun x-koordinaatin
     * 
     * @return int x-koordinaatti
     */
    public int getXKoord() {
        
        return this.xKoord;
    }
    
    /**
     * Palauttaa Ruudun y-koordinaatin
     * 
     * @return int y-koordinaatti
     */
    public int getYKoord() {
        
        return this.yKoord;
    }
    
    /**
     * Asettaa Ruudun esteeksi labyrintissa.
     */
    public void asetaEste() {
        
        super.setEnabled(false);
        this.labyrintti.setEste(this.xKoord, this.yKoord);
    }
    

   
}
