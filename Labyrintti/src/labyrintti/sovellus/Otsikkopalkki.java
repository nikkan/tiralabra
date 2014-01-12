
package labyrintti.sovellus;

/**
 * Luokka vastaa otsikkopalkin toteuttamisesta Labyrintti-ohjelman graafiseen
 * käyttöliittymään.
 * 
 * @author Anu N.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Otsikkopalkki-luokka vastaa graafisen käyttöliittymän ylälaitaan tulevan
 * otsikkopalkin luomisesta ja lisäämisestä mainPaneliin.
 * 
 * @author Anu N.
 */

public class Otsikkopalkki {
  
    private JPanel otsikkopalkki;
    
    /**
     * Konstruktori luo otsikkopalkin ja lisää sen parametrina saatavaan mainPaneliin.
     * 
     * @param mainPanel Paneli, johon otsikkopalkki lisätään.
     */
    public Otsikkopalkki(JPanel mainPanel) {
        // Luodaan otsikkopalkki ja laitetaan sille asetukset
        this.otsikkopalkki = new JPanel();
        this.otsikkopalkki.setOpaque(true);
        this.otsikkopalkki.setBackground(Color.black);
        
        // Luodaan JLabel otsikolle 
        JLabel otsikko = new JLabel("LABYRINTTI");
        Font font = new Font("Arial", Font.BOLD, 18);
        otsikko.setFont(font);
        otsikko.setForeground(Color.white);
        
        // Lisätään otsikko otsikkopalkkiin
        this.otsikkopalkki.add(otsikko);
        
        // Asetetaan GridBag-rajoitukset 
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 5;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(1,1,1,1);
        c.fill = GridBagConstraints.HORIZONTAL;
        
        // Lisätään otsikkopalkki mainPaneliin
        mainPanel.add(this.otsikkopalkki, c);  
    }
    
    
}
