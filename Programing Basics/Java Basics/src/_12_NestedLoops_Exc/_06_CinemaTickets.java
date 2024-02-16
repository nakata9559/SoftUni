package _12_NestedLoops_Exc;

import java.util.Scanner;

public class _06_CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();

        int sumTotalTickets = 0;
        int sumStudentTickets = 0;
        int sumStandardTickets = 0;
        int sumKidsTickets = 0;

        while (!movieName.equals("Finish")) {

            String vacantSeats = scanner.nextLine();

            if (vacantSeats.equals("0") || vacantSeats.equals("End") || vacantSeats.equals("Finish")) {

                System.out.printf("%s - %.2f%% full.%n", movieName, 0.0);

                if (vacantSeats.equals("End")) {
                    movieName = scanner.nextLine();
                    continue;

                } else if (vacantSeats.equals("Finish")) {
                    break;
                }
            }

            int sumTotalTicketsPerMovie = 0;
            int sumStudentTicketsPerMovie = 0;
            int sumStandardTicketsPerMovie = 0;
            int sumKidsTicketsPerMovie = 0;
            String ticketType = scanner.nextLine();

            int vacantSeatsNum = Integer.parseInt(vacantSeats);

            while (!ticketType.equals("End") && !ticketType.equals("Finish")) {

                switch (ticketType) {

                    case "student":
                        sumStudentTicketsPerMovie++;
                        break;
                    case "standard":
                        sumStandardTicketsPerMovie++;
                        break;
                    case "kid":
                        sumKidsTicketsPerMovie++;
                        break;
                }

                sumTotalTicketsPerMovie = sumStudentTicketsPerMovie + sumStandardTicketsPerMovie + sumKidsTicketsPerMovie;

                if (sumTotalTicketsPerMovie == vacantSeatsNum) {
                    break;
                }

                ticketType = scanner.nextLine();
            }

            System.out.printf("%s - %.2f%% full.%n", movieName, 100.0 * sumTotalTicketsPerMovie / vacantSeatsNum);

            sumTotalTickets += sumTotalTicketsPerMovie;
            sumStudentTickets += sumStudentTicketsPerMovie;
            sumStandardTickets += sumStandardTicketsPerMovie;
            sumKidsTickets += sumKidsTicketsPerMovie;

            if (ticketType.equals("Finish")) {
                break;
            }

            movieName = scanner.nextLine();
        }


        double averageStudentTickets = 100.0 * sumStudentTickets / sumTotalTickets;
        double averageStandardTickets = 100.0 * sumStandardTickets / sumTotalTickets;
        double averageKidsTickets = 100.0 * sumKidsTickets / sumTotalTickets;

        if (sumTotalTickets == 0) {
            averageStudentTickets = 0;
            averageStandardTickets = 0;
            averageKidsTickets = 0;
        }

        System.out.println("Total tickets: " + sumTotalTickets);
        System.out.printf("%.2f%% student tickets.%n", averageStudentTickets);
        System.out.printf("%.2f%% standard tickets.%n", averageStandardTickets);
        System.out.printf("%.2f%% kids tickets.%n", averageKidsTickets);
    }
}
