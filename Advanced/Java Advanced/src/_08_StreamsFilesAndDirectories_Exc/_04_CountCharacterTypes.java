package _08_StreamsFilesAndDirectories_Exc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _04_CountCharacterTypes {
    public static void main(String[] args) {
        Path inputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\input.txt");
        Path outputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\output4.txt");

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)){

            int vowelsCount = 0;
            int otherSymbolsCount = 0;
            int punctuationsCount = 0;

            String line = reader.readLine();

            while (line != null) {
                for (char eachChar : line.toCharArray()) {
                    if (eachChar == 'a'
                    || eachChar == 'e'
                    || eachChar == 'i'
                    || eachChar == 'o'
                    || eachChar == 'u') {
                        vowelsCount++;

                    } else if (eachChar == '!'
                    || eachChar == ','
                    || eachChar == '.'
                    || eachChar == '?') {
                        punctuationsCount++;

                    } else if (eachChar != ' ') {
                        otherSymbolsCount++;
                    }

                }

                line = reader.readLine();
            }

            String outputText = "Vowels: " + vowelsCount + System.lineSeparator()
                    + "Other symbols: " + otherSymbolsCount + System.lineSeparator()
                    + "Punctuation: " + punctuationsCount;

            System.out.println(outputText);

            writer.write(outputText);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
