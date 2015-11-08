package javase07.t01_1;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Bank extends Thread {

    private StringBuilder operations=new StringBuilder();

    public void loadFile() {
        FileReader fileReader = null;
        try {
            Thread.sleep(5_000);
            fileReader = new FileReader("src//main//java//javase07//t01_2//Operations.txt");
            int content;
            while ((content = fileReader.read()) != -1) {
                operations.append((char) content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

    public void operations() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            bankAccounts.put(i, new BankAccount());
        }

        String[] commands = operations.toString().split("\n");

        for (String command : commands)
        {
            command = command.replaceAll("\r", "");
            String[] splitCommand = command.split(" ");
            if(Integer.parseInt(splitCommand[0])<2){
                switch (splitCommand[1])
                {
                    case "deposit:":
                       new Deposit(bankAccounts.get(Integer.parseInt(splitCommand[0])), Double.parseDouble(splitCommand[2]));
                        break;
                    case "sendMoney:":
                        int num1= Integer.parseInt(splitCommand[0]);
                        int num2 = Integer.parseInt(splitCommand[4]);
                        double value = Double.parseDouble(splitCommand[2]);
                        new SendMoney(bankAccounts.get(num1), bankAccounts.get(num2), value);
                        break;
                    case "withdraw:":
                        new Withdraw(bankAccounts.get(Integer.parseInt(splitCommand[0])), Double.parseDouble(splitCommand[2]));
                        break;
                    default:
                        System.out.println("Command not found!");
                        break;
                }
            }
        }

        Thread.sleep(25_000);
        System.out.println();
        System.out.println("Account history:");
        for (int i = 0; i < 2; i++) {
            System.out.println(bankAccounts.get(i).getAccountHistory());
        }
    }
}