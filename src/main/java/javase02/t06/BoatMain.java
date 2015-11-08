package javase02.t06;

    /*
    Разработайте класс АтомнаяЛодка, создайте внутренний класс – ДвигательДляАтомнойЛодки.
    Создайте объект АтомнаяЛодка и “запустите его в плавание”.
    */
public class BoatMain {
    public static void main(String... arg){
        Uranium uranium = new Uranium(10, 235);
        NuclearBoat nuclearBoat = new NuclearBoat();

        nuclearBoat.fillBoat(uranium);
        nuclearBoat.startButton();
    }
}
