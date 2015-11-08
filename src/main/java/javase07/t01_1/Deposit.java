package javase07.t01_1;

public class Deposit implements Runnable{

    BankAccount bankAccount;
    double deposit;

    Deposit(BankAccount bankAccount, double deposit)
    {
        this.bankAccount = bankAccount;
        this.deposit = deposit;
        new Thread(this, "Deposit " + bankAccount.getId()).start();
    }
@Override
    public void run()
    {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(deposit);
    }
}
