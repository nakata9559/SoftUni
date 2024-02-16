package _16_TextProcessing_Exc;

import java.util.Scanner;

public class _03_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        StringBuilder name = new StringBuilder();
        StringBuilder extension = new StringBuilder();

        int index = path.length() - 1;

        while (path.charAt(index) != '\\') {
            name.append(path.charAt(index));
            index--;
        }

        index = path.length() - 1;

        while (path.charAt(index) != '.') {
            extension.append(path.charAt(index));
            index--;
        }

        name.replace(0,
                extension.length() + 1,
                "").reverse();
        extension.reverse();

        System.out.printf("File name: %s\nFile extension: %s\n",
                name,
                extension);
    }
}