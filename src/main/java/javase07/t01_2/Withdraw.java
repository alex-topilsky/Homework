package javase07.t01_2;

public class Withdraw implements Runnable {
    BankAccount bankAccount;
    double deposit;

    Withdraw(BankAccount bankAccount, double deposit) {
        this.bankAccount = bankAccount;
        this.deposit = deposit;
        new Thread(this, "Withdraw " + bankAccount.getId()).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.withdraw(deposit);
    }
}
