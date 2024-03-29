package _08_InterfacesAndAbstraction_Exc._05_Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();

        this.urls.forEach(e -> {
            char[] charArr = e.toCharArray();
            boolean containsDigit = false;

            for (char eachChar: charArr){
                if (Character.isDigit(eachChar)) {
                    containsDigit = true;
                    break;
                }
            }

            if (containsDigit) {
                output.append("Invalid URL!").append(System.lineSeparator());
            } else {
                output.append("Browsing: ").append(e).append("!").append(System.lineSeparator());
            }
        });

        return output.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();

        this.numbers
                .forEach(e -> {
                    char[] charArr = e.toCharArray();
                    boolean containsOnlyDigits = true;

                    for (char eachChar: charArr){
                        if (!Character.isDigit(eachChar)) {
                            containsOnlyDigits = false;
                            break;
                        }
                    }

                    if (!containsOnlyDigits) {
                        output.append("Invalid number!").append(System.lineSeparator());
                    } else {
                        output.append("Calling... ").append(e).append(System.lineSeparator());
                    }
                });

        return output.toString().trim();
    }
}
