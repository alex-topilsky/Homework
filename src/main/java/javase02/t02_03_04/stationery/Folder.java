package javase02.t02_03_04.stationery;

public class Folder extends ArchivalSupplies {
    public enum Type {
        CARDBOARD,
        PLASTIC
    }

    private Type type;

    private Format format;

    public Folder() {
        super();
        this.type = type.CARDBOARD;
    }

    public Folder(int cost, String name, Format format, Type type) {
        super(cost, name, format);
        this.type = type;
    }
}