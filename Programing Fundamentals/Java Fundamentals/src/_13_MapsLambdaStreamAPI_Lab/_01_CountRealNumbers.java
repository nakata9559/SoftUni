package _13_MapsLambdaStreamAPI_Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _01_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        TreeMap<Double, Integer> numberCount = new TreeMap<>();

        for (double number : numbers) {
            if (!numberCount.containsKey(number)) {
                numberCount.put(number, 1);
            } else {
                numberCount.put(number, numberCount.get(number) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : numberCount.entrySet()) {
            DecimalFormat format = new DecimalFormat("#.######");
            System.out.printf("%s -> %d%n", format.format(entry.getKey()), entry.getValue());
        }
    }
}
