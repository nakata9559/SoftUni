package _00_MoreExercises._10_FinalExamPreparation._01_;

import java.util.Scanner;

public class _01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        while (true) {
            String[] command = scanner.nextLine().split("\\|");
            if (command[0].equals("Decode")) {
                break;
            }
            switch (command[0]) {
                case "Move":
                    String leftSide1 = message.substring(Integer.parseInt(command[1]));
                    String rightSide1 = message.substring(0, Integer.parseInt(command[1]));
                    message = new StringBuilder(leftSide1).append(rightSide1);
                    break;
                case "Insert":
                    String leftSide2 = message.substring(0, Integer.parseInt(command[1]));
                    String rightSide2 = message.substring(Integer.parseInt(command[1]));
                    message = new StringBuilder(leftSide2).append(command[2]).append(rightSide2);
                    break;
                case "ChangeAll":
                    while (message.indexOf(command[1]) >= 0) {
                        message.replace(message.indexOf(command[1]), message.indexOf(command[1]) + 1 , command[2]);
                    }
                    break;
            }
        }
        System.out.println("The decrypted message is: " + message);
    }
}
