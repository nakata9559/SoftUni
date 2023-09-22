package _04_ConditionalStatements_Exc;

import java.util.Scanner;

public class _05_GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Ред 1.	Бюджет за филма – реално число в интервала [1.00 … 1000000.00]
        //Ред 2.	Брой на статистите – цяло число в интервала [1 … 500]
        //Ред 3.	Цена за облекло на един статист – реално число в интервала [1.00 … 1000.00]

        double budget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine());
        double priceCostumes = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.1;
        double priceCostumesPerExtra = priceCostumes * extras;

        if (extras > 150) {
            priceCostumesPerExtra = priceCostumesPerExtra * 0.9;
        }

        //•	Ако  парите за декора и дрехите са повече от бюджета:
        //o	"Not enough money!"
        //o	"Wingard needs {парите недостигащи за филма} leva more."
        //•	Ако парите за декора и дрехите са по малко или равни на бюджета:
        //o	"Action!"
        //o	"Wingard starts filming with {останалите пари} leva left."

        if (budget < decor + priceCostumesPerExtra) {
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", decor + priceCostumesPerExtra - budget);

        } else {
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", budget - priceCostumesPerExtra - decor);
        }
    }
}
