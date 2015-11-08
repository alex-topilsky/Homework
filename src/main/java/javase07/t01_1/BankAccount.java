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

    synchronized public void deposit(double deposit) {
        while (balanceKeep) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balanceKeep = true;
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
        balanceKeep = false;
        notifyAll();
    }

    synchronized public void sendMoney(double value, BankAccount accountRecipient) {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (balanceKeep && accountRecipient.balanceKeep) {
            try {
                wait();
                accountRecipient.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balanceKeep = true;
        accountRecipient.balanceKeep = true;

        if (this.getBalance() >= value && value > 0) {
            this.balance -= value;
            accountRecipient.receiveMoney(value, this.getId());
            accountHistory.append("Отправленно: " + value + " to " + accountRecipient.getId() + '\n');
            accountHistory.append("Текущий баланс:" + getBalance() + '\n');
            System.out.println("Отправлен перевод в размере " + value + " на счет " + accountRecipient.getId());
        } else {
            System.out.println("Нельзя переводить отрицательную сумму!");
            accountHistory.append("Неудачная попытка отправить: " + value + " на счет " + accountRecipient.getId() + '\n');
            accountHistory.append("Текущий баланс:" + getBalance() + '\n');
        }
        balanceKeep = false;
        accountRecipient.balanceKeep = false;
        notifyAll();
        accountRecipient.notifyAll();
    }

    synchronized private void receiveMoney(double value, int id) {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance += value;
        accountHistory.append("Получено: " + value + " от " + id + '\n');
        accountHistory.append("Текущий баланс:" + getBalance() + '\n');
        System.out.println("Поступил перевод в размере " + value + " со счета " + id);
    }

    synchronized public void withdraw(double value) {
        while (balanceKeep) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balanceKeep = true;

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
        balanceKeep = false;
        notifyAll();
    }
}
