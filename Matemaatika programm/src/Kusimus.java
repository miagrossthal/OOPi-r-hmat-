public abstract class Kusimus implements Kuvatav {
    protected String tekst;
    protected String oigeVastus;

    public Kusimus(String tekst, String oigeVastus) {
        this.tekst = tekst;
        this.oigeVastus = oigeVastus;
    }

    public String getTekst() {
        return tekst;
    }

    public String getOigeVastus() {
        return oigeVastus;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public void setOigeVastus(String oigeVastus) {
        this.oigeVastus = oigeVastus;
    }

    public boolean kontrolliVastus(String vastus) {
        return oigeVastus.equalsIgnoreCase(vastus);
    }

    @Override
    public abstract void kuva();
}