package _13_ExamPreparation_Lab;

import java.util.Scanner;

public class _05_CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogFood = Integer.parseInt(scanner.nextLine()) * 1000;

        String foodPerServing = scanner.nextLine();

        int totalFoodAte = 0;

        while (!foodPerServing.equals("Adopted")) {

            totalFoodAte += Integer.parseInt(foodPerServing);

            foodPerServing = scanner.nextLine();
        }

        if (totalFoodAte <= dogFood) {
            System.out.printf("Food is enough! Leftovers: %d grams.", dogFood - totalFoodAte);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", totalFoodAte - dogFood);
        }
    }
}
