package _08_StreamsFilesAndDirectories_Exc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class _05_LineNumbers {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\inputLineNumbers.txt");
        Path outputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\output5.txt");

        List<String> inputText = Files.readAllLines(inputPath);
        List<String> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.size(); i++) {
            outputText.add(i + 1 + ". " + inputText.get(i));
        }

        Files.write(outputPath, outputText);
        outputText.forEach(System.out::println);
    }
}
