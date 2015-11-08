package javase07.t01_2;

public class Main {
    /*
    В текстовом (или xml) файле содержится информация о переводах средств со счета на счет.
    Создайте приложение, позволяющее в параллельном режиме обработать эту информацию
    (счета в приложении представляются собой объекты).

    Синхронизируйте код приложения используя  библиотеку java.util.concurrent (2 вариант).
    */

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        bank.loadFile();
        bank.operations();
    }
}
