public class Main {

    public static void main(String[] args) {
        GlobalData globalData = new GlobalData();
        globalData.loadData();
        globalData.showData();

        Grid grid = new Grid();
        grid.generateNodes();
        grid.printNodes();

        grid.generateElements();
        grid.printElements();

        grid.generateGlobalMatrix();
        grid.printGlobalMatrix();

        grid.fillGlobalMatrix();
        grid.printGlobalMatrix();

        grid.fillGlobalVector();
        grid.printGlobalVector();

        GaussJordan gaussJordan = new GaussJordan(grid.HG, grid.PG);
        gaussJordan.calculate();

    }
}
