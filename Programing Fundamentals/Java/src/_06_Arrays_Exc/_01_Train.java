package _06_Arrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());

        int[] peopleInAWagon = new int[wagons];

        int sum = 0;

        for (int i = 0; i < wagons; i++) {
            peopleInAWagon[i] = Integer.parseInt(scanner.nextLine());

            System.out.printf("%d ", peopleInAWagon[i]);
            sum += peopleInAWagon[i];

        }
        System.out.printf("%n%d", sum);
    }
}
