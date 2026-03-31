/**
 * TekstKusimus on tavaline avatud küsimus,
 * millele kasutaja sisestab vastuse tekstina.
 */

public class TekstKusimus extends Kusimus {

    public TekstKusimus(String tekst, String oigeVastus) {
        super(tekst, oigeVastus);
    }

    @Override
    public void kuva() {
        System.out.println(tekst);
    }
}