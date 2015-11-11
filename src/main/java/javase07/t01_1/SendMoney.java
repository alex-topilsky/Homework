package javase07.t01_1;

public class SendMoney implements Runnable {

    BankAccount bankAccountSender;
    BankAccount bankAccountRecipient;
    double deposit;

    SendMoney(BankAccount bankAccountSender, BankAccount bankAccountRecipient, double deposit) {
        this.bankAccountSender = bankAccountSender;
        this.bankAccountRecipient = bankAccountRecipient;
        this.deposit = deposit;
        new Thread(this, "SendMoney " + bankAccountSender.getId()).start();
    }

    public void run() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int hashAcc1 = bankAccountSender.hashCode();
        int hashAcc2 = bankAccountRecipient.hashCode();
        BankAccount bankAccount1 = null;
        BankAccount bankAccount2 = null;

        if (hashAcc1 < hashAcc2) {
            bankAccount1 = bankAccountRecipient;
            bankAccount2 = bankAccountSender;
        } else {
            bankAccount2 = bankAccountRecipient;
            bankAccount1 = bankAccountSender;
        }

        synchronized (bankAccount1) {
            synchronized (bankAccount2) {
                bankAccountSender.withdraw(deposit);
                bankAccountRecipient.deposit(deposit);
            }
        }
    }
}

