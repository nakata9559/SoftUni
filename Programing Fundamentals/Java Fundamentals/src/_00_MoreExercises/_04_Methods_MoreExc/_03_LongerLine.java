package _00_MoreExercises._04_Methods_MoreExc;

import java.util.Scanner;

public class _03_LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] points = new double[8];

        for (int i = 0; i < points.length; i++) {
            points[i] = Double.parseDouble(scanner.nextLine());
        }

        double lineOneLength = lineLength(points[0], points[1], points[2], points[3]);
        double lineTwoLength = lineLength(points[4], points[5], points[6], points[7]);

        if (lineOneLength >= lineTwoLength) {
            printCoordinates(points[0], points[1], points[2], points[3]);
        } else {
            printCoordinates(points[4], points[5], points[6], points[7]);
        }
    }

    public static double lineLength(double X1, double Y1, double X2, double Y2) {
        return Math.sqrt(Math.pow((X2 - X1), 2) + Math.pow((Y2 - Y1), 2));
    }

    public static void printCoordinates(double X1, double Y1, double X2, double Y2) {
        double awayFromCenterOne = awayFromCenter(X1, Y1);
        double awayFromCenterTwo = awayFromCenter(X2, Y2);

        if (awayFromCenterOne <= awayFromCenterTwo) {
            printPoints(X1, Y1);
            printPoints(X2, Y2);
        } else {
            printPoints(X2, Y2);
            printPoints(X1, Y1);
        }
        System.out.println();
    }

    public static double awayFromCenter(double X, double Y) {
        return Math.sqrt(Math.pow((0 - X), 2) + Math.pow((0 - Y), 2));
    }

    public static void printPoints (double pointX, double pointY) {
        System.out.printf("(%.0f, %.0f)", pointX, pointY);
    }
}

