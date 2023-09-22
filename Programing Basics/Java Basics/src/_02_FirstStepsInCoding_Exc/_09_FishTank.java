package _02_FirstStepsInCoding_Exc;

import java.util.Scanner;

public class _09_FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        double percent = Double.parseDouble(scanner.nextLine());

        double liters = width * 0.1 * length * 0.1 * height * 0.1 * (1 - percent / 100);

        System.out.println(liters);
    }
}
