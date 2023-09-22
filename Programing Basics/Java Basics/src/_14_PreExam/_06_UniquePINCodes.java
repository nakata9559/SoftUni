package _14_PreExam;

import java.util.Scanner;

public class _06_UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstDigitMax = Integer.parseInt(scanner.nextLine());
        int secondDigitMax = Integer.parseInt(scanner.nextLine());
        int thirdDigitMax = Integer.parseInt(scanner.nextLine());

        boolean isNonPrime = false;

        for (int first = 2; first <= firstDigitMax; first += 2) {

            for (int second = 2; second <= secondDigitMax; second++) {



                for (int i = 2; i < second; i++) {

                    if (second % i == 0) {
                        isNonPrime = true;
                        break;
                    }
                }

                if (isNonPrime) {
                    isNonPrime = false;
                    continue;
                }



                for (int third = 2; third <= thirdDigitMax; third += 2) {
                    System.out.printf("%d %d %d%n", first, second, third);
                }
            }
        }
    }
}
