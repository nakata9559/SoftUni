package _06_ConditionalStatementsAdvanced_Exc;

import java.util.Scanner;

public class _08_OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHours = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHours = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        int examMinutesTotal = examMinutes + examHours * 60;
        int arrivalMinutesTotal = arrivalMinutes + arrivalHours * 60;

        if (examMinutesTotal > arrivalMinutesTotal && (examMinutesTotal - arrivalMinutesTotal) > 30) {
            //Early
            if (examMinutesTotal - arrivalMinutesTotal > 59) {
                int minutesLeft = (examMinutesTotal - arrivalMinutesTotal) % 60;
                int hoursLeft = (examMinutesTotal - arrivalMinutesTotal) / 60;
                System.out.printf("Early%n%d:%02d hours before the start", hoursLeft, minutesLeft);
            } else {
                System.out.printf("Early%n%d minutes before the start", examMinutesTotal - arrivalMinutesTotal);
            }


        } else if (examMinutesTotal > arrivalMinutesTotal && (examMinutesTotal - arrivalMinutesTotal) <= 30) {
            // On time
            System.out.printf("On time%n%d minutes before the start", examMinutesTotal - arrivalMinutesTotal);


        } else if (examMinutesTotal < arrivalMinutesTotal) {
            //Late
            if (arrivalMinutesTotal - examMinutesTotal > 59) {
                int minutesLeft = (arrivalMinutesTotal - examMinutesTotal) % 60;
                int hoursLeft = (arrivalMinutesTotal - examMinutesTotal) / 60;
                System.out.printf("Late%n%d:%02d hours after the start", hoursLeft, minutesLeft);
            } else {
                System.out.printf("Late%n%d minutes after the start", arrivalMinutesTotal - examMinutesTotal);
            }

        } else if (examMinutesTotal == arrivalMinutesTotal) {
            // On time *
            System.out.print("On time");
        }
    }
}
