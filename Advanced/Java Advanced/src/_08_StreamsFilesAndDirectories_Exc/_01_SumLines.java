package _08_StreamsFilesAndDirectories_Exc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _01_SumLines {
    public static void main(String[] args) {
        Path inputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\input.txt");

        try (BufferedReader reader = Files.newBufferedReader(inputPath)){

            String line = reader.readLine();

            while (line != null) {
                long sum = 0;

                for (char eachChar : line.toCharArray()) {
                    sum += eachChar;
                }

                System.out.println(sum);
                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
