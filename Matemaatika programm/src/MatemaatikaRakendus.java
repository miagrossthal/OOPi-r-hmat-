/**
 * Rakenduse põhiklass, mis haldab menüüd ja suunab kasutaja
 * kas kordamismoodulisse või testimoodulisse.
 */

import java.util.List;
import java.util.Scanner;

public class MatemaatikaRakendus {
    private KordamisMoodul kordamisMoodul;
    private TestiMoodul testiMoodul;

    public MatemaatikaRakendus() {
        List<KordamisTeema> kordamiseTeemad = AndmeHoidla.looKordamiseTeemad("matemaatiline_loogika.txt");
        List<TestiTeema> testiTeemad = AndmeHoidla.looTestiTeemad("matemaatiline_loogika.txt");

        kordamisMoodul = new KordamisMoodul(kordamiseTeemad);
        testiMoodul = new TestiMoodul(testiTeemad);
    }

    public void kaivita() {
        Scanner sc = new Scanner(System.in);
        boolean tooTab = true;

        while (tooTab) {
            System.out.println();
            System.out.println("===== MENÜÜ =====");
            System.out.println("1 - Kordamine");
            System.out.println("2 - Testi lahendamine");
            System.out.println("0 - Välju");
            System.out.print("Valik: ");

            int valik = loeArv(sc);

            if (valik == 1) {
                avaKordamine(sc);
            } else if (valik == 2) {
                avaTest(sc);
            } else if (valik == 0) {
                tooTab = false;
                System.out.println("Head aega!");
            } else {
                System.out.println("Vale valik.");
            }
        }
    }

    private void avaKordamine(Scanner sc) {
        System.out.println();
        System.out.println("===== KORDAMINE =====");
        kordamisMoodul.kuvaTeemad();
        System.out.print("Vali teema number: ");

        int teemaNr = loeArv(sc);
        kordamisMoodul.kuvaTeema(teemaNr - 1, sc);
    }

    private void avaTest(Scanner sc) {
        System.out.println();
        System.out.println("===== TEST =====");
        testiMoodul.kuvaTeemad();
        System.out.print("Vali teema number: ");

        int teemaNr = loeArv(sc);
        testiMoodul.alustaTest(teemaNr - 1, sc);
    }

    private int loeArv(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Palun sisesta arv: ");
            sc.nextLine();
        }
        int arv = sc.nextInt();
        sc.nextLine();
        return arv;
    }
}