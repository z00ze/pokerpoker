package pokeri;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
/*********************************************************
 * 
 * Pelaajan luokka. Pelaajaa mallinnetaan antamalla hanelle nimi (String)
 * seka pelikasi (LinkedList<Kortti>) jossa on viisi korttia (Kortti olioita)
 * Kortit, nostetaan pakasta joka on annettu parametrina.
 * @author Marko Loponen, 2016
 * @version 1.1
 **********************************************************/
public class Pelaaja {
    /** Pelaajan nimi */
    private String nimi;
    /** Pelaajan pelikasi */
    private LinkedList<Kortti> kasi = new LinkedList<Kortti>();

    // *************************************************************************
    // Konstruktori
    // *************************************************************************
    /** Luodaan pelaaja parametrina annetuista arvoista.
     * Alkuehto : Parametrina annetussa pakassa on viisi tai enemman korttia
     * jaljella.
     * @param nimi Uudeksi nimeksi tulee nimi.
     * @param pakka Uudeksi pakasti tulee pakka.
    */
    public Pelaaja(String nimi, Pakka pakka){
        this.nimi = nimi;
        this.luoPeliKasi(pakka);
        this.sortKasi(); // Jarjestetaan kasi pienimmista suurimpaan.
    }
    /** Luodaan pelaaja kun vain pakka on annettu, pelaajan nimeksi tulee tyhja.
     * Alkuehto : Parametrina annetussa pakassa on viisi tai enemman korttia
     * jaljella.
     * @param pakka Uudeksi pakaksi tulee pakka.
    */
    public Pelaaja(Pakka pakka){
        this.nimi = "";
        this.luoPeliKasi(pakka);
        this.sortKasi();
    }
    /** Luodaan pelaaja kun vain nimi on annettu.
     * @param nimi Uudeksi nimeksi tulee nimi.
     */
    public Pelaaja(String s){
        this.nimi = s;
    }
    /** Luodaan pelaaja kun parametrit ovat tyhjat.
     * Tassa tapauksessa pelaajalle ei ole nimea, eika kadessa ole yhtaan korttia.
     */
    public Pelaaja() {
        this.nimi = "";
    }
    
    // *************************************************************************
    // Havainnointi metodit
    // *************************************************************************
    /** Palauttaa pelaajan nimen. 
     * @return Olion nimen.
     */
    public String getNimi(){
        return this.nimi;
    }
    /** Palauttaa pelaajan kaden.
     * @return Olion kaden.
     */
    public LinkedList<Kortti> getKasi(){
        return this.kasi;
    }
    /** Palauttaa pelaajan nimen ja kaden merkkijonona.
     * @return Olio merkkijonona.
     */
    @Override
    public String toString(){
        return "Nimi : " + this.nimi + " " +Arrays.toString(kasi.toArray());
    }
    /** Tulostaa pelaajan nimen. */
    public void tulostaNimi(){
        System.out.println(this.nimi);
    }
    /** Tulostaa pelaajan kaden. */
    public void tulostaKasi(){
        System.out.println(Arrays.toString(kasi.toArray()));
    }
    
    // *************************************************************************
    // Muutos metodit
    // *************************************************************************
    
    /** Pelikaden luonti, nostaa parametrina annetusta pakasta viisi korttia kateen.
     * Alkuehto : Parametrina annetussa pakassa on viisi tai enemman korttia
     * jaljella.
     * @param pakka Nostaa pakasta viisi korttia kateen.
    */
    public void luoPeliKasi(Pakka pakka){
        for(int i = 0;i<5;i++){
            nostaKortti(pakka);
        }
    }
    
    /** Nostaa parametrina annetusta pakasta ensimmaisen kortin ja lisaa sen kateen. 
     * Alkuehto : Parametrina annetussa pakassa on yksi tai enemman korttia jaljella.
     * @param pakka Nostaa pakasta kortin kateen.
     */
    public void nostaKortti(Pakka pakka){
        kasi.add(pakka.nostaKortti());
        this.sortKasi();
    }
    /** Poistaa parametrina annetun indexin kortin kadesta. Ja jarjestaa kaden.
     * Palauttaa true/false onnistuiko poisto.
     * @param i Poistaa kadesta kortin.
     */
    public boolean poistaKortti(int i){
        if(i>0 && i<this.kasi.size()){
        kasi.remove(i);
        this.sortKasi();
        return true;
        }
        return false;
    }
    /** Poistaa parametrina annetun merkkijonon vastaavan kortin kadesta.
     * Alkuehto: merkkijono on oikeassa muodossa esim. 12D ja kadessa. Metodi
     * palauttaa true/false onnistuiko poisto.
     * @param poistettava Poistaa kadesta kysisen kortin.
     * @return Onnistuiko poisto.
     */
    public boolean poistaKortti(String poistettava){
        poistettava = poistettava.toUpperCase();
        for(int i = 0;i<kasi.size();i++){
            // Verrataan metodissa parametrina annettua merkkijonoa kädessä olevan
            // kortin arvoon ja maahan, jos molemmat ovat samat - Kortti poistetaan.
            if(kasi.get(i).getArvo()==Integer.parseInt(poistettava.substring(0,poistettava.length()-1)) 
               && kasi.get(i).getMaa()==poistettava.charAt(poistettava.length()-1))
                {
                kasi.remove(i);
                return true;
                }
        }
        return false;
    }
    /** Metodi lisaa kateen parametrina annetun kortin ja palauttaa
     * parametrin annetun indexin kortin. Katta ei jarjesteta suuruus jarjestykseen.
     * @param x Kortin indeksi kadessa.
     * @param kortti Kateen lisattava kortti.
     * @return Kadesta poistettu kortti.
     */
    public Kortti vaihdaKortti(int x, Kortti kortti){
        kasi.add(kortti);
        return kasi.remove(x);
    }
    /** Asettaa pelaajan nimen.
     * @param nimi Uusi nimi.
     */
    public void setNimi(String nimi){
        this.nimi = nimi;
    }
    /** Jarjestaa kaden pienimmasta suurimpaan. */
    public void sortKasi(){
        for(int i = 0;i<kasi.size();i++){
            for(int k = 0;k<kasi.size();k++){
                if(kasi.get(i).getArvo()<kasi.get(k).getArvo()) Collections.swap(kasi, i, k);
            }
        }
    }
    
    // *************************************************************************
    // Kaden voittoluokkien tarkistus.
    // *************************************************************************
    
    /** Metodi tarkistaa ovatko kaikki kadessa olevat kortit samaa varia (maata).
     * Metodi palauttaa true tai false.
     * @return Onko kadessa vari.
     */
    public boolean onkoVari(){
        char maa = kasi.get(0).getMaa();
        int laskuri = 1;
        for(int p = 1;p<kasi.size();p++){
            if(maa==kasi.get(p).getMaa()) laskuri++;
        }
        return laskuri==kasi.size();
    }
    
    /** Metodi palauttaa suurimman kortin arvo.
     * @return Suurimman kortin arvo.
     */
    public int suurinKortti(){
        this.sortKasi();
        if(kasi.get(0).getArvo()==1) return kasi.get(0).getArvo();
        return kasi.get(kasi.size()-1).getArvo();
    }

}
