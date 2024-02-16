package _00_MoreExercises._01_FirstStepsInCoding_MoreExc;

import java.util.Scanner;

public class _06_Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //От конзолата се четат 5 числа:
        //•	Първи ред – цена на скумрията на килограм. Реално число в интервала [0.00…40.00]
        //•	Втори ред – цена на цацата на килограм. Реално число в интервала [0.00…30.00]
        //•	Трети ред – килограма паламуд. Реално число в интервала [0.00…50.00]
        //•	Четвърти ред – килограма сафрид. Реално число в интервала [0.00… 70.00]
        //•	Пети ред – килограма миди. Цяло число в интервала [0 ... 100]

        double priceSkumria = Double.parseDouble(scanner.nextLine());
        double priceTsatsa = Double.parseDouble(scanner.nextLine());
        double amountPalamud = Double.parseDouble(scanner.nextLine());
        double amountSafrid = Double.parseDouble(scanner.nextLine());
        int amountMidi = Integer.parseInt(scanner.nextLine());

        double pricePalamud = priceSkumria * 1.6;
        double priceSafrid = priceTsatsa * 1.8;
        double priceMidi = 7.50;

        double sum = amountPalamud * pricePalamud + amountSafrid * priceSafrid + amountMidi * priceMidi;

        System.out.printf("%.2f", sum);

    }
}
