package _19_FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("[@#]+(?<color>[a-z]{3,})[@#]+[^A-Za-z0-9@#]*[/]+(?<number>[0-9]+)[/]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.printf("You found %s %s eggs!\n",
                    matcher.group("number"),
                    matcher.group("color"));
        }
    }
}
