import java.util.List;
import java.util.Scanner;

public class MatemaatikaRakendus {
    private KordamisMoodul kordamisMoodul;
    private TestiMoodul testiMoodul;

//    public MatemaatikaRakendus() {
//        List<KordamiseTeema> kordamiseTeemad = AndmeHoidla.looKordamiseTeemad();
//        List<TestiTeema> testiTeemad = AndmeHoidla.looTestiTeemad();
//
//        kordamisMoodul = new KordamisMoodul(kordamiseTeemad);
//        testiMoodul = new TestiMoodul(testiTeemad);
//    }

    public void kaivita() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nVali:");
            System.out.println("1 - Kordamine");
            System.out.println("2 - Test");
            System.out.println("0 - Välju");

            int valik = sc.nextInt();
            sc.nextLine();

            if (valik == 1) {
                kordamisMoodul.kuvaTeemad();
                System.out.print("Vali teema: ");
                int t = sc.nextInt() - 1;
                sc.nextLine();
                kordamisMoodul.kuvaTeema(t);
            } else if (valik == 2) {
                testiMoodul.alustaTest(0);
            } else {
                break;
            }
        }
    }
}