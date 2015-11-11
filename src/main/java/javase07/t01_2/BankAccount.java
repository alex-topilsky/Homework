package javase07.t01_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount{
    private int id;
    private static int numberId = 0;
    private StringBuilder accountHistory;
    private double balance;

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
    }

     public void withdraw(double value) {
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
    }
}
