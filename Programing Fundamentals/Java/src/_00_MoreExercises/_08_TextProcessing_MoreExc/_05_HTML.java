package _00_MoreExercises._08_TextProcessing_MoreExc;

import java.util.Scanner;

public class _05_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();

        System.out.printf("<h1>\n" +
                "    %s\n" +
                "</h1>\n", title);

        System.out.printf("<article>\n" +
                "    %s\n" +
                "</article>\n", content);

        while (true){
            String comment = scanner.nextLine();
            if (comment.equals("end of comments")) {
                break;
            }

            System.out.printf("<div>\n" +
                            "    %s\n" +
                            "</div>\n",
                    comment);
        }
    }
}
