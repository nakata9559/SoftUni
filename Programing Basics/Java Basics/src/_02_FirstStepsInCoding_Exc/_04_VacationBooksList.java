package _02_FirstStepsInCoding_Exc;

import java.util.Scanner;

public class _04_VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ppb = Integer.parseInt(scanner.nextLine());
        int pph = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int hours = ppb / pph / days;

        System.out.println(hours);
    }
}
