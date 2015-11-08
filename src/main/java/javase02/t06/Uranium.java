package javase02.t06;

public class Uranium {
    public int getValue() {
        return value;
    }

    int value;
    int type;

    public Uranium() {
        this.type = 235;
        this.value = 1;
        System.out.println("Было создано " + value + " кг урана-" + type);
    }

    public Uranium(int value, int type) {
        this.value = value;
        this.type = type;
        System.out.println("Было создано " + this.value + " кг урана-" + this.type);
    }

    public int spend() {
        if (this.value > 0) {
            this.value--;
            return 1;
        } else {
            return 0;
        }
    }
}
