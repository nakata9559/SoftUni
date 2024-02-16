package _00_MoreExercises._02_ConditionalStatements_MoreExc;

import java.util.Scanner;

public class _03_Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	1ви ред: X кв.м е лозето – цяло число в интервала [10 … 5000]
        //•	2ри ред: Y грозде за един кв.м – реално число в интервала [0.00 … 10.00]
        //•	3ти ред: Z нужни литри вино – цяло число в интервала [10 … 600]
        //•	4ти ред: брой работници – цяло число в интервала [1 … 20]

        int area = Integer.parseInt(scanner.nextLine());
        double grapePerSqM = Double.parseDouble(scanner.nextLine());
        int neededLitters = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        //От лозе с площ X квадратни метри се заделя 40% от реколтата за производство на вино.
        // От 1 кв.м лозе се изкарват Y килограма грозде. За 1 литър вино са нужни 2,5 кг. грозде.
        //Желаното количество вино за продан е Z литра.

        double harvestForWine = area * 0.4 * grapePerSqM / 2.5; //litters

        //•	Ако произведеното вино е по-малко от нужното:
        //o	“It will be a tough winter! More {недостигащо вино} liters wine needed.”
        //	Резултатът трябва да е закръглен към по-ниско цяло число
        //•	Ако произведеното вино е колкото или повече от нужното:
        //o	“Good harvest this year! Total wine: {общо вино} liters.”
        //	Резултатът трябва да е закръглен към по-ниско цяло число
        //o	“{Оставащо вино} liters left -> {вино за 1 работник} liters per person.”
        //	И двата резултата трябва да са закръглени към по-високото цяло число

        if (harvestForWine < neededLitters) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(neededLitters - harvestForWine));
        } else {
            double littersLeft = harvestForWine - neededLitters;
            double littersPerPerson = littersLeft / workers;
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n%.0f liters left -> %.0f liters per person.", Math.floor(harvestForWine), Math.ceil(littersLeft), Math.ceil(littersPerPerson));
        }

    }
}
