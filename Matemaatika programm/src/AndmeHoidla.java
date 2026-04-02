/**
 * AndmeHoidla loeb küsimused tekstifailist ja jaotab need teemade kaupa.
 * Siin valmistatakse ette nii testi- kui kordamisteemad.
 */


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AndmeHoidla {

    /**
     * Otstarve: Loob testiteemad failist loetud andmete põhjal.
     * Antud: Faili nimi .
     * Tulemus: List testiteemadest koos küsimustega.
     */
    public static List<TestiTeema> looTestiTeemad(String failiNimi) {
        List<TestiTeema> teemad = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(failiNimi));

            String tyyp = "";
            String kysimus = "";
            String vastus = "";

            while (sc.hasNextLine()) {
                String rida = sc.nextLine().trim();

                if (rida.isEmpty()) {
                    continue;
                }

                // '---' tähendab, et üks küsimuse blokk sai läbi.
                if (rida.equals("---")) {
                    if (!tyyp.isEmpty() && !kysimus.isEmpty() && !vastus.isEmpty()) {
                        Kusimus uusKusimus = new TekstKusimus(kysimus, vastus);
                        lisaKusimusTeemasse(teemad, tyyp, uusKusimus);
                    }

                    tyyp = "";
                    kysimus = "";
                    vastus = "";
                    continue;
                }

                if (rida.startsWith("TÜÜP:")) {
                    tyyp = rida.substring(5).trim();
                } else if (rida.startsWith("KÜSIMUS:")) {
                    kysimus = rida.substring(8).trim();
                } else if (rida.startsWith("VASTUS:")) {
                    vastus = rida.substring(7).trim();
                }
            }
            // On vajalik juhuks kui viimane küsimuste blokk ei lõppe '---'.
            if (!tyyp.isEmpty() && !kysimus.isEmpty() && !vastus.isEmpty()) {
                Kusimus uusKusimus = new TekstKusimus(kysimus, vastus);
                lisaKusimusTeemasse(teemad, tyyp, uusKusimus);
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Viga faili lugemisel: " + e.getMessage());
        }

        return teemad;
    }

    /**
     * Otstarve: Loob kordamisteemad failist loetud andmete põhjal.
     * Antud: Faili nimi.
     * Tulemus: List kordamisteemadest koos kokkuvõtetega.
     */
    public static List<KordamisTeema> looKordamiseTeemad(String failiNimi) {
        List<KordamisTeema> teemad = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(failiNimi));

            String tyyp = "";
            String kysimus = "";
            String vastus = "";

            while (sc.hasNextLine()) {
                String rida = sc.nextLine().trim();

                if (rida.isEmpty()) {
                    continue;
                }

                if (rida.equals("---")) {
                    if (!tyyp.isEmpty() && !kysimus.isEmpty() && !vastus.isEmpty()) {
                        lisaKordamiseTeemasse(teemad, tyyp, kysimus, vastus);
                    }

                    tyyp = "";
                    kysimus = "";
                    vastus = "";
                    continue;
                }

                if (rida.startsWith("TÜÜP:")) {
                    tyyp = rida.substring(5).trim();
                } else if (rida.startsWith("KÜSIMUS:")) {
                    kysimus = rida.substring(8).trim();
                } else if (rida.startsWith("VASTUS:")) {
                    vastus = rida.substring(7).trim();
                }
            }

            if (!tyyp.isEmpty() && !kysimus.isEmpty() && !vastus.isEmpty()) {
                lisaKordamiseTeemasse(teemad, tyyp, kysimus, vastus);
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Viga faili lugemisel: " + e.getMessage());
        }

        return teemad;
    }

    /**
     * Otstarve: Lisab küsimuse õigesse testiteemasse.
     * Antud: teemade list, teema nimi ja küsimus.
     * Tulemus: küsimus lisatakse olemasolevasse või uude teemasse.
     */
    private static void lisaKusimusTeemasse(List<TestiTeema> teemad, String teemaNimi, Kusimus kusimus) {
        TestiTeema teema = leiaTestiTeema(teemad, teemaNimi);

        // Teed uue teema ja lisad küsimuse sinna.
        if (teema == null) {
            List<Kusimus> kysimused = new ArrayList<>();
            kysimused.add(kusimus);
            teema = new TestiTeema(teemaNimi, "Testi teema: " + teemaNimi, kysimused);
            teemad.add(teema);
        // Juhul kui teema on juba olemas siis lisan küsimuse sinna teemasse.
        } else {
            teema.getKysimused().add(kusimus);
        }
    }

    /**
     * Otstarve: Lisab küsimuse kordamisteemasse.
     * Antud: teemade list, teema nimi, küsimus ja vastus.
     * Tulemus: küsimus lisatakse või liidetakse olemasoleva kokkuvõttega.
     */
    private static void lisaKordamiseTeemasse(List<KordamisTeema> teemad, String teemaNimi, String kysimus, String vastus) {
        KordamisTeema teema = leiaKordamisTeema(teemad, teemaNimi);
        // teeb ühest küsimusest ploki
        String uusRida = kysimus + "\n" + vastus;

        if (teema == null) {
            teema = new KordamisTeema(teemaNimi, "Kordamise teema: " + teemaNimi, uusRida);
            teemad.add(teema);
        // Juhul kui küsimus kuulub samasse teemasse siis lisatakse küsimus sinna plokki.
        } else {
            String vana = teema.getKokkuvote();
            teema.setKokkuvote(vana + "\n\n" + uusRida);
        }
    }


    /**
     * Otstarve: Leiab testiteema nime järgi.
     * Antud: teemade list ja teema nimi.
     * Tulemus: vastav TestiTeema või null.
     */
    private static TestiTeema leiaTestiTeema(List<TestiTeema> teemad, String nimi) {
        for (int i = 0; i < teemad.size(); i++) {
            if (teemad.get(i).getNimi().equalsIgnoreCase(nimi)) {
                return teemad.get(i);
            }
        }
        return null;
    }

    /**
     * Otstarve: Leiab kordamisteema nime järgi.
     * Antud: teemade list ja teema nimi.
     * Tulemus: vastav KordamisTeema või null.
     */
    private static KordamisTeema leiaKordamisTeema(List<KordamisTeema> teemad, String nimi) {
        for (int i = 0; i < teemad.size(); i++) {
            if (teemad.get(i).getNimi().equalsIgnoreCase(nimi)) {
                return teemad.get(i);
            }
        }
        return null;
    }
}