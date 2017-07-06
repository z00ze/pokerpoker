package pokeri;
import java.util.Scanner;
/*********************************************************
 * 
 * Pokeri testiluokka.
 * @author Marko Loponen, 2016
 * @version 1.1
 **********************************************************/

public class PokeriTesti {
        public static void main(String[] args) {
            Scanner luku = new Scanner(System.in);
            
            // Luodaan uusi pakka.
            Pakka pakka = new Pakka();
            
            // Sekoitetaan pakka.
            pakka.sekoitaPakka();
            
            // Luodaan uusi pelaaja.
            Pelaaja mies = new Pelaaja("Marko Loponen", pakka);
            
            // Tulostetaan pelaajan nimi.
            System.out.println(mies.getNimi());
            mies.tulostaNimi();
            // Tulostetaan pelaajan käsi.
            System.out.println(mies.getKasi());
            mies.tulostaKasi();
            
            // Poistetaan kädestä kortti.
            mies.poistaKortti(0);
            mies.tulostaKasi();
            // Poistetaan kädestä käyttäjän antama kortti.
            System.out.print("Kirjoita kädestä poistettava kortti: ");
            mies.poistaKortti(luku.nextLine());
            mies.tulostaKasi();
            
            // Vaihdetaan luotu kortti kädessä olevaan korttiin. Luotu kortti on
            // luotu ilman parametreja joten se saa arvokseen 0V
            Kortti vaihto = new Kortti();
            System.out.println("Kädestä otettu kortti on " + mies.vaihdaKortti(0, vaihto));
            System.out.println("Käteen lisätty kortti on " + vaihto);
            mies.sortKasi();
            mies.tulostaKasi();
            
            // Luodaan kortti joka saa arvoksensa 25 ja maakseen X
            Kortti luonti = new Kortti("25X");
            
            // Suurin kortti.
            System.out.println("Suurin kortti on " + mies.suurinKortti());
            
            // Nostetaan pakasta kortti. (Kaksi kertaa.)
            System.out.println("Nostetaan pakasta yksi kortti.");
            mies.nostaKortti(pakka);
            mies.tulostaKasi();
            System.out.println("Nostetaan pakasta yksi kortti.");
            mies.nostaKortti(pakka);
            mies.tulostaKasi();
            
            // Tulostetaan keskimmäisen kortin arvo ja maa eri tavoilla.
            System.out.println("Tulostetaan keskimmäisen kortin arvo : " + mies.getKasi().get(2).getArvo());
            System.out.println("Tulostetaan keskimmäisen kortin maa : " + mies.getKasi().get(2).getMaa());
            System.out.print("Tulostetaan keskimmäinen kortti : "); mies.getKasi().get(2).tulostaKortti();
            
            // Onko kädessä väri. Testimielessä luodaan uusi pelaaja ilman pelikättä sekä uusi pakka.
            // mutta pakkaa ei järjestetä joten ensimmäiset kortit jotka nostetaan ovat
            // 1D, 2D, 3D, 4D, 5D
            Pakka uusipakka = new Pakka();
            Pelaaja uusipelaaja = new Pelaaja("Matti Meikäläinen");
            for(int i = 0;i<5;i++){ uusipelaaja.nostaKortti(uusipakka); }
            System.out.println(uusipelaaja.toString());
            if(uusipelaaja.onkoVari()) System.out.println("Väri!");
            else System.out.println("Ei väriä!");
            
            // Testaus että onkoVari-metodi ei toimi jos kädessä olevan kortin maa on eri kuin muut.
            uusipelaaja.vaihdaKortti(0, luonti);
            System.out.println(uusipelaaja.toString());
            if(uusipelaaja.onkoVari()) System.out.println("Väri!");
            else System.out.println("Ei väriä!");
            
        }
}
