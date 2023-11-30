package _00_MoreExercises._10_FinalExamPreparation._02_;

import java.util.Scanner;

public class _01_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tour = scanner.nextLine();

        while (true) {
            String[] command = scanner.nextLine().split(":");
            if (command[0].equals("Travel")) {
                break;
            }

            switch (command[0]) {
                case "Add Stop":
                    if (tour.length() - 1 >= Integer.parseInt(command[1])) {
                        String leftPart = tour.substring(0, Integer.parseInt(command[1]));
                        String rightPart = tour.substring(Integer.parseInt(command[1]));
                        tour = leftPart + command[2] + rightPart;
                    }
                    break;

                case "Remove Stop":
                    if (tour.length() - 1 >= Integer.parseInt(command[2])) {
                        String leftPart = tour.substring(0, Integer.parseInt(command[1]));
                        String rightPart = tour.substring(Integer.parseInt(command[2]) + 1);
                        tour = leftPart + rightPart;
                    }
                    break;

                case "Switch":
                    tour = tour.replaceAll(command[1], command[2]);
                    break;
            }

            System.out.println(tour);
        }
        System.out.println("Ready for world tour! Planned stops: " + tour);
    }
}
