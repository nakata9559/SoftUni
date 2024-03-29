package _14_ReflectionAndAnnotation_Exc._02_BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
        field.setAccessible(true);

        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();

        String tokens = scanner.nextLine();

        while (!"END".equals(tokens)) {
            String command = tokens.split("_")[0];
            int value = Integer.parseInt(tokens.split("_")[1]);

            Arrays.stream(methods)
                    .filter(m -> m.getName().equals(command))
                    .forEach(m -> {
                        m.setAccessible(true);
                        try {
                            m.invoke(blackBoxInt, value);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    });

            System.out.println(field.get(blackBoxInt));
            tokens = scanner.nextLine();
        }
    }
}
