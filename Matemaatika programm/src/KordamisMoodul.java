import java.util.List;

public class KordamisMoodul {
    private List<KordamiseTeema> teemad;

    public KordamisMoodul(List<KordamiseTeema> teemad) {
        this.teemad = teemad;
    }

    public void kuvaTeemad() {
        for (int i = 0; i < teemad.size(); i++) {
            System.out.println((i + 1) + ". " + teemad.get(i).getNimi());
        }
    }

    public void kuvaTeema(int indeks) {
        teemad.get(indeks).kuva();
    }
}