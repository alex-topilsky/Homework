package javase02.t07;

/*
Разработайте для класса АтомнаяЛодка из задания 6 (или любого другого класса) аннотацию,
которая могла бы обрабатываться утилитой Javadoc. Аннотируйте класс.
 */

public class NuclearBoatMain {
    public static void main(String... arg) {
        //Создаем 10 кг урана
        Uranium uranium = new Uranium(10, 235);
        //Создаем лодку
        NuclearBoat nuclearBoat = new NuclearBoat();
        //Заправляем лодку ураном
        nuclearBoat.fillBoat(uranium);
        //Запускаем лодку в плавание
        nuclearBoat.startButton();
    }
}
