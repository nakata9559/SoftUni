package _16_Generics_Exc._01_GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxList = new ArrayList<>();

        while (lines-- > 0) {
            boxList.add(new Box<>(scanner.nextLine()));
        }

        boxList.forEach(System.out::println);
    }
}
