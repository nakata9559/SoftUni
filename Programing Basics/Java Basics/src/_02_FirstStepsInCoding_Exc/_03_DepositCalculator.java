package _02_FirstStepsInCoding_Exc;

import java.util.Scanner;

public class _03_DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double deposit = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double interestRate = (Double.parseDouble(scanner.nextLine())/100);

        double sum = deposit + months * ((deposit * interestRate)/12);

        System.out.println(sum);
    }
}
