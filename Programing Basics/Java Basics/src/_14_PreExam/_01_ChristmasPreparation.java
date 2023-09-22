package _14_PreExam;

import java.util.Scanner;

public class _01_ChristmasPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double paperWrapPrice = 5.80;
        double clothPrice = 7.20;
        double gluePrice = 1.20;

        int paperWrapAmount = Integer.parseInt(scanner.nextLine());
        int clothRollsAmount = Integer.parseInt(scanner.nextLine());
        double littersGlue = Double.parseDouble(scanner.nextLine());
        int discountPercentage = Integer.parseInt(scanner.nextLine());

        double sum = (paperWrapAmount * paperWrapPrice + clothPrice * clothRollsAmount + gluePrice * littersGlue) * (1 - 1.0 * discountPercentage / 100);

        System.out.printf("%.3f", sum);
    }
}
