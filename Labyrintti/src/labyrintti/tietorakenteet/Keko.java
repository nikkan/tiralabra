
package labyrintti.tietorakenteet;

/**
 * Luokka vastaa minimikeko-tietorakenteen toteutuksesta. 
 * 
 * Keko on rakennettu Helsingin yliopiston Tietojenkäsittelytieteen laitoksen
 * Tietorakenteet ja algoritmit -kurssin kurssimonisteen (maksimikeko)-
 * pseudokoodien pohjalta.
 * 
 * @author Anu N.
 */

public class Keko {
    private int keonKoko;
    private int keonPituus;
    private Solmu[] keko;
    
    /**
     * Luokan konstruktori alustaa annetun kokoisen taulukon ja asettaa keon 
     * pituudeksi 0.
     */
    public Keko(int koko) {
        this.keonKoko = koko;
        this.keonPituus = 0;
        this.keko = new Solmu[this.keonKoko];
        for (int i=0; i<this.keonKoko; ++i) {
            this.keko[i] = null;
        }
    }
    
    /**
     * Palauttaa keon koon kutsuhetkellä.
     * 
     * @return int keon koko
     */
    public int getKoko() {
        return this.keonKoko;
    }
    
    /**
     * Palauttaa keon pituuden kutsuhetkellä, ts. kuinka monta alkiota taulukosta
     * "keko" kuuluu kekoon
     * 
     * @return int keon pituus
     */
    public int getPituus() {
        return this.keonPituus;
    }
    
    
    /**
     * Palauttaa Solmu-olion annetussa indeksissä.
     * 
     * @param indeksi
     * @return Solmu -olio annetussa indeksissä
     */
    public Solmu palautaAlkioIndeksissa(int indeksi) {
        return this.keko[indeksi];
    }
     
    /**
     * Palauttaa solmun i vanhemman indeksin.
     * 
     * @param i 
     * @return i:n vanhempi
     */
    public int vanhempi(int i) {
        return (((i+1)/2)-1);
    }
    
    /**
     * Palauttaa solmun i vasemman lapsen indeksin.
     * 
     * @param i
     * @return i:n vasen lapsi
     */
    public int vasen(int i) { 
            return 2*i+1; 
    }
    
    /**
     * Palauttaa solmun i oikean lapsen indeksin.
     * 
     * @param i
     * @return i:n oikea lapsi
     */
    public int oikea(int i) {
            return 2*i+2;
    }
    
    /**
     * Korjaa kekoehdon, jos se on rikki indeksissä i olevan solmun kohdalla.
     * 
     * @param i 
     */
    private void korjaa(int i) {
        int v = vasen(i);
        int o = oikea(i);
        int pienin = 0;
        if (o <= this.keonPituus) {
            if (this.keko[v].getKokonaisKustannus() < this.keko[o].getKokonaisKustannus()) {
                pienin = v;
            } else {
                pienin = o;
            }
            if (keko[i].getKokonaisKustannus() > keko[pienin].getKokonaisKustannus()) {
                // vaihdetaan keko[i] ja keko[pienin] keskenään
                Solmu apu = keko[i];
                keko[i] = keko[pienin];
                //keko[pienin].setIndeksiKeossa(i);
                keko[pienin] = apu;
                //keko[i].setIndeksiKeossa(pienin);
                // varmistetaan, että kekoehto toteutuu/korjataan keko
                korjaa(pienin);
                
            }
        } else {
            if (o == this.keonPituus && keko[i].getKokonaisKustannus() < keko[o].getKokonaisKustannus()) {
                // vaihdetaan keko[i] ja keko[v] keskenään
                Solmu apu = keko[i];
                keko[i] = keko[o];
                //keko[o].setIndeksiKeossa(i);
                keko[o] = apu;
                //keko[i].setIndeksiKeossa(o);
            }
        }
    }
    
    /**
     * 
     * @param indeksi 
     */
    public void paivita(int indeksi) {
        this.korjaa(indeksi);
    }
    
    /**
     * Poistaa juurena olleen alkion keosta ja korjaa kekoehdon, jos se on rikki
     * juuren kohdalta.
     * 
     * @return Solmu min
     */
    public Solmu poistaPienin() {
        Solmu min = keko[0];
        keko[0] = keko[this.keonPituus-1];
        //keko[0].setIndeksiKeossa(0);
        this.keonPituus--;
        korjaa(0);
        //keko[this.keonPituus] = null;
        return min;
    }
    
    /**
     * Lisää kekoon yhden solmun -> paikka uudelle avaimelle
     * 
     * @param solmu 
     */
    public void lisaaKekoon(Solmu solmu) {
        if (this.keonPituus == 0) {
            keko[0] = solmu;
            solmu.setIndeksiKeossa(0);
            this.keonPituus++;
        } else if (this.taynna() == true) {
            this.kaksinkertaistaKeko();
        } else {
            this.keonPituus++;
            int i = this.keonPituus-1;
            while (i > 0 && keko[vanhempi(i)].getKokonaisKustannus() > solmu.getKokonaisKustannus()) {
                keko[i] = keko[vanhempi(i)];
                keko[i].setIndeksiKeossa(i);
                i = vanhempi(i);
            }
            keko[i] = solmu;
            solmu.setIndeksiKeossa(i);
        }
    }
    
    /**
     * Tulostaa keossa olevat alkiot.
     */
    public void tulostaKeko() {
        for (int i=0; i<this.keonPituus; ++i) {
            System.out.println(keko[i]);
        }
    }
    
    /**
     * Tarkistaa, onko keko tyhjä eli onko keossa Solmu-alkioita.
     * 
     * @return true, jos keko on tyhjä, muuten false
     */
    public boolean isEmpty() {
        return this.keonPituus == 0;
    }
    
    /**
     * Tarkistaa, löytyykö keosta annettu Solmu-alkio. 
     * 
     * Metodi hyödyntää binäärihakua alkion etsimisessä.
     * 
     * @param Solmu-alkio s
     * @return true jos solmu löytyy keosta, muuten false
     */
    public boolean contains(Solmu s) {
     
         int vasen = 0;
         int oikea = this.keonPituus-1;
         boolean found = false;
         
         while (vasen <= oikea && found == false) {
             int keski = (vasen+oikea)/2;
             if (this.keko[keski] == s) {
                 found = true;
                 return found;
             }
             if (this.keko[keski].getKokonaisKustannus() > s.getKokonaisKustannus()) {
                 oikea = keski-1;
                 
             } else {
                 vasen = keski+1;
             }
         
    } return false;
    
    }
    
     /**
     * Tarkistaa, löytyykö keosta annettu Solmu-alkio. 
     * 
     * Metodi hyödyntää binäärihakua alkion etsimisessä.
     * 
     * @param Solmu-alkio s
     * @return true jos solmu löytyy keosta, muuten false
     */
    public int haeIndeksi(Solmu s) {
     
         for (int i=0; i<this.keonPituus; ++i) {
             if (this.keko[i].equals(s)) {
                 return i;
             }
         } return -1;
    
    }
    
    public boolean taynna() {
        if (this.keonPituus == this.keonKoko) {
            return true;
        } return false;
    }
    
    public void kaksinkertaistaKeko() {
        int uusikoko = this.keonKoko*2;
        Solmu[] k = new Solmu[uusikoko];
        
        for (int i=0; i<keko.length; ++i) {
            k[i] = this.keko[i];
        }
        
        this.keko = k;
    }
}
