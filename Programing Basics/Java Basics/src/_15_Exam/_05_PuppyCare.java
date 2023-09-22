package _15_Exam;

import java.util.Scanner;

public class _05_PuppyCare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogFoodGrams = Integer.parseInt(scanner.nextLine()) * 1000;

        String input = scanner.nextLine();
        int requiredFood = 0;

        while (!input.equals("Adopted")) {

            requiredFood += Integer.parseInt(input);

            input = scanner.nextLine();
        }

        if (requiredFood <= dogFoodGrams) {
            System.out.printf("Food is enough! Leftovers: %d grams.", dogFoodGrams - requiredFood);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", requiredFood - dogFoodGrams);
        }
    }
}
