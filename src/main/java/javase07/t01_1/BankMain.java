package javase07.t01_1;

public class BankMain {
    /*
    В текстовом (или xml) файле содержится информация о переводах средств со счета на счет.
    Создайте приложение, позволяющее в параллельном режиме обработать эту информацию
    (счета с приложении представляются собой объекты).
    Синхронизируйте код приложения используя ключевое слово synchronized
     */

    public static void main(String[] args) throws InterruptedException {
        System.out.println("HH");
        Bank bank = new Bank();
        bank.loadFile();
        bank.operations();
    }
}
