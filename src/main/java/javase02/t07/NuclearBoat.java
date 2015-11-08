package javase02.t07;

/**
 * Класс позволяет создавать атомную лодку
 */
@Info(author = "Alex Topilsky", date = "05.10.15")
public class NuclearBoat {
    private Engine engine;
    private FuelTank fuelTank;

    /**
     * Конструктор класса
     */
    public NuclearBoat() {
        engine = new Engine();
        fuelTank = new FuelTank();
    }

    /**
     * Метод позволяет заправить лодку
     *
     * @param enrichedUranium топливо для лодки
     */
    public void fillBoat(Uranium enrichedUranium) {
        fuelTank.fill(enrichedUranium);
    }

    /**
     * Метод запускает лодку в плавание
     */
    public void startButton() {
        engine.start(fuelTank.getUranium());
    }

    /**
     * Класс Мотор
     */
    private class Engine {
        /**
         * Метод перерабатывает полученный уран и движет лодку
         *
         * @param uranium топливо
         */
        private void start(Uranium uranium) {
            while (uranium.spend() == 1) {
                System.out.println("Корабль движется, израсходованн 1 кг урана");
            }
            System.out.println("Уран закончился! Корабль остановился!");
        }
    }

    /**
     * Класс Топливный бак
     */
    private class FuelTank {
        /**
         * Переменная для хранения топлива
         */
        private Uranium uranium;

        /**
         * Конструктор класса
         */
        private FuelTank() {
            System.out.println("Топливный бак пуст");
            uranium = null;
        }

        /**
         * Метод для заправки бака топливом
         *
         * @param uranium топливо
         */
        private void fill(Uranium uranium) {
            System.out.println("Топливный бак заправлен. Теперь он содержит " + uranium.getValue() + " кг урана");
            this.uranium = uranium;
        }

        /**
         * Метод возвращает топливо из бака
         *
         * @return топливо
         */
        private Uranium getUranium() {
            return this.uranium;
        }
    }
}