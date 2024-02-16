package _07_StreamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _01_ReadFile {
    public static void main(String[] args) {
        String path = "D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\input.txt";

        try (FileInputStream fileInputStream = new FileInputStream(path)){
            int oneByte = fileInputStream.read();

            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileInputStream.read();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
