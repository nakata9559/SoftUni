package _00_MoreExercises._01_BasicSyntax_ConditionalStatements_And_Loops_MoreExc;

import java.util.Scanner;

public class _03_GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        double currentBalance = balance;
        double totalSpent = 0;

        String input = scanner.nextLine();

        while (!input.equals("Game Time")) {
            switch (input) {
                case "OutFall 4":
                    if (currentBalance >= 39.99) {
                        System.out.println("Bought " + input);
                        currentBalance -= 39.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "CS: OG":
                    if (currentBalance >= 15.99) {
                        System.out.println("Bought " + input);
                        currentBalance -= 15.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "Zplinter Zell":
                    if (currentBalance >= 19.99) {
                        System.out.println("Bought " + input);
                        currentBalance -= 19.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "Honored 2":
                    if (currentBalance >= 59.99) {
                        System.out.println("Bought " + input);
                        currentBalance -= 59.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "RoverWatch":
                    if (currentBalance >= 29.99) {
                        System.out.println("Bought " + input);
                        currentBalance -= 29.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "RoverWatch Origins Edition":
                    if (currentBalance >= 39.99) {
                        System.out.println("Bought " + input);
                        currentBalance -= 39.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                default:
                    System.out.println("Not Found");
                    break;
            }


            if (currentBalance <= 0) {
                System.out.println("Out of money!");
                break;
            }

            input = scanner.nextLine();
        }

        if (currentBalance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", balance - currentBalance, currentBalance);
        }
    }
}
