package _00_MoreExercises._10_FinalExamPreparation._05_;

import java.util.Scanner;

public class _01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder activationKey = new StringBuilder(scanner.nextLine());

        while (true) {
            String[] command = scanner.nextLine().split(">>>");
            if (command[0].equals("Generate")) {
                break;
            }

            switch (command[0]) {
                case "Contains":
                    if (activationKey.indexOf(command[1]) >= 0) {
                        System.out.printf("%s contains %s\n",
                                activationKey,
                                command[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    int startIndex = Integer.parseInt(command[2]);
                    int endIndex = Integer.parseInt(command[3]);
                    String givenSubstring = activationKey.substring(startIndex, endIndex);

                    switch (command[1]) {
                        case "Upper":
                            activationKey.replace(Integer.parseInt(command[2]),
                                    Integer.parseInt(command[3]),
                                    givenSubstring.toUpperCase());
                            break;

                        case "Lower":
                            activationKey.replace(Integer.parseInt(command[2]),
                                    Integer.parseInt(command[3]),
                                    givenSubstring.toLowerCase());
                            break;
                    }
                    System.out.println(activationKey);
                    break;

                case "Slice":
                    activationKey.replace(Integer.parseInt(command[1]),
                            Integer.parseInt(command[2]),
                            "");
                    System.out.println(activationKey);
                    break;
            }
        }
        System.out.printf("Your activation key is: %s\n", activationKey);
    }
}
