package _08_StreamsFilesAndDirectories_Exc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class _07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path inputPath1 = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\inputOne.txt");
        Path inputPath2 = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\inputTwo.txt");
        Path outputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\output7.txt");

        List<String> text = Files.readAllLines(inputPath1);
        text.addAll(Files.readAllLines(inputPath2));
        System.out.println(String.join("\n", text));
        Files.write(outputPath, text);
    }
}
