package _07_StreamsFilesAndDirectories_Lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _04_ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\input.txt";
        String outputPath = "D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\04.ExtractIntegersOutput.txt";

        try (FileReader reader = new FileReader(inputPath);
             FileWriter writer = new FileWriter(outputPath)){

            Scanner scanner = new Scanner(reader);

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int nextInt = scanner.nextInt();
                    System.out.println(nextInt);
                    writer.write(String.valueOf(nextInt) + (char)10);
                }

                scanner.next();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
