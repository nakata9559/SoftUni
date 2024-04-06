package _23_PastExams._2022_04_April_09.fairyShop.factory;

import _23_PastExams._2022_04_April_09.fairyShop.common.ExceptionMessages;
import _23_PastExams._2022_04_April_09.fairyShop.models.Helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HelperFactory {
    private static final String HELPER_PATH = "fairyShop.models.";

    private HelperFactory() {
    }

    public static Helper createHelper(String type, String helperName) {
        try {
            String className = HELPER_PATH + type;
            Class<?> helperClass = Class.forName(className);
            Constructor<?> constructor = helperClass.getDeclaredConstructor(String.class);

            return (Helper) constructor.newInstance(helperName);

        } catch (ClassNotFoundException |
                 NoSuchMethodException |
                 InvocationTargetException |
                 InstantiationException |
                 IllegalAccessException e) {

            throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
    }

}
