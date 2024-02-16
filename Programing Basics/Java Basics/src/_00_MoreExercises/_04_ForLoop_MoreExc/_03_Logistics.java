package _00_MoreExercises._04_ForLoop_MoreExc;

import java.util.Scanner;

public class _03_Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLoads = Integer.parseInt(scanner.nextLine());

        int busPricePerTon = 200;
        int truckPricePerTon = 175;
        int trainPricePerTon = 120;

        int tonsOfBuses = 0;
        int tonsOfTrucks = 0;
        int tonsOfTrains = 0;
        int loadWeightTotal = 0;

        for (int i = 0; i < numOfLoads; i++) {

            int loadWeight = Integer.parseInt(scanner.nextLine());
            loadWeightTotal += loadWeight;

            if (loadWeight <= 3) {
                tonsOfBuses += loadWeight;
            } else if (loadWeight <= 11) {
                tonsOfTrucks += loadWeight;
            } else {
                tonsOfTrains += loadWeight;
            }
        }

        double sumAverage = 1.0 * (tonsOfBuses * busPricePerTon + tonsOfTrucks * truckPricePerTon + tonsOfTrains * trainPricePerTon) / loadWeightTotal;
        double percentageBuses = 100.0 * tonsOfBuses / loadWeightTotal;
        double percentageTrucks = 100.0 * tonsOfTrucks / loadWeightTotal;
        double percentageTrains = 100.0 * tonsOfTrains / loadWeightTotal;

        System.out.printf("%.2f%n%.2f%%%n%.2f%%%n%.2f%%", sumAverage, percentageBuses, percentageTrucks, percentageTrains);
    }
}
