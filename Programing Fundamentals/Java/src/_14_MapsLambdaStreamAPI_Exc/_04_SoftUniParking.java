package _14_MapsLambdaStreamAPI_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, String> carData = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String name = input[1];
            String licensePlate = "";

            if (input.length > 2) {
                licensePlate = input[2];
            }

            switch (command) {
                case "register":
                    if (!carData.containsKey(name)) {
                        carData.put(name, licensePlate);
                        System.out.printf("%s registered %s successfully%n",
                                name,
                                licensePlate);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n",
                                licensePlate);
                    }
                    break;

                case "unregister":
                    if (carData.containsKey(name)) {
                        carData.remove(name);
                        System.out.printf("%s unregistered successfully%n",
                                name);
                    } else {
                        System.out.printf("ERROR: user %s not found%n",
                                name);
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> entry : carData.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());

        }
    }
}
