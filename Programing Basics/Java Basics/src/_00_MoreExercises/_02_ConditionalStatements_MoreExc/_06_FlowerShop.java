package _00_MoreExercises._02_ConditionalStatements_MoreExc;

import java.util.Scanner;

public class _06_FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Брой магнолии – цяло число в интервала [0 … 50]
        //•	Брой зюмбюли – цяло число в интервала [0 … 50]
        //•	Брой рози – цяло число в интервала [0 … 50]
        //•	Брой кактуси – цяло число в интервала [0 … 50]
        //•	Цена на подаръка – реално число в интервала [0.00 … 500.00]

        int amountMagnolias = Integer.parseInt(scanner.nextLine());
        int amountHyacinths = Integer.parseInt(scanner.nextLine());
        int amountRoses = Integer.parseInt(scanner.nextLine());
        int amountCactuses = Integer.parseInt(scanner.nextLine());
        double presentPrice = Double.parseDouble(scanner.nextLine());

        double sumWithTaxes = (amountMagnolias * 3.25 + amountHyacinths * 4 + amountRoses * 3.5 + amountCactuses * 8) * 0.95;

        //•	Ако парите СА стигнали: "She is left with {останали} leva."
        // – сумата трябва да е закръглена към по-малко цяло число (пр. 1.90 -> 1).
        //•	Ако парите НЕ достигат: "She will have to borrow {останали} leva."
        // – сумата трябва да е закръглена към по-голямо цяло число (пр. 1.10 -> 2).

        if (sumWithTaxes >= presentPrice) {
            System.out.printf("She is left with %.0f leva.", Math.floor(sumWithTaxes - presentPrice));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(presentPrice - sumWithTaxes));
        }
    }
}
