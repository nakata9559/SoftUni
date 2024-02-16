package _00_MoreExercises._09_RegularExpressions_MoreExc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("\\s*,\\s*");

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            String leftHalf = ticket.substring(0, 10);
            String rightHalf = ticket.substring(10);

            Pattern pattern = Pattern.compile("@{6,10}|#{6,10}|\\${6,10}|\\^{6,10}");
            Matcher matcherLeft = pattern.matcher(leftHalf);
            Matcher matcherRight = pattern.matcher(rightHalf);

            if (matcherLeft.find() && matcherRight.find()) {
                int winningAmount = Math.min(matcherLeft.group().length(), matcherRight.group().length());
                char matchingSign = matcherLeft.group().charAt(0);

                if (winningAmount == 10) {
                    System.out.printf("ticket \"%s\" - %d%c Jackpot!\n",
                            ticket, winningAmount, matchingSign);
                } else {
                    System.out.printf("ticket \"%s\" - %d%c\n",
                            ticket, winningAmount, matchingSign);
                }

            } else {
                System.out.printf("ticket \"%s\" - no match\n",
                        ticket);
            }
        }
    }
}
