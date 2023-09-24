package _04_DataTypesAndVariables_Exc;

import java.util.Scanner;

public class _11_Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfSnowballs = Integer.parseInt(scanner.nextLine());

        long highestSnowballValue = Integer.MIN_VALUE;
        if (numOfSnowballs == 0) {
            highestSnowballValue = 0;
        }

        int highestSnowballValueSnow = 0;
        int highestSnowballValueTime = 0;
        int highestSnowballValueQuality = 0;

        for (int i = 0; i < numOfSnowballs; i++) {

            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            long snowballValue = (long) Math.pow(snowballSnow * 1.0 / snowballTime, snowballQuality);

            if (snowballValue > highestSnowballValue) {
                highestSnowballValue = snowballValue;
                highestSnowballValueSnow = snowballSnow;
                highestSnowballValueTime = snowballTime;
                highestSnowballValueQuality = snowballQuality;
            }

        }

        System.out.printf("%d : %d = %d (%d)",
                highestSnowballValueSnow,
                highestSnowballValueTime,
                highestSnowballValue,
                highestSnowballValueQuality);
    }
}
