package _02_FirstStepsInCoding_Exc;

import java.util.Scanner;

public class _08_BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int AnnualPrice = Integer.parseInt(scanner.nextLine());

        double Shoes = AnnualPrice * 0.6;
        double Clothes = Shoes * 0.8;
        double Ball = Clothes * 0.25;
        double Accesories = Ball * 0.2;

        double Sum = AnnualPrice + Shoes + Clothes + Ball + Accesories;

        System.out.println(Sum);
    }
}
