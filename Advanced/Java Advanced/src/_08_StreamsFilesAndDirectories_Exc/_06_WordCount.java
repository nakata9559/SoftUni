package _08_StreamsFilesAndDirectories_Exc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _06_WordCount {
    public static void main(String[] args) throws IOException {
        Path inputPathCheck = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\words.txt");
        Path inputPathText = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\text.txt");
        Path outputPath = Paths.get("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\results.txt");

        Map<String, Integer> wordsCount = new HashMap<>();
        Files.write(outputPath, "".getBytes());

        try (BufferedReader readerCheck = Files.newBufferedReader(inputPathCheck)) {

            String[] words = readerCheck.readLine().split(" ");
            String[] wholeText = String.valueOf(Files.readAllLines(inputPathText)).replaceAll("[\\[\\]]", "").split(" ");

            for (String word1 : words) {
                for (String word2 : wholeText) {
                    if (word1.equals(word2)) {
                        wordsCount.putIfAbsent(word1, 0);
                        wordsCount.put(word1, wordsCount.get(word1) + 1);
                    }
                }
            }
        }

        wordsCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(e -> {
                    String outputText = e.getKey() + " - " + e.getValue();

                    System.out.println(outputText);

                    try {
                        Files.write(outputPath, (outputText + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
    }
}
