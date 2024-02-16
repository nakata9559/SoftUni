package _05_SetsAndMapsAdvanced_Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> licensePlates = new LinkedHashSet<>();

        while (true) {
            String[] input = scanner.nextLine().split(",\\s+");
            if ("END".equals(input[0])) {
                break;
            }

            if ("IN".equals(input[0])) {
                licensePlates.add(input[1]);
            } else if ("OUT".equals(input[0])) {
                licensePlates.remove(input[1]);
            }
        }
        if (licensePlates.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            licensePlates.forEach(System.out::println);
        }
    }
}
