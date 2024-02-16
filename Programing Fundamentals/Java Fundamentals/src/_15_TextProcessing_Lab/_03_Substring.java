package _15_TextProcessing_Lab;

import java.util.Scanner;

public class _03_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String text = scanner.nextLine();

        System.out.println(text.replace(key, ""));
    }
}
