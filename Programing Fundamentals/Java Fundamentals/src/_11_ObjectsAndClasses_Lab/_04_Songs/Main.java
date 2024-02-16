package _11_ObjectsAndClasses_Lab._04_Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] songData = scanner.nextLine().split("_");

            Song song = new Song();

            song.setTypeList(songData[0]);
            song.setName(songData[1]);
            song.setTime(songData[2]);

            songs.add(song);
        }

        String desiredTypeList = scanner.nextLine();



        if (desiredTypeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }

        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(desiredTypeList)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
