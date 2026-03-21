public class KordamiseTeema extends Teema {
    private String kokkuvote;

    public KordamiseTeema(String nimi, String kirjeldus, String kokkuvote) {
        super(nimi, kirjeldus);
        this.kokkuvote = kokkuvote;
    }

    public String getKokkuvote() {
        return kokkuvote;
    }

    public void setKokkuvote(String kokkuvote) {
        this.kokkuvote = kokkuvote;
    }

    @Override
    public void kuva() {
        System.out.println("Teema: " + nimi);
        System.out.println(kirjeldus);
        System.out.println("Kokkuvõte: " + kokkuvote);
    }
}