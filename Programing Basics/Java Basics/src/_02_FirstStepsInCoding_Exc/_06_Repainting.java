package _02_FirstStepsInCoding_Exc;

import java.util.Scanner;

public class _06_Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double PE = 1.50;
        double Paint = 14.50;
        double PaintThinner = 5.00;
        double Bags = 0.40;

        int reqPE = Integer.parseInt(scanner.nextLine());
        int reqPaint = Integer.parseInt(scanner.nextLine());
        int reqPaintThinner = Integer.parseInt(scanner.nextLine());
        int workingHours = Integer.parseInt(scanner.nextLine());

        double MatsSum = (reqPE + 2) * PE + (reqPaint * 1.1) * Paint + reqPaintThinner * PaintThinner + Bags;

        double salary = MatsSum * 0.3 * workingHours;

        double SumTotal = MatsSum + salary;

        System.out.println(SumTotal);
    }
}
