package _07_StreamsFilesAndDirectories_Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class _05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\input.txt");
        Path outputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\05.WriteEveryThirdLineOutput.txt");

        List<String> inputLines = Files.readAllLines(inputPath);
        Files.write(outputPath, "".getBytes());

        for (int i = 0; i < inputLines.size(); i++) {
            if ((i + 1) % 3 == 0) {
                System.out.println(inputLines.get(i));
                Files.write(outputPath,
                        (inputLines.get(i) + System.lineSeparator()).getBytes(),
                        StandardOpenOption.APPEND);
            }
        }
    }
}
