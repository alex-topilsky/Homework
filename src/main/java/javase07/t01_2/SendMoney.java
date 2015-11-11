package javase07.t01_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SendMoney implements Runnable {

    BankAccount bankAccountSender;
    BankAccount bankAccountRecipient;
    double deposit;
    Lock lock = new ReentrantLock();

    SendMoney(BankAccount bankAccountSender, BankAccount bankAccountRecipient, double deposit) {
        this.bankAccountSender = bankAccountSender;
        this.bankAccountRecipient = bankAccountRecipient;
        this.deposit = deposit;
        new Thread(this, "SendMoney " + bankAccountSender.getId()).start();
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
            bankAccountSender.withdraw(deposit);
            bankAccountRecipient.deposit(deposit);
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

