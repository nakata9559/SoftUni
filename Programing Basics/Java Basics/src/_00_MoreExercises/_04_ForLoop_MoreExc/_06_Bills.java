package _00_MoreExercises._04_ForLoop_MoreExc;

import java.util.Scanner;

public class _06_Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());

        double waterBillPerMonth = 20;
        double internetBillPerMonth = 15;
        double otherBillsPerMonth = 0;

        double totalElectricityBills = 0;
        double totalOtherBills = 0;

        for (int i = 0; i < months; i++) {

            double electricityBillPerMonth = Double.parseDouble(scanner.nextLine());
            otherBillsPerMonth = (electricityBillPerMonth + waterBillPerMonth + internetBillPerMonth) * 1.2;

            totalElectricityBills += electricityBillPerMonth;
            totalOtherBills += otherBillsPerMonth;

        }

        double averageBills = (totalElectricityBills + waterBillPerMonth * months + internetBillPerMonth * months + totalOtherBills) / months;

        System.out.printf("Electricity: %.2f lv%n", totalElectricityBills);
        System.out.printf("Water: %.2f lv%n", waterBillPerMonth * months);
        System.out.printf("Internet: %.2f lv%n", internetBillPerMonth * months);
        System.out.printf("Other: %.2f lv%n", totalOtherBills);
        System.out.printf("Average: %.2f lv%n", averageBills);

    }
}
