package javase07.t01_1;
public class BankAccount {
    private int id;
    private static int numberId = 0;
    private StringBuilder accountHistory;
    private double balance;
    public volatile boolean balanceKeep = false;

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
        accountHistory.append("ID: " + this.getId());
        accountHistory.append(" Balance: " + this.getBalance() + "\n");
    }

    synchronized private void setId() {
        this.id = numberId;
        numberId++;
    }

    public void deposit(double deposit) {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (deposit > 0) {
            this.balance += deposit;
            accountHistory.append("Вклад: " + deposit + '\n');
            accountHistory.append("Текущий баланс:" + getBalance() + '\n');
            System.out.println("На счет внесено: " + deposit);
        } else {
            System.out.println("Нельзя вносить отрицательную сумму!");
            accountHistory.append("Попытка внести: " + deposit + '\n');
            accountHistory.append("Текущий баланс:" + getBalance() + '\n');
        }
    }

    public void withdraw(double value) {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (value > 0 && this.getBalance() >= value) {
            this.balance -= value;
            accountHistory.append("Снято: " + value + '\n');
            accountHistory.append("Текущий баланс:" + getBalance() + '\n');
            System.out.println("Со счета снято: " + value);
        } else {
            System.out.println("Нельзя снимать отрицательную сумму!");
            accountHistory.append("Неудачная попытка снять: " + value + '\n');
            accountHistory.append("Текущий баланс:" + getBalance() + '\n');
        }
    }
}
