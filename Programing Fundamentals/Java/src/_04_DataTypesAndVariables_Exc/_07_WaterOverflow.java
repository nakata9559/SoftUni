package _04_DataTypesAndVariables_Exc;

import java.util.Scanner;

public class _07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPours = Integer.parseInt(scanner.nextLine());

        int litersTotal = 0;

        for (int i = 0; i < numOfPours; i++) {
            int litersPoured = Integer.parseInt(scanner.nextLine());

            if (litersTotal + litersPoured <= 255) {
                litersTotal += litersPoured;
            } else {
                System.out.println("Insufficient capacity!");
            }

        }

        System.out.println(litersTotal);
    }
}
