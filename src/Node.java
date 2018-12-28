public class Node {
    double x;
    int id;

    /**
     * BC [0,1,2]
     * 0 - brak warunków brzegowych
     * 1 - warunek brzegowy na początku  =>  ( Q * S )
     * 2 - warunek brzegowy na końcu (konwekcja) =>  ( Alfa * Temp. otoczenia *  S ) * (-1)
     */
    int BC;


    public Node(int id, double x, int BC) {
        this.id = id;
        this.x = x;
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
