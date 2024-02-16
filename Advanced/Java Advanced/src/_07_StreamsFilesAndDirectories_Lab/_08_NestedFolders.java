package _07_StreamsFilesAndDirectories_Lab;

import java.io.File;

public class _08_NestedFolders {
    public static void main(String[] args) {
        File fileDir = new File("D:\\Documents\\GitHub\\SoftUni\\Advanced\\Java Advanced\\Resources\\07. Streams, Files And Directories - Lab");

        File[] allFiles = fileDir.listFiles();
        assert allFiles != null;
        int foldersCount = 0;

        foldersCount = getFolders(allFiles, foldersCount);
        System.out.println(foldersCount + " folders");
    }

    public static int getFolders(File[] allFiles, int foldersCount) {

        for (File file : allFiles) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
            }
        }

        for (File file : allFiles) {
            if (file.isDirectory()) {
                File[] subdirectory = file.listFiles();
                assert subdirectory != null;
                foldersCount++;
                foldersCount = getFolders(subdirectory, foldersCount);
            }
        }

        return foldersCount;
    }
}
