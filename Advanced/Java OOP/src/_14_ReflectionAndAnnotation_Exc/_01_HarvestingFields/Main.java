package _14_ReflectionAndAnnotation_Exc._01_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Field[] fields = RichSoilLand.class.getDeclaredFields();

		String command = scanner.nextLine();
		int numOfCommands = 0;

		while (!"HARVEST".equals(command) && numOfCommands++ <= 100) {
			printFields(command, fields);
			command = scanner.nextLine();
		}
	}

	public static void printFields(String command, Field[] fields) {
		switch (command) {
			case "private":
				Arrays.stream(fields)
						.filter(f -> Modifier.isPrivate(f.getModifiers()))
						.forEach(f -> {
							System.out.printf("%s %s %s%n",
									Modifier.toString(f.getModifiers()),
									f.getType().getSimpleName(),
									f.getName());
						});
				break;

			case "protected":
				Arrays.stream(fields)
						.filter(f -> Modifier.isProtected(f.getModifiers()))
						.forEach(f -> {
							System.out.printf("%s %s %s%n",
									Modifier.toString(f.getModifiers()),
									f.getType().getSimpleName(),
									f.getName());
						});
				break;

			case "public":
				Arrays.stream(fields)
						.filter(f -> Modifier.isPublic(f.getModifiers()))
						.forEach(f -> {
							System.out.printf("%s %s %s%n",
									Modifier.toString(f.getModifiers()),
									f.getType().getSimpleName(),
									f.getName());
						});
				break;

			case "all":
				Arrays.stream(fields)
						.forEach(f -> {
							System.out.printf("%s %s %s%n",
									Modifier.toString(f.getModifiers()),
									f.getType().getSimpleName(),
									f.getName());
						});
				break;
		}

	}
}
