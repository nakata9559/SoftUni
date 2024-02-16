package _02_BasicSyntax_ConditionalStatements_And_Loops_Exc;

import java.util.Scanner;

public class _01_Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        String person = "";

        if (0 <= input && input <= 2) {
            person = "baby";

        } else if (3 <= input && input <= 13) {
            person = "child";

        }else if (14 <= input && input <= 19) {
            person = "teenager";

        }else if (20 <= input && input <= 65) {
            person = "adult";

        }else if (66 <= input) {
            person = "elder";

        }
        System.out.println(person);
    }
}
