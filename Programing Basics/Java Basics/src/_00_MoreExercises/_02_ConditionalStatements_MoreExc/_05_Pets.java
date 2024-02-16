package _00_MoreExercises._02_ConditionalStatements_MoreExc;

import java.util.Scanner;

public class _05_Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първи ред – брой дни – цяло число в интервал [1…5000]
        //•	Втори ред – оставена храна в килограми – цяло число в интервал [0…100000]
        //•	Трети ред – храна на ден за кучето в килограми – реално число в интервал [0.00…100.00]
        //•	Четвърти ред – храна на ден за котката в килограми– реално число в интервал [0.00…100.00]
        //•	Пети ред – храна на ден за костенурката в грамове – реално число в интервал [0.00…10000.00]

        int days = Integer.parseInt(scanner.nextLine());
        int foodTotal = Integer.parseInt(scanner.nextLine());
        double dogFood = Double.parseDouble(scanner.nextLine());
        double catFood = Double.parseDouble(scanner.nextLine());
        double turtleFood = Double.parseDouble(scanner.nextLine());

        //•	Ако оставената храна Е достатъчна:
        //o	"{килограма остатък} kilos of food left."
        //	Резултатът трябва да е закръглен към по-ниското цяло число
        //•	Ако оставената храна НЕ Е достатъчна:
        //o	“{килограма недостигат} more kilos of food are needed.”

        double foodRequired = (dogFood + catFood + turtleFood / 1000) * days;
        double foodLeft = foodTotal - foodRequired;

        if (foodTotal >= foodRequired) {
            System.out.printf("%.0f kilos of food left.", Math.floor(foodLeft));

        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(Math.abs(foodLeft)));
        }
    }
}
