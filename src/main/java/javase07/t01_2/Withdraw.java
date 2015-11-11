package javase07.t01_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Withdraw implements Runnable {
    BankAccount bankAccount;
    double deposit;
    private Lock lock = new ReentrantLock();
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

        try {
            lock.lock();
            bankAccount.withdraw(deposit);
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
