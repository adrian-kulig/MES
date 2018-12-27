public class Node {
    double x;
    int id;

    //    0 -- brak warunkow brzegowych
    //    1 -- warunek brzegowy na początku
    //    2 -- warunki brzegowe na koncu (t otoczenia * s ) => konwekcja
    int BC = 1;


    public Node(int id, double x, int BC) {
        this.id  = id;
        this.x = x;
        this.BC = BC;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getBC() {
        return BC;
    }

    public void setBC(int BC) {
        this.BC = BC;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Node{ " +
                "ID=" + id +
                ", x=" + x +
                ", BC=" + BC + " " +
                 '}';
    }
}
