package pokeri;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
/*********************************************************
 * 
 * Pakan luokka. Pakka on LinkedList<Kortti> johon lisataan kaikki kortit.
 * @author Marko Loponen, 2016
 * @version 1.1
 **********************************************************/
public class Pakka {
    /** Pakan muuttuja */
    private LinkedList<Kortti> pakka = new LinkedList<Kortti>();

    // *************************************************************************
    // Konstruktori
    // *************************************************************************
    /** Luodaan korttipakka. */
    public Pakka(){
        // Voidaan myös piilottaa kommenttoihin alla olevat rivit ja
        // lisätä korit manuaalisesti esim. this.pakka.add(new Kortti("12D));
        char diamonds = 'D';
        char hearts = 'H';
        char clubs = 'C';
        char spades = 'S';
        for(int k = 0;k<4;k++){
            for(int i = 1;i<=13;i++){
                if(k==0) this.pakka.add(new Kortti(Integer.toString(i)+diamonds));
                if(k==1) this.pakka.add(new Kortti(Integer.toString(i)+hearts));
                if(k==2) this.pakka.add(new Kortti(Integer.toString(i)+clubs));
                if(k==3) this.pakka.add(new Kortti(Integer.toString(i)+spades));
            }
        }
    }
    // *************************************************************************
    // Muutos metodit.
    // *************************************************************************
    /** Sekoitetaan korttipakka. */
    public void sekoitaPakka(){
        Collections.shuffle(this.pakka);
    }
    /** Nostetaan kortti korttipakan paalta, kortti poistetaan pakasta.
     * @return Kortti Pakasta.
     */
    public Kortti nostaKortti(){
        if(this.pakka.isEmpty()) return null;
        return this.pakka.removeFirst();
    }
    /** Metodi palauttaa pakan merkkijonona.
     * @return Pakka merkkijonona.
     */
    @Override
    public String toString(){
        return Arrays.toString(this.pakka.toArray());
    }
}
