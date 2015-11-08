package javase02.t02_03_04.stationery;

public abstract class PaperSupplies extends Stationery {
    public enum Format {
        A3,
        A4,
        A5
    }

    public Format getFormat() {
        return format;
    }

    private Format format;

    PaperSupplies() {
        super();
        this.format = Format.A4;
    }

    PaperSupplies(int cost, String name, Format format) {
        super(cost, name);
        this.format = format;
    }
}
