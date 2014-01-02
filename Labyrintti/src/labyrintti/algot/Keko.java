
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
    private int heapSize;
    private int heapLength;
    private int[] A;
    
    /**
     * Luokan konstruktori alustaa annetun kokoisen taulukon ja asettaa keon 
     * pituudeksi 0.
     * 
     */
    public Keko(int koko) {
        this.heapSize = koko;
        this.heapLength = 0;
        this.A = new int[this.heapSize];
        for (int i=0; i<this.heapSize; ++i) {
            this.A[i] = 0;
        }
    }
    
    /**
     * Palauttaa solmun i vanhemman
     * 
     * @param i 
     * @return i:n vanhempi
     */
    public int parent(int i) {
        return (((i+1)/2)-1);
    }
    
    /**
     * Palauttaa solmun i vasemman lapsen
     * 
     * @param i
     * @return i:n vasen lapsi
     */
    public int left(int i) { // pitäskö näihin tehdä jotku tsekkaukset et ei me yli
            return 2*i+1; 
    }
    
    /**
     * Palauttaa solmun i oikean lapsen
     * 
     * @param i
     * @return i:n oikea lapsi
     */
    public int right(int i) {
            return 2*i+2;
    }
    
    /**
     * Heapify korjaa kekoehdon, jos se on rikki solmun i kohdalla
     * 
     * @param i 
     */
    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = 0;
        if (r < this.heapLength || r == this.heapLength) {
            if (this.A[l] < this.A[r]) {
                smallest = l;
            } else {
                smallest = r;
            }
            if (A[i] > A[smallest]) {
                // vaihdetaan A[i] ja A[smallest] keskenään
                int temp = A[i];
                A[i] = A[smallest];
                A[smallest] = temp;
                // varmistetaan, että kekoehto toteutuu/korjataan keko
                heapify(smallest);
                
            }
        } else {
            if (r == this.heapLength && A[i] < A[r]) {
                // vaihdetaan A[i] ja A[l] keskenään
                int temp = A[i];
                A[i] = A[r];
                A[r] = temp;
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
        A[0] = A[this.heapLength-1];
        this.heapLength = this.heapLength-1;
        heapify(0);
        return min;
    }
    
    /**
     * Lisää kekoon yhden solmun -> paikka uudelle avaimelle
     * 
     * @param k 
     */
    public void heapInsert(int k) {
        if (this.heapLength == 0) {
            A[0] = k;
            this.heapLength++;
        } else {
            this.heapLength++;
            int i = this.heapLength-1;
            while (i > 0 && A[parent(i)] > k) {
                A[i] = A[parent(i)];
                i = parent(i);
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
            while (i > 0 && A[parent(i)] < A[i]) {
                int apu = A[i];
                A[i] = A[parent(i)];
                A[parent(i)] = apu;
                
                i = parent(i);
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
        for (int i=0; i<this.heapLength; ++i) {
            System.out.println(A[i]);
        }
    }
    
    
}
