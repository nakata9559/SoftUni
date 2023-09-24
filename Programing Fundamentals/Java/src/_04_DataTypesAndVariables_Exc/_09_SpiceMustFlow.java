package _04_DataTypesAndVariables_Exc;

import java.util.Scanner;

public class _09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int totalYield = 0;
        int yieldPerDay = startingYield;
        int daysWorked = 0;

        while (yieldPerDay >= 100) {
            totalYield += yieldPerDay - 26;
            daysWorked++;
            yieldPerDay -= 10;

            if (yieldPerDay < 100) {
                totalYield -= 26;
            }
        }

        System.out.printf("%d%n%d", daysWorked, totalYield);
    }
}
