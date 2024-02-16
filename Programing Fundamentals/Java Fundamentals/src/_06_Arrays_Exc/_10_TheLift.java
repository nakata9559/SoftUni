package _06_Arrays_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _10_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        int[] currentStateOfTheLift = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isFull = true;

        for (int i = 0; i < currentStateOfTheLift.length; i++) {

            int emptySpots = 4 - currentStateOfTheLift[i];

            if (emptySpots > 0) {
                if (emptySpots > peopleWaiting) {
                    currentStateOfTheLift[i] += peopleWaiting;
                    peopleWaiting = 0;
                    isFull = false;

                } else {
                    currentStateOfTheLift[i] = 4;
                    peopleWaiting -= emptySpots;
                }
            }
        }

        if (!isFull) {
            System.out.println("The lift has empty spots!");
        } else if (peopleWaiting > 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }

        System.out.println(String
                .join(" ", Arrays.stream(currentStateOfTheLift)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)));
    }
}
