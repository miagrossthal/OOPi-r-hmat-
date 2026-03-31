
/**************************************************************************
 * Objektorienteeritud programmeerimine LTAT.03.003 2025/2026 kevadsemester
 * Rühmatöö nr 1
 * Teema: Matemaatika rakendus
 * Autorid: Mia Grossthal, Joosep-Gre Kallaste
 **************************************************************************/


/**
 * Programmi käivitusklass.
 * Klass algatab rakenduse töö ja luuakse MatemaatikaRakendus objekt.
 */

public class Main {
    public static void main(String[] args) {
        MatemaatikaRakendus rakendus = new MatemaatikaRakendus();
        rakendus.kaivita();
    }
}