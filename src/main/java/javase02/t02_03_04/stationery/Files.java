package javase02.t02_03_04.stationery;

public class Files extends ArchivalSupplies {
    int quantity;

    Files() {
        super();
        this.quantity = 100;
    }

    Files(int cost, String name, Format format, int quantity) {
        super(cost, name, format);
        this.quantity = quantity;
    }
}
