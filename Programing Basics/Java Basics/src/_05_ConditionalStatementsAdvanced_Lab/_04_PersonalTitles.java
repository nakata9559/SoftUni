package _05_ConditionalStatementsAdvanced_Lab;

import java.util.Scanner;

public class _04_PersonalTitles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();

        if (age < 16) {
            if (gender.equals("f")) {
                System.out.println("Miss");
            } else {
                    System.out.println("Master");
            }
        } else {
            if (gender.equals("f")) {
                System.out.println("Ms.");
            } else {
                    System.out.println("Mr.");
            }
        }
    }
}
