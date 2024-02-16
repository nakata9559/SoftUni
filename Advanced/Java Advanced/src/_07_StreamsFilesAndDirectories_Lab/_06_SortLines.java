package _07_StreamsFilesAndDirectories_Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class _06_SortLines {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\input.txt");
        Path outputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\06.SortLinesOutput.txt");

        List<String> lines = Files.readAllLines(inputPath);
        Collections.sort(lines);
        Files.write(outputPath, lines);
        lines.forEach(System.out::println);
    }
}
