package _07_ForLoop_Lab;

import java.util.Scanner;

public class _08_NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersCount = Integer.parseInt(scanner.nextLine());
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int i = 1; i <= numbersCount ; i++) {

            int num = Integer.parseInt(scanner.nextLine());

            if (num > highest) {
                highest = num;
            }

            if (num < lowest) {
                lowest = num;
            }
        }

        /*
        int num1 = Integer.parseInt(scanner.nextLine());
        int lowest = num1;
        int highest = num1;

        for (int next = 1; next <= numbersCount - 1; next++) {
            int num2 = Integer.parseInt(scanner.nextLine());
            if (highest >= num2 && lowest >= num2) {
                lowest = num2;

            } else if (highest < num2){
                highest = num2;
            }
        }
        */

        System.out.printf("Max number: %d%nMin number: %d", highest, lowest);
    }
}
