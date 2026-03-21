import java.util.List;
import java.util.Scanner;

public class TestiMoodul {
    private List<TestiTeema> teemad;

    public TestiMoodul(List<TestiTeema> teemad) {
        this.teemad = teemad;
    }

    public void alustaTest(int indeks) {
        Scanner sc = new Scanner(System.in);
        TestiTeema teema = teemad.get(indeks);

        int punktid = 0;

        for (Kusimus k : teema.getKysimused()) {
            k.kuva();
            System.out.print("Sinu vastus: ");
            String vastus = sc.nextLine();

            if (k.kontrolliVastus(vastus)) {
                punktid++;
            }
        }

        System.out.println("Said punkte: " + punktid);
    }
}