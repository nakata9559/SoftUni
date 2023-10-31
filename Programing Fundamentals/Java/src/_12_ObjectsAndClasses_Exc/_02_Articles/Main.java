package _12_ObjectsAndClasses_Exc._02_Articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> article = new ArrayList<>();

        String[] articleInput = scanner.nextLine().split(", ");

        Article articleDetails = new Article(
                articleInput[0],
                articleInput[1],
                articleInput[2]);

        article.add(articleDetails);

        int numOfChanges = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfChanges; i++) {
            String[] command = scanner.nextLine().split(": ");

            switch (command[0]) {
                case "Edit":
                    articleDetails.edit(command[1]);
                    break;

                case "ChangeAuthor":
                    articleDetails.changeAuthor(command[1]);
                    break;

                case "Rename":
                    articleDetails.rename(command[1]);
                    break;
            }
        }

        System.out.println(articleDetails.getArticle());
    }
}
