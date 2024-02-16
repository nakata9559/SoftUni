package _00_MoreExercises._10_FinalExamPreparation._04_;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> hitPoints = new LinkedHashMap<>();
        Map<String, Integer> manaPoints = new LinkedHashMap<>();

        for (int i = 0; i < numOfHeroes; i++) {
            String[] input = scanner.nextLine().split(" ");
            hitPoints.put(input[0], Integer.parseInt(input[1]));
            manaPoints.put(input[0], Integer.parseInt(input[2]));
        }

        while (true) {
            String[] command = scanner.nextLine().split(" - ");
            if (command[0].equals("End")) {
                break;
            }

            switch (command[0]) {
                case "CastSpell":
                    manaPoints.replace(command[1],
                            manaPoints.get(command[1]),
                            castSpell(command[1],
                                            manaPoints.get(command[1]),
                                            Integer.parseInt(command[2]),
                                            command[3]));
                    break;

                case "TakeDamage":
                    hitPoints.replace(command[1],
                            hitPoints.get(command[1]),
                                    takeDamage(command[1],
                                            hitPoints.get(command[1]),
                                            Integer.parseInt(command[2]),
                                            command[3]));
                    if (hitPoints.get(command[1]) <= 0) {
                        hitPoints.remove(command[1]);
                        manaPoints.remove(command[1]);
                    }
                    break;

                case "Recharge":
                    manaPoints.replace(command[1],
                            manaPoints.get(command[1]),
                            recharge(command[1],
                                    manaPoints.get(command[1]),
                                    Integer.parseInt(command[2])));
                    break;

                case "Heal":
                    hitPoints.replace(command[1],
                            hitPoints.get(command[1]),
                            heal(command[1],
                                    hitPoints.get(command[1]),
                                    Integer.parseInt(command[2])));
                    break;
            }
        }
        hitPoints.forEach((key, value) -> {
            System.out.printf("%s\n" +
                    "  HP: %d\n" +
                    "  MP: %d\n",
                    key,
                    value,
                    manaPoints.get(key));
        });
    }

    public static int castSpell (String heroName, int currentMP, int spellCost, String spellName) {
        if (currentMP >= spellCost) {
            currentMP -= spellCost;
            System.out.printf("%s has successfully cast %s and now has %d MP!\n",
                    heroName,
                    spellName,
                    currentMP);
        } else {
            System.out.printf("%s does not have enough MP to cast %s!\n",
                    heroName,
                    spellName);
        }

        return currentMP;
    }

    public static int takeDamage(String heroName, int currentHP, int damage, String attacker) {
        currentHP -= damage;
        if (currentHP > 0) {
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                    heroName,
                    damage,
                    attacker,
                    currentHP);
        } else {
            System.out.printf("%s has been killed by %s!\n",
                    heroName,
                    attacker);
        }
        return currentHP;
    }

    public static int recharge(String heroName, int currentMP, int rechargeAmount) {
        if (currentMP + rechargeAmount > 200) {
            rechargeAmount = 200 - currentMP;
        }
        currentMP += rechargeAmount;

        System.out.printf("%s recharged for %d MP!\n",
                heroName,
                rechargeAmount);

        return currentMP;
    }

    public static int heal(String heroName, int currentHP, int healAmount) {
        if (currentHP + healAmount > 100) {
            healAmount = 100 - currentHP;
        }
        currentHP += healAmount;

        System.out.printf("%s healed for %d HP!\n",
                heroName,
                healAmount);

        return currentHP;
    }
}
