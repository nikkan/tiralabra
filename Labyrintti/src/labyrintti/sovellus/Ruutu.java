
package labyrintti.sovellus;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
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
     * Kortista on defaulttina esillä nurja puoli. Kun nappia painetaan, oikea
     * puoli tulee näkyviin (eli asetetaan super.setEnabled(false))
     * 
     * @param oikeapuoli Kortin eli napin DisabledIcon (ImageIcon)
     * @param kaantopuoli Kortin eli napin Icon (ImageIcon)
     */
    public Ruutu(int x, int y, boolean lahto, boolean maali, Labyrintti labyrintti) {
        super();
        this.xKoord = x;
        this.yKoord = y;
        this.labyrintti = labyrintti;
        super.setOpaque(false);
        super.setBorder(new LineBorder(Color.BLACK, 1));
        super.setEnabled(true);
        super.setFocusPainted(false);
        if (lahto == true) {
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/lahto.gif");
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/lahto.gif");
        } else if (maali == true) {
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/maali.gif");
            this.kaantopuoli = new ImageIcon("src/labyrintti/kuvat/maali.gif");
        } else {
            this.oikeapuoli = new ImageIcon("src/labyrintti/kuvat/valkoinen.gif");
            this.kaantopuoli = new ImageIcon("src/labyrintti/kuvat/este.gif");
        }
        super.setIcon(oikeapuoli);
        super.setDisabledIcon(kaantopuoli);
        
    }
    
    public int getXKoord() {
        return this.xKoord;
    }
    
    public int getYKoord() {
        return this.yKoord;
    }
    
    /**
     * Asetetaan este.
     */
    public void asetaEste() {
        super.setEnabled(false);
        this.labyrintti.setEste(this.xKoord, this.yKoord);
    }
    
    /**
     * Asetetaan ruudun==solmun väri vaaleanharmaaksi, jos solmua on tarkasteltu
     */
    public void asetaTarkasteltu() {
        super.setBackground(Color.LIGHT_GRAY);
    }
    
    public void asetaLisatty() {
        super.setBackground(Color.RED);
    }
    
   /**
    * Metodi palauttaa kortin kuvapuolen merkkijonona, eli joko kuvakortin 
    * DisabledIconina olevan kuvan tiedostonimen tai numerokortin numeron.
    * 
    * @return Ikonin tiedostonimi tai numero merkkijonona
    */
    /*public String getKuvapuoli() {
        if (this.pelityyppi == true) {
            return this.oikeapuoli.toString();
        } else {
            return this.kuvapuoli;
        }
    }
    /**
     * Metodi palauttaa kortin kääntöpuolen merkkijonona, eli joko kuvakortin 
     * Iconina olevan kuvan tiedostonimen tai kysymysmerkin.
     * 
     * @return Ikonin tiedostonimi merkkijonona tai kysymysmerkki
     */
    /*public String getNurjapuoli() {
        if (this.pelityyppi == true) {
            return this.kaantopuoli.toString();
        } else {
            return this.nurjapuoli.toString();
        }
    }
    
   
}*/

    
}
