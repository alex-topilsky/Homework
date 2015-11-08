package javase02.t07;

/**
 * Класс для создания обогащенного урана
 */
public class Uranium {

    int value;
    int type;

    /**
     * Возвращает количество урана
     *
     * @return количество урана
     */
    public int getValue() {
        return value;
    }

    /**
     * Конструктор класса
     */
    public Uranium() {
        this.type = 235;
        this.value = 1;
        System.out.println("Было создано " + value + " кг урана-" + type);
    }

    /**
     * Конструктор класса
     *
     * @param value количество урана
     * @param type  тип урана
     */
    public Uranium(int value, int type) {
        this.value = value;
        this.type = type;
        System.out.println("Было создано " + this.value + " кг урана-" + this.type);
    }

    /**
     * Метод позволяет тратить уран
     *
     * @return потраченный уран
     */
    public int spend() {
        if (this.value > 0) {
            this.value--;
            return 1;
        } else {
            return 0;
        }
    }
}
