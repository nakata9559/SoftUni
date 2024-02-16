package _07_StreamsFilesAndDirectories_Lab;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class _07_ListFiles {
    public static void main(String[] args) throws IOException {
        File fileDir = new File("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab\\Files-and-Streams");

        boolean isDirectory = fileDir.isDirectory();
        boolean exists = fileDir.exists();

        Map<String, Long> filesData = new LinkedHashMap<>();

        if (isDirectory && exists) {
            File[] files = fileDir.listFiles();

            assert files != null;
            for (File file : files) {
                if (!file.isDirectory()) {
                    filesData.put(file.getName(), file.length());
                }
            }
        }

        filesData.forEach((k, v) -> System.out.println(k + ": [" + v + "]"));
    }
}
