package _02_FirstStepsInCoding_Exc;

import java.util.Scanner;

public class _01_USDToBGN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double USD = Double.parseDouble(scanner.nextLine());

        double BGN = USD * 1.79549;

        System.out.println(BGN);
    }
}
