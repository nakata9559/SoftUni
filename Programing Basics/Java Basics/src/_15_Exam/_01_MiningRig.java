package _15_Exam;

import java.util.Scanner;

public class _01_MiningRig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int videoCardPrice = Integer.parseInt(scanner.nextLine());
        int adapterPrice = Integer.parseInt(scanner.nextLine());
        double electricityPricePerDay = Double.parseDouble(scanner.nextLine());
        double profitPerDay = Double.parseDouble(scanner.nextLine());

        double videoCardPriceTotal = videoCardPrice * 13;
        double adapterPriceTotal = adapterPrice * 13;
        double priceTotal = adapterPriceTotal + videoCardPriceTotal + 1000;
        double incomePerDay = profitPerDay - electricityPricePerDay;
        double incomeTotal = incomePerDay * 13;

        System.out.printf("%.0f%n", priceTotal);
        System.out.printf("%.0f%n", Math.ceil(priceTotal / incomeTotal));
    }
}
