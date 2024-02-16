package _15_Exam;

import java.util.Scanner;

public class _04_CatFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodPricePerDay = 12.45;

        int catsAmount = Integer.parseInt(scanner.nextLine());
        int smallCats = 0;
        int mediumCats = 0;
        int bigCats = 0;
        double totalFood = 0;

        for (int i = 0; i < catsAmount; i++) {

            double foodPerCatPerDay = Double.parseDouble(scanner.nextLine());

            if (100 <= foodPerCatPerDay && foodPerCatPerDay < 200) {
                totalFood += foodPerCatPerDay;
                smallCats++;
            } else if (200 <= foodPerCatPerDay && foodPerCatPerDay < 300) {
                totalFood += foodPerCatPerDay;
                mediumCats++;
            } else if (300 <= foodPerCatPerDay && foodPerCatPerDay < 400) {
                totalFood += foodPerCatPerDay;
                bigCats++;
            }

        }
        double sumPricePerDay = totalFood / 1000 * foodPricePerDay;

        System.out.printf("Group 1: %d cats.%n", smallCats);
        System.out.printf("Group 2: %d cats.%n", mediumCats);
        System.out.printf("Group 3: %d cats.%n", bigCats);
        System.out.printf("Price for food per day: %.2f lv.", sumPricePerDay);
    }
}
