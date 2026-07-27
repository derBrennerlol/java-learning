import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Perceptron {
    public static void main(String[] args){
        double w1 = 3.0;
        double w2 = 1.0;
        double threshold = 12.0;

        /** Try-catch Block um zu testen ob die Datei wirklich existiert und nicht blockiert ist */
        try {
            /** Java zeigen mit welcher Datei wir arbeiten wollen */
            File logFile = new File("src/02_login_perceptron/logins.txt"); 
            Scanner scanner = new Scanner(logFile);

            System.out.println("--- Starte Log-Analyse ---");

            /** Datei lesen und nach Zeilen schauen */
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); /** nach jedem Zeilenumnbruch "\n" wird die zeile in Line gespeichert */
                String[] parts = line.split("\\|");
                double x1 = Double.parseDouble(parts[3].split("=")[1].trim());
                double x2 = Double.parseDouble(parts[4].split("=")[1].trim());
                double sum = (x1 * w1) + (x2 * w2);
                if (sum >= threshold) {
                    System.out.println("🚨 ALARM [Score: " + sum + "] -> " + line);
                } else {
                    System.out.println("✅ OK    [Score: " + sum + "] -> " + line);
                }
            }

            scanner.close(); /** Ganz wichtig!! Datei wird für das OS wieder frei gealassen, meidet Resource Leaks vor */

        } catch (FileNotFoundException e) {
            System.out.println("❌ Fehler: Die Datei 'logins.txt' wurde nicht gefunden!");
        }
    }
}
