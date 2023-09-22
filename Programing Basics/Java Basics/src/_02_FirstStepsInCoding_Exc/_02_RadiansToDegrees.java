package _02_FirstStepsInCoding_Exc;

import java.util.Scanner;

public class _02_RadiansToDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double Rad = Double.parseDouble(scanner.nextLine());

        double Deg = Rad * 180 / Math.PI;

        System.out.println(Deg);
    }
}
