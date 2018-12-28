public class Grid {
    Node[] nodes;
    Element[] elements;
    double[][] HG = new double[GlobalData.nH][GlobalData.nH];
    double[] PG = new double[GlobalData.nH];
    double deltaX = (GlobalData.L) / (GlobalData.nH - 1);


    public Grid() {
        this.nodes = new Node[GlobalData.nH];
        this.elements = new Element[GlobalData.nE];
    }


    public void generateNodes() {
        for (int i = 0; i < GlobalData.nH; i++) {
            nodes[i] = new Node(i, i * deltaX, 0);
        }
        nodes[0].BC = 1;
        nodes[GlobalData.nH - 1].BC = 2;
    }


    public void generateElements() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new Element(i);
            elements[i].node1 = nodes[i];
            elements[i].node2 = nodes[i + 1];

            //Wypełnienie macierzy lokalnej
            double elementLength = elements[i].node2.x - elements[i].node1.x;
            double C = (GlobalData.S * GlobalData.K) / elementLength;
            elements[i].HL[0][0] = C;
            elements[i].HL[0][1] = -C;
            elements[i].HL[1][0] = -C;
            elements[i].HL[1][1] = C;

            if (i == elements.length - 1) {
                //dla ostatniego elementu do macierzy lokalnej dodajemy iloczyn (alfa * s)
                elements[i].HL[1][1] = C + GlobalData.alfa * GlobalData.S;
            }

            //wypełnienie wektora obiązeń lokalnego
            elements[i].PL[0] = 0;
            elements[i].PL[1] = 0;


            //Warunek początkowy
            if (i == 0) {
                elements[i].PL[0] = GlobalData.q * GlobalData.S;
            } else if (i == elements.length - 1) {
                // warunek końcowy, dla ostatniego elementu dajemy -1, aby mieć gotowe później do
                // przeniesienia na prawą stronę przy obliczeniu równania
                elements[elements.length - 1].PL[1] = (GlobalData.alfa * GlobalData.tInfinity * GlobalData.S) * -1;
            }
        }
    }


    public void fillGlobalVector() {
        for (int i = 0; i < GlobalData.nE; i++) {
            PG[elements[i].node1.id] += elements[i].PL[0];
            PG[elements[i].node2.id] += elements[i].PL[1];
        }
    }

    public void fillGlobalMatrix() {
        for (int i = 0; i < GlobalData.nE; i++) {
            HG[elements[i].node1.id][elements[i].node1.id] += elements[i].HL[0][0];
            HG[elements[i].node1.id][elements[i].node2.id] += elements[i].HL[0][1];
            HG[elements[i].node2.id][elements[i].node1.id] += elements[i].HL[1][0];
            HG[elements[i].node2.id][elements[i].node2.id] += elements[i].HL[1][1];
        }
    }

    public void generateGlobalMatrix() {
        for (int i = 0; i < GlobalData.nH; i++) {
            for (int j = 0; j < GlobalData.nH; j++) {
                HG[i][j] = 0;
            }
        }
    }


    /**
     * P R I N T    M E T H O D S
     **/
    public void printNodes() {
        System.out.println("N O D E S");

        for (int i = 0; i < GlobalData.nH; i++) {
            System.out.println(nodes[i]);
        }
        System.out.println("");
    }

    public void printGlobalVector() {
        System.out.println("W E K T O R   G L O B A L N Y    O B C I Ą Ż E N: ");
        System.out.print("[ ");

        for (int i = 0; i < GlobalData.nH; i++) {
            System.out.print(" " + PG[i] + ", ");
        }
        System.out.print(" ]");

        System.out.println("");
    }

    public void printElements() {
        System.out.println("E L E M E N T Y");
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
        System.out.println("");
    }

    public void printGlobalMatrix() {
        System.out.println("M A C I E R Z    G L O B A L N A: ");

        for (int i = 0; i < GlobalData.nH; i++) {
            for (int j = 0; j < GlobalData.nH; j++) {
                System.out.print("   " + HG[i][j] + "   ");
            }
            System.out.println("");
            System.out.println("");
        }
        System.out.println("");
    }

}
