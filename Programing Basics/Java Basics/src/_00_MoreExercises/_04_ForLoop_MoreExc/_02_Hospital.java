package _00_MoreExercises._04_ForLoop_MoreExc;

import java.util.Scanner;

public class _02_Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());

        int doctors = 7;
        int treated = 0;
        int untreated = 0;

        for (int i = 1; i <= period; i++) {

            if (i % 3 == 0 && untreated > treated) {
                doctors++;
            }

            int patientsEachDay = Integer.parseInt(scanner.nextLine());

            if (doctors >= patientsEachDay){
                treated += patientsEachDay;
            } else {
                treated += doctors;
                untreated += patientsEachDay - doctors;
            }
        }
        System.out.printf("Treated patients: %d.%n", treated);
        System.out.printf("Untreated patients: %d.", untreated);
    }
}
