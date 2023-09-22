package _04_ConditionalStatements_Exc;

import java.util.Scanner;

public class _06_WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.	Рекордът в секунди – реално число в интервала [0.00 … 100000.00]
        //2.	Разстоянието в метри – реално число в интервала [0.00 … 100000.00]
        //3.	Времето в секунди, за което плува разстояние от 1 м. - реално число в интервала [0.00 … 1000.00]

        double recordTime = Double.parseDouble(scanner.nextLine());
        double recordLenght = Double.parseDouble(scanner.nextLine());
        double secondsPerMeter = Double.parseDouble(scanner.nextLine());

        double resistance = Math.floor(recordLenght / 15) * 12.5;

        double timeIvan = recordLenght * secondsPerMeter + resistance;

        if (timeIvan < recordTime) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", timeIvan);

        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", timeIvan - recordTime);
        }
    }
}
