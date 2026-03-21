import java.util.List;

public class ValikvastustegaKusimus extends Kusimus {
    private List<String> variandid;

    public ValikvastustegaKusimus(String tekst, String oigeVastus, List<String> variandid) {
        super(tekst, oigeVastus);
        this.variandid = variandid;
    }

    public List<String> getVariandid() {
        return variandid;
    }

    public void setVariandid(List<String> variandid) {
        this.variandid = variandid;
    }

    @Override
    public void kuva() {
        System.out.println(tekst);
        for (int i = 0; i < variandid.size(); i++) {
            System.out.println((i + 1) + ". " + variandid.get(i));
        }
    }
}