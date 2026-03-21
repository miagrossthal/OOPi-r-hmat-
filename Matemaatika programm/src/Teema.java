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

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setKirjeldus(String kirjeldus) {
        this.kirjeldus = kirjeldus;
    }

    @Override
    public abstract void kuva();
}