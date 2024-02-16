package _11_NestedLoops_Lab;

import java.util.Scanner;

public class _05_Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            double requiredMoney = Double.parseDouble(scanner.nextLine());
            double savedMoney = 0;

            while (savedMoney < requiredMoney) {
                savedMoney += Double.parseDouble(scanner.nextLine());
            }

            System.out.println("Going to " + command + "!");
            command = scanner.nextLine();

        }
    }
}
