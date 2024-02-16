package _00_MoreExercises._10_FinalExamPreparation._03_;

import java.util.Scanner;

public class _01_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        while (true){
            String[] command = scanner.nextLine().split(":\\|:");
            if (command[0].equals("Reveal")) {
                break;
            }

            switch (command[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);
                    message.insert(index, " ");
                    break;

                case "Reverse":
                    if (message.indexOf(command[1]) >= 0) {
                        message.replace(message.indexOf(command[1]), message.indexOf(command[1]) + command[1].length(), "");
                        StringBuilder text = new StringBuilder(command[1]).reverse();
                        message.append(text);
                    } else {
                        System.out.println("error");
                        continue;
                    }
                    break;

                case "ChangeAll":
                    while (message.indexOf(command[1]) >= 0) {
                        message.replace(message.indexOf(command[1]), message.indexOf(command[1]) + command[1].length(), command[2]);
                    }
                    break;
            }

            System.out.println(message);
        }

        System.out.printf("You have a new text message: %s\n", message);
    }
}
