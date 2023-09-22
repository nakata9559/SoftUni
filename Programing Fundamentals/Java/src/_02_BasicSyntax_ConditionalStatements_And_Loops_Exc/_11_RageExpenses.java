package _02_BasicSyntax_ConditionalStatements_And_Loops_Exc;

import java.util.Scanner;

public class _11_RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetsTrashed = lostGames / 2;
        int mousesTrashed = lostGames / 3;
        int keyboardsTrashed = lostGames / 6;
        int displaysTrashed = lostGames / 12;

        double expenses = headsetsTrashed * headsetPrice + mousesTrashed * mousePrice + keyboardPrice * keyboardsTrashed + displaysTrashed * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
