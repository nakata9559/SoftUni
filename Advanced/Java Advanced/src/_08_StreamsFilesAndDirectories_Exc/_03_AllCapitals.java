package _08_StreamsFilesAndDirectories_Exc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class _03_AllCapitals {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\input.txt");
        Path outputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\output3.txt");

        List<String> text = Files.readAllLines(inputPath);
        Files.write(outputPath, "".getBytes());

        text.forEach(e -> {
            System.out.println(e.toUpperCase());
            try {
                Files.write(outputPath, (e.toUpperCase() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
