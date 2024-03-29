package _13_ReflectionAndAnnotation_Lab._02_GettersAndSetters;

import _13_ReflectionAndAnnotation_Lab.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Method> gettersSet = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> settersSet = new TreeSet<>(Comparator.comparing(Method::getName));

        Method[] methods = Reflection.class.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") &&
                        m.getParameterCount() == 0)
                .forEach(gettersSet::add);

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") &&
                        m.getParameterCount() == 1)
                .forEach(settersSet::add);

        gettersSet.forEach(m -> {
            System.out.printf("%s will return class %s%n", m.getName(), m.getReturnType().getName());
        });

        settersSet.forEach(m -> {
            System.out.printf("%s and will set field of class %s%n", m.getName(), m.getParameterTypes()[0].getName());
        });
    }
}
