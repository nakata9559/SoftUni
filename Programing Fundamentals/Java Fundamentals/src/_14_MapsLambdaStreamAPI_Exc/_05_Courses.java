package _14_MapsLambdaStreamAPI_Exc;

import java.util.*;

public class _05_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();

        while (true){
            String[] input = scanner.nextLine().split(" : ");
            if (input[0].equals("end")) {
                break;
            }
            String courseName = input[0];
            String name = input[1];

            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
                courses.get(courseName).add(name);
            } else {

                courses.get(courseName).add(name);
            }
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.printf("%s: %d%n",
                    entry.getKey(),
                    entry.getValue().size());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s%n", entry.getValue().get(i));
            }
        }
    }
}
