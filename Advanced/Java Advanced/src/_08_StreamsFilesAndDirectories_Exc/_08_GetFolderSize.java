package _08_StreamsFilesAndDirectories_Exc;

import java.io.File;
import java.io.IOException;

public class _08_GetFolderSize {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\08. Streams, Files And Directories - Exercises\\Exercises Resources");

        long size = 0;

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            for (File eachFile : files) {
                size += eachFile.length();
            }
        }

        System.out.println("Folder size: " + size);
    }
}
