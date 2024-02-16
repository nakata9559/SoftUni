package _05_SetsAndMapsAdvanced_Lab;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _09_LargeThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Integer> nums = new TreeSet<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(nums::add);

        Set<Integer> reversedNums = nums.descendingSet();
        Iterator<Integer> iterator = reversedNums.iterator();

        for (int i = 0; i < nums.size(); i++) {
            if (i == 3) {
                break;
            }
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
    }
}
