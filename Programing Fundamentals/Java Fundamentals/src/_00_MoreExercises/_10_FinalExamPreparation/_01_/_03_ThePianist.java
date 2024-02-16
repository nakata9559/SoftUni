package _00_MoreExercises._10_FinalExamPreparation._01_;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPieces = Integer.parseInt(scanner.nextLine());

        Map<String, String> collection = new LinkedHashMap<>();
        Map<String, String> collectionKey = new LinkedHashMap<>();

        for (int i = 0; i < numOfPieces; i++) {
            String[] input = scanner.nextLine().split("\\|");
            collection.put(input[0], input[1]);
            collectionKey.put(input[0], input[2]);
        }

        while (true) {
            String[] input = scanner.nextLine().split("\\|");
            if (input[0].equals("Stop")) {
                break;
            }

           switch (input[0]) {
               case "Add":
                   if (collection.containsKey(input[1])) {
                       System.out.println(input[1] + " is already in the collection!");
                   } else {
                       collection.put(input[1], input[2]);
                       collectionKey.put(input[1], input[3]);
                       System.out.printf("%s by %s in %s added to the collection!\n",
                               input[1],
                               input[2],
                               input[3]);
                   }
                   break;

               case "Remove":
                   if (collection.containsKey(input[1])) {
                       collection.remove(input[1]);
                       collectionKey.remove(input[1]);
                       System.out.printf("Successfully removed %s!\n", input[1]);
                   } else {
                       System.out.printf("Invalid operation! %s does not exist in the collection.\n", input[1]);
                   }
                   break;

               case "ChangeKey":
                   if (collectionKey.containsKey(input[1])) {
                       String oldKey = collectionKey.get(input[1]);
                       collectionKey.replace(input[1], oldKey, input[2]);
                       System.out.printf("Changed the key of %s to %s!\n", input[1], input[2]);
                   } else {
                       System.out.printf("Invalid operation! %s does not exist in the collection.\n", input[1]);
                   }
                   break;
           }
        }
        collection.forEach((key, value) -> {
            System.out.printf("%s -> Composer: %s, Key: %s\n",
                    key,
                    value,
                    collectionKey.get(key));
        });
    }
}
