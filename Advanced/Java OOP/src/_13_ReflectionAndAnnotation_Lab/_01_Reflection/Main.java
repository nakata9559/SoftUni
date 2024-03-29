package _13_ReflectionAndAnnotation_Lab._01_Reflection;

import _13_ReflectionAndAnnotation_Lab.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> reflection = Reflection.class;
        System.out.println(reflection);

        Class<?> superClass = reflection.getSuperclass();
        System.out.println(superClass);

        Class<?>[] interfaces = reflection.getInterfaces();
        for (Class<?> eachInterface : interfaces) {
            System.out.println(eachInterface);
        }

        Object reflectionObj = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObj);
    }
}
