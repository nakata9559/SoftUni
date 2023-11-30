package _00_MoreExercises._10_FinalExamPreparation._04_;

import java.util.Scanner;

public class _01_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("Done")) {
                break;
            }
            switch (command[0]) {
                case "TakeOdd":
                    StringBuilder currentText1 = new StringBuilder();
                    for (int i = 1; i < password.length(); i+=2) {
                        currentText1.append(password.charAt(i));
                    }
                    password = currentText1.toString();
                    break;

                case "Cut":
                    String leftPart = password.substring(0, Integer.parseInt(command[1]));
                    String rightPart = password.substring(Integer.parseInt(command[1]) + Integer.parseInt(command[2]));
                    password = leftPart + rightPart;
                    break;

                case "Substitute":
                    if (password.contains(command[1])) {
                        password = password.replace(command[1], command[2]);
                    } else {
                        System.out.println("Nothing to replace!");
                        continue;
                    }
                    break;
            }
            System.out.println(password);
        }
        System.out.printf("Your password is: %s\n", password);
    }
}
