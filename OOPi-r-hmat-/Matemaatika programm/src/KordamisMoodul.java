import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class KordamisMoodul {
    private List<KordamisTeema> teemad;
    private Random random;

    public KordamisMoodul(List<KordamisTeema> teemad) {
        this.teemad = teemad;
        this.random = new Random();
    }

    public void kuvaTeemad() {
        for (int i = 0; i < teemad.size(); i++) {
            System.out.println((i + 1) + ". " + teemad.get(i).getNimi());
        }
    }

    public void kuvaTeema(int indeks, Scanner sc) {
        if (indeks < 0 || indeks >= teemad.size()) {
            System.out.println("Sellist teemat ei ole.");
            return;
        }

        KordamisTeema teema = teemad.get(indeks);
        String[] osad = teema.getKokkuvote().split("\n\n");

        List<String> plokid = new ArrayList<>();
        for (int i = 0; i < osad.length; i++) {
            plokid.add(osad[i]);
        }

        Collections.shuffle(plokid, random);

        System.out.println();
        System.out.println("===== KORDAMINE: " + teema.getNimi() + " =====");

        for (int i = 0; i < plokid.size(); i++) {
            String[] read = plokid.get(i).split("\n", 2);

            String kysimus = read[0];
            String vastus = "";

            if (read.length > 1) {
                vastus = read[1];
            }

            System.out.println();
            System.out.println("Kaart " + (i + 1) + ":");
            System.out.println(kysimus);

            System.out.println();
            System.out.print("Vastuse nägemiseks vajuta Enter...");
            sc.nextLine();

            System.out.println(vastus);

            if (i < plokid.size() - 1) {
                System.out.println();
                System.out.print("Järgmise kaardi jaoks vajuta Enter...");
                sc.nextLine();
            }
        }
    }
}