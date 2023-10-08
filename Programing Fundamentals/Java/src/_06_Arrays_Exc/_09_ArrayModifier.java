package _06_Arrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _09_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("end")) {

            switch (input[0]) {
                case "swap":
                    int firstNumberModify = array[Integer.parseInt(input[1])];
                    array[Integer.parseInt(input[1])] = array[Integer.parseInt(input[2])];
                    array[Integer.parseInt(input[2])] = firstNumberModify;
                    break;

                case "multiply":
                    array[Integer.parseInt(input[1])] = array[Integer.parseInt(input[1])] * array[Integer.parseInt(input[2])];
                    break;

                case "decrease":
                    for (int i = 0; i < array.length; i++) {
                        array[i]--;
                    }
            }

            input = scanner.nextLine().split(" ");
        }
        System.out.println(String
                .join(", ", Arrays.stream(array)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)));
    }
}
