package _13_MapsLambdaStreamAPI_Lab;

import java.util.*;

public class _02_WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPairs = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<String>> synonymsMap = new LinkedHashMap<>();

        for (int i = 0; i < numOfPairs; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            synonymsMap.putIfAbsent(word, new ArrayList<>()) ;
            synonymsMap.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : synonymsMap.entrySet()) {
            System.out.printf("%s - %s%n",
                    entry.getKey(),
                    String.join(", ", entry.getValue()));
        }
    }
}
