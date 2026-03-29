import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestiMoodul {
    private List<TestiTeema> teemad;
    private Random random;

    public TestiMoodul(List<TestiTeema> teemad) {
        this.teemad = teemad;
        this.random = new Random();
    }

    public void kuvaTeemad() {
        for (int i = 0; i < teemad.size(); i++) {
            System.out.println((i + 1) + ". " + teemad.get(i).getNimi());
        }
    }

    public void alustaTest(int indeks, Scanner sc) {
        if (indeks < 0 || indeks >= teemad.size()) {
            System.out.println("Sellist teemat ei ole.");
            return;
        }

        TestiTeema teema = teemad.get(indeks);

        List<Kusimus> kysimused = new ArrayList<>(teema.getKysimused());
        Collections.shuffle(kysimused, random);

        int punktid = 0;

        System.out.println();
        System.out.println("===== TEST: " + teema.getNimi() + " =====");

        for (int i = 0; i < kysimused.size(); i++) {
            Kusimus k = kysimused.get(i);

            System.out.println();
            System.out.println("Küsimus " + (i + 1) + ":");
            k.kuva();
            System.out.print("Sinu vastus: ");
            String vastus = sc.nextLine();

            if (k.kontrolliVastus(vastus)) {
                System.out.println("Õige!");
                punktid++;
            } else {
                System.out.println("Vale.");
                System.out.println("Õige vastus: " + k.getOigeVastus());
            }
        }

        System.out.println();
        System.out.println("Tulemus: " + punktid + " / " + kysimused.size());
    }
}