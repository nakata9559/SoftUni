package _07_StreamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _02_WriteToFile {
    public static void main(String[] args) {
        String inputPath = "D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\input.txt";
        String outputPath = "D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\02.WriteToFileOutput.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputPath)){

            int oneByte = fileInputStream.read();
            Character[] chars = {',', '.', '!', '?'};
            Set<Character> check = new HashSet<>(List.of(chars));

            while (oneByte >= 0) {
                if (!check.contains((char)oneByte)) {
                    System.out.print((char)oneByte);
                    fileOutputStream.write(oneByte);
                }
                oneByte = fileInputStream.read();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
