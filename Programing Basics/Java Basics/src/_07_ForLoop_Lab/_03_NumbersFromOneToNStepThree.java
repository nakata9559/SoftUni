package _07_ForLoop_Lab;

import java.util.Scanner;

public class _03_NumbersFromOneToNStepThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int end = Integer.parseInt(scanner.nextLine());

        for (int num = 1; num <= end; num += 3){
            System.out.println(num);
        }
    }
}
