package _00_MoreExercises._08_TextProcessing_MoreExc;

import java.util.Scanner;

public class _04_MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] message = scanner.nextLine().split("\\|");
        StringBuilder decryptedMessage = new StringBuilder();

        for (String eachWord : message) {
            String[] eachLetter = eachWord.split(" ");

            for (String eachSymbol : eachLetter) {
                switch (eachSymbol) {
                    case ".-":
                        decryptedMessage.append("A");
                        break;
                    case "-...":
                        decryptedMessage.append("B");
                        break;
                    case "-.-.":
                        decryptedMessage.append("C");
                        break;
                    case "-..":
                        decryptedMessage.append("D");
                        break;
                    case ".":
                        decryptedMessage.append("E");
                        break;
                    case "..-.":
                        decryptedMessage.append("F");
                        break;
                    case "--.":
                        decryptedMessage.append("G");
                        break;
                    case "....":
                        decryptedMessage.append("H");
                        break;
                    case "..":
                        decryptedMessage.append("I");
                        break;
                    case ".---":
                        decryptedMessage.append("J");
                        break;
                    case "-.-":
                        decryptedMessage.append("K");
                        break;
                    case ".-..":
                        decryptedMessage.append("L");
                        break;
                    case "--":
                        decryptedMessage.append("M");
                        break;
                    case "-.":
                        decryptedMessage.append("N");
                        break;
                    case "---":
                        decryptedMessage.append("O");
                        break;
                    case ".--.":
                        decryptedMessage.append("P");
                        break;
                    case "--.-":
                        decryptedMessage.append("Q");
                        break;
                    case ".-.":
                        decryptedMessage.append("R");
                        break;
                    case "...":
                        decryptedMessage.append("S");
                        break;
                    case "-":
                        decryptedMessage.append("T");
                        break;
                    case "..-":
                        decryptedMessage.append("U");
                        break;
                    case "...-":
                        decryptedMessage.append("V");
                        break;
                    case ".--":
                        decryptedMessage.append("W");
                        break;
                    case "-..-":
                        decryptedMessage.append("X");
                        break;
                    case "-.--":
                        decryptedMessage.append("Y");
                        break;
                    case "--..":
                        decryptedMessage.append("Z");
                        break;
                }
            }

            decryptedMessage.append(" ");
        }

        System.out.println(decryptedMessage);
    }
}
