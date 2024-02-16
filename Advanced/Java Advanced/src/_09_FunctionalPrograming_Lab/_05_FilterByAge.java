package _09_FunctionalPrograming_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class _05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> peopleData = new LinkedHashMap<>();

        while (numOfLines-- > 0){
            String[] input = scanner.nextLine().split(",\\s+");
            peopleData.put(input[0], Integer.parseInt(input[1]));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiFunction<Integer, String, Predicate<Integer>> filter = (age1, condition1) -> {
            if ("younger".equals(condition1)) {
                return a -> a <= age1;
            }
            return a -> a >= age1;
        };

        Function<String, Consumer<Map.Entry<String, Integer>>> consumerFactory = a -> {
            switch (a) {
                case "name":
                    return m -> System.out.println(m.getKey());

                case "age":
                    return m -> System.out.println(m.getValue());

                default:
                    return m -> System.out.println(m.getKey() + " - " + m.getValue());
            }
        };

        peopleData.entrySet()
                .stream()
                .filter(e -> filter.apply(age, condition).test(e.getValue()))
                .forEach(e -> consumerFactory.apply(format).accept(e));

//        Predicate<Integer> tester = createTester(condition, age);
//        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
//
//        printFilteredData(peopleData, tester, printer);
    }

//    static  Consumer<Map.Entry<String, Integer>> createPrinter (String format) {
//        Consumer<Map.Entry<String, Integer>> printer = null;
//
//        switch (format) {
//            case "name age":
//                printer = p -> System.out.printf("%s - %d%n",
//                        p.getKey(),
//                        p.getValue());
//                break;
//
//            case "name":
//                printer = p -> System.out.println(p.getKey());
//                break;
//
//            case "age":
//                printer = p -> System.out.println(p.getValue());
//                break;
//        }
//
//        return printer;
//    }

//    static Predicate<Integer> createTester(String condition, Integer age) {
//        Predicate<Integer> tester = null;
//
//        switch (condition) {
//            case "younger":
//                tester = v -> v <= age;
//                break;
//
//            case "older":
//                tester = v -> v >= age;
//                break;
//        }
//
//        return tester;
//    }

//    static void printFilteredData(
//            Map<String, Integer> people,
//            Predicate<Integer> tester,
//            Consumer<Map.Entry<String, Integer>> printer) {
//
//        for (Map.Entry<String, Integer> person : people.entrySet()) {
//            if (tester.test(people.get(person.getKey()))) printer.accept(person);
//        }
//    }
}
