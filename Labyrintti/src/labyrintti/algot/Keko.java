
package labyrintti.algot;

/**
 * Luokka vastaa minimikeko-tietorakenteen toteutuksesta. HUOM! TOIMII
 * TÄLLÄ HETKELLÄ KOKONAISLUVUILLE, EI VIELÄ SOLMU-OLIOILLE!
 * 
 * Keko on rakennettu Helsingin yliopiston Tietojenkäsittelytieteen laitoksen
 * Tietorakenteet ja algoritmit -kurssin kurssimonisteen pseudokoodien
 * pohjalta.
 * 
 * @author Anu N.
 */
public class Keko {
    private int keonKoko;
    private int keonPituus;
    private int[] A;
    
    /**
     * Luokan konstruktori alustaa annetun kokoisen taulukon ja asettaa keon 
     * pituudeksi 0.
     * 
     */
    public Keko(int koko) {
        this.keonKoko = koko;
        this.keonPituus = 0;
        this.A = new int[this.keonKoko];
        for (int i=0; i<this.keonKoko; ++i) {
            this.A[i] = 0;
        }
    }
    
    /**
     * Palauttaa solmun i vanhemman
     * 
     * @param i 
     * @return i:n vanhempi
     */
    public int vanhempi(int i) {
        return (((i+1)/2)-1);
    }
    
    /**
     * Palauttaa solmun i vasemman lapsen
     * 
     * @param i
     * @return i:n vasen lapsi
     */
    public int vasen(int i) { // pitäskö näihin tehdä jotku tsekkaukset et ei me yli
            return 2*i+1; 
    }
    
    /**
     * Palauttaa solmun i oikean lapsen
     * 
     * @param i
     * @return i:n oikea lapsi
     */
    public int oikea(int i) {
            return 2*i+2;
    }
    
    /**
     * Heapify korjaa kekoehdon, jos se on rikki solmun i kohdalla
     * 
     * @param i 
     */
    public void heapify(int i) {
        int v = vasen(i);
        int o = oikea(i);
        int pienin = 0;
        if (o < this.keonPituus || o == this.keonPituus) {
            if (this.A[v] < this.A[o]) {
                pienin = v;
            } else {
                pienin = o;
            }
            if (A[i] > A[pienin]) {
                // vaihdetaan A[i] ja A[smallest] keskenään
                int temp = A[i];
                A[i] = A[pienin];
                A[pienin] = temp;
                // varmistetaan, että kekoehto toteutuu/korjataan keko
                heapify(pienin);
                
            }
        } else {
            if (o == this.keonPituus && A[i] < A[o]) {
                // vaihdetaan A[i] ja A[l] keskenään
                int apu = A[i];
                A[i] = A[o];
                A[o] = apu;
            }
        }
    }
    
    /**
     * Poistaa juurena olleen alkion keosta ja korjaa kekoehdon, jos se on rikki
     * juuren kohdalta.
     * 
     * @return 
     */
    public int heapDelMin() {
        int min = A[0];
        A[0] = A[this.keonPituus-1];
        this.keonPituus = this.keonPituus-1;
        heapify(0);
        return min;
    }
    
    /**
     * Lisää kekoon yhden solmun -> paikka uudelle avaimelle
     * 
     * @param k 
     */
    public void heapInsert(int k) {
        if (this.keonPituus == 0) {
            A[0] = k;
            this.keonPituus++;
        } else {
            this.keonPituus++;
            int i = this.keonPituus-1;
            while (i > 0 && A[vanhempi(i)] > k) {
                A[i] = A[vanhempi(i)];
                i = vanhempi(i);
            }
            A[i] = k;
        }
    }
    
    /**
     * Kasvattaa annetussa indeksissä olevan avaimen arvoa.
     * 
     * @param i
     * @param newk 
     */
    public void heapIncKey(int i, int newk) {
        if (newk > A[i]) {
            A[i] = newk;
            while (i > 0 && A[vanhempi(i)] < A[i]) {
                int apu = A[i];
                A[i] = A[vanhempi(i)];
                A[vanhempi(i)] = apu;
                
                i = vanhempi(i);
            }
        }
    }
    
    /**
     * Pienentää annetussa indeksissä olevan avaimen arvoa.
     * 
     * @param i
     * @param newk 
     */
    public void heapDecKey(int i, int newk) {
        if (newk < A[i]) {
            A[i] = newk;
            heapify(i);
        }
    }
    
    /**
     * Tulostaa keossa olevat alkiot.
     */
    public void printKeko() {
        for (int i=0; i<this.keonPituus; ++i) {
            System.out.println(A[i]);
        }
    }
    
    
}
