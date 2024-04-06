package _23_PastExams._2023_04_April_08.robotService.core;

public interface Controller {
    String addService(String type, String name);
    String addSupplement(String type);
    String supplementForService(String serviceName, String supplementType) throws NoSuchMethodException, ClassNotFoundException;
    String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price);
    String feedingRobot(String serviceName);
    String sumOfAll(String serviceName);
    String getStatistics();
}
