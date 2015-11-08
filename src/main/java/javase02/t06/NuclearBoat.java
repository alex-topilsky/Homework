package javase02.t06;

public class NuclearBoat {
    private Engine engine;
    private FuelTank fuelTank;

    public NuclearBoat() {
        engine = new Engine();
        fuelTank = new FuelTank();
    }

    public void fillBoat(Uranium enrichedUranium) {
        fuelTank.fill(enrichedUranium);
    }

    public void startButton() {
        engine.start(fuelTank.getUranium());
    }

    private class Engine {
        private void start(Uranium uranium) {
            while (uranium.spend() == 1) {
                System.out.println("Корабль движется, израсходованн 1 кг урана");
            }
            System.out.println("Уран закончился! Корабль остановился!");
        }
    }

    private class FuelTank {
        private Uranium uranium;

        private FuelTank() {
            System.out.println("Топливный бак пуст");
            uranium = null;
        }

        private void fill(Uranium uranium) {
            System.out.println("Топливный бак заправлен. Теперь он содержит " + uranium.getValue() + " кг урана");
            this.uranium = uranium;
        }

        private Uranium getUranium() {
            return this.uranium;
        }
    }
}