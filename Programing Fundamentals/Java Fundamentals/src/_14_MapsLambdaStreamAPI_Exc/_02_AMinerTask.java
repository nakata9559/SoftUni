package _14_MapsLambdaStreamAPI_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _02_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Long> resources = new LinkedHashMap<>();

        while (true){
            String resource = scanner.nextLine();
            if (resource.equals("stop")) {
                break;
            }
            long quantity = Long.parseLong(scanner.nextLine());

            if (!resources.containsKey(resource)) {
                resources.put(resource, quantity);
            } else {
                resources.put(resource, resources.get(resource) + quantity);
            }
        }

        for (Map.Entry<String, Long> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n",
                    entry.getKey(),
                    entry.getValue());

        }
    }
}
