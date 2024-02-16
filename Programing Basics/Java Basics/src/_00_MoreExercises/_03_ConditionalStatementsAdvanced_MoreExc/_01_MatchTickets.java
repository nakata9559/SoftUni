package _00_MoreExercises._03_ConditionalStatementsAdvanced_MoreExc;

import java.util.Scanner;

public class _01_MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());

        double vipTickets = 499.99;
        double normalTickets = 249.99;

        double ticketFee = 0;
        double transportFee = 0;

        switch (category) {
            case "VIP":
                ticketFee = people * vipTickets;
                break;
            case "Normal":
                ticketFee = people * normalTickets;
                break;
        }


        if (1 <= people && people <= 4) {
            transportFee = budget * 0.75;
        } else if (people <= 9) {
            transportFee = budget * 0.6;
        } else if (people <= 24) {
            transportFee = budget * 0.5;
        } else if (people <= 49) {
            transportFee = budget * 0.4;
        } else if (people > 50) {
            transportFee = budget * 0.25;
        }


        double sum = budget - ticketFee - transportFee;

        if (budget >= ticketFee + transportFee){
            System.out.printf("Yes! You have %.2f leva left.", Math.abs(sum));
        }else{
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(sum));
        }
    }
}
