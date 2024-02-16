package _00_MoreExercises._02_ConditionalStatements_MoreExc;

import java.util.Scanner;

public class _04_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първият ред съдържа числото n – брой километри – цяло число в интервала [1…5000]
        //•	Вторият ред съдържа дума “day” или “night” – пътуване през деня или през нощта

        int kilometers = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();

        //•	Такси. Начална такса: 0.70 лв. Дневна тарифа: 0.79 лв. / км. Нощна тарифа: 0.90 лв. / км.
        //•	Автобус. Дневна / нощна тарифа: 0.09 лв. / км. Може да се използва за разстояния минимум 20 км.
        //•	Влак. Дневна / нощна тарифа: 0.06 лв. / км. Може да се използва за разстояния минимум 100 км.

        if (kilometers >= 100) {
            System.out.printf("%.2f", kilometers * 0.06);

        } else if (kilometers >= 20) {
            System.out.printf("%.2f", kilometers * 0.09);

        } else if (dayOrNight.equals("day")) {
            System.out.printf("%.2f", 0.7 + kilometers * 0.79);

        } else {
            System.out.printf("%.2f", 0.7 + kilometers * 0.90);
        }
    }
}
