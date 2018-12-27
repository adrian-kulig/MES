import java.util.Arrays;

public class Element {
    int ID;
    Node node1;
    Node node2;

    double[][] HL = new double[2][2]; // macierz pojemności cieplnej (LOKALNA)
    double[] PL = new double[2]; // Wektor obciążeń


    public Element(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Element{" +
                "ID=" + ID +
                ", HL=" + Arrays.deepToString(HL) +
                ", PL=" + Arrays.toString(PL) +
                ", node1 = " + node1 +
                ", node2 = " + node2 +
                '}';
    }
}
