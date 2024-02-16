package _08_ForLoop_Exc;

import java.util.Scanner;

public class _04_CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double priceWashingMashine = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());

        double savedMoney = 0;
        int toysAmount = 0;

        for (int i = 1; i <= age; i++) {

            if (i % 2 == 0) {
                savedMoney += 10.0 * i / 2 - 1;
            } else {
                toysAmount++;
            }
        }

        double totalMoney = savedMoney + toysAmount * priceToy;

        if (totalMoney >= priceWashingMashine) {
            System.out.printf("Yes! %.2f", totalMoney - priceWashingMashine);
        } else {
            System.out.printf("No! %.2f", priceWashingMashine - totalMoney);
        }
    }
}
