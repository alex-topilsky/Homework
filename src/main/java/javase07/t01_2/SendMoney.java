package javase07.t01_2;

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

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            bankAccountSender.sendMoney(deposit, bankAccountRecipient);

    }
}

