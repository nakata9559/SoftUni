package _07_StreamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03_CopyBytes {
    public static void main(String[] args) {
        String inputPath = "D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\input.txt";
        String outputPath = "D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\03.CopyBytesOutput.txt";

        try (FileInputStream inStream = new FileInputStream(inputPath);
        FileOutputStream outStream = new FileOutputStream(outputPath)) {
            int oneByte = inStream.read();

            while (oneByte >= 0) {
                if (oneByte == 10) {
                    System.out.println();
                    outStream.write(oneByte);
                } else if (oneByte == 32) {
                    System.out.print(" ");
                    outStream.write(oneByte);
                } else {
                    System.out.print(oneByte);
                    outStream.write(String.valueOf(oneByte).getBytes());
                }
                oneByte = inStream.read();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

