package javase02.t02_03_04.stationery;

public class PrintingPaper extends PaperSupplies {
    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    private int numberOfSheets;

    PrintingPaper() {
        super();
        this.numberOfSheets = 500;
    }

    PrintingPaper(int cost, String name, Format format, int numberOfSheets) {
        super(cost, name, format);
        this.numberOfSheets = numberOfSheets;
    }
}