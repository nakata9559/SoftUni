package _24_Exam.restaurant.factory;

import _24_Exam.restaurant.common.ExceptionMessages;
import _24_Exam.restaurant.models.waiter.Waiter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WaiterFactory {
    private static final String WAITER_PATH = "restaurant.models.waiter.";

    public static Waiter createWaiter(String type, String waiterName) {
        try {
            String className = WAITER_PATH + type;
            Class<?> waiterClass = Class.forName(className);
            Constructor<?> constructor = waiterClass.getDeclaredConstructor(String.class);
            return (Waiter) constructor.newInstance(waiterName);

        } catch (ClassNotFoundException |
                 NoSuchMethodException |
                 InvocationTargetException |
                 InstantiationException |
                 IllegalAccessException e) {

            throw new IllegalArgumentException(ExceptionMessages.WAITER_INVALID_TYPE);
        }
    }
}
