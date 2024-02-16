package _11_DefiningClasses_Lab._03_BankAccount;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Map<Integer, BankAccount> accounts = new LinkedHashMap<>();

        while (!"End".equals(tokens[0])) {
            String command = tokens[0];
            DecimalFormat format = new DecimalFormat("#.##");

            switch (command) {
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getID(), account);
                    System.out.println("Account ID" + account.getID() + " created");
                    break;

                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);

                    if (accounts.size() >= id) {
                        accounts.get(id).deposit(amount);
                        System.out.printf("Deposited %s to ID%d%n",
                                format.format(amount),
                                id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;

                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;

                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (accounts.size() >= id) {
                        System.out.printf("%.2f%n",
                                accounts.get(id).getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            tokens = scanner.nextLine().split("\\s+");
        }
    }
}
