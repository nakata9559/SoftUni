package _08_StreamsFilesAndDirectories_Exc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _02_SumBytes {
    public static void main(String[] args) {
        Path inputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\input.txt");

        long sum = 0;

        try (BufferedReader reader = Files.newBufferedReader(inputPath)){
            String line = reader.readLine();
            while (line != null) {
                for (char eachChar : line.toCharArray()) {
                    sum += eachChar;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum);
    }
}
