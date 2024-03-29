package _13_ReflectionAndAnnotation_Lab._03_HighQualityMistakes;

import _13_ReflectionAndAnnotation_Lab.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Class<?> reflection = Reflection.class;


        Set<Field> nonPrivateFields = new TreeSet<>(Comparator.comparing(Field::getName));
        Set<Method> nonPublicGetters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> nonPrivateSetters = new TreeSet<>(Comparator.comparing(Method::getName));

        Method[] methods = Reflection.class.getDeclaredMethods();
        Field[] fields = Reflection.class.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(nonPrivateFields::add);

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") &&
                        m.getParameterCount() == 0 &&
                        !Modifier.isPublic(m.getModifiers()))
                .forEach(nonPublicGetters::add);

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") &&
                        m.getParameterCount() == 1 &&
                        !Modifier.isPrivate(m.getModifiers()))
                .forEach(nonPrivateSetters::add);


        nonPrivateFields.forEach(f -> {
            System.out.printf("%s must be private!%n", f.getName());
        });

        nonPublicGetters.forEach(m -> {
            System.out.printf("%s have to be public!%n", m.getName());
        });

        nonPrivateSetters.forEach(m -> {
            System.out.printf("%s have to be private!%n", m.getName());
        });
    }
}
