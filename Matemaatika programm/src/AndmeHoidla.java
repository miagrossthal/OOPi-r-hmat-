import java.io.File;
import java.util.*;

public class AndmeHoidla {

    public static List<TestiTeema> loeTestiTeemad(String failiNimi) throws Exception {
        Map<String, List<Kusimus>> teemadMap = new HashMap<>();

        Scanner sc = new Scanner(new File(failiNimi));

        while (sc.hasNextLine()) {
            String rida = sc.nextLine();
            String[] osad = rida.split(";");

            String teemaNimi = osad[0];
            String kysimus = osad[1];
            String vastus = osad[2];

            Kusimus k = new OigeVaarKusimus(kysimus, vastus);

            // Kui teemat veel pole, loo uus list
            if (!teemadMap.containsKey(teemaNimi)) {
                teemadMap.put(teemaNimi, new ArrayList<>());
            }

            teemadMap.get(teemaNimi).add(k);
        }

        sc.close();

        // Muudame mapi listiks
        List<TestiTeema> teemad = new ArrayList<>();

        for (String nimi : teemadMap.keySet()) {
            teemad.add(new TestiTeema(
                    nimi,
                    "Teema: " + nimi,
                    teemadMap.get(nimi)
            ));
        }

        return teemad;
    }
}