package _02_FirstStepsInCoding_Exc;

import java.util.Scanner;

public class _07_FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double ChickenMenu = 10.35;
        double FishMenu = 12.40;
        double VeggieMenu = 8.15;
        double Delivery = 2.50;

        int CMAmount = Integer.parseInt(scanner.nextLine());
        int FMAmount = Integer.parseInt(scanner.nextLine());
        int VMAmount = Integer.parseInt(scanner.nextLine());

        double SumMenus = ChickenMenu * CMAmount + FishMenu * FMAmount + VeggieMenu * VMAmount;

        double SumTotal = SumMenus * 1.2 + Delivery;

        System.out.println(SumTotal);
    }
}
