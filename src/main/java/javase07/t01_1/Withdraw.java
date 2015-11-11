package javase07.t01_1;

public class Withdraw implements Runnable{

    BankAccount bankAccount;
    double deposit;

    Withdraw(BankAccount bankAccount, double deposit)
    {
        this.bankAccount = bankAccount;
        this.deposit = deposit;
        new Thread(this, "Withdraw " + bankAccount.getId()).start();
    }

    public void run()
    {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (bankAccount) {
            bankAccount.withdraw(deposit);
        }
    }
}
