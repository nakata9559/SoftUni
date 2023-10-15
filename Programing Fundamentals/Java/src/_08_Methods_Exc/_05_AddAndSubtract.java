package _08_Methods_Exc;

import java.util.Scanner;

public class _05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(result(Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine())));
    }

    public static int result(int first, int second, int third) {
        return first + second - third;
    }
}
