public class OigeVaarKusimus extends Kusimus {

    public OigeVaarKusimus(String tekst, String oigeVastus) {
        super(tekst, oigeVastus);
    }

    @Override
    public void kuva() {
        System.out.println(tekst + " (jah/ei)");
    }
}