package _04_DataTypesAndVariables_Exc;

import java.util.Scanner;

public class _10_PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int distanceBetweenTargets = Integer.parseInt(scanner.nextLine());
        int exaustionFactor = Integer.parseInt(scanner.nextLine());

        int initialPokePower = pokePower;
        int targetsPoked = 0;

        while (pokePower >= distanceBetweenTargets) {
            targetsPoked++;
            pokePower -= distanceBetweenTargets;

            if (initialPokePower / 2 == pokePower && exaustionFactor != 0) {
                pokePower /= exaustionFactor;
            }
        }

        System.out.println(pokePower);
        System.out.println(targetsPoked);
    }
}
