public class KordamisTeema extends Teema {
    private String kokkuvote;

    public KordamisTeema(String nimi, String kirjeldus, String kokkuvote) {
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
        System.out.println(kokkuvote);
    }
}