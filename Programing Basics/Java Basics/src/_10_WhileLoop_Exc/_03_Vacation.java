package _10_WhileLoop_Exc;

import java.util.Scanner;

public class _03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double requiredMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        int daysPast = 0;
        int daysSpendingMoney = 0;

        while (availableMoney < requiredMoney) {

            daysPast++;

            String spendOrSave = scanner.nextLine();
            double sumSpentOrSaved = Double.parseDouble(scanner.nextLine());

            switch (spendOrSave) {
                case "spend":
                    daysSpendingMoney++;
                    availableMoney -= sumSpentOrSaved;
                    break;
                case "save":
                    availableMoney += sumSpentOrSaved;
                    daysSpendingMoney = 0;
                    break;
            }

            if (availableMoney < 0) {
                availableMoney = 0;
            }

            if (daysSpendingMoney == 5) {
                System.out.printf("You can't save the money.%n%d", daysPast);
                break;

            } else if (availableMoney >= requiredMoney) {
                System.out.printf("You saved the money for %d days.", daysPast);
                break;
            }
        }
    }
}
