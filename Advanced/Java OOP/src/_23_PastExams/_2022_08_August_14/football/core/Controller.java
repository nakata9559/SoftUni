package _23_PastExams._2022_08_August_14.football.core;

public interface Controller {
    String addField(String fieldType, String fieldName);
    String deliverySupplement(String type);
    String supplementForField(String fieldName, String supplementType);
    String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength);
    String dragPlayer(String fieldName) throws NoSuchFieldException, IllegalAccessException;
    String calculateStrength(String fieldName) throws NoSuchFieldException, IllegalAccessException;
    String getStatistics();
}
