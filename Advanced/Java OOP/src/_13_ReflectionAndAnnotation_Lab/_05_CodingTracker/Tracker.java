package _13_ReflectionAndAnnotation_Lab._05_CodingTracker;

import java.util.Arrays;

public class Tracker {

    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl) {
        Arrays.stream(cl.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(Author.class))
                .forEach(m -> {
                    System.out.printf("%s: %s()%n",
                            m.getAnnotation(Author.class).name(),
                            m.getName());
                });
    }
}
