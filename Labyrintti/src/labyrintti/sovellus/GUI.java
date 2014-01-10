
package labyrintti.sovellus;

import java.awt.Container;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Luokka vastaa Labyrintti-ohjelman graafisen käyttöliittymän toteuttamisesta.
 * 
 * @author Anu N.
 */
public class GUI implements Runnable {
    private JFrame frame;
    private JPanel mainPanel;
    
    public GUI() {
    
    }

    @Override
    public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Labyrintti");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Luodaan käyttöliittymään tulevat komponentit
     * 
     * @param container 
     */
    private void luoKomponentit(Container container) {
        
        JPanel kokonaisGUI = new JPanel();
        
        mainPanel = new JPanel(new GridBagLayout());
        
        // luodaan uusi labyrintti, oletusarvoisena kokona 10x10
        Labyrintti labyrintti = new Labyrintti(10);
        
        // luodaan mainPanelin sisälle tulevat komponentit 
        Otsikkopalkki otsikkopalkki = new Otsikkopalkki(mainPanel);
        Ohjepalkki ohjepalkki = new Ohjepalkki(mainPanel);
        Valintapalkki valintapalkki = new Valintapalkki(mainPanel);
        Tulospalkki tulospalkki = new Tulospalkki(mainPanel);
        Tausta tausta = new Tausta(labyrintti, mainPanel);
        Alapalkki alapalkki = new Alapalkki(mainPanel);
        
        kokonaisGUI.add(mainPanel);
        kokonaisGUI.setOpaque(true);
        container.add(kokonaisGUI);
        
        // lisätään kuuntelijat alapalkille ja valintapalkille
        AlapalkinKuuntelija apk = new AlapalkinKuuntelija(alapalkki, tausta);
        alapalkki.get10x10().addActionListener(apk);
        alapalkki.get20x20().addActionListener(apk);
        alapalkki.get40x40().addActionListener(apk);
        alapalkki.getLopeta().addActionListener(apk);
        
        ValintapalkinKuuntelija vpk = new ValintapalkinKuuntelija(valintapalkki, labyrintti, tausta);
        valintapalkki.getastarNappi().addActionListener(vpk);
        valintapalkki.getastarJPSNappi().addActionListener(vpk);
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
}
