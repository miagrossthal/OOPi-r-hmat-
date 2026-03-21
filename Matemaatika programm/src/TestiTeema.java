import java.util.List;

public class TestiTeema extends Teema {
    private List<Kusimus> kysimused;

    public TestiTeema(String nimi, String kirjeldus, List<Kusimus> kysimused) {
        super(nimi, kirjeldus);
        this.kysimused = kysimused;
    }

    public List<Kusimus> getKysimused() {
        return kysimused;
    }

    public void setKysimused(List<Kusimus> kysimused) {
        this.kysimused = kysimused;
    }

    @Override
    public void kuva() {
        System.out.println("Testi teema: " + nimi);
    }
}