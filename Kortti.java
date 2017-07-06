package pokeri;
import java.util.Random;
/*********************************************************
 * 
 * Pelikortin luokka. Kortti on muotoa ARVO(int)+MAA(char)
 * esim. Hertta Kuningas on 13H
 * @author Marko Loponen, 2016
 * @version 1.1
 **********************************************************/

public class Kortti {
    /** Kortin arvo. */
    private int arvo;
    /** Kortin maa. */
    private char maa;
    
    // *************************************************************************
    // Konstruktori
    // *************************************************************************
    /** Luodaan kortti parametrina annetusta merkkijonosta.
     * Alkuehto : Merkkijono on maksimissaan kolme merkkia pitka ja jossa
     * viimeinen merkki on kirjain ja muut merkit on numeroina. Esim. "12D"
     * @param s:ssa on merkkijonona kortin maaritelma.
    */
    public Kortti(String s){
        this.arvo = Integer.parseInt(s.substring(0,s.length()-1));
        this.maa = Character.toUpperCase(s.charAt(s.length()-1));
    }
    /** Luodaan kortti kun parametrit ovat tyhjat.
     * Kortti saa arvoksensa 0V
     */
    public Kortti() { this.arvo = 0; this.maa = 'V'; }
    
    // *************************************************************************
    // Havainnointi metodit
    // *************************************************************************
    /** Palauttaa kortin arvon. 
     * @return Kortti olion arvon kokonaislukuna.
     */
    public int getArvo(){
        return this.arvo;
    }
    /** Palauttaa kortin maan.
     * @return Kortti olion maa char-merkkina.
     */
    public char getMaa(){
        return this.maa;
    }
    /** Palauttaa kortin merkkijonona.
     * @return Olio merkkijonona.
     */
    @Override
    public String toString(){
        return this.arvo+ "" +this.maa;
    }
    /** Tulostaa kortin. */
    public void tulostaKortti(){
        System.out.println(this.arvo+""+this.maa);
    }
}
