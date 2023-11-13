package _15_TextProcessing_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        List<String> output = new ArrayList<>();

        for (String eachInput : input) {
            for (int i = 0; i < eachInput.length(); i++) {
                output.add(eachInput);
            }
        }

        System.out.println(String.join("", output));
    }
}
