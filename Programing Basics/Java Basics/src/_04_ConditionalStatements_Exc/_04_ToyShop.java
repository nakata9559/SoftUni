package _04_ConditionalStatements_Exc;

import java.util.Scanner;

public class _04_ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //От конзолата се четат 6 реда:
        //1.	Цена на екскурзията - реално число в интервала [1.00 … 10000.00]
        //2.	Брой пъзели - цяло число в интервала [0… 1000]
        //3.	Брой говорещи кукли - цяло число в интервала [0 … 1000]
        //4.	Брой плюшени мечета - цяло число в интервала [0 … 1000]
        //5.	Брой миньони - цяло число в интервала [0 … 1000]
        //6.	Брой камиончета - цяло число в интервала [0 … 1000]

        double vacationPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int talkingDolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int toyTrucks = Integer.parseInt(scanner.nextLine());

        //Цени на играчките:
        //•	Пъзел - 2.60 лв.
        //•	Говореща кукла - 3 лв.
        //•	Плюшено мече - 4.10 лв.
        //•	Миньон - 8.20 лв.
        //•	Камионче - 2 лв.

        double pricePuzzle = 2.60;
        double priceTalkingDoll = 3.00;
        double priceTeddyBear = 4.10;
        double priceMinion = 8.20;
        double priceToyTruck = 2.00;

        int orders = puzzles + talkingDolls + teddyBears + minions + toyTrucks;
        double sumPrice = puzzles * pricePuzzle + talkingDolls * priceTalkingDoll + teddyBears * priceTeddyBear + minions * priceMinion + toyTrucks * priceToyTruck;

        if (orders >= 50) {
            sumPrice = sumPrice * 0.75;
        }

        double sumTotalPrice = sumPrice * 0.9;
        double moneyLeft = sumTotalPrice - vacationPrice;
        double moneyReq = vacationPrice - sumTotalPrice;

        if (sumTotalPrice >= vacationPrice) {
            System.out.printf("Yes! %.2f lv left.", moneyLeft);

        } else {
            System.out.printf("Not enough money! %.2f lv needed.", moneyReq);
        }
    }
}
