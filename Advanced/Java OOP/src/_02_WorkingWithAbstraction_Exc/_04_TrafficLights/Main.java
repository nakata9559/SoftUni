package _02_WorkingWithAbstraction_Exc._04_TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrafficLight trafficLight = new TrafficLight(scanner.nextLine().split("\\s+"));
        int numOfChanges = Integer.parseInt(scanner.nextLine());

        while (numOfChanges-- > 0) {
            trafficLight.switchSignals();
            trafficLight.printSignals();
        }
    }
}
