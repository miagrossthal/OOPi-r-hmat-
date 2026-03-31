/**
 * Teema on üldine abstraktne klass, mis kirjeldab ühte õppeteemat.
 * Selle alamklassideks on KordamisTeema ja TestiTeema.
 */

public abstract class Teema implements Kuvatav {
    protected String nimi;
    protected String kirjeldus;

    public Teema(String nimi, String kirjeldus) {
        this.nimi = nimi;
        this.kirjeldus = kirjeldus;
    }

    public String getNimi() {
        return nimi;
    }

    public String getKirjeldus() {
        return kirjeldus;
    }

    @Override
    public abstract void kuva();
}