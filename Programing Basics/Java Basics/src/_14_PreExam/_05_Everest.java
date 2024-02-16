package _14_PreExam;

import java.util.Scanner;

public class _05_Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = 1;

        int currentHeight = 5364;

        String input = scanner.nextLine();

        if (input.equals("Yes")) {
            days++;

        }
        while (!input.equals("END") && days <= 5) {

            currentHeight += Integer.parseInt(scanner.nextLine());

            if (currentHeight >= 8848) {
                System.out.printf("Goal reached for %d days!", days);
                break;
            }

            input = scanner.nextLine();
            if (input.equals("Yes")) {
                days++;
            }
        }

        if (currentHeight < 8848) {
            System.out.println("Failed!");
            System.out.println(currentHeight);
        }
    }
}
