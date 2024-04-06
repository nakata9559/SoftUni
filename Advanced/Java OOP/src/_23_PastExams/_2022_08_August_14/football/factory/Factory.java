package _23_PastExams._2022_08_August_14.football.factory;

import _23_PastExams._2022_08_August_14.football.common.ExceptionMessages;
import _23_PastExams._2022_08_August_14.football.entities.field.Field;
import _23_PastExams._2022_08_August_14.football.entities.player.Player;
import _23_PastExams._2022_08_August_14.football.entities.supplement.Supplement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class Factory {
    private static final String FIELD_PATH = "football.entities.field.";
    private static final String PLAYER_PATH = "football.entities.player.";
    private static final String SUPPLEMENT_PATH = "football.entities.supplement.";

    public static Field createNew(String fieldType, String fieldName) {
        try {
            String className = FIELD_PATH + fieldType;
            Class<?> aClass = Class.forName(className);
            Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);

            return (Field) constructor.newInstance(fieldName);

        } catch (ClassNotFoundException |
                 InvocationTargetException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException e) {
            throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
    }

    public static Player createNew(
            String playerType,
            String playerName,
            String nationality,
            int strength) {

        try {
            String className = PLAYER_PATH + playerType;
            Class<?> aClass = Class.forName(className);
            Constructor<?> constructor = aClass.getDeclaredConstructor(
                    String.class,
                    String.class,
                    int.class
            );

            return (Player) constructor.newInstance(
                    playerName,
                    nationality,
                    strength
            );

        } catch (ClassNotFoundException |
                 InvocationTargetException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
    }

    public static Supplement createNew(String supplementType) {
        try {
            String className = SUPPLEMENT_PATH + supplementType;
            Class<?> aClass = Class.forName(className);
            Constructor<?> constructor = aClass.getDeclaredConstructor();

            return (Supplement) constructor.newInstance();

        } catch (ClassNotFoundException |
                 InvocationTargetException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
    }
}
