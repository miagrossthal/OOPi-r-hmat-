/**
 * Rakenduse põhiklass, mis haldab menüüd ja suunab kasutaja
 * kas kordamismoodulisse või testimoodulisse.
 */

import java.util.List;
import java.util.Scanner;

public class MatemaatikaRakendus {
    private KordamisMoodul loogikaKordamisMoodul;
    private TestiMoodul loogikaTestiMoodul;

    private KordamisMoodul hulgadKordamisMoodul;
    private TestiMoodul hulgadTestiMoodul;

    public MatemaatikaRakendus() {
        // Matemaatilise loogika andmed
        List<KordamisTeema> loogikaKordamiseTeemad =
                AndmeHoidla.looKordamiseTeemad("matemaatiline_loogika.txt");
        List<TestiTeema> loogikaTestiTeemad =
                AndmeHoidla.looTestiTeemad("matemaatiline_loogika.txt");

        // Hulgateooria andmed
        List<KordamisTeema> hulgadKordamiseTeemad =
                AndmeHoidla.looKordamiseTeemad("hulgateooria.txt");
        List<TestiTeema> hulgadTestiTeemad =
                AndmeHoidla.looTestiTeemad("hulgateooria.txt");

        loogikaKordamisMoodul = new KordamisMoodul(loogikaKordamiseTeemad);
        loogikaTestiMoodul = new TestiMoodul(loogikaTestiTeemad);

        hulgadKordamisMoodul = new KordamisMoodul(hulgadKordamiseTeemad);
        hulgadTestiMoodul = new TestiMoodul(hulgadTestiTeemad);
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
        KordamisMoodul valitudMoodul = valiKordamiseAine(sc);

        if (valitudMoodul == null) {
            System.out.println("Sellist ainet ei ole.");
            return;
        }

        System.out.println();
        System.out.println("===== KORDAMINE =====");
        valitudMoodul.kuvaTeemad();
        System.out.print("Vali teema number: ");

        int teemaNr = loeArv(sc);
        valitudMoodul.kuvaTeema(teemaNr - 1, sc);
    }

    private void avaTest(Scanner sc) {
        TestiMoodul valitudMoodul = valiTestiAine(sc);

        if (valitudMoodul == null) {
            System.out.println("Sellist ainet ei ole.");
            return;
        }

        System.out.println();
        System.out.println("===== TEST =====");
        valitudMoodul.kuvaTeemad();
        System.out.print("Vali teema number: ");

        int teemaNr = loeArv(sc);
        valitudMoodul.alustaTest(teemaNr - 1, sc);
    }

    private KordamisMoodul valiKordamiseAine(Scanner sc) {
        System.out.println();
        System.out.println("Vali aine:");
        System.out.println("1 - Matemaatiline loogika");
        System.out.println("2 - Hulgateooria");
        System.out.print("Valik: ");

        int aine = loeArv(sc);

        if (aine == 1) {
            return loogikaKordamisMoodul;
        } else if (aine == 2) {
            return hulgadKordamisMoodul;
        } else {
            return null;
        }
    }

    private TestiMoodul valiTestiAine(Scanner sc) {
        System.out.println();
        System.out.println("Vali aine:");
        System.out.println("1 - Matemaatiline loogika");
        System.out.println("2 - Hulgateooria");
        System.out.print("Valik: ");

        int aine = loeArv(sc);

        if (aine == 1) {
            return loogikaTestiMoodul;
        } else if (aine == 2) {
            return hulgadTestiMoodul;
        } else {
            return null;
        }
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