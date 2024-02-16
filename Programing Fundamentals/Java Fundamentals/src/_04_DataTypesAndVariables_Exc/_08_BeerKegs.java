package _04_DataTypesAndVariables_Exc;

import java.util.Scanner;

public class _08_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfKegs = Integer.parseInt(scanner.nextLine());

        double biggestKegVolume = Double.MIN_VALUE;
        String biggestKeg = "";

        for (int i = 0; i < numOfKegs; i++) {
            String kegName = scanner.nextLine();
            double kegRadius = Double.parseDouble(scanner.nextLine());
            double kegHeight = Double.parseDouble(scanner.nextLine());

            double currentKegVolume = Math.PI * Math.pow(kegRadius, 2) * kegHeight;

            if (currentKegVolume > biggestKegVolume) {
                biggestKegVolume = currentKegVolume;
                biggestKeg = kegName;
            }
        }
        System.out.println(biggestKeg);
    }
}
