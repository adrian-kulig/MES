import java.util.Arrays;

public class GaussJordan {

    public GaussJordan() {}

    public void calculate(double[][] matrix2D, double[] vector) {

        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                if (i != j) {
                    double w = matrix2D[j][i] / matrix2D[i][i];
                    for (int k = 0; k < vector.length; k++) {
                        matrix2D[j][k] -= w * matrix2D[i][k];
                    }
                    vector[j] -= vector[i] * w;
                }
            }
        }

        for (int i = 0; i < vector.length; i++) {
            vector[i] /= matrix2D[i][i];
        }

        System.out.println();
        System.out.println("T E M P E R A T U R Y    K O N C O W E: ");
        System.out.println(Arrays.toString(vector));
    }
}