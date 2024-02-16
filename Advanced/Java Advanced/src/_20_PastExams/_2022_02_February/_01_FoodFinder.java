package _20_PastExams._2022_02_February;

import java.util.*;

public class _01_FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = new ArrayList<>();
        Map<String, Set<String>> wordsCheck = new LinkedHashMap<>();
        wordsCheck.put("pear", new HashSet<>());
        wordsCheck.put("flour", new HashSet<>());
        wordsCheck.put("pork", new HashSet<>());
        wordsCheck.put("olive", new HashSet<>());

        Deque<String> vowelsQueue = new ArrayDeque<>();
        Deque<String> consonantsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .forEach(vowelsQueue::offer);

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .forEach(consonantsStack::push);

        while (!consonantsStack.isEmpty()) {
            String currentVowel = vowelsQueue.poll();
            String currentConsonant = consonantsStack.pop();

            wordsCheck.forEach((k, v) -> {
                if (k.contains(currentVowel)) {
                    v.add(currentVowel);
                }
                if (k.contains(currentConsonant)) {
                    v.add(currentConsonant);
                }
            });

            vowelsQueue.offer(currentVowel);
        }

        wordsCheck.forEach((k, v) -> {
            if (k.length() == v.size()) {
                words.add(k);
            }
        });

        System.out.printf("Words found: %d%n" +
                "%s%n",
                words.size(),
                String.join(System.lineSeparator(), words.stream()
                        .map(String::valueOf)
                        .toArray(String[]::new)));
    }
}
