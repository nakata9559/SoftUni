package _23_PastExams._2022_04_April_09.fairyShop.core;

public interface Controller {
    String addHelper(String type, String helperName);

    String addInstrumentToHelper(String helperName, int power);

    String addPresent(String presentName, int energyRequired);

    String craftPresent(String presentName);

    String report();
}
