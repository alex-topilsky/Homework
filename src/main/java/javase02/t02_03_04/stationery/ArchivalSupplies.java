package javase02.t02_03_04.stationery;

public abstract class ArchivalSupplies extends Stationery {
    enum Format {
        A3,
        A4,
        A5
    }

    public Format getFormat() {
        return format;
    }

    private Format format;

    ArchivalSupplies() {
        super();
        this.format = Format.A4;
    }

    ArchivalSupplies(int cost, String name, Format format) {
        super(cost, name);
        this.format = format;
    }
}
