/**
 * TestiTeema kirjeldab ühte testiteemat ja selle alla kuuluvaid küsimusi.
 */

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

    @Override
    public void kuva() {
        System.out.println(nimi);
    }
}