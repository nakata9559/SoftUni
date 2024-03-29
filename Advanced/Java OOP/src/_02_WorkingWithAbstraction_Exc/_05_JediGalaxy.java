package _02_WorkingWithAbstraction_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _05_JediGalaxy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        long[][] galaxy = fillMatrix(dimensions);

        long collectedStars = 0;
        String input = scanner.nextLine();

        while (!"Let the Force be with you".equals(input)) {
            int peterRow = Integer.parseInt(input.split("\\s+")[0]);
            int peterCol = Integer.parseInt(input.split("\\s+")[1]);
            input = scanner.nextLine();
            int evilRow = Integer.parseInt(input.split("\\s+")[0]);
            int evilCol = Integer.parseInt(input.split("\\s+")[1]);

            destroyValues(galaxy, evilRow, evilCol);
            collectedStars += collectStars(galaxy, peterRow, peterCol);

            input = scanner.nextLine();
        }

        System.out.println(collectedStars);
    }

    public static long[][] fillMatrix(int[] dimensions) {
        long[][] matrix = new long[dimensions[0]][dimensions[1]];
        int filler = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = filler++;
            }
        }

        return matrix;
    }

    public static void destroyValues(long[][] galaxy, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow >= galaxy.length
                    || evilCol >= galaxy[0].length) {
                evilRow--;
                evilCol--;
            } else {
                galaxy[evilRow--][evilCol--] = 0;
            }
        }
    }

    public static long collectStars(long[][] galaxy, int peterRow, int peterCol) {
        long collectedStars = 0;

        while (peterRow >= 0 && peterCol < galaxy[0].length) {
            if (peterRow >= galaxy.length
                    || peterCol < 0) {
                peterRow--;
                peterCol++;
            } else {
                collectedStars += galaxy[peterRow--][peterCol++];
            }
        }

        return collectedStars;
    }
}
