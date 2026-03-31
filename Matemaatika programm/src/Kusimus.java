/**
 * Kusimus on abstraktne baas klass kõikidele küsimusetüüpidele.
 * See hoiab küsimuse teksti ja õiget vastust.
 */

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

    public boolean kontrolliVastus(String vastus) {
        return oigeVastus.equalsIgnoreCase(vastus.trim());
    }

    @Override
    public abstract void kuva();
}