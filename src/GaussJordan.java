import java.util.Arrays;

public class GaussJordan {

    double mac[][];
    double prawa[];

    double a;

    public GaussJordan(double[][] mac, double[] prawa) {
        this.mac = mac;
        this.prawa = prawa;
    }

//    public GaussJordan() {
//    }

    public void licz() {

        for (int i = 0; i < prawa.length; i++) {
            for (int j = 0; j < prawa.length; j++) {
                if (i != j) {
                    double w = mac[j][i] / mac[i][i];
                    for (int k = 0; k < prawa.length; k++) {
                        mac[j][k] -= w * mac[i][k];
                    }
                    prawa[j] -= prawa[i] * w;
                }
            }
        }

//        for (int i = 0; i < prawa.length; i++) {
//            for (int j = 0; j < prawa.length; j++) {
//
//                if (j == i) continue;
//                double w = mac[j][i] / mac[i][i];
//                for (int k = 0; k < prawa.length; k++) {
//                    mac[j][k] -= w * mac[i][k];
//                }
//            }
//        }


        for (int i = 0; i < prawa.length; i++) {
            prawa[i] /= mac[i][i];
        }

        System.out.println();
        System.out.println("Szukane temperatury:");
        System.out.print("{");
        for (int i = 0; i < prawa.length; i++) {
            System.out.print(prawa[i] + " ");

        }
        System.out.println("}");
    }

    public void gaussJordans(double[][] tab, double[] PG, int width, int height) {
        double[][] merged = new double[width][width + 1];
//        merged = tab;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (j == width - 1) {
                    System.out.println(j);
//                    merged[i][j+1] = PG[i];
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (j == i) continue;
                double w = merged[j][i] / merged[i][i];
                for (int k = 0; k < height; k++) {
                    merged[j][k] -= w * merged[i][k];
                }
            }
        }
//        System.out.println(Arrays.deepToString(merged));

    }
}