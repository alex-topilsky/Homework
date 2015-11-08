package javase07.t01_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount{
    private int id;
    private static int numberId = 0;
    private StringBuilder accountHistory;
    private double balance;
    private Lock lock = new ReentrantLock();

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public StringBuilder getAccountHistory() {
        return accountHistory;
    }

    BankAccount() {
        setId();
        this.balance = 0;
        accountHistory = new StringBuilder();
        accountHistory.append("ID: "+this.getId());
        accountHistory.append(" Balance: "+this.getBalance() + "\n");
    }

     private void setId() {
        this.id = numberId;
        numberId++;
    }

     public void deposit(double deposit) {
         try {
             lock.lock();
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
        if (deposit > 0) {
            this.balance += deposit;
            accountHistory.append("deposit: " + deposit+ '\n');
            accountHistory.append("Balance now:" + getBalance() + '\n');
            System.out.println("На счет внесено: " + deposit);
        } else {
            System.out.println("Нельзя вносить отрицательную сумму!");
            accountHistory.append("try deposit: " + deposit+ '\n');
            accountHistory.append("Balance now:" + getBalance() + '\n');
        }
         } catch (Exception e) {
             e.fillInStackTrace();
         } finally {
             lock.unlock();
         }
    }

     public void sendMoney(double value, BankAccount accountRecipient) {
         try {
             lock.lock();
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

        if (this.getBalance() >= value && value > 0) {
            accountRecipient.receiveMoney(value, this.getId());
            accountHistory.append("sendMoney: " + value + " to " + accountRecipient.getId()+ '\n');
            accountHistory.append("Balance now:" + getBalance() + '\n');
            System.out.println("Отправлен перевод в размере " + value + " на счет " + accountRecipient.getId());
        } else {
            System.out.println("Нельзя переводить отрицательную сумму!");
            accountHistory.append("try sendMoney: " + value + " to " + accountRecipient.getId()+ '\n');
            accountHistory.append("Balance now:" + getBalance() + '\n');
        }
         } catch (Exception e) {
             e.fillInStackTrace();
         } finally {
             lock.unlock();
         }
    }

     private void receiveMoney(double value, int id) {
        try {
            lock.lock();
        try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
        this.balance += value;
        accountHistory.append("receiveMoney: " + value + " from " + id+ '\n');
        accountHistory.append("Balance now:" + getBalance() + '\n');
        System.out.println("Поступил перевод в размере " + value + " со счета " + id);
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }
    }

     public void withdraw(double value) {
        try {
            lock.lock();
        try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
        if (value > 0 && this.getBalance()>=value) {
            this.balance -= value;
            accountHistory.append("withdraw: " + value+ '\n');
            accountHistory.append("Balance now:" + getBalance() + '\n');
            System.out.println("Со счета снято: " + value);
        } else{
            System.out.println("Нельзя снимать отрицательную сумму!");
            accountHistory.append("try withdraw: " + value+ '\n');
            accountHistory.append("Balance now:" + getBalance() + '\n');
        }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
