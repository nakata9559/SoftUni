package _00_MoreExercises._01_FirstStepsInCoding_MoreExc;

import java.util.Scanner;

public class _04_VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Вход
        //От конзолата се четат 4 числа, по едно на ред:
        //•	Първи ред – Цена за килограм зеленчуци – реално число[0.00… 1000.00]
        //•	Втори ред – Цена за килограм плодове – реално число[0.00… 1000.00]
        //•	Трети ред – Общо килограми на зеленчуците – цяло число[0… 1000]
        //•	Четвърти ред – Общо килограми на плодовете – цяло число[0… 1000]

        double veggiePrice = Double.parseDouble(scanner.nextLine());
        double fruitPrice = Double.parseDouble(scanner.nextLine());
        int veggieWeight = Integer.parseInt(scanner.nextLine());
        int fruitWeight = Integer.parseInt(scanner.nextLine());

        //Изход
        //Да се отпечата на конзолата едно число: приходите от всички плодове и зеленчуци в евро.
        //Резултата да се форматира до втория знак след десетичния разделител.

        double income = veggiePrice * veggieWeight + fruitPrice * fruitWeight;

        double incomeEU = income / 1.94;

        System.out.printf("%.2f", incomeEU);

    }
}
