package _19_FinalExam;

import java.util.Scanner;

public class _01_Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String spellName = scanner.nextLine();

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("Abracadabra")) {
                break;
            }

            switch (command[0]) {
                case "Abjuration":
                    spellName = spellName.toUpperCase();
                    System.out.println(spellName);
                    break;

                case "Necromancy":
                    spellName = spellName.toLowerCase();
                    System.out.println(spellName);
                    break;

                case "Illusion":
                    if (spellName.length() - 1 < Integer.parseInt(command[1])) {
                        System.out.println("The spell was too weak.");
                    } else {
                        String leftPart = spellName.substring(0, Integer.parseInt(command[1]));
                        String rightPart = "";
                        if (Integer.parseInt(command[1]) != spellName.length() - 1) {
                            rightPart = spellName.substring(Integer.parseInt(command[1]) + 1);
                        }
                        spellName = leftPart + command[2] + rightPart;
                        System.out.println("Done!");
                    }
                    break;

                case "Divination":
                    if (spellName.contains(command[1])) {
                        spellName = spellName.replace(command[1], command[2]);
                        System.out.println(spellName);
                    }
                    break;

                case "Alteration":
                    spellName = spellName.replace(command[1], "");
                    System.out.println(spellName);
                    break;

                default:
                    System.out.println("The spell did not work!");
                    break;
            }
        }
    }
}
