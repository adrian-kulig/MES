import java.util.Arrays;

public class Element {
    int ID;
    Node node1; // obiekt Node
    Node node2; // obiekt node

    double[][] HL = new double[2][2]; // lokalna macierz pojemności cieplnej
    double[] PL = new double[2]; // lokalny wektor obciążeń


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
