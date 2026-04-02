/**
 * KordamisTeema salvestab ühe kordamise teema nime,
 * kirjelduse ja kokkuvõtte.
 */

public class KordamisTeema extends Teema {
    private String kokkuvote;

    public KordamisTeema(String nimi, String kirjeldus, String kokkuvote) {
        super(nimi, kirjeldus);
        this.kokkuvote = kokkuvote;
    }

    public String getKokkuvote() {
        return kokkuvote;
    }

    /**
     * Otstarve: Muudab kokkuvõtte teksti.
     * Antud: uus kokkuvõte.
     * Tulemus: kokkuvõte uuendatakse.
     */
    public void setKokkuvote(String kokkuvote) {
        this.kokkuvote = kokkuvote;
    }

    /**
     * Otstarve: Kuvab teema nime ja kokkuvõtte.
     * Antud: puudub.
     * Tulemus: info kuvatakse ekraanile.
     */
    @Override
    public void kuva() {
        System.out.println("Teema: " + nimi);
        System.out.println(kokkuvote);
    }
}