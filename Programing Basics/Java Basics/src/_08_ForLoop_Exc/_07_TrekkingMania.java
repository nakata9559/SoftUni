package _08_ForLoop_Exc;

import java.util.Scanner;

public class _07_TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());
        int totalPeople = 0;

        int peak1 = 0;
        int peak2 = 0;
        int peak3 = 0;
        int peak4 = 0;
        int peak5 = 0;


        for (int i = 0; i < groups; i++) {

            int peopleInAGroup = Integer.parseInt(scanner.nextLine());

            totalPeople += peopleInAGroup;

            if (peopleInAGroup <= 5) {
                peak1 += peopleInAGroup;
            } else if (peopleInAGroup <= 12) {
                peak2 += peopleInAGroup;
            } else if (peopleInAGroup <= 25) {
                peak3 += peopleInAGroup;
            } else if (peopleInAGroup <= 40) {
                peak4 += peopleInAGroup;
            } else {
                peak5 += peopleInAGroup;
            }
        }

        double p1 = 100.0 * peak1 / totalPeople;
        double p2 = 100.0 * peak2 / totalPeople;
        double p3 = 100.0 * peak3 / totalPeople;
        double p4 = 100.0 * peak4 / totalPeople;
        double p5 = 100.0 * peak5 / totalPeople;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3, p4, p5);
    }
}
