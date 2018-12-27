import java.io.File;
import java.util.Scanner;

public class GlobalData {
    static double S = 0; // przekrój
    static double K = 0; // współczynnik przewodzenia cieplnego
    static double L = 0; // długość prenta
    static double alfa = 0; // współczynnik wymiany temperatury poprzez konwekcje
    static double tInfinity = 0;  // temperatura otoczenia
    static int nH = 0; // liczba węzłów
    static int nE = 0; // liczba elementów
    static double q = 0; // strumień ciepła

    public void loadData() {
        try {
            Scanner scaner = new Scanner(new File("data.txt"));

            S = scaner.nextDouble();
            scaner.nextLine();
            K = scaner.nextDouble();
            scaner.nextLine();
            L = scaner.nextDouble();
            scaner.nextLine();
            alfa = scaner.nextDouble();
            scaner.nextLine();
            tInfinity = scaner.nextDouble();
            scaner.nextLine();
            nH = scaner.nextInt();
            scaner.nextLine();
            q = scaner.nextDouble();
            scaner.nextLine();

            scaner.close();

            nE = (nH - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    public void showData() {
        System.out.println("Wczytane dane");
        System.out.println("Przekrój S : " + S);
        System.out.println("Współczynnik przewodzenia ciepła K : " + K);
        System.out.println("Długość prenta L : " + L);
        System.out.println("Współczynnik wymiany temperatury poprzez konwekcje : " + alfa);
        System.out.println("Temperatura otoczenia : " + tInfinity);
        System.out.println("Liczba węzłów : " + nH);
        System.out.println("Liczba elementów : " + nE);
        System.out.println("Strumień ciepła : " + q);
        System.out.println("");

    }
}
