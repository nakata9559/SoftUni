package _09_FunctionalPrograming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class _04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVat = v -> v * 1.2;
        Consumer<Double> print = e -> System.out.printf("%.2f%n", e);

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Double::parseDouble)
                .forEach(e -> print.accept(addVat.apply(e)));
    }
}
