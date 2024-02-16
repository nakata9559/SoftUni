package _20_PastExams._2023_08_August;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01_MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> monsterArmor = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEachOrdered(monsterArmor::offer);

        Deque<Integer> soldierPower = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEachOrdered(soldierPower::push);

        int monstersKilled = 0;

        while (!monsterArmor.isEmpty() && !soldierPower.isEmpty()) {
            if (monsterArmor.peek() <= soldierPower.peek()) {
                monstersKilled++;

                if (soldierPower.peek() - monsterArmor.peek() == 0) {
                    soldierPower.pop();
                    monsterArmor.pop();

                } else {
                    if (soldierPower.size() == 1) {
                        soldierPower.push(soldierPower.pop() - monsterArmor.poll());
                    } else {
                        soldierPower.push(soldierPower.pop() - monsterArmor.poll() + soldierPower.pop());

                    }
                }

            } else {
                monsterArmor.offer(monsterArmor.poll() - soldierPower.pop());
            }
        }

        if (monsterArmor.isEmpty()) {
            System.out.printf("All monsters have been killed!%n");

        }

        if (soldierPower.isEmpty()){
            System.out.printf("The soldier has been defeated.%n");
        }

        System.out.printf("Total monsters killed: %d%n", monstersKilled);
    }
}
