package _02_WorkingWithAbstraction_Exc._04_TrafficLights;

import java.util.Arrays;

public class TrafficLight {
    private String[] signals;

    public TrafficLight(String... signals) {
        this.signals = signals;
    }

    public void printSignals() {
        for (String signal : signals) {
            System.out.print(signal + " ");
        }
        System.out.println();
    }

    public void switchSignals() {
        this.signals = Arrays.stream(signals).map(signal -> {
            switch (signal) {
                case "RED":
                    return "GREEN";
                case "GREEN":
                    return "YELLOW";
                case "YELLOW":
                    return "RED";
                default:
                    return null;
            }
        }).toArray(String[]::new);
    }
}
