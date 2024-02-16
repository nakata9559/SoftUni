package _06_SetsAndMapsAdvanced_Exc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfChemicals = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElements = new TreeSet<>();

        for (int i = 0; i < numOfChemicals; i++) {
            chemicalElements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }

        chemicalElements.forEach(v -> {
            System.out.printf("%s ", v);
        });

        System.out.println();
    }
}
