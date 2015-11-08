package javase02.t02_03_04.stationery;

public class Notebook extends PaperSupplies {
    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    int numberOfSheets;

    public Notebook() {
        super();
        this.numberOfSheets = 96;
    }

    public Notebook(int cost, String name, Format format, int numberOfSheets) {
        super(cost, name, format);
        this.numberOfSheets = numberOfSheets;
    }
}