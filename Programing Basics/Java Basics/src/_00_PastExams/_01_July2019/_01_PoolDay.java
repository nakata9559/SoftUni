package _00_PastExams._01_July2019;

import java.util.Scanner;

public class _01_PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPeople = Integer.parseInt(scanner.nextLine());
        double entranceFee = Double.parseDouble(scanner.nextLine());
        double sunbedPrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());

        double totalEntranceFee = numOfPeople * entranceFee;
        double totalUmbrellaPrice = Math.ceil(1.0 * numOfPeople / 2) * umbrellaPrice;
        double totalSunbedPrice = Math.ceil(numOfPeople * 0.75) * sunbedPrice;

        double totalSum =  totalEntranceFee + totalSunbedPrice + totalUmbrellaPrice;

        System.out.printf("%.2f lv.", totalSum);
    }
}
