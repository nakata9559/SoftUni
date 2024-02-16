package _00_MoreExercises._04_Methods_MoreExc;

import java.util.Scanner;

public class _01_DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        switch (dataType) {
            case "int":
                result(Integer.parseInt(scanner.nextLine()));
                break;
            case "real":
                result(Double.parseDouble(scanner.nextLine()));
                break;
            case "string":
                result(scanner.nextLine());
                break;
        }
    }
    public static void result(String input) {
        System.out.println("$" + input + "$");
    }

    public static void result(int input) {
        System.out.println(input * 2);
    }

    public static void result(double input) {
        System.out.printf("%.2f%n", input * 1.5);
    }
}
