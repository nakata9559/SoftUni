package _14_MapsLambdaStreamAPI_Exc;

import java.util.*;

public class _09_ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> forceBook = new LinkedHashMap<>();

        while (true){
            String input = scanner.nextLine();
            String[] inputArray = input.split(" \\| | -> ");
            String command = input.replaceAll("[^->|]", "");
            if (inputArray[0].equals("Lumpawaroo")) {
                break;
            }
            String side = inputArray[0];
            String user = inputArray[1];


            boolean containsSide = false;
            boolean containsUser = false;

            switch (command) {
                case "|":
                    for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                        if (entry.getKey().equals(side)) {
                            containsSide = true;
                        }

                        if (entry.getValue().contains(user)) {
                            containsUser = true;
                        }
                    }
                    if (!containsSide && !containsUser) {
                        forceBook.put(side, new ArrayList<>());
                        forceBook.get(side).add(user);

                    } else if (!containsUser) {
                        forceBook.get(side).add(user);
                    }

                    break;

                case "->":
                    side = inputArray[1];
                    user = inputArray[0];

                    for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                        if (entry.getKey().equals(side)) {
                            containsSide = true;
                        }

                        if (entry.getValue().contains(user)) {
                            containsUser = true;
                        }
                    }
                    if (containsUser) {
                        for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                            if (entry.getValue().contains(user)) {
                                forceBook.get(entry.getKey()).remove(user);
                            }
                        }
                        if (!containsSide) {
                            forceBook.put(side, new ArrayList<>());
                            forceBook.get(side).add(user);

                        } else {
                            forceBook.get(side).add(user);
                        }

                    } else if (containsSide) {
                        forceBook.get(side).add(user);

                    } else {
                        forceBook.put(side, new ArrayList<>());
                        forceBook.get(side).add(user);
                    }

                    System.out.printf("%s joins the %s side!%n", user, side);

                    break;
            }
        }

        for (Map.Entry<String, List<String>> entry : forceBook.entrySet()){
            if (!entry.getValue().isEmpty()) {
                System.out.printf("Side: %s, Members: %d%n",
                        entry.getKey(),
                        entry.getValue().size());

                for (String member : entry.getValue()) {
                    System.out.printf("! %s%n", member);
                }
            }
        }
    }
}
