package _00_MoreExercises._05_WhileLoop_MoreExc;

import java.util.Scanner;

public class _03_StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String letter = "";
        String word = "";

        int nTimes = 0;
        int oTimes = 0;
        int cTimes = 0;

        while (!command.equals("End")) {

            char wordChar = command.charAt(0);

            if (('a' <= wordChar && wordChar <= 'z') || ('A' <= wordChar && wordChar <= 'Z')) {

                if (wordChar == 'n' && nTimes == 0) {
                    nTimes++;
                } else if (wordChar == 'o' && oTimes == 0) {
                    oTimes++;
                } else if (wordChar == 'c' && cTimes == 0) {
                    cTimes++;
                } else {
                    letter += command;
                }

                if (nTimes != 0 && oTimes != 0 && cTimes != 0) {
                    word += letter;
                    letter = " ";
                    nTimes = 0;
                    oTimes = 0;
                    cTimes = 0;
                }
            }

            command = scanner.nextLine();

        }
        System.out.println(word);
    }
}
